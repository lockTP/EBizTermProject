/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.JobDAO;
import dao.UserDAO;
import email.EmailNotifier;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import model.Constant;
import model.Job;
import model.User;
import org.springframework.stereotype.*;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.portlet.ModelAndView;
import spider.FilesUtility;
import spider.JobItemFlag;
import spider.SpiderMain;

/**
 *
 * @author linxiaohui
 */
@Controller
public class UserController {

    @RequestMapping(value = "user", method = RequestMethod.GET)
    public String index(ModelMap model) {
        model.put("user", new User());
        return "login";
    }

    @RequestMapping(value = "search", method = RequestMethod.GET)
    public String toSearchPage(ModelMap model) {
        model.put("user", new User());
        return "search";
    }
    

    @RequestMapping(value = "post", method = RequestMethod.GET)
    public String toPostPage(ModelMap model) {
        model.put("user", new User());
        return "post";
    }

    @RequestMapping(value = "profile", method = RequestMethod.GET)
    public String toProfilePage(ModelMap model) {
        model.put("user", new User());
        return "profile";
    }
    
    @RequestMapping(value = "crawler", method = RequestMethod.GET)
    public String toCrawlerPage(ModelMap model) {
        model.put("user", new User());
        //get the root path of the project, where all those files are
        ServletContext context=this.getServletContext();
        String projectRootPath=context.getRealPath("/"); 
        projectRootPath = projectRootPath.replaceAll("(.+Assignment7_hab81).+", "$1");
        projectRootPath += "/";
        
        SpiderMain spiderMain = new SpiderMain();
        spiderMain.setErrorFilePath(projectRootPath);
        spiderMain.setTempFilePath(projectRootPath);
        spiderMain.setErrorFilePath(projectRootPath);
        spiderMain.setJobsFilePath(projectRootPath);
        JobItemFlag.setRefSourceFilePath(projectRootPath);
        FilesUtility.setErrorFilePath(projectRootPath);
        FilesUtility.setTempFilePath(projectRootPath);
        
        spiderMain.startSpider();
        return "post";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(@ModelAttribute(value = "user") User user, ModelMap model, HttpSession session) {
        UserDAO userdao = new UserDAO();
        user = userdao.login(user.getName(), user.getPassword());
        if (user != null) {
            session.setAttribute("name", user.getName());
            session.setAttribute("userid", user.getId());
            session.setAttribute("email", user.getEmail());
            session.setAttribute("password", user.getPassword());
            userdao.close();
            return "profile";
        } else {
            model.put("message", "Invalid");
            userdao.close();
            return "login";
        }
    }

    @RequestMapping(value = "register", method = RequestMethod.POST)
    public String register(@ModelAttribute(value = "user") User user, ModelMap model, HttpSession session) {
        UserDAO userdao = new UserDAO();
        if (userdao.insertOrUpdateUser("register", user) == Constant.REG_SUCCESS) {
            session.setAttribute("name", user.getName());
            session.setAttribute("userid", user.getId());
            session.setAttribute("email", user.getEmail());
            session.setAttribute("password", user.getPassword());
            userdao.close();
            return "profile";
        } else {
            if (userdao.insertOrUpdateUser("register", user) == Constant.USERNAME_DUPLICATE) {
                userdao.close();
                return "login";
            } else {
                model.put("message", "Register Fail");
                userdao.close();
                return "login";
            }
        }
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(@ModelAttribute(value = "user") User user, ModelMap model, HttpSession session) {
        UserDAO userdao = new UserDAO();
        user.setId((String) session.getAttribute("userid"));
        userdao.insertOrUpdateUser("update", user);
        session.setAttribute("name", user.getName());
        session.setAttribute("userid", user.getId());
        session.setAttribute("email", user.getEmail());
        session.setAttribute("password", user.getPassword());
        userdao.close();
        return "profile";
    }

//    @RequestMapping(value = "postJob", method = RequestMethod.POST)
//    public String post(@ModelAttribute(value = "user") User user, ModelMap model, HttpSession session){
//        UserDAO userdao = new UserDAO();
//        user = userdao.login(user.getName(), user.getPassword());
//        if (user != null) {
//            session.setAttribute("name", user.getName());
//            session.setAttribute("userid", user.getId());
//            session.setAttribute("email", user.getEmail());
//            session.setAttribute("password", user.getPassword());
//            return "post";
//        } else {
//            model.put("message", "Invalid");
//            return "login";
//        }
//    }
    

    @RequestMapping(value = "insertJob", method = RequestMethod.POST)
    public String insertJob(@ModelAttribute(value = "job") Job job, ModelMap model, HttpSession session) {
        JobDAO jobdao = new JobDAO();
        UserDAO userdao = new UserDAO();
        jobdao.saveJob(job);
        jobdao.close();
        EmailNotifier emailNotifier = new EmailNotifier();
        String mailSubject = "Job ALert:" + job.getTitle();
        String mailText = "Title:" + job.getTitle() +"\nCompany:" + job.getcName() + "\nDescription:" + job.getDescription();
        List<User> users = userdao.getAllUsers();
        for(int i = 0; i< users.size(); i++){
            emailNotifier.sendMail(users.get(i).getEmail(), mailSubject, mailText);
        }
        userdao.close();
        return "post";
    }
    


}

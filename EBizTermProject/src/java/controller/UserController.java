/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.User;
import dao.UserDAO;
import javax.servlet.http.HttpSession;
import model.Constant;
import org.springframework.stereotype.*;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(@ModelAttribute(value = "user") User user, ModelMap model, HttpSession session) {
        UserDAO userdao = new UserDAO();
        user = userdao.login(user.getName(), user.getPassword());
        if (user != null) {
            session.setAttribute("name", user.getName());
            session.setAttribute("userid", user.getId());
            session.setAttribute("email", user.getEmail());
            session.setAttribute("password", user.getPassword());
            return "profile";
        } else {
            model.put("message", "Invalid");
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
            return "profile";
        } else {
            if (userdao.insertOrUpdateUser("register", user) == Constant.USERNAME_DUPLICATE) {
                return "login";
            } else {
                model.put("message", "Register Fail");
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
        return "profile";
    }

}

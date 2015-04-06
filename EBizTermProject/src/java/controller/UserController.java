/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.User;
import dao.UserDAO;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.*;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author linxiaohui
 */
@Controller
public class UserController {

    UserDAO userdao = new UserDAO();

    @RequestMapping(value = "user", method = RequestMethod.GET)
    public String index(ModelMap model) {
        model.put("user", new User());
        return "login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(@ModelAttribute(value = "user") User user, ModelMap model, HttpSession session) {
        if (userdao.login(user.getName(), user.getPassword()) != null) {
            session.setAttribute("name", user.getName());
            return "welcome";
        } else {
            model.put("message", "Invalid");
             return "login";
        }

       
    }

}

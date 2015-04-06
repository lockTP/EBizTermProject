/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.User;
import hibernate.HibernateUtils;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author linxiaohui
 */
public class UserDAO {
    Session session = null;

    public UserDAO() {
        this.session = HibernateUtils.getSessionFactory().openSession();
    }
    
    public User login(String name, String password){
        User userinfo;
        try {
            Query q = session.createQuery("from User as userinfo where userinfo.name = '" + name+ "' and userinfo.password = '" + password + "'");
            userinfo = new User();
            userinfo = (User) q.uniqueResult();
            return userinfo;
        } catch (Exception e) {
            return null;
        }
    }
}

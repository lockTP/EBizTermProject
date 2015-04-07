/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.User;
import hibernate.HibernateUtils;
import model.Constant;
import org.hibernate.HibernateException;
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

    public User login(String name, String password) {
        User userinfo;
        try {
            Query q = session.createQuery("from User as userinfo where userinfo.name = '" + name + "' and userinfo.password = '" + password + "'");
            userinfo = new User();
            userinfo = (User) q.uniqueResult();
            return userinfo;
        } catch (Exception e) {
            return null;
        }
    }

    public boolean checkUsernameDuplicate(String name) {

        try {
            Query q = session.createQuery("from User as userinfo where userinfo.name = '" + name + "'");
            if (q.list().size() > 0) {
                return true;
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    public int insertOrUpdateUser(String method, User userinfo) {
        org.hibernate.Transaction tx = null;
        try {
            tx = session.beginTransaction();
            if (checkUsernameDuplicate(userinfo.getName()) && method.equals("register")) {
                return Constant.USERNAME_DUPLICATE;
            }
            if (method.equals("update")) {
                String hql = "update User set name=:name, email=:email, password=:password where id=:id ";
                Query q = session.createQuery(hql);
                q.setParameter("name", userinfo.getName());
                q.setParameter("id", userinfo.getId());
                q.setParameter("email", userinfo.getEmail());
                q.setParameter("password", userinfo.getPassword());
                int result = q.executeUpdate();
                tx.commit();
                session.close();
                return result;
            }

            session.saveOrUpdate(userinfo);
            tx.commit();
            session.close();
            return Constant.REG_SUCCESS;
        } catch (HibernateException e) {
            System.err.println(e.getMessage());
            tx.rollback();
            return Constant.USER_INSERT_ERROR;
        } catch (Exception e) {
            tx.rollback();
            return Constant.UNKNOWN_ERROR;
        }
    }
    
    public User getUserInfo(User userinfo) {

        try {
            String password = userinfo.getPassword();
            Query q = session.createQuery("from User as userinfo where userinfo.uid="+userinfo.getId()+"");
            userinfo = new User();
            userinfo = (User) q.uniqueResult();
            return userinfo;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public void close() {
        session.close();
    }
}

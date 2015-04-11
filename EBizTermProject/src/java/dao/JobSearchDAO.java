/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import hibernate.HibernateUtils;
import java.util.ArrayList;
import java.util.List;
import model.Job;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author linxiaohui
 */
public class JobSearchDAO {

    Session session = null;

    public JobSearchDAO() {
        this.session = HibernateUtils.getSessionFactory().openSession();
    }
    
    public List<Job> searchByCriteria(Job job,int page) {

        int maxPage;
        int itemsPerPage = 5;
        
        List<Job> jobList = new ArrayList<Job>();
        try {
            Criteria c = session.createCriteria(Job.class);
            if (job.getTitle() != null) {
                c.add(Restrictions.like("title", "%" + job.getTitle() + "%"));
            }

            maxPage = c.list().size() / itemsPerPage;
            c.setFirstResult(page * itemsPerPage);
            c.setMaxResults(itemsPerPage);
            jobList = (List<Job>) c.list();
            return jobList;
        } catch (HibernateException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public List<Job> searchByCondition(String keyword, String location, String cName){
        Criteria c = session.createCriteria(Job.class);
        if(keyword != null){
            c.add(Restrictions.or(Restrictions.like("title", "%" + keyword + "%"), Restrictions.like("description", "%" + keyword + "%")));
        }
        if(cName != null){
            c.add(Restrictions.like("cName", "%" + cName + "%"));
        }
        if(location != null){
            c.add(Restrictions.like("location", "%" + location + "%"));
        }
        List<Job> jobList = new ArrayList<Job>();
        jobList = (List<Job>) c.list();
        return jobList;
    }
    
    public void close() {
        session.close();
    }
}

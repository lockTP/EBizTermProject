/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

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

    public List<Job> searchByCriteria(Job job,int page) {

        int maxPage;
        int itemsPerPage = 5;
        Session session = null;
        
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
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hibernate;

import dao.JobSearchDAO;
import java.util.List;
import model.Job;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Weichuan
 */
public class JobSearchDAOTest {
    
    public JobSearchDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @Test
    public void testSearchByCondition(){
        JobSearchDAO jobSearchDAO = new JobSearchDAO();
        List<Job> jobs = jobSearchDAO.searchByCondition("pig", "location", "cName");
        System.out.print(jobs.get(0).getDescription());
        assertEquals(1,1);
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}

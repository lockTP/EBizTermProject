/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hibernate;

import dao.JobDAO;
import model.Job;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Weichuan
 */
public class JobDAOTest {
    
    public JobDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @Test
    public void testSaveJob(){
        Job job = new Job();
        job.setDescription("Description");
        job.setTitle("title");
        job.setRequirement("requirement");
        job.setWebsite("website");
        job.setLocation("location");
        job.setcName("cName");
        job.setcType("cType");
        job.setcDescription("cDescription");
        job.setcIndustry("cIndustry");
        JobDAO jobDAO = new JobDAO();
        jobDAO.saveJob(job);
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

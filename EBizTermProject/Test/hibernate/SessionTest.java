/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hibernate;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Weichuan
 */
public class SessionTest {
    
    public SessionTest() {
    }
    
//    
//    @Test
//	public void testSave() {
//		Session session = null;
//		Transaction tx = null; 
//		try {
//			session = HibernateUtils.getSession();
//			tx = session.beginTransaction();
//			
//			User user = new User();
//			user.setName("testSave");
//			user.setPassword("11");
//			session.save(user);
//			tx.commit();
//			assertEquals(1, 1);
//		} catch (Exception e) {
//			e.printStackTrace();
//			tx.rollback();
//		}finally{
//			HibernateUtils.closeSession(session);
//		}
//	}
//	
//	@Test
//	public void testReadByGetMethod(){
//		Session session = null;
//		try {
//			session = HibernateUtils.getSession();
//			session.beginTransaction();
//			User user = (User) session.get(User.class, "8a8080974a1838e2014a1838e3e80000");
//			System.out.println("user name:" + user.getName());
//			session.getTransaction().commit();
//		} catch (Exception e) {
//			e.printStackTrace();
//			session.getTransaction().rollback();
//		}finally{
//			HibernateUtils.closeSession(session);
//		}
//	}
    
    
    @BeforeClass
    public static void setUpClass() {
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

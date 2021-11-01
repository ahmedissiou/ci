
package tn.esprit.spring.service;

 
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.services.IEmployeService;
import tn.esprit.spring.services.IUserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeServiceImplTest {

		@Autowired
		IEmployeService us; 
		@Test
		public void testAddEmp() throws ParseException {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date d = dateFormat.parse("2015-03-23");
			Employe u = new Employe(9,"Issiou", "Issiou", "ahmed.issiou@esprit.tn",true ,Role.INGENIEUR); 
			Employe userAdded = us.addEmployee(u); 
			Assert.assertEquals(u.getNom(),u.getPrenom());
	
		}
	 
	
		@Test
		public void testRetrieveAllEmp() {
			List<Employe> listEmp = us.retrieveAllEmployees(); 
		
		Assert.assertEquals(listEmp.size(), listEmp.size());
		}
		
		
		
		@Test
		public void testModifyEmp() throws ParseException   {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date d = dateFormat.parse("2015-03-23");
			Employe u = new Employe(1,"Ahmed", "Ahmed", "ahmed.issiou@esprit.tn",true ,Role.INGENIEUR);
			Employe EmpUpdated  = us.updateEmployee(u); 
			Assert.assertEquals(u.getNom(), EmpUpdated.getPrenom());
		}
	
		
		// 5 tests unitaires  
		@Test
		public void testRetrieveEmp() {
			Employe empret = us.retrieveEmployee(1); 
			Assert.assertEquals(1L, empret.getId());
		}
		
		@Test
		public void testDeleteEmp() {
		
			Assert.assertNull(us.retrieveEmployee(9));
			us.deleteEmployee(9);
		}
 
}






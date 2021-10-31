
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
		public void testRetrieveAllEmp() {
			List<Employe> listEmp = us.retrieveAllEmployees(); 
			// if there are 7 users in DB : 
		Assert.assertEquals(15, listEmp.size());
		}
		
		
		@Test
		public void testAddEmp() throws ParseException {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date d = dateFormat.parse("2015-03-23");
			Employe u = new Employe("Issiou", "Ahmed", "ahmed.issiou@esprit.tn",true ,Role.INGENIEUR); 
			Employe userAdded = us.addEmployee(u); 
	
		}
	 
		@Test
		public void testModifyUser() throws ParseException   {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date d = dateFormat.parse("2015-03-23");
			Employe u = new Employe("Issiou", "Ahmed", "ahmed.issiou@esprit.tn",true ,Role.INGENIEUR);
			Employe EmpUpdated  = us.updateEmployee(u); 
			//Assert.assertEquals(u.getLastName(), userUpdated.getLastName());
		}
	
		
		// 5 tests unitaires  
 
}






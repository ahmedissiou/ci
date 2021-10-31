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

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.services.*;
import tn.esprit.spring.services.IUserService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ContratServiceImplTest {
	
			@Autowired
			IContratService us; 
		
			@Test
			public void testRetrieveAllContrats() {
				List<Contrat> listContrats = us.retrieveAllContrats(); 
				// if there are 7 contracts in DB : 
				List<Contrat> Contrats = us.retrieveAllContrats() ;
				 Assert.assertEquals(91, listContrats.size());
			}
			
			
			@Test
			public void testAddContrat() throws ParseException {
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				Date d = dateFormat.parse("1997-07-05");
				Contrat c = new Contrat(d , "Par mois", 500); 
				Contrat contratAdded = us.addContrat(c) ;
				//Assert.assertEquals(contratAdded.getTypeContrat(), contratAdded.getSalaire());
			}
			
		 
			@Test
			public void testModifyContrat() throws ParseException   {
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				Date d = dateFormat.parse("2015-03-23");
				Contrat c = new Contrat(d , "Par ans", 800);  
				Contrat contratUpdated  = us.updateContrat(c); 
			//	Assert.assertEquals(c.getTypeContrat(), contratUpdated.getTypeContrat());
			}
		
			@Test
			public void testRetrieveContrat() {
			Contrat contratRetrieved = us.retrieveContrat(1); 
			//Assert.assertEquals(1L, contratRetrieved.getReference());
			}
			
			@Test
			public void testDeleteContrat() {
				 us.deleteContrat(36);
				//Assert.assertNull(us.retrieveContrat(7));
				
			}
			
			// 5 tests unitaires  
	 
}

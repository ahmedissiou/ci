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

import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.services.IMissionService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MissionServiceImplTest {
	
	@Autowired
	IMissionService ms;
	
	@Test
	public void testRetrieveAllMissions() {
		List<Mission> listMissions = ms.retrieveAllMissions(); 
		Assert.assertEquals(3, listMissions.size());
	}
	
	
	@Test
	public void testAddMission() throws ParseException {
		
		Mission m = new Mission("main", "maintenance"); 
		Mission missionAdded = ms.addMission(m); 
		Assert.assertEquals(m.getName(), missionAdded.getName());
	}
 
	@Test
	public void testModifyMission() throws ParseException   {
		
		Mission m = new Mission(6,"dev", "developpement"); 
		Mission missionUpdated  = ms.updateMission(m); 
		Assert.assertEquals(m.getName(), missionUpdated.getName());
	}

	@Test
	public void testRetrieveMission() {
		Mission missionRetrieved = ms.retrieveMission("1"); 
		Assert.assertEquals(1,missionRetrieved.getId());
	}
	
	@Test
	public void testDeleteMission() {
		ms.deleteMission("5");
		Assert.assertNull(ms.retrieveMission("5"));
	}
	

}

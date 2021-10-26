package tn.esprit.spring.services;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.EmployeRepository;


@Service
public class EmployeeServiceImpl implements IEmployeService {

	@Autowired
	EmployeRepository employerepository;

	private static final Logger l = LogManager.getLogger(EmployeeServiceImpl.class);



	
	
	@Override
	public List<Employe> retrieveAllEmployees() { 
		List<Employe> employees  = null; 
		try {
	
			l.info("In retrieveAllEmployees() : ");
			employees = (List<Employe>) employerepository.findAll();  
			for (Employe employe : employees) {
				l.debug("employe +++ : " + employees);
			} 
			l.info("Out of retrieveAllEmployees() : ");
		}catch (Exception e) {
			l.error("Error in retrieveAllEmployees() : " + e);
		}

		return employees;
	}


	@Override
	public Employe addEmployee(Employe u) {
		return employerepository.save(u); 
	}

	@Override 
	public Employe updateEmployee(Employe u) { 
		return employerepository.save(u);
	}

	@Override
	public void deleteEmployee(int id) {
		employerepository.deleteById(id);
	}

	@Override
	public Employe retrieveEmployee(int id) {
		l.info("in  retrieveEmployee id = " + id);
		//Employe u =  employerepository.findById(Long.parseLong(id)).orElse(null);
		//int i = 1/0; 
		Employe u =  employerepository.findById(id).get(); 
		l.info("user returned : " + u);
		return u; 
	}

}

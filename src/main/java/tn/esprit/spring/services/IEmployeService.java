package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Employe;

public interface IEmployeService { 
	 
	List<Employe> retrieveAllEmployees(); 
	Employe addEmployee(Employe u);
	void deleteEmployee(int id);
	Employe updateEmployee(Employe u);
	//Employe retrieveEmployee(int i);
	public Employe retrieveEmployee(int id);

} 
 
package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Mission;

@Repository
public interface MissionRepository extends JpaRepository <Mission, Integer> {
	
	//@Query

}

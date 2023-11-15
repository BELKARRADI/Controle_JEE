package com.BELKARRADI.control.Repositories;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.BELKARRADI.control.beans.Employe;
import com.BELKARRADI.control.beans.Service;

@Repository
public interface EmployeRepository extends JpaRepository<Employe, Integer> {
 
	List<Employe> findByService(Service  s);
	
	
}

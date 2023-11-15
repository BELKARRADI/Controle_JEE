package com.BELKARRADI.control.Services;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BELKARRADI.control.IDao.IDao;
import com.BELKARRADI.control.Repositories.EmployeRepository;
import com.BELKARRADI.control.beans.Employe;

@Service
public class EmployeService implements IDao<Employe>{

	@Autowired
	EmployeRepository employeRepository;
	@Override
	public Employe create(Employe o) {
		// TODO Auto-generated method stub
		return employeRepository.save(o);
	}

	@Override
	public boolean delete(Employe o) {
		// TODO Auto-generated method stub
		try {
			employeRepository.delete(o);
			return true;
		} catch (Exception e) {
			return false;		}
	}

	@Override
	public Employe update(Employe o) {
		// TODO Auto-generated method stub
		return employeRepository.save(o);
	}

	@Override
	public List<Employe> findAll() {
		// TODO Auto-generated method stub
		return employeRepository.findAll();
	}

	@Override
	public Employe findById(int id) {
		// TODO Auto-generated method stub
		return employeRepository.findById(id).orElse(null);
	}
	
	public List<Employe> findByService(com.BELKARRADI.control.beans.Service s) {
		return employeRepository.findByService(s);
	}

}

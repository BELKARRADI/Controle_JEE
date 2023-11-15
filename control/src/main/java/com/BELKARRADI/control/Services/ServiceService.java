package com.BELKARRADI.control.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.BELKARRADI.control.IDao.IDao;
import com.BELKARRADI.control.Repositories.ServiceRepository;
import com.BELKARRADI.control.beans.Service;

@org.springframework.stereotype.Service
public class ServiceService  implements IDao<Service>{
	
	@Autowired
	ServiceRepository serviceRepository;

	@Override
	public Service create(Service o) {
		// TODO Auto-generated method stub
		return serviceRepository.save(o);
	}

	@Override
	public boolean delete(Service o) {
		// TODO Auto-generated method stub
		try {
			serviceRepository.delete(o);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Service update(Service o) {
		// TODO Auto-generated method stub
		return serviceRepository.save(o);
	}

	@Override
	public List<Service> findAll() {
		// TODO Auto-generated method stub
		return serviceRepository.findAll();
	}

	@Override
	public Service findById(int id) {
		// TODO Auto-generated method stub
		return serviceRepository.findById(id).orElse(null);
	}

}

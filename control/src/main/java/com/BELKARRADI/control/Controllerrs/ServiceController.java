package com.BELKARRADI.control.Controllerrs;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BELKARRADI.control.Services.ServiceService;
import com.BELKARRADI.control.beans.Service;


@RestController
@RequestMapping("/api/Sevice")
public class ServiceController {
	@Autowired
	private ServiceService serviceService;

	@PostMapping("")

	public Service save(@RequestBody Service p) {

		p.setId(0);
		return serviceService.create(p);

	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable int id) {

		Service p = serviceService.findById(id);
		if (p == null) {

			return new ResponseEntity<Object>("Aucun service avec l'id :" + id, HttpStatus.BAD_REQUEST);

		} else {

			return ResponseEntity.ok(p);
		}

	}

	@PutMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable int id, @RequestBody Service service) {

		if (serviceService.findById(id) == null) {

			return new ResponseEntity<Object>("Aucune service avec l'id :" + id, HttpStatus.BAD_REQUEST);

		} else {

			service.setId(id);
			return ResponseEntity.ok(serviceService.update(service));
		}

	}

	@GetMapping("")
	public List<Service> getAll() {
		return serviceService.findAll();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable int id) {

		Service p = serviceService.findById(id);

		if (p == null) {
			return new ResponseEntity<Object>("Aucune service avec l id " + id, HttpStatus.BAD_REQUEST);
		} else {

			serviceService.delete(p);
			return ResponseEntity.ok("Service " + id + " supprimé avec succes");

		}

	}

	

}
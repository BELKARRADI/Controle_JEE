package com.BELKARRADI.control.Controllerrs;

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

import com.BELKARRADI.control.Services.EmployeService;
import com.BELKARRADI.control.beans.Employe;

import com.BELKARRADI.control.beans.Service;


@RestController
@RequestMapping("/api/Employe")
public class EmployeController {
	@Autowired
	private EmployeService employeService;

	@PostMapping("")

	public Employe save(@RequestBody Employe p) {

		p.setId(0);
		return employeService.create(p);

	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable int id) {

		Employe p = employeService.findById(id);
		if (p == null) {

			return new ResponseEntity<Object>("Aucun employe avec l'id :" + id, HttpStatus.BAD_REQUEST);

		} else {

			return ResponseEntity.ok(p);
		}

	}

	@PutMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable int id, @RequestBody Employe employe) {

		if (employeService.findById(id) == null) {

			return new ResponseEntity<Object>("Aucune employe avec l'id :" + id, HttpStatus.BAD_REQUEST);

		} else {

			employe.setId(id);
			return ResponseEntity.ok(employeService.update(employe));
		}

	}

	@GetMapping("")
	public List<Employe> getAll() {
		return employeService.findAll();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable int id) {

		Employe p = employeService.findById(id);

		if (p == null) {
			return new ResponseEntity<Object>("Aucune employe avec l id " + id, HttpStatus.BAD_REQUEST);
		} else {

			employeService.delete(p);
			return ResponseEntity.ok("Employe " + id + " supprimé avec succes");

		}

	}
	@GetMapping("/filtre")
	public List<Employe> getByService(@RequestBody Service s) {
		return employeService.findByService(s);
	}
	

}
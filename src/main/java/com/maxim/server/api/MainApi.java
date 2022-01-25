package com.maxim.server.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maxim.server.controller.MainController;
import com.maxim.server.model.entities.Task;
import com.maxim.server.model.entities.Technician;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/main")
public class MainApi {
	@Autowired
	MainController controller;
	
	@GetMapping ("/all")
	public Iterable<Technician> getAllTechnicians (){
		return controller.getAllTechnicians();
	}
	
	@PostMapping("{techId}")
	public Task addTask (@RequestBody Task task,@PathVariable("techId") long techId) throws Exception {
		return controller.addTask(task, techId);
	}
}

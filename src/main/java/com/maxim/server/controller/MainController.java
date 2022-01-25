package com.maxim.server.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;

import com.maxim.server.model.entities.Task;
import com.maxim.server.model.entities.Technician;

@Controller
public class MainController {

	List<Technician> technicians;
	
	public List<Technician> getAllTechnicians (){
		return technicians;
	}
	
	public Task addTask(Task newTask, long techId) throws Exception {
		Technician technician = findOne(techId);
		addTaskValidation (newTask,technician);
		technician.getTasks().add(newTask);
		return newTask;
	}
	
	private Technician findOne(long techId) throws Exception {
		for (Technician technician : technicians) {
			if (technician.getId()==techId) {
				return technician;
			}
		}
		throw new Exception("Id not found");
	}

	private void addTaskValidation(Task newTask, Technician technician) throws Exception {
		if (technician.getTasks()==null) {
			technician.setTasks(new ArrayList<Task>());
		}
		
		for (Task task : technician.getTasks()) {
			
			Timestamp newBegin = newTask.getBegin();
			Timestamp newEnd = newTask.getEnd();
			Timestamp end = task.getEnd();
			Timestamp begin = task.getBegin();
			System.out.println("!!!!!!!!!!!!!!!!"+newBegin);
			System.out.println("!!!!!!!!!!!!!!!!"+newEnd);
			System.out.println("!!!!!!!!!!!!!!!!"+begin);
			System.out.println("!!!!!!!!!!!!!!!!"+end);
			 if (!newBegin.before(begin)&&(newBegin.before(end))){
			        throw new Exception (" task begin inside another task");
			      }
			      if (end.after(newBegin)&&(!end.after(newEnd))){
			    	  throw new Exception ("task end inside another task");
			   
			      }
			      if (!newBegin.before(begin)&&(newBegin.before(end))){
			    	  throw new Exception ("another task begin inside new task");
			       
			      }
			      if (newEnd.after(begin)&&(newEnd.before(end))){
			    	  throw new Exception ("another task end inside new task");
			      }
		}
		
	}

	@PostConstruct
	private void init (){
		technicians = new ArrayList<Technician>();
		technicians.add(new Technician(1,"Oleg Ivanov"));
		technicians.add(new Technician(2,"Andrey Sokolov"));
		technicians.add(new Technician(3,"Avi Edri"));
	}
}

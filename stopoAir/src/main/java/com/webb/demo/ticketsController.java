package com.webb.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
public class ticketsController {
	
	@Autowired
	ticketsDao __dao;

	@PostMapping("/bookTickets")
	@ResponseBody
	public String createTickets(@RequestBody List<owners> owner)
	{
		System.out.println("inside the controller");
		__dao.saveAll(owner);
		return "success";
	}
	
	
	@GetMapping("/ticketsList")
	@ResponseBody
	public List<owners> getTicketsList(){
		
		System.out.println("get the list");
		return (List<owners>) __dao.findAll();
	}
	
	
	@GetMapping("/ticketsList/{id}")
	@ResponseBody
	public ResponseEntity<Object> getOneList(@PathVariable(value="id") Long id)
	{
		
		Optional<owners> air=__dao.findById(id);
		if(air.isEmpty()) {
			return new ResponseEntity<Object>("Please give correct id",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		else
		{
			return new ResponseEntity<>(air,HttpStatus.FOUND);
		}
	}
	
	@DeleteMapping("/ticketsList/{id}")
	public String deleteAirLines(@PathVariable(value="id") Long id)
	{
	 __dao.deleteById(id);
	 return "success";
	}
	
	
}

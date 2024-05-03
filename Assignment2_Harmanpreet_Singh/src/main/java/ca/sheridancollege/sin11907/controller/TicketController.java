package ca.sheridancollege.sin11907.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ca.sheridancollege.sin11907.beans.Ticket;
import ca.sheridancollege.sin11907.repositories.TicketRepository;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class TicketController {

	
	private TicketRepository ticketRepo;
	
	
	@GetMapping("/")
	public String loadRoot() {

		return "home.html";
		
	}
	
	@GetMapping("/add")
	public String addP(Model model) {
		model.addAttribute("ticket",new Ticket());
		return "addPage.html";
	}
	
	@GetMapping("/addPage")
	public String addPage(@ModelAttribute Ticket ticket, Model model ) {
		
		ticketRepo.addTicket(ticket);
		model.addAttribute("ticket", new Ticket());
		return "addPage.html";
	}
	
	@GetMapping("/viewPage")
	public String viewPage(Model model) {
		ArrayList<Ticket> ticket= ticketRepo.getTickets2();
		model.addAttribute("ticket",ticket);
		return "viewPage.html";
	}
	
	@GetMapping("/edit/{id}")
		public String editTicket(Model model, @PathVariable int id) {
			// Get the drink with the specifc id
		Ticket ticket = ticketRepo.getTicketByID(id);
			//Send that drink to a specific edit page
		model.addAttribute("ticket",ticket);
		return "edit.html";
	}
	
	@PostMapping("/edit")
	public String processEdit(@ModelAttribute Ticket ticket) {
		Ticket d = ticket;
		ticketRepo.editTicket(d);
		
		//Go back to my view page
		return "redirect:/viewPage";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteData(@ModelAttribute Ticket ticket) {
		Ticket d = ticket;
		ticketRepo.deleteTicket(d);
		
		return "redirect:/viewPage";
		
	}
	@GetMapping("/stats")
	public String ststPage(Model model) {
		ArrayList<Ticket> tickets = ticketRepo.Cars();
		model.addAttribute("tickets", tickets);
		
		ArrayList<Ticket> Walltickets = ticketRepo.Wall();
		model.addAttribute("Walltickets", Walltickets);
		
		ArrayList<Ticket> COCOtickets = ticketRepo.COCO();
		model.addAttribute("COCOtickets", COCOtickets);
		
		ArrayList<Ticket> Othertickets = ticketRepo.Other();
		model.addAttribute("Othertickets", Othertickets);
		
		ArrayList<Ticket> Tangledtickets = ticketRepo.Tangled();
		model.addAttribute("Tangledtickets", Tangledtickets);
		
		return "statsPage.html";
		
	}
}
	
	


	
	



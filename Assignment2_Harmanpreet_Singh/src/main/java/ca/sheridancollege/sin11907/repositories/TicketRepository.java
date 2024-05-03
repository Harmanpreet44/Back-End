package ca.sheridancollege.sin11907.repositories;

import java.util.*;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.sin11907.beans.Ticket;
import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class TicketRepository {

	private NamedParameterJdbcTemplate jdbc;
	
	public void addTicket(Ticket ticket) {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query ="INSERT INTO easy_tickets (ticket_name, main1, amount1, main2, amount2, directions, genre) VALUES (:name,:m1,:a1,:m2,:a2,:dir,:gen)";
		parameters.addValue("name", ticket.getTicket_name());
		parameters.addValue		("m1",ticket.getMain1());
		parameters.addValue		("a1",ticket.getAmount1());
		parameters.addValue		("m2",ticket.getMain2());
		parameters.addValue		("a2",ticket.getAmount2());
		parameters.addValue		("dir",ticket.getDirections());
		parameters.addValue		("gen",ticket.getGenre());
		
		
				jdbc.update(query,parameters);
	}
	
	public ArrayList<Ticket> getTickets(){
		ArrayList<Ticket> tickets = new ArrayList<Ticket>();
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query="Select * from easy_tickets";
		
		List<Map<String,Object>> rows = jdbc.queryForList(query,parameters);
		for(Map<String,Object> row : rows) {
			Ticket d = new Ticket();
			d.setId((Integer)row.get("id"));
			d.setTicket_name((String)row.get("ticket_name"));
			d.setMain1((String)row.get("main1"));
			d.setAmount1((int)row.get("amount1"));
			d.setMain2((String)row.get("main2"));
			d.setAmount2((int)row.get("amount2"));
			d.setDirections((String)row.get("directions"));
			d.setGenre((String)row.get("genre"));
			
			tickets.add(d);
			
		}
		
		return tickets;
	}
	
	public ArrayList<Ticket> getTickets2(){
		
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query="Select * from easy_tickets";
		
		ArrayList<Ticket> tickets = (ArrayList<Ticket>)jdbc.query(query, parameters, new BeanPropertyRowMapper<Ticket>(Ticket.class));
		
		return tickets;
	}
	
	public Ticket getTicketByID(int id){
		ArrayList<Ticket> tickets = new ArrayList<Ticket>();
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query="Select * from easy_tickets WHERE ID=:woof";
		parameters.addValue("woof",id);
		List<Map<String,Object>> rows = jdbc.queryForList(query,parameters);
		for(Map<String,Object> row : rows) {
			Ticket d = new Ticket();
			d.setId((Integer)row.get("id"));
			d.setTicket_name((String)row.get("ticket_name"));
			d.setMain1((String)row.get("main1"));
			d.setAmount1((int)row.get("amount1"));
			d.setMain2((String)row.get("main2"));
			d.setAmount2((int)row.get("amount2"));
			d.setDirections((String)row.get("directions"));
			d.setGenre((String)row.get("genre"));
			tickets.add(d);
			
		}
		// I am only expecting 0 or 1 tickets
		if(tickets.size()>0) {
			return tickets.get(0);
		}else {
		return null;
		}
	}

	public void editTicket(Ticket ticket) {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
	String query="UPDATE easy_tickets SET ticket_name=:name,main1=:m1,amount1=:a1,main2=:m2,amount2=:a2,directions=:dir, genre=:gen WHERE ID=:id";
	parameters.addValue("name", ticket.getTicket_name());
	parameters.addValue		("m1",ticket.getMain1());
	parameters.addValue		("a1",ticket.getAmount1());
	parameters.addValue		("m2",ticket.getMain2());
	parameters.addValue		("a2",ticket.getAmount2());
	parameters.addValue		("dir",ticket.getDirections());
	parameters.addValue		("gen",ticket.getGenre());
	parameters.addValue		("id", ticket.getId());
	
	jdbc.update(query,parameters);
	}

	public void deleteTicket(Ticket ticket) {
		MapSqlParameterSource parameters = new MapSqlParameterSource();
	String query="DELETE FROM easy_tickets WHERE ID=:id";
	parameters.addValue("name", ticket.getTicket_name());
	parameters.addValue		("m1",ticket.getMain1());
	parameters.addValue		("a1",ticket.getAmount1());
	parameters.addValue		("m2",ticket.getMain2());
	parameters.addValue		("a2",ticket.getAmount2());
	parameters.addValue		("dir",ticket.getDirections());
	parameters.addValue		("gen",ticket.getGenre());
	parameters.addValue		("id", ticket.getId());
	
	jdbc.update(query,parameters);
		
	}
	public ArrayList<Ticket> Cars(){
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "select *from easy_tickets where genre = 'Cars'";
		ArrayList<Ticket> tickets = (ArrayList<Ticket>)jdbc.query(query,parameters, new BeanPropertyRowMapper<Ticket>(Ticket.class));
		return tickets;
	}
	public ArrayList<Ticket> Wall(){
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "select *from easy_tickets where genre = 'Wall E'";
		ArrayList<Ticket> Walltickets = (ArrayList<Ticket>)jdbc.query(query,parameters, new BeanPropertyRowMapper<Ticket>(Ticket.class));
		return Walltickets;
	}
	public ArrayList<Ticket> COCO(){
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "select *from easy_tickets where genre = 'COCO'";
		ArrayList<Ticket> COCOtickets = (ArrayList<Ticket>)jdbc.query(query,parameters, new BeanPropertyRowMapper<Ticket>(Ticket.class));
		return COCOtickets;
	}
	
	public ArrayList<Ticket> Other(){
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query = "select *from easy_tickets where genre = 'Others'";
		
		ArrayList<Ticket> Othertickets = (ArrayList<Ticket>)jdbc.query(query,parameters, new BeanPropertyRowMapper<Ticket>(Ticket.class));
		return Othertickets;
	}
		
		public ArrayList<Ticket> Tangled(){
			MapSqlParameterSource parameters = new MapSqlParameterSource();
			String query = "select *from easy_tickets where genre = 'Tangled'";
			ArrayList<Ticket> Tangledtickets = (ArrayList<Ticket>)jdbc.query(query,parameters, new BeanPropertyRowMapper<Ticket>(Ticket.class));
			return Tangledtickets;
			
	}
}

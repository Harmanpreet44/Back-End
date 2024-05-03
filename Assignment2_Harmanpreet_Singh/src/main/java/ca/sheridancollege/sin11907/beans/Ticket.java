package ca.sheridancollege.sin11907.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Ticket {
	
	private int id;
	private String ticket_name;
	private String main1;
	private int amount1;
	private String main2;
	private int amount2;
	private String directions;
	private String genre;
	private String [] categories = {"Cars","","Wall E","COCO","Tangled","Others"};
}

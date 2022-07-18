package ca.sheridancollege.antonye.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ca.sheridancollege.antonye.dao.ClubDatabaseAccess;
import ca.sheridancollege.antonye.model.Club;

@Controller
public class MidtermPart2H2DatabaseController {
	@Autowired
	private ClubDatabaseAccess cda;
	

	@GetMapping("/index")
	public String index() {
	return "index";
    }
	
	@GetMapping("/clubDataInput")
	public String clubDataInput(Model model) {
	model.addAttribute("club", new Club());
	return "clubDataInput";
	}
	
	@PostMapping("/clubDataInput")
	public String addClubMember(Model model, @ModelAttribute Club club) {
	String message;
	long numberOfRows=cda.addClubMember(club);
	if (numberOfRows > 0)
	{message="Success! The club object successfully added to the database.";}
	else
	{message ="Failure The club object is not added to the database.";}
	model. addAttribute ("message", message) ;
	return "clubMemberAddOutcome";
	}
	
	@GetMapping ("/listOfMembers")
	public String viewListofClubMembers (Model model) {
	List<Club> club = cda.selectClubMember();
	model.addAttribute ("club", club) ;
	return "listOfMembers";
	}
	
	@GetMapping("/phoneNumberBasedSearch")
	public String clubMemberPhoneNumberInput(Model model) {
	return "phoneNumberBasedSearch";
	}

	@PostMapping("/phoneNumberBasedSearch")
	public String phoneNumberSearch(Model model, @RequestParam String memberPhoneNumber) {
	List<Club> clubs =cda.selectmemberByPhoneNumber(memberPhoneNumber);
	model.addAttribute("club", clubs) ;
	return "listOfMembers";
	}


}

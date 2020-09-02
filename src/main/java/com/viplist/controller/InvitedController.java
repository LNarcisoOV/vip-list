package com.viplist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.viplist.model.Invited;
import com.viplist.repository.InvitedRepository;

@Controller
@RequestMapping(value = "/invitedlist")
public class InvitedController {

	@Autowired
	private InvitedRepository invitedRepository;
	
	
	@RequestMapping(value="/")
	public String invitedList(Model model) {
		List<Invited> invitedList = invitedRepository.findAll();
		model.addAttribute("invitedList", invitedList);
		return "invitedlist";
	}

}

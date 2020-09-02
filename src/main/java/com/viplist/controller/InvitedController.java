package com.viplist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/invitedlist")
public class InvitedController {

	@RequestMapping(value="/")
	public String invitedList() {
		return "invitedlist";
	}

}

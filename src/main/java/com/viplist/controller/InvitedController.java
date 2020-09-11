package com.viplist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.viplist.model.Invited;
import com.viplist.service.InvitedService;

@RestController
@RequestMapping(value = "/invitedlist")
public class InvitedController {

	@Autowired
	private InvitedService invitedService;

	@GetMapping(value = "/")
	public ResponseEntity<List<Invited>> invitedList(Model model) {
		List<Invited> invitedList = invitedService.findAll();
		return new ResponseEntity<List<Invited>>(invitedList, HttpStatus.OK);
	}

	@PostMapping(value = "/send-email")
	public ResponseEntity<Object> sendEmail() {
		invitedService.sendEmail();
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
}

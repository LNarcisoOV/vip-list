package com.viplist.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.alura.sendemail.service.EmailService;
import com.viplist.model.Invited;
import com.viplist.repository.InvitedRepository;

@Service
public class InvitedService {
	
	@Autowired
	private InvitedRepository invitedRepository;

	public List<Invited> findAll() {
		return invitedRepository.findAll();
	}
	
	public Invited findById(Integer id) {
		Optional<Invited> optInv = invitedRepository.findById(id);
		return optInv.get();
	}

	public int sendEmail() {
		try {
			List<Invited> invitedList = invitedRepository.findAll();
			EmailService emailService = new EmailService();
			invitedList.forEach(inv -> emailService.send(inv.getEmail()));
			return HttpStatus.OK.value();
		} catch (RuntimeException e) {
			return HttpStatus.INTERNAL_SERVER_ERROR.value();
		}
	}
}

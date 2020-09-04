package com.viplist.repository;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import javax.annotation.PostConstruct;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import com.viplist.model.Invited;

@SpringBootTest
@AutoConfigureMockMvc
class InvitedRepositoryTest {

	private static final String DEFAULT_NAME = "Jaco Pastorius";

	@Autowired
	private InvitedRepository invitedRepository;
	
	private Invited invited;
	
	@PostConstruct
	void init() {
		invited = new Invited();
		invited.setId(4);
		invited.setName(DEFAULT_NAME);
		invited.setEmail("jaco@gmail.com");
		invited.setTelephone("32233223");
		invited = invitedRepository.save(invited);
	}
	
	@Test
	void shouldGetCorrectInvitedById() throws Exception {
		Optional<Invited> invitedDB = invitedRepository.findById(4);
		assertTrue(invitedDB.isPresent() && invitedDB.get().getName().equalsIgnoreCase(DEFAULT_NAME));
	}

	@Test
	void shouldTestTheSizeOfTheList() throws Exception {
		assertTrue(invitedRepository.findAll() != null && invitedRepository.findAll().size() == 4);
	}
	
	@Test
	void shouldRemoveInvited() throws Exception {
		invitedRepository.delete(invited);
		Optional<Invited> invited = invitedRepository.findById(4);
		assertFalse(invited.isPresent());
	}
}

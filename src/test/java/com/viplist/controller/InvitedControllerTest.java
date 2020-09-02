package com.viplist.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.Optional;

import javax.annotation.PostConstruct;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.viplist.model.Invited;
import com.viplist.repository.InvitedRepository;

@SpringBootTest
@WebAppConfiguration
@ActiveProfiles("teste")
public class InvitedControllerTest {

	private static final String DEFAULT_NAME = "Jaco Pastorius";

	@Autowired
	private InvitedController invitedController;

	private MockMvc invitedlMockMvc;

	@Autowired
	private InvitedRepository invitedRepository;

	private Invited invited;

	@PostConstruct
	private void setup() {
		this.invitedlMockMvc = MockMvcBuilders.standaloneSetup(invitedController).build();

		invited = new Invited();
		invited.setId(4);
		invited.setName(DEFAULT_NAME);
		invited.setEmail("jaco@gmail.com");
		invited.setTelephone("32233223");
		invited = invitedRepository.save(invited);
	}

//	@Test
//	public void shouldGetStatusOKCallingVipList() throws Exception {
//		MvcResult mvcResult = (MvcResult) invitedlMockMvc.perform(get("/"))
//				.accept(MediaType.TEXT_HTML)
//                .contentType(MediaType.TEXT_HTML)
//				.andExpect(view().name("invitedlist"))
//				.andExpect(forwardedUrl("/templates/invitedlist.html"));
//				.andReturn();
//	}

	@Test
	public void shouldGetCorrectInvitedById() throws Exception {
		Optional<Invited> invitedDB = invitedRepository.findById(4);
		assertTrue(invitedDB.isPresent() && invitedDB.get().getName().equalsIgnoreCase(DEFAULT_NAME));
	}

	@Test
	public void shouldTestTheSizeOfTheList() throws Exception {
		assertNotNull(invitedRepository.findAll().size() == 4);
	}
}

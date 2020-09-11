package com.viplist.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.viplist.service.InvitedService;

@SpringBootTest
@AutoConfigureMockMvc
class InvitedControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@InjectMocks
	private InvitedController invitedController;
	
	@Mock
	private InvitedService invitedService;
	
	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(invitedController).build();
	}

	@Test
	void shouldGetStatusOKCallingVipList() throws Exception {
		this.mockMvc.perform(get("/invitedlist/")).andExpect(status().isOk()).andReturn();
	}
}

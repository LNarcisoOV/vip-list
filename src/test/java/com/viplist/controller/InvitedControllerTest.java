package com.viplist.controller;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.viplist.model.Invited;

@SpringBootTest
@AutoConfigureMockMvc
class InvitedControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void shouldGetStatusOKCallingVipList() throws Exception {
		MvcResult result = this.mockMvc.perform(get("/invitedlist/")).andExpect(status().isOk()).andReturn();
		List<Invited> invitedResponseList = new ObjectMapper().readValue(result.getResponse().getContentAsString(),
				new TypeReference<List<Invited>>() {
				});
		assertTrue(invitedResponseList != null && !invitedResponseList.isEmpty() && invitedResponseList.size() == 3);
	}
}

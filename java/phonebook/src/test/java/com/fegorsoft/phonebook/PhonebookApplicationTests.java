package com.fegorsoft.phonebook;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertEquals;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Collection;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import com.fegorsoft.phonebook.controller.PhonebookController;
import com.fegorsoft.phonebook.model.People;

@SpringBootTest
@AutoConfigureMockMvc
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class PhonebookApplicationTests {

	@Autowired
	private PhonebookController phonebookController;

	@Autowired
	private MockMvc mockMvc;

	@Test
	void pricesControllerTest() throws Exception {
		this.mockMvc.perform(
				get("/phonebook/forCreateDate?startDate=01/01/2020 00:00:00&endDate=01/01/2025 00:00:00")
						.contentType(APPLICATION_JSON))
				.andDo(MockMvcResultHandlers.print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(3)));

		Collection<People> prices = this.phonebookController.getAllPeople();
		People firstPrice = prices.iterator().next();
		assertEquals("AAAAA", firstPrice.getName());
	}
}

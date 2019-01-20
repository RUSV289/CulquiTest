package com.culqui;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.culqui.entity.Card;
import com.culqui.entity.CardToken;
import com.culqui.service.BasicCardService;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.http.MediaType.APPLICATION_JSON;

@RunWith(SpringRunner.class)
@WebMvcTest(BasicCardService.class)
public class CulquiTestApplicationTests {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private BasicCardService basicCardService;
		   
	@Test
	public void contextLoads() throws Exception{
		Card card = new Card("4444333322221111", "2020", "10");
		CardToken cardToken = new CardToken();
		
		given(basicCardService.generarTokenTarjeta(card)).willReturn(cardToken);
		
		mvc.perform(post("http://localhost:8085/token")
	    .contentType(APPLICATION_JSON))
	    .andExpect(status().isOk());
            		     
	}

}


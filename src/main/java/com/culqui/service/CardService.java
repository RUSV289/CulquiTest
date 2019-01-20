package com.culqui.service;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.culqui.entity.Card;
import com.culqui.entity.CardToken;

public interface CardService {

	@RequestMapping(method = RequestMethod.POST, value="/token")
	public CardToken generarTokenTarjeta(@RequestBody Card tarjeta);
}

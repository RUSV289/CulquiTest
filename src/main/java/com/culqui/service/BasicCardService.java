package com.culqui.service;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.culqui.client.RestCardClient;
import com.culqui.entity.Card;
import com.culqui.entity.CardBinlist;
import com.culqui.entity.CardToken;
import com.culqui.util.PropertiesCulquiTest;
import com.culqui.util.UtilCulqui;

@RestController()
public class BasicCardService implements CardService{
	
	private static final Logger log = LoggerFactory.getLogger(BasicCardService.class);
	
	@Autowired
	RestCardClient restCardClient;
	
	@Autowired
	UtilCulqui util;
	
	@Autowired
	PropertiesCulquiTest propertiesCulquiTest;
	
	CardBinlist cardBinlist;
	CardToken cardToken;
	Date fechaHora;
	private String FORMATO_FECHA;
	
	public CardToken generarTokenTarjeta(Card card) {
		FORMATO_FECHA = propertiesCulquiTest.fechaFormatoCulquiTest;
		String codBin = "";
		String tkn_live = "";
		String brand = "";
		String dateString = "";

		log.info("---------------------------------------------");
		log.info("Método: generarTokenTarjeta");
		log.info("---------------------------------------------");
		codBin = card.getPan().substring(0, 6);
		cardBinlist = restCardClient.callBinlistService(codBin);
		
		tkn_live = "tkn_live_"+card.getPan()+"-"+card.getExp_year()+"-"+card.getExp_month();
		brand = cardBinlist.getScheme();
		dateString = util.formatoFechaString(new Date(), FORMATO_FECHA);
		
		cardToken = new CardToken(tkn_live, brand, dateString);
		
		log.info("Json Respuesta Generado: ");
		log.info(util.objectToJson(cardToken));
		
		return cardToken;
	}

}

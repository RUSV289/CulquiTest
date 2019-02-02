package com.culqui.service;

import java.util.Date;

import com.culqui.client.RestAutorizacionClient;
import com.culqui.entity.Autorizacion;
import org.apache.http.impl.client.DefaultHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
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
	RestAutorizacionClient restAutorizacionClient;
	
	@Autowired
	UtilCulqui util;
	
	@Autowired
	PropertiesCulquiTest propertiesCulquiTest;
	
	CardBinlist cardBinlist;
	CardToken cardToken;
	Date fechaHora;
	private String FORMATO_FECHA;
	

	@Override
	public CardToken generarTokenTarjeta(Card card, HttpHeaders headers) {
		FORMATO_FECHA = propertiesCulquiTest.fechaFormatoCulquiTest;
		String codBin = "";
		String tkn_live = "";
		String brand = "";
		String dateString = "";

		log.info("---------------------------------------------");
		log.info("Método: generarTokenTarjeta");
		log.info("---------------------------------------------");

		headers.set("clave", "abcdefg");

		codBin = card.getPan().substring(0, 6);

		log.info("Invoca al servicio de autorización: ");
		Autorizacion autorizacion = restAutorizacionClient.callBinlistService(codBin);

		if(autorizacion.getValor()){
			log.info("Paso la autorización: ");
			cardBinlist = restCardClient.callBinlistService(codBin);

			tkn_live = "tkn_live_"+card.getPan()+"-"+card.getExp_year()+"-"+card.getExp_month();
			brand = cardBinlist.getScheme();
			dateString = util.formatoFechaString(new Date(), FORMATO_FECHA);

			cardToken = new CardToken(tkn_live, brand, dateString);

			log.info("Json Respuesta Generado: ");
			log.info(util.objectToJson(cardToken));
		}else{
			log.info("No paso el servicio de autorización ");

		}


		return cardToken;
	}
}

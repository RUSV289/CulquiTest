package com.culqui.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.culqui.entity.CardBinlist;
import com.culqui.util.PropertiesCulquiTest;
import com.culqui.util.UtilCulqui;


@Component
public class RestCardClient {
	
	private static final Logger log = LoggerFactory.getLogger(RestCardClient.class);
	
	@Autowired
	UtilCulqui util;
	
	@Autowired
	PropertiesCulquiTest propertiesCulquiTest;
	
	private RestTemplate restTemplate;
	private String URL;

	public CardBinlist callBinlistService(String bin) {
		URL = propertiesCulquiTest.urlBinlist;
		log.info("---------------------------------------------");
		log.info("Método: callBinlistService");
		log.info("---------------------------------------------");
		log.info("URL: "+ URL);
		log.info("Parametro bin: "+bin);
		restTemplate = new RestTemplate();
		CardBinlist cardBinlist = restTemplate.getForObject(URL, CardBinlist.class, bin);
		log.info("Json Respuesta Servicio: ");
		log.info(util.objectToJson(cardBinlist));
		
		return cardBinlist;
	}
}

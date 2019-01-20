package com.culqui.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class UtilCulqui {
	private static final Logger log = LoggerFactory.getLogger(UtilCulqui.class);
	
	public String objectToJson(Object object){
		
		String json = "";
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
		} catch (JsonProcessingException e) {
			
			log.error("Error convirtiendo objeto a JSON ", e);
		}
		return json;
	}
	
	public String formatoFechaString(Date date, String formato){
		String dateFormat = "";
		try {
			SimpleDateFormat formatDate = new SimpleDateFormat(formato);
			dateFormat =  formatDate.format(date);
		} catch (Exception e) {
			log.error("Error convirtiendo Date a formato: "+formato, e);
		}
		return dateFormat;
	}

}

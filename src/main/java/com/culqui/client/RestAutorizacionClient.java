package com.culqui.client;

import com.culqui.entity.Autorizacion;
import com.culqui.entity.CardBinlist;
import com.culqui.util.PropertiesCulquiTest;
import com.culqui.util.UtilCulqui;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestAutorizacionClient {
    private static final Logger log = LoggerFactory.getLogger(RestCardClient.class);

    @Autowired
    UtilCulqui util;

    @Autowired
    PropertiesCulquiTest propertiesCulquiTest;

    private RestTemplate restTemplate;
    private String URL;

    public Autorizacion callBinlistService(String bin) {
        URL = propertiesCulquiTest.valida;
        log.info("---------------------------------------------");
        log.info("Método: callBinlistService");
        log.info("---------------------------------------------");
        log.info("URL: "+ URL);
        log.info("Parametro bin: "+bin);
        restTemplate = new RestTemplate();

        Autorizacion autorizacion = restTemplate.getForObject(URL, Autorizacion.class, bin);
        log.info("Json Respuesta Servicio: ");
        log.info(util.objectToJson(autorizacion));

        return autorizacion;
}

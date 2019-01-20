package com.culqui.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:culquiTest.properties")
public class PropertiesCulquiTest {

	@Value( "${url.binlist}" )
	public String urlBinlist;

	@Value( "${fecha.formato.culqui.test}" )
	public String fechaFormatoCulquiTest;
}

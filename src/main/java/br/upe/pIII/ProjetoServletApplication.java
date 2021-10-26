package br.upe.pIII;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

@ServletComponentScan
@SpringBootApplication
public class ProjetoServletApplication {

//	@Bean
//	public RestTemplate restTemplate(List<HttpMessageConverter<?>>
//	messageConverters) {
//	return new RestTemplate(messageConverters);
//	}
	
	
	@Bean
	public RestTemplate restTemplate() {
	   final RestTemplate restTemplate = new RestTemplate();

	   List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
	   MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
	   converter.setSupportedMediaTypes(Collections.singletonList(org.springframework.http.MediaType.ALL));
	   messageConverters.add(converter);
	   restTemplate.setMessageConverters(messageConverters);

	   return restTemplate;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ProjetoServletApplication.class, args);
	}

}

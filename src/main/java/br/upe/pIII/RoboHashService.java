package br.upe.pIII;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;



@Service
public class RoboHashService {

	private static String URI = "https://robohash.org/";
	
	public InputStream GerarAvatar(String nome) {
		
		try {
			URL url = new URL(URI + nome);
		    InputStream is = url.openStream();
		    
		    return is;
		} catch (Exception e) {
			return null;
		}
		
	}
	
	
}

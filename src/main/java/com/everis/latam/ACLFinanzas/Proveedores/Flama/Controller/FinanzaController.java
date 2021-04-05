package com.everis.latam.ACLFinanzas.Proveedores.Flama.Controller;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.everis.latam.ACLFinanzas.Proveedores.Flama.Entity.Response;
import com.everis.latam.ACLFinanzas.Proveedores.Flama.Exception.BadRequestException;
import com.everis.latam.ACLFinanzas.Proveedores.Flama.Exception.ExceptionPost;
import com.everis.latam.ACLFinanzas.Proveedores.Flama.dto.RequestDto;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
@RequestMapping(value="/")
public class FinanzaController {
	
	/*private HttpHeaders headers = new HttpHeaders();
	@Autowired
	RestTemplate restTemplate;*/
	
	
	
	@RequestMapping(value="",method = RequestMethod.POST)
	public ResponseEntity<String> cosa() {
		return new ResponseEntity<>("holaa",HttpStatus.OK);
	}
	
	@RequestMapping(value ="finanza", method = RequestMethod.POST, consumes= "application/json")
	public ResponseEntity<Response> finanzasRequest(@RequestBody RequestDto req) throws BadRequestException{
		
		RequestDto reqDto = new RequestDto();
		reqDto = req;
		log.info("reqdto"+reqDto);
		try {
			
			//aqui se consume el api de finanzas , la ruta esta en URLs
			/*
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			HttpEntity<RequestDto> entity = new HttpEntity<>(reqDto,headers);

			Response res = restTemplate.exchange(
					URLs.apiURL, HttpMethod.POST, entity, Response.class).getBody();
			*/
			
			
			//respuesta de prueba
			SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date(System.currentTimeMillis());
			
			int min = 1;
		    int max = 2000;
		        
		    //Generate random int value from 1 to 2000 
		    System.out.println("Random value in int from "+min+" to "+max+ ":");
		    int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
		    
			
		    Response res = new Response();
			res.setEstatus("3");
			res.setFechaResolucion(date);
			res.setIdResolucion(random_int);
			res.setIdSolicitud(reqDto.getIdSolicitud());
			res.setMontoTotal(reqDto.getMonto());
			
			log.info("Procedimiento correcto en FinanzaController, metodo: finanzasRequest");
			log.info("Respuesta enviada = " +res);
			return new ResponseEntity<>(res, HttpStatus.OK);
		} catch (Exception e) {
			log.error("Error en FinanzaController, metodo: finanzasRequest");
			throw new BadRequestException(ExceptionPost.error);
		}
		
	}
}

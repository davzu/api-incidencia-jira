package pe.com.mibanco.serviceManagement.chatbot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.mibanco.serviceManagement.chatbot.model.IncidenciaJira;
import pe.com.mibanco.serviceManagement.chatbot.service.IncidenciaService;

@RestController
@RequestMapping(value="/incidencia")
public class IncidenciaController {
	
	@Autowired
	private IncidenciaService incidenciaService;
	
	@GetMapping(value="/{key}")
	public ResponseEntity<IncidenciaJira> obtenerIncidencia(@PathVariable String key) {
		IncidenciaJira incidenciaJira = new IncidenciaJira();
		
//		try {
			incidenciaJira = incidenciaService.obtenerIncidencia(key);
			
//			if(incidenciaJira == null) {
//				
//			}
//		} catch (Exception e) {
//			return new ResponseEntity<IncidenciaJira>(incidenciaJira, HttpStatus.INTERNAL_SERVER_ERROR);
//		}
		
		return new ResponseEntity<IncidenciaJira>(incidenciaJira, HttpStatus.OK);
	}

}

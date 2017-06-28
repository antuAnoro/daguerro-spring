package app.controllers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PublicController {
	
	// Peticiones al front
	@GetMapping("/")
	public String getFront(Map<String, Object> model) {
		
		return "public/front";
	}
	
	// Mensajes de error públicos
	@GetMapping("/error")
	public String getError(@RequestParam("mensajeError") String mensajeError,Map<String, Object> model) {
		
		model.put("mensajeError", mensajeError);
		
		return "public/error";
	}
	
	// Peticiones de documentos publicos
	@GetMapping("/public/{ruta}")
	public String getPublic(@PathVariable String ruta, Map<String, Object> model) {		
	
		return "public/"+ruta;
	}
	
}

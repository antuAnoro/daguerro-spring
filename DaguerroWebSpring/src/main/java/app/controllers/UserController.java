package app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import app.models.User;
import app.services.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
		
	@Autowired
	private UserService userService;
	
	@GetMapping("/{ruta}")
	public String getUser(@PathVariable String ruta, Model model) {
		return "user/"+ ruta;
	}
	
	//TODO Añadir tratamiento para welcome, necesitamos validar el login
	
    @RequestMapping("/activate")
    public String activate(String activation) {
        User u = userService.activate(activation);
        if(u != null) {
        	// Me autologo, con el password por defecto
            userService.autoLogin(u);
            // Con la misma redirijo al cambio de contraseña, para permitirle cambiarla por primera vez
            return "redirect:/user/reset-password-change?token="+activation;
        }
        // TODO Refinar para que aparezca en iframe
        return "redirect:/error?message=Clave de activación no válida, por favor contacte con soporte";
    }
	

}
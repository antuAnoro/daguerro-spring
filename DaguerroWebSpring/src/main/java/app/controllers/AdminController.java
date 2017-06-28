package app.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import app.models.User;
import app.repositories.UserRepository;
import app.services.MailService;
import app.services.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {	
	
	@Autowired
	private UserService userService;
	
   @Autowired
    private UserRepository userRepository;
   
   @Autowired
   private MailService mailService;
	
	@GetMapping("/gestionUsuarios")
	public String doGestionarUsuarios(Model model) {
		// Vamos a cargar en el modelo la lista de usuarios obtenida del servicio
		Iterable<User> listaUsuarios = userRepository.findAll();
		model.addAttribute("listaUsuarios", listaUsuarios);
		
		return "admin/gestionUsuarios";
	}
	
	@GetMapping("/altaUsuario")
	public String doAltaUsuario(Model model) {
		// Creamos un objeto para el formulario de alta
		User nuevoUsuario = new User();
		model.addAttribute("userForm",nuevoUsuario);
		
		return "admin/altaUsuario";
	}
	
	@PostMapping("/registrarUsuario")
	public String doRegistrarUsuario(@Valid @ModelAttribute("userForm") User usuario, BindingResult result, Model model) {
		// Primero debemos validar las entradas del formulario. Asumimos los errores de username y password, ya que en el registro no se pasan.
		if (result.getErrorCount()>2) {
			return "admin/altaUsuario";
		}
		
		//Siguiente, vemos si podemos registrar el usuario mediante el servicio		
		User usuarioRegistrado = userService.register(usuario);
		
		if (usuarioRegistrado!=null){
			// He registrado un nuevo usuario, debo enviar el mail de activacion por primera vez
			mailService.sendNewRegistration(usuarioRegistrado.getEmail(), usuarioRegistrado.getToken());			
			
			// TODO Aquí empezaría toda la lógica del registro para el usuario
			
			// Si todo va bien, me vuelvo a la lista
			return "redirect:/admin/gestionUsuarios";
		}else{
			// Si la cosa va mal, vuelvo al formulario de alta.
			
			// Vamos a añadir el error para que se muestre en el usuario
			result.rejectValue("userName", "user.error", "El usuario ya existe");

			return "admin/altaUsuario";
		}
		
	}
	
	@GetMapping("/bajaUsuario")
	public String doBajaUsuario(Long id) {
		// Creamos un objeto para el formulario de alta
		userService.delete(id);
		
		// Si todo va bien, me vuelvo a la lista
		return "redirect:/admin/gestionUsuarios";
	}
}
package com.senacre.ecommerce.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.senacre.ecommerce.Model.Usuario;
import com.senacre.ecommerce.Model.Repositories.UserRepository;

import jakarta.validation.Valid;


@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/home")
    public String home() {
        return "/user/publica-index";
    }

    @GetMapping("/lista")
    public ModelAndView listarUsuarios() {
       List<Usuario> usuarios = this.userRepository.findAll();
       ModelAndView mv = new ModelAndView("/user/lista-usuarios");
       mv.addObject("usuarios", usuarios);

       return mv;
    }

    @GetMapping("/novo")
	public String adicionarUsuario() {
		return "/user/criar-usuario";
	}
	
	@PostMapping("/salvar")
	public String salvarUsuario(@Validated Usuario usuario, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return "/user/criar-usuario";
		}	
		userRepository.save(usuario);
		attributes.addFlashAttribute("mensagem", "Usuário salvo com sucesso!");
		return "redirect:/usuario/lista";
	}

/*Editar usuarios */
    @GetMapping("/editar/{id}")
	public String editarUsuario(@PathVariable("id") long id, Model model) {
		Optional<Usuario> usuarioVelho = userRepository.findById(id);
		if (!usuarioVelho.isPresent()) {
            throw new IllegalArgumentException("Usuário inválido:" + id);
        } 
		Usuario usuario = usuarioVelho.get();
	    model.addAttribute("usuario", usuario);
	    return "/user/alterar-usuario";
	}
	
	@PostMapping("/editar/{id}")
	public String editarUsuario(@PathVariable("id") long id, 
			@Valid Usuario usuario, BindingResult result) {
		if (result.hasErrors()) {
	    	usuario.setId(id);
	        return "/user/alterar-usuario";
	    }
	    userRepository.save(usuario);
	    return "redirect:/usuario/lista";
	}

    
}

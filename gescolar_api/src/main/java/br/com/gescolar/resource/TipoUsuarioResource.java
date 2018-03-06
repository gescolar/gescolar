package br.com.gescolar.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gescolar.model.TipoUsuario;
import br.com.gescolar.repository.TipoUsuarioRepository;

@RestController
@RequestMapping("/tipoUsuario")
public class TipoUsuarioResource {
	
	@Autowired
	private TipoUsuarioRepository tipoUsuarioRepository;  
	
	@GetMapping
	public List<TipoUsuario> listar() {
		return this.tipoUsuarioRepository.findAll();
	}

}

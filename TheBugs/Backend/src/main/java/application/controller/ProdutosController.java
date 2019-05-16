package application.controller;

import java.util.List;

import javax.validation.Valid;


import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import application.model.Produto;
import application.repository.Produtos;

@RestController
@RequestMapping("")
public class ProdutosController {

	@Autowired
	private Produtos produtos;
	
	@PostMapping("/produtos")
	public Produto adicionar(@Valid @RequestBody Produto produto) {
		return produtos.save(produto);
	}
	@GetMapping("/produtos")
	public @ResponseBody Iterable<Produto> listar() {
		return produtos.findAll();
	}
}

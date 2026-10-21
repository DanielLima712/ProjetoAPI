package com.matera.api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.matera.api.model.Servicos;
import com.matera.api.service.ServicosService;

@RestController
@RequestMapping("/servicos")
public class ServicosController {

	private final ServicosService service;

	public ServicosController(ServicosService service) {
		this.service = service;
	}

	//GET /servicos - lista todos os serviços
	@GetMapping
	public List<Servicos> findAll() {
		return service.findAll();
	}

	//GET /servicos/{id} - busca um serviço pelo ID
	@GetMapping("/{id}")
	public Servicos findOne(@PathVariable("id") Integer id) {
		return service.findOne(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Serviço não encontrado"));
	}

	//POST /servicos - cadastra um serviço
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Servicos save(@RequestBody Servicos servico) {
		return service.save(servico);
	}

	//PUT /servicos/{id} - atualiza um serviço
	@PutMapping("/{id}")
	public Servicos update(@PathVariable("id") Integer id, @RequestBody Servicos servico) {
		findOne(id); //retorna 404 se o serviço não existir
		servico.setId(id);
		return service.save(servico);
	}

	//DELETE /servicos/{id} - exclui um serviço
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Integer id) {
		service.delete(id);
	}
}

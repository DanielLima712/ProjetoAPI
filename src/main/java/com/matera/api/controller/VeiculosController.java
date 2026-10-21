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

import com.matera.api.model.Veiculos;
import com.matera.api.service.VeiculosService;

@RestController
@RequestMapping("/veiculos")
public class VeiculosController {

	private final VeiculosService service;

	public VeiculosController(VeiculosService service) {
		this.service = service;
	}

	//GET /veiculos - lista todos os veículos
	@GetMapping
	public List<Veiculos> findAll() {
		return service.findAll();
	}

	//GET /veiculos/{placa} - busca um veículo pela placa
	@GetMapping("/{placa}")
	public Veiculos findOne(@PathVariable("placa") String placa) {
		return service.findOne(placa)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Veículo não encontrado"));
	}

	//POST /veiculos - cadastra um veículo
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Veiculos save(@RequestBody Veiculos veiculo) {
		return service.save(veiculo);
	}

	//PUT /veiculos/{placa} - atualiza um veículo
	@PutMapping("/{placa}")
	public Veiculos update(@PathVariable("placa") String placa, @RequestBody Veiculos veiculo) {
		findOne(placa); //retorna 404 se o veículo não existir
		veiculo.setPlaca(placa);
		return service.save(veiculo);
	}

	//DELETE /veiculos/{placa} - exclui um veículo
	@DeleteMapping("/{placa}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("placa") String placa) {
		service.delete(placa);
	}
}

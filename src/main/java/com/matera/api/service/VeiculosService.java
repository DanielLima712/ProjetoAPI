package com.matera.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.matera.api.model.Veiculos;
import com.matera.api.repository.VeiculosRepository;

@Service
public class VeiculosService {

	private final VeiculosRepository repository;

	public VeiculosService(VeiculosRepository repository) {
		this.repository = repository;
	}

	//Retorna uma lista com todos os veículos
	public List<Veiculos> findAll() {
		return repository.findAll();
	}

	//Retorna um veículo a partir da placa
	public Optional<Veiculos> findOne(String placa) {
		return repository.findById(placa);
	}

	//Salva ou atualiza um veículo
	public Veiculos save(Veiculos veiculo) {
		return repository.save(veiculo);
	}

	//Exclui um veículo
	public void delete(String placa) {
		repository.deleteById(placa);
	}

}

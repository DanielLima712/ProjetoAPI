package com.matera.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.matera.api.model.Servicos;
import com.matera.api.repository.ServicosRepository;

@Service
public class ServicosService {

	private final ServicosRepository repository;

	public ServicosService(ServicosRepository repository) {
		this.repository = repository;
	}

	//Retorna uma lista com todos os serviços
	public List<Servicos> findAll() {
		return repository.findAll();
	}

	//Retorna um serviço a partir do ID
	public Optional<Servicos> findOne(Integer id) {
		return repository.findById(id);
	}

	//Salva ou atualiza um serviço
	public Servicos save(Servicos servico) {
		return repository.save(servico);
	}

	//Exclui um serviço
	public void delete(Integer id) {
		repository.deleteById(id);
	}

}

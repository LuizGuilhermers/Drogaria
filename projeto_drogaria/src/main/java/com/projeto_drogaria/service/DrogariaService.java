package com.projeto_drogaria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto_drogaria.entities.Drogaria;
import com.projeto_drogaria.repository.DrogariaRepository;

@Service
public class DrogariaService {
	
	private final DrogariaRepository drogariaRepository;
	
	@Autowired
	public DrogariaService (DrogariaRepository drogariaRepository) {
		this.drogariaRepository = drogariaRepository;
	}
	
	public Drogaria saveDrogaria (Drogaria drogaria) {
		return drogariaRepository.save(drogaria);
	}

	public Drogaria getDrogariaById (Long id) {
		return drogariaRepository.findById(id).orElse(null);
	}

	public List<Drogaria> getAllDrogaria(){
		return drogariaRepository.findAll();
	}
	public Drogaria updateDrogaria(Long id, Drogaria updatedDrogaria) {
		Optional<Drogaria> existingDrogaria = drogariaRepository.findById(id);

		if (existingDrogaria.isPresent()) {
			updatedDrogaria.setId(id);
			return drogariaRepository.save(updatedDrogaria);
		}
		return null;
	}

		public boolean deleteDrogaria(Long id) {
			Optional <Drogaria> existingDrogaria = drogariaRepository.findById(id);
			if (existingDrogaria.isPresent()) {
				drogariaRepository.deleteById(id);
				return true;
			}
			return false;

		}

	

}

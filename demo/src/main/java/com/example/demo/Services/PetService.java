package com.example.demo.Services;

import com.example.demo.Entities.Pet;
import com.example.demo.Repositories.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetService {

    @Autowired
    PetRepository petRepository;

    public List<Pet> getAllPets() {
        return (List<Pet>) petRepository.findAll();
    }

    public Optional<Pet> getPetById(int id) {
        return petRepository.findById(id);
    }

    public void savePet(Pet pet){
        petRepository.save(pet);
    }
}

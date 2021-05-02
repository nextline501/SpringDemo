package com.example.demo.Controllers;

import com.example.demo.Entities.Pet;
import com.example.demo.Services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class PetController {

    @Autowired
    PetService petService;

    @GetMapping("/api/pets")
    public List<Pet> getAllPets() {
        return petService.getAllPets();
    }

    @GetMapping("/api/pets/{id}")
    public Optional<Pet> getPet(@PathVariable int id) {
        return petService.getPetById(id);
    }

    @PostMapping("/api/postPet")
    public void postPet(@RequestBody Pet pet) {
        petService.savePet(pet);
    }
}

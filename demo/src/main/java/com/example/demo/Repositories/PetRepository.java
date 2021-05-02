package com.example.demo.Repositories;

import com.example.demo.Entities.Pet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
    public interface PetRepository extends CrudRepository<Pet, Integer> {
}

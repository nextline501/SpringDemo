package com.example.demo.Repositories;

import com.example.demo.Entities.Owner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
    public interface OwnerRepository extends CrudRepository<Owner, Integer> {
}
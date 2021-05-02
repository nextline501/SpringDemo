package com.example.demo.Services;

import com.example.demo.Entities.Owner;
import com.example.demo.Repositories.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerService {
    
    @Autowired 
    OwnerRepository ownerRepository;

    public List<Owner> getAllOwner(){
        return (List<Owner>) ownerRepository.findAll();
    }

    public void saveOwner(Owner owner){
        ownerRepository.save(owner);
    }
}

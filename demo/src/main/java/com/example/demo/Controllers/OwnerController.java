package com.example.demo.Controllers;

import com.example.demo.Services.OwnerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import com.example.demo.Entities.Owner;

@RestController
public class OwnerController {
    @Autowired
    OwnerService ownerService;

    @GetMapping("/api/getOwner")
    public List<Owner> getAllOwner(){
        return ownerService.getAllOwner();
    }

    @PostMapping("/api/postOwner")
    public void postOwner(@RequestBody Owner owner){
        ownerService.saveOwner(owner);
    }
}

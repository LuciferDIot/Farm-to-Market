package com.hcl.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.hcl.project.model.Item;
import com.hcl.project.repository.ItemRepository;

import jakarta.validation.Valid;

@RestController
public class ItemController {
	
	@Autowired
	ItemRepository itemRepo;
	
	@GetMapping("/viewall/item")
    public ResponseEntity<List<Item>> getProduct() {
        return new ResponseEntity<>(itemRepo.findAll(), HttpStatus.OK);
    }
	
	@PostMapping("/create/item")
    public ResponseEntity<String> createProduct(@Valid @RequestBody Item item) {
        itemRepo.save(item);
        return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
    }
	
	@PutMapping("update/item/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable("id") Integer id, @RequestBody Item item) {
        item.setItemId(id);
        itemRepo.save(item);
        return new ResponseEntity<>("Product is updated successsfully", HttpStatus.OK);
    }
	
	@DeleteMapping("/deleteItem/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Integer id) {
        itemRepo.deleteById(id);
        return new ResponseEntity<>("Product is deleted successsfully", HttpStatus.OK);
    }

}

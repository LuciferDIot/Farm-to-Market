package com.hcl.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.hcl.project.model.Item;
import com.hcl.project.repository.ItemRepository;


public class ItemServiceImpl implements ItemService {
	
	@Autowired
	ItemRepository itemRepo;
	
    public List<Item> getProduct() {
        return itemRepo.findAll();
    }
	
    public void createProduct(Item item) {
        itemRepo.save(item);
    }
	
    public void updateProduct(Integer id,Item item) {
        item.setItemId(id);
        itemRepo.save(item);
    }
	
    public void delete(Integer id) {
        itemRepo.deleteById(id);
    }

}

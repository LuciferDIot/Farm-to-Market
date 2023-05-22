package com.hcl.project.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.hcl.project.model.Item;

@Service
public interface ItemService {
	
	public List<Item> getProduct();
	
    public void createProduct(Item item);
	
    public void updateProduct(Integer id,Item item);
	
    public void delete(Integer id);

}

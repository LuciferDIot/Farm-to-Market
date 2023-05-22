package com.hcl.project.controller;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.project.model.Item;
import com.hcl.project.model.Trader;
import com.hcl.project.service.TraderServiceImple;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/trader")
public class TraderController {

	static Logger lg = Logger.getLogger(TraderController.class.getName());
	
	
	@Autowired
	TraderServiceImple service;
	
	@GetMapping("/viewAll/item")
	public ResponseEntity<List<Item>> getAllItems(){
		lg.info("View all items");
		return new ResponseEntity<>(service.getAllItems(), HttpStatus.OK);
	}
	
	@PutMapping("/{traderId}/add/{itemId}")
	public ResponseEntity<String> addTraderItem(@PathVariable("traderId")Integer traderId,@PathVariable("itemId")Integer itemId){
		Item item= service.buyItem(traderId, itemId);
		lg.info("Buy items from farmer");
		return new ResponseEntity<>("Item added to trader", HttpStatus.OK);	
	}
	
	@GetMapping("/{traderid}/viewItem")
	public ResponseEntity<List<Item>> getTraderItems(@PathVariable("traderid") Integer traderid){
		List<Item> items = service.getTraderItems(traderid);
		lg.info("View all bought items of the farmer");
		return new ResponseEntity<>(items, HttpStatus.OK);
	}

	@PostMapping("/create")
    public ResponseEntity<String> createTrader(@Valid @RequestBody Trader trader) {
        service.createTrader(trader);
		lg.info("Create a trader");
        return new ResponseEntity<>("Trader is created successfully", HttpStatus.CREATED);
    }

}

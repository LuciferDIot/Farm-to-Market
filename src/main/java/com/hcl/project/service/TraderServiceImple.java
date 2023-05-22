package com.hcl.project.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.project.exceptions.ItemNotFound;
import com.hcl.project.exceptions.UserNotFound;
import com.hcl.project.model.Item;
import com.hcl.project.model.Trader;
import com.hcl.project.repository.ItemRepository;
import com.hcl.project.repository.TraderRepository;

import jakarta.validation.Valid;

@Service
public class TraderServiceImple implements TraderService{

	@Autowired
	private TraderRepository traderRepository;
	@Autowired
	private ItemRepository itemRepository;

	@Override
	public Item buyItem(Integer traderId, Integer itemId) {
		Optional<Item> item = itemRepository.findById(itemId);
		if(item.equals(null)) throw new ItemNotFound("User not found");
		Optional<Trader> trader = traderRepository.findById(traderId);
		if(trader.equals(null)) throw new UserNotFound("User not found");
		
		item.get().setTrader(trader.get());
		trader.get().setItemsList(item.get());

		traderRepository.save(trader.get());
		return item.get();
	}

	@Override
	public List<Item> getTraderItems(Integer traderid) {
		Optional<Trader> traderOptional = traderRepository.findById(traderid);
		if(traderOptional.equals(null)) throw new UserNotFound("User not found");
		return traderOptional.get().getItemsList();
	}

	public void createTrader(@Valid Trader trader) {
		traderRepository.save(trader);
	}

	@Override
	public List<Item> getAllItems() {
		List<Item> items = itemRepository.findAll();
		
		List<Item> notBuyedItems = new ArrayList<>();
		for(Item e:items) {
			if (e.getTrader()==null) {
				notBuyedItems.add(e);
			}
		}
		return notBuyedItems;
	}
}

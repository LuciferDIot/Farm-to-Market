package com.hcl.project.service;

import java.util.List;

import com.hcl.project.model.Item;
import com.hcl.project.model.Trader;

import jakarta.validation.Valid;

public interface TraderService {

	Item buyItem(Integer traderId, Integer itemId);
	List<Item> getTraderItems(Integer traderid);
	void createTrader(@Valid Trader trader);
	List<Item> getAllItems();
}

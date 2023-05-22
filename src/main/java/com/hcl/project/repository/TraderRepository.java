package com.hcl.project.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.project.model.Trader;

@Repository
public interface TraderRepository extends JpaRepository<Trader, Integer> {



}

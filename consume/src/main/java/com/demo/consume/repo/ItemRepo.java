package com.demo.consume.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.consume.domain.Item;

public interface ItemRepo extends JpaRepository<Item, Long> {

}

package com.esensesoftware.demo.repository;

import com.esensesoftware.demo.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}//ItemRepository

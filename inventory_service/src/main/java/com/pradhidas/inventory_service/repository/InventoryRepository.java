package com.pradhidas.inventory_service.repository;

import com.pradhidas.inventory_service.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    Optional<Inventory> findBySkuCodeIn(List<String> skuCode);
}

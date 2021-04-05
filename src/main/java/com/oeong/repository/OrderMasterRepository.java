package com.oeong.repository;

import com.oeong.entity.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {
}

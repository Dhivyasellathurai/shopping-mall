package com.example.shoppingmall.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.shoppingmall.entity.Bill;
@Repository
public interface BillRepository extends JpaRepository<Bill, UUID> {

}

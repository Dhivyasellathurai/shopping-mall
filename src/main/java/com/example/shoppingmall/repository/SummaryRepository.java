package com.example.shoppingmall.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.shoppingmall.entity.BinwiseSummary;

@Repository
public interface SummaryRepository extends JpaRepository<BinwiseSummary, Integer> {

	@Query(value = "select bw.id,bw.bin_name,bw.bin_card_no,bw.product_name,bw.product_category,bw.lot,bw.stock_qty,"
			+ "bw.average_cost,bw.cost,bw.department,bw.plant,bw.report_type,bw.product_type,bw.inventory_type from "
			+ "bin_wise_summary as bw where " + " (bw.department =:department) or( :department is null)\r\n"
			+ " AND (bw.plant =:plant )or(plant is null)\r\n"
			+ " AND (bw.inventory_type =:inventoryType) or (inventory_type is null)\r\n"
			+ " AND (bw.report_type =:reportType) or (report_type is null)\r\n"
			+ " AND (bw.product_type =:productType) or (product_type is null)", nativeQuery = true)
	List<BinwiseSummary> getByFilter(String department, String plant, String inventoryType, String reportType,
			String productType);

}

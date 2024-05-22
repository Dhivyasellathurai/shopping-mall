package com.example.shoppingmall.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "bin_wise_summary")

public class BinwiseSummary {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "bin_name")
	private String binName;

	@Column(name = "bin_card_no")
	private String binCardNo;

	@Column(name = "product_name ")
	private String productName;

	@Column(name = "product_category")
	private String productCategory;

	@Column(name = "lot")
	private String lot;

	@Column(name = "stock_qty")
	private int stockQuantity;

	@Column(name = "average_cost")
	private double averageCost;

	@Column(name = "cost")
	private double cost;

	@Column(name = "department")
	private String department;

	@Column(name = "plant")
	private String plant;

	@Column(name = "report_type")
	private String reportType;

	@Column(name = "product_type")
	private String productType;

	@Column(name = "inventory_type")
	private String inventoryType;

}

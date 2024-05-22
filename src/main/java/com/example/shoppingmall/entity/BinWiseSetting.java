package com.example.shoppingmall.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name = "bw_setting")
public class BinWiseSetting {
	
	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "bin_name_prefix")
	private String binNamePrefix;

	@Column(name = "bin_name_suffix")
	private char binNameSuffix;

	@Column(name = "bin_card_no_prefix")
	private String binCardNoPrefix;

	@Column(name = "bin_card_no_suffix")
	private int binCardNoSuffix;

	@Column(name = "lot_prefix")
	private String lotPrefix;

	@Column(name = "lot_suffix")
	private int lotSuffix;

	@Column(name = "note_no_prefix")
	private String noteNoPrefix;

	@Column(name = "note_no_suffix")
	private int noteNoSuffix;

	@Column(name = "bill_number_prefix")
	private String billNumberPrefix;

	@Column(name = "bill_number_suffix")
	private int billNumbersuffix;

}
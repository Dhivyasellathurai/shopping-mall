package com.example.shoppingmall.entity;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "credit_note")
public class CreditNote {

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Type(type = "uuid-char")
	@Column(name = "credit_id", updatable = false, nullable = false)
	private UUID creditId;

	@Column(name = "note_number")
	private String noteNo;

	@Column(name = "note_date")
	private Date noteDate;

	@Column(name = "note_quantity")
	private int noteQuantity;

	@Column(name = "note_type")
	private String noteType;

	@Column(name = "total_gross_amount")
	private double totalGrossAmount;

	@Column(name = "destination_plant")
	private String destinationPlant;

	@Column(name = "description")
	private String description;

	@Column(name = "party_name")
	private String partyName;

	@Column(name = "bill_quantity")
	private int billQuantity;

	@Column(name = "total_tcs_percent")
	private double totalTcsPercentage;

	@Column(name = "company_name")
	private String companyName;

	@Column(name = "bill_type")
	private String billType;

	@Column(name = "total_tcs_amount")
	private double totalTcsAmount;

	@OneToMany(targetEntity = Bill.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "credit_note_id", referencedColumnName = "credit_id")
	private List<Bill> bill;
}
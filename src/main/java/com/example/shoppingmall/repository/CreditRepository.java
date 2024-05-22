package com.example.shoppingmall.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.shoppingmall.entity.CreditNote;

@Repository
@EnableJpaRepositories
public interface CreditRepository extends JpaRepository<CreditNote, UUID> {

	@Query(value = "select c.credit_id,c.note_number,c.note_date,c.note_quantity,c.note_type,c.total_gross_amount,"
			+ "c.destination_plant,c.description,c.party_name,c.bill_quantity,c.total_tcs_percent,c.company_name,"
			+ "c.bill_type,c.total_tcs_amount,b.bill_date,b.bill_number from bills as b inner join credit_note as c on c.credit_id = b.credit_note_id"
			+ " where (b.bill_number =:billNumber )or( bill_number is null )", nativeQuery = true)
	List<CreditNote> getByFilter(String billNumber);

}

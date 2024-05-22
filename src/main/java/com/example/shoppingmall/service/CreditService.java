package com.example.shoppingmall.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shoppingmall.entity.Bill;
import com.example.shoppingmall.entity.BinWiseSetting;
import com.example.shoppingmall.entity.CreditNote;
import com.example.shoppingmall.repository.BWSettingRepository;
import com.example.shoppingmall.repository.CreditRepository;

@Service
public class CreditService {

	@Autowired
	private CreditRepository creditRepository;

	@Autowired
	private BWSettingRepository bwSettingRepository;

	public void save(CreditNote note) {
		BinWiseSetting setting = bwSettingRepository.findAll().get(0);
		List<Bill> bill = new ArrayList<>();
		for (Bill bill1 : note.getBill()) {
			Bill bill2 = new Bill();
			bill2.setBillNumber(setting.getBillNumberPrefix() + "" + setting.getBillNumbersuffix());
			bill2.setBillDate(bill1.getBillDate());
			bill.add(bill2);
		}
		note.setNoteNo(setting.getNoteNoPrefix() + "" + setting.getNoteNoSuffix());
		setting.setBillNumbersuffix(setting.getBillNumbersuffix() + 1);
		setting.setNoteNoSuffix(setting.getNoteNoSuffix() + 1);
		bwSettingRepository.saveAndFlush(setting);
		note.setBill(bill);
		creditRepository.save(note);
	}

	public Optional<CreditNote> getById(UUID id) {
		return creditRepository.findById(id);
	}

	public void update(CreditNote note) {
		creditRepository.saveAndFlush(note);
	}

	public void delete(UUID id) {
		creditRepository.deleteById(id);
	}

	public List<CreditNote> getByFilter(String billNumber) {
		if(billNumber == null) {
			return creditRepository.findAll();
		}else {
		return creditRepository.getByFilter(billNumber);
		}
	}

}
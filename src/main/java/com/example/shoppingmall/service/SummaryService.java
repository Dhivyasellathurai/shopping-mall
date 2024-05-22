package com.example.shoppingmall.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.shoppingmall.entity.BinWiseSetting;
import com.example.shoppingmall.entity.BinwiseSummary;
import com.example.shoppingmall.repository.BWSettingRepository;
import com.example.shoppingmall.repository.SummaryRepository;

@Service
public class SummaryService {

	@Autowired
	private SummaryRepository summaryRepository;

	@Autowired
	private BWSettingRepository bwSettingRepository;

	public void save(BinwiseSummary request) {
		BinWiseSetting setting = bwSettingRepository.findAll().get(0);
		request.setBinName(setting.getBinNamePrefix() + " " + setting.getBinNameSuffix());
		request.setBinCardNo(setting.getBinCardNoPrefix() + "" + setting.getBinCardNoSuffix());
		request.setLot(setting.getLotPrefix() + "-" + setting.getLotSuffix());
		request.setCost(request.getAverageCost() * request.getStockQuantity());
		setting.setBinCardNoSuffix(setting.getBinCardNoSuffix() + 001);
		setting.setBinNameSuffix((char) (setting.getBinNameSuffix() + 1));
		setting.setLotSuffix(setting.getLotSuffix() + 001);
		bwSettingRepository.saveAndFlush(setting);
		summaryRepository.save(request);
	}

	public Optional<BinwiseSummary> getById(int id) {
		return summaryRepository.findById(id);
	}

	public void update(BinwiseSummary request) {
		request.setCost(request.getStockQuantity() * request.getAverageCost());
		summaryRepository.saveAndFlush(request);
	}

	public void deleteById(Integer id) {
		summaryRepository.deleteById(id);
	}

	public List<BinwiseSummary> getByFilter(String department, String plant, String reportType, String productType,
			String inventoryType) {
		if ((department == null) & (plant == null) & (reportType == null) & (productType == null)
				& (inventoryType == null)) {
			return summaryRepository.findAll();
		} else {
			return summaryRepository.getByFilter(department, plant, reportType, productType, inventoryType);
		}
	}
}

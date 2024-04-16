package com.example.wastemanagercore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.wastemanagercore.core.service.WasteManagerService;
import com.example.wastemanagercore.entity.WasteManagerEntity;
import com.example.wastemanagercore.repository.WasteManagerRepository;

@Service
public class WasteManagerServiceImpl implements WasteManagerService {

	@Autowired
	private WasteManagerRepository wasteManagerRepository;

	@Override
	public void create(WasteManagerEntity wasteManager) {
		wasteManagerRepository.save(wasteManager);
	}

	@Override
	public void update(WasteManagerEntity wasteManager) {
		WasteManagerEntity temp = wasteManagerRepository.findById(wasteManager.getId()).get();
		temp.setNombre(wasteManager.getNombre());
		temp.setNif(wasteManager.getNif());
		temp.setIsEnabled(wasteManager.getIsEnabled());
		temp.setVersion(wasteManager.getVersion());
		wasteManagerRepository.save(temp);
	}
	
	@Override
	public WasteManagerEntity findById(Long id) {
		if (wasteManagerRepository.existsById(id)) {
			return wasteManagerRepository.findById(id).get();
		} else {
			return new WasteManagerEntity();
		}
	}
}

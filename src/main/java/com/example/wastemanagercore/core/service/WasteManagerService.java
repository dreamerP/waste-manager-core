package com.example.wastemanagercore.core.service;

import com.example.wastemanagercore.entity.WasteManagerEntity;

public interface WasteManagerService {
	
	 void create(WasteManagerEntity wasteManager);
	 void update(WasteManagerEntity wasteManager);
	 WasteManagerEntity findById(Long id);
}

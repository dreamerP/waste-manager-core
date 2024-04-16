package com.example.wastemanagercore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.wastemanagercore.entity.WasteManagerEntity;


@Repository
public interface WasteManagerRepository extends JpaRepository<WasteManagerEntity, Long> {

}

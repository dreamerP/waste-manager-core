package com.example.wastemanagercore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.wastemanagercore.entity.WasteCenterAuthorizationEntity;


@Repository
public interface WasteCenterAuthorizationRepository extends JpaRepository<WasteCenterAuthorizationEntity, Long> {

}

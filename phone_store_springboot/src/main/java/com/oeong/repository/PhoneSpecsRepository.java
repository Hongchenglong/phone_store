package com.oeong.repository;

import com.oeong.entity.PhoneSpecs;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PhoneSpecsRepository extends JpaRepository<PhoneSpecs, Integer> {
    public List<PhoneSpecs> findAllByPhoneId(Integer phoneId);
}

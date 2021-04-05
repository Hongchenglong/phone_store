package com.oeong.repository;

import com.oeong.entity.PhoneCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneCategoryRepository extends JpaRepository<PhoneCategory, Integer> { // 接口 Jpa<实体类，主键类型>
    public PhoneCategory findByCategoryType(Integer categoryType);
}

package com.oeong.repository;

import com.oeong.entity.PhoneCategory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PhoneCategoryRepositoryTest {

    @Autowired
    private PhoneCategoryRepository repository;

    @Test
    void findAll() {
        List<PhoneCategory> list = repository.findAll();
        for (PhoneCategory phoneCategory: list) {
            System.out.println(phoneCategory);
        }
    }

    @Test
    void findByCategoryType() {
        PhoneCategory phoneCategory = repository.findByCategoryType(1);
        System.out.println(phoneCategory);
    }
}
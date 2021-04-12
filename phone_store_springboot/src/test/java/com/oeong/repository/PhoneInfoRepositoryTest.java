package com.oeong.repository;

import com.oeong.entity.PhoneInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PhoneInfoRepositoryTest {

    @Autowired // 成员属性字段使用@Autowired，无需set方法
    // @Autowired 是一个注释，它可以对类成员变量、方法及构造函数进行标注，让 spring 完成 bean 自动装配的工作。
    private PhoneInfoRepository repository;

    @Test
    void findAll() {
        List<PhoneInfo> list = repository.findAll();
        for (PhoneInfo phoneInfo : list) { // list.for
            System.out.println(phoneInfo);
        }
    }

    @Test
    void findAllByCategoryType() {
        List<PhoneInfo> list = repository.findAllByCategoryType(1);
        for (PhoneInfo phoneInfo : list) {
            System.out.println(phoneInfo);
        }
    }
}
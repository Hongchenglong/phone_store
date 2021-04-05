package com.oeong.repository;

import com.oeong.entity.BuyerAddress;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BuyerAddressRepositoryTest {
    @Autowired
    private BuyerAddressRepository repository;

    @Test
    void findAll() {
        List<BuyerAddress> list = repository.findAll();
        for (BuyerAddress buyerAddress : list) {
            System.out.println(buyerAddress);
        }
    }

    @Test
    void save() {
        BuyerAddress buyerAddress = new BuyerAddress();
        buyerAddress.setAreaCode("330104");
        buyerAddress.setBuyerAddress("广东省深圳市罗湖区科技路123号456室");
        buyerAddress.setBuyerName("小红");
        buyerAddress.setBuyerPhone("13678787878");
        repository.save(buyerAddress);
    }

    @Test
    void update() {
        BuyerAddress buyerAddress = repository.findById(36).get();
        buyerAddress.setBuyerName("小龙");
        repository.save(buyerAddress);
    }

}
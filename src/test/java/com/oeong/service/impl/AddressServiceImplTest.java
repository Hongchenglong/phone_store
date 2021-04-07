package com.oeong.service.impl;

import com.oeong.service.AddressService;
import com.oeong.vo.AddressVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AddressServiceImplTest {

    @Autowired // 忘记在Impl加@Service
    private AddressService addressService;

    @Test
    void findAll() {
        List<AddressVO> list = addressService.findAll();
        int id = 0;
    }

}
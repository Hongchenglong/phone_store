package com.oeong.service.impl;

import com.oeong.service.PhoneService;
import com.oeong.vo.DataVO;
import com.oeong.vo.PhoneInfoVO;
import com.oeong.vo.SpecsPackageVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.xml.crypto.Data;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PhoneServiceImplTest {

    @Autowired
    private PhoneService phoneService;

    @Test
    void findDataVO() {
        DataVO dataVO = phoneService.findDataVO();
        int id = 0;
    }

    @Test
    void findPhoneInfoVOByCategoryType() {
        List<PhoneInfoVO> list = phoneService.findPhoneInfoVOByCategoryType(2);
        int id = 0;
    }

    @Test
    void findSku() {
        SpecsPackageVO specsPackageVO = phoneService.findSpecsByPhoneId(1);
        int id = 0;
    }

    @Test
    void subStock() {
        phoneService.subStock(1,1);
    }
}
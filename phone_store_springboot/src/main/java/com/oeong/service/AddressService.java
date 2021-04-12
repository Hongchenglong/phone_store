package com.oeong.service;

import com.oeong.form.AddressForm;
import com.oeong.vo.AddressVO;

import java.util.List;

public interface AddressService {
    public List<AddressVO> findAll();
    public void saveOrUpdate(AddressForm addressForm); // 根据有无ID判断是创建还是更新
}


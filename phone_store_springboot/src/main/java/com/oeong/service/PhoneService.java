package com.oeong.service;

import com.oeong.vo.DataVO;
import com.oeong.vo.PhoneInfoVO;
import com.oeong.vo.SpecsPackageVO;
import lombok.Data;

import java.util.List;

public interface PhoneService {
    public DataVO findDataVO();
    public List<PhoneInfoVO> findPhoneInfoVOByCategoryType(Integer categoryType);
    public SpecsPackageVO findSpecsByPhoneId(Integer phoneId); // 查询手机规格
    public void subStock(Integer specsId, Integer quantity);
}

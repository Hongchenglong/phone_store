package com.oeong.service.impl;

import com.oeong.dto.OrderDTO;
import com.oeong.entity.OrderMaster;
import com.oeong.entity.PhoneInfo;
import com.oeong.entity.PhoneSpecs;
import com.oeong.enums.PayStatusEnum;
import com.oeong.enums.ResultEnum;
import com.oeong.exception.PhoneException;
import com.oeong.repository.OrderMasterRepository;
import com.oeong.repository.PhoneInfoRepository;
import com.oeong.repository.PhoneSpecsRepository;
import com.oeong.service.OrderService;
import com.oeong.service.PhoneService;
import com.oeong.util.KeyUtil;
import com.oeong.vo.OrderDetailVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service // 用于标注业务层组件
@Slf4j // 用作日志输出
public class OrderServiceImpl implements OrderService {
    @Autowired
    private PhoneSpecsRepository phoneSpecsRepository;
    @Autowired
    private PhoneInfoRepository phoneInfoRepository;
    @Autowired
    private OrderMasterRepository orderMasterRepository;
    @Autowired
    private PhoneService phoneService;

    @Override
    public OrderDTO create(OrderDTO orderDTO) {
        OrderMaster orderMaster = new OrderMaster();
        BeanUtils.copyProperties(orderDTO, orderMaster);
        // BeanUtils.copyProperties(源, 目标)方法进行对象之间属性的赋值，避免通过get、set方法一个一个属性的赋值

        PhoneSpecs phoneSpecs = phoneSpecsRepository.findById(orderDTO.getSpecsId()).get();
        if (phoneSpecs == null) {
            log.error("【创建订单】规格不存在,phoneSpecs={}", phoneSpecs);
            throw new PhoneException(ResultEnum.SPECS_NOT_EXIST);
        }
        BeanUtils.copyProperties(phoneSpecs, orderMaster);

        PhoneInfo phoneInfo = phoneInfoRepository.findById(phoneSpecs.getPhoneId()).get();
        if (phoneInfo == null) {
            log.error("【创建订单】手机不存在,phoneInfo={}", phoneInfo);
            throw new PhoneException(ResultEnum.PHONE_NOT_EXIST);
        }
        BeanUtils.copyProperties(phoneInfo, orderMaster);

        //计算总价
        BigDecimal orderAmount = new BigDecimal(0);
        orderAmount = phoneSpecs.getSpecsPrice().divide(new BigDecimal(100))
                .multiply(new BigDecimal(orderDTO.getPhoneQuantity()))
                .add(orderAmount)
                .add(new BigDecimal(10));
        orderMaster.setOrderAmount(orderAmount);

        // orderId
        orderMaster.setOrderId(KeyUtil.createUniqueKey());
        orderDTO.setOrderId(orderMaster.getOrderId());

        // payStatus
        orderMaster.setPayStatus(PayStatusEnum.UNPIAD.getCode());

        orderMasterRepository.save(orderMaster);

        phoneService.subStock(orderDTO.getSpecsId(), orderDTO.getPhoneQuantity());

        return orderDTO;
    }

    @Override
    public OrderDetailVO findOrderDetailByOrderId(String orderId) {
        OrderDetailVO orderDetailVO = new OrderDetailVO();
        OrderMaster orderMaster = orderMasterRepository.findById(orderId).get();

        if (orderMaster == null) {
            log.error("【查询订单】订单不存在,orderMaster={}",orderMaster);
            throw new PhoneException(ResultEnum.ORDER_NOT_EXIST);
        }

        BeanUtils.copyProperties(orderMaster, orderDetailVO);
        orderDetailVO.setSpecsPrice(orderMaster.getSpecsPrice().divide(new BigDecimal(100))+".00");

        return orderDetailVO;
    }

    @Override
    public String pay(String orderId) {
        OrderMaster orderMaster = orderMasterRepository.findById(orderId).get();

        if(orderMaster == null){
            log.error("【支付订单】订单不存在,orderMaster={}",orderMaster);
            throw new PhoneException(ResultEnum.ORDER_NOT_EXIST);
        }

        if(orderMaster.getPayStatus().equals(PayStatusEnum.UNPIAD.getCode())){
            orderMaster.setPayStatus(PayStatusEnum.PAID.getCode());
            orderMasterRepository.save(orderMaster);
        } else {
            log.error("【支付订单】订单已支付,orderMaster={}",orderMaster);
        }

        return orderId;
    }
}

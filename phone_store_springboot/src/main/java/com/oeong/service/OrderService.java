package com.oeong.service;

import com.oeong.dto.OrderDTO;
import com.oeong.vo.OrderDetailVO;

public interface OrderService { // 订单
    public OrderDTO create(OrderDTO orderDTO);
    public OrderDetailVO findOrderDetailByOrderId(String orderId);
    public String pay(String orderId);
}

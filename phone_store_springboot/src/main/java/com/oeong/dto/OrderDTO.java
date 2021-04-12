package com.oeong.dto;

import lombok.Data;

@Data
public class OrderDTO {
    // DTO即data to object
    private String orderId;
    private String buyerName;
    private String buyerPhone;
    private String buyerAddress;
    private Integer specsId;
    private Integer phoneQuantity;
}

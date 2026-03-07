package com.learn.withravi.email_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    private String order_id;
    private String name;
    private int quantity;
    private double price;
}

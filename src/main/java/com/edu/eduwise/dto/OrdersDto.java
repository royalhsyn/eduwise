package com.edu.eduwise.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrdersDto {

    private LocalDate orderDate;

    private Integer quantity;

    private Double totalAmount;

    private String paymentStatus;
}

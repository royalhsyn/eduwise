package com.edu.eduwise.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "orderDate")
    private LocalDate orderDate;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "totalAmount")
    private Double totalAmount;

    @Column(name = "paymentStatus")
    private String paymentStatus;

}

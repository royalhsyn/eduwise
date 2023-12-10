package com.edu.eduwise.dto;

import com.edu.eduwise.model.Certificat;
import com.edu.eduwise.model.Orders;
import com.edu.eduwise.valid.PositiveNumber;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CourseDto {

    private String title;

    private String subtitle;

    @PositiveNumber
    private Double price;

    private Double discount;

    private String bestSeller;


    private Double ratings;

    private Long ratingCount;

    private Long purchasesCount;

    private String courseLink;

    private String duration;

    private String instructor;

    private Boolean isDiscount;

    private Boolean inWishlist;

    private Double discountPrice;

    private Long ordersId;

    private Long certificatId;
}

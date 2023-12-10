package com.edu.eduwise.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.bind.annotation.RequestAttribute;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "course" , schema = "public")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "subtitle")
    private String subtitle;

    @Column(name = "price")
    private Double price;

    @Column(name = "discount")
    private Double discount;

    @Column(name = "bestSeller")
    private String bestSeller;

    @Column(name = "ratings")
    private Double ratings;

    @Column(name = "ratingCount")
    private Long ratingCount;

    @Column(name = "purchasesCount")
    private Long purchasesCount;

    @Column(name = "courseLink")
    private String courseLink;

    @Column(name = "duration")
    private String duration;

    @Column(name = "instructor")
    private String instructor;

    @Column(name = "isDiscount")
    private Boolean isDiscount;

    @Column(name = "inWishlist")
    private Boolean inWishlist;

    @Column(name = "discountPrice")
    private Double discountPrice;

    @OneToMany(mappedBy = "course",cascade = CascadeType.ALL)
    private List<Image> images;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ordersId")
    private Orders orders;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "certificatId", referencedColumnName = "id")
    private Certificat certificat;

    @OneToMany(mappedBy = "course",cascade = CascadeType.ALL)
    private List<Exam> exams;


}

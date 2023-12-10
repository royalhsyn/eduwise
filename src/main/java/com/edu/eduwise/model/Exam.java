package com.edu.eduwise.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "exam")
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "examDate")
    private LocalDate examDate;

    @Column(name = "durationMinutes")
    private Long durationMinutes;

    @Column(name = "totalMarks")
    private Long totalMarks;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "exam",cascade = CascadeType.ALL)
    private List<ExamResult> examResults;

    @OneToMany(mappedBy = "exam",cascade = CascadeType.ALL)
    private List<SubCategory> subCategories;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "courseId")
    private Course course;

    @OneToMany(mappedBy = "exam",cascade = CascadeType.ALL)
    private List<Question> questionList;

}

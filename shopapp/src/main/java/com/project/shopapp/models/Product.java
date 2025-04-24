package com.project.shopapp.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "products")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
// @Column(name = "id") không cần thiết lắm nên bỏ được vì tên trong bảng và tên trong đây giống nhau
    private Long id;

    @Column(name = "name", nullable = false, length = 350)
    private String name;

    private Float price;

    @Column(name = "thumbnail", nullable = true, length = 350)
    private String thumbnail;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @Column(name = "category_id")
    private Category category;
}

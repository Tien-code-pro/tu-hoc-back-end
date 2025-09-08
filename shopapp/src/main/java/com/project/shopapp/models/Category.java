package com.project.shopapp.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "categories")
@Data // to String
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
// @Column(name = "id") không cần thiết lắm nên bỏ được vì tên trong bảng và tên trong đây giống nhau
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

}

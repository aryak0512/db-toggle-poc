package com.aryak.db.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;

/**
 * My SQL entity
 */
@ToString
@Entity
@NoArgsConstructor
@Builder
@Getter
@Setter
@AllArgsConstructor
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private double price;
    private LocalDateTime publishedAt;
}

package com.aryak.db.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;
@Data
@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class BookRequest {

    private String name;
    private double price;
    private LocalDateTime publishedAt;
}

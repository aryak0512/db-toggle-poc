package com.aryak.db.domain;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;
/**
 * My cache entity
 */
@Data
@ToString
@Builder
public class Book {

    private Object id;
    private String name;
    private double price;
    private LocalDateTime publishedAt;
    private String igniteKey;
}

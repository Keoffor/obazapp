package com.obas.obazapp.model;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class AddBook {
    private String booktitle;
    private String author;
    private String rating;
    private String userEMail;
}

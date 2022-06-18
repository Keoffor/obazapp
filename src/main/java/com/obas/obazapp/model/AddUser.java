package com.obas.obazapp.model;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class AddUser {
    private String name;
    private String email;
}

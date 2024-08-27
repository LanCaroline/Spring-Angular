package org.example.dto;

import jdk.jfr.DataAmount;
import lombok.*;

import java.time.LocalDate;

@Data
public class UserDTO {

    private int id;
    private String name;
    private LocalDate birthday;
}

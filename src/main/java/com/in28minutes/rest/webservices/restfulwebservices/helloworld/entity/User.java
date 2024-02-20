package com.in28minutes.rest.webservices.restfulwebservices.helloworld.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class User {


    private Integer id;
    @Size(min = 2)

    @JsonProperty("user_name")
    private String name;
    @Past
    private LocalDate birthDate;


}

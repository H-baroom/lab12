package com.example.lab12w10day2.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.catalina.User;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "title not valid")
    @Column(columnDefinition ="varchar(10) not null")
    private String title;

    @NotEmpty(message = "body not valid")
    @Column(columnDefinition ="varchar(200) not null")
    private String body;

    @ManyToOne
    @JsonIgnore
    private MyUser user;
}

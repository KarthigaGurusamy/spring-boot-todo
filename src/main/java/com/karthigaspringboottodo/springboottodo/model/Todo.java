package com.karthigaspringboottodo.springboottodo.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="table_todo")
public class Todo {

    @Id
    @GeneratedValue
    private Integer id;
    private String item;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="user_id",referencedColumnName = "id")
    private AppUser appUser;
}

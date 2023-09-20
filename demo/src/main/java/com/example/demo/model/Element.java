package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "element")
public class Element {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "elem")
    private Long elem;

    @Column(name = "arr")
    private Long arr;

    @Column(name = "sorting")
    private Long sorting;
}

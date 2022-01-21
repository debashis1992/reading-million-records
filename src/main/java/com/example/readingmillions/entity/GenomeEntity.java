package com.example.readingmillions.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Table(name = "genome", schema = "test") //1 million records in mysql
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class GenomeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    @Column(name = "movieid")
    Integer movieid;

    @Column(name = "tagid")
    Integer tagid;

    @Column(name = "relevance")
    Integer relevance;
}

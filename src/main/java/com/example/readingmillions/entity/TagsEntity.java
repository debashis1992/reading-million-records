package com.example.readingmillions.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Table(name = "tags", schema = "test") // 0.45 million records in mysql
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class TagsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    @Column(name = "userid")
    Integer userid;

    @Column(name = "movieid")
    Integer movieid;

    @Column(name = "tag")
    String  tag;
}


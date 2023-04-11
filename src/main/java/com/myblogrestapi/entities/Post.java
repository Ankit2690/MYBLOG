package com.myblogrestapi.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data//gives me getters and setters
@NoArgsConstructor//will add no arg constructor
@AllArgsConstructor//will add all arg constructor
@Entity
@Table(name="posts",uniqueConstraints = {@UniqueConstraint(columnNames = {"title"})})
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="title", nullable=false)
    private String title;
    @Column(name="description", nullable=false)
    private String description;
    @Lob//more than 255 characters
    @Column(name="content", nullable=false)
    private String content;//255 characters

    @OneToMany(mappedBy = "post",cascade=CascadeType.ALL,orphanRemoval = true)
    Set<Comment> comments=new HashSet<>();
}

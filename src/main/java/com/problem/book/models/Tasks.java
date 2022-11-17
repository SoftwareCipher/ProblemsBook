package com.problem.book.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tasks")
public class Tasks {

    @Id
    @Column(name = "id")
    private Long id;
    @Column( name = "task")
    private String task;

}

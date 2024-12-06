package org.example.notes.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "comments_table")
public class Comments {

    @Id
    @Column(name = "id", nullable = false)
    private BigInteger id;

    @Column(name = "description", nullable = false, length = 400)
    private String description;

    @Column(name = "date_time", nullable = false)
    private LocalDateTime dateTime;

    @ManyToMany(mappedBy = "comments")
    @JoinTable(
        name="task_and_comment_table",
        joinColumns= @JoinColumn(name="task_id", referencedColumnName="id"),
        inverseJoinColumns= @JoinColumn(name="comment_id", referencedColumnName="id"))
    private List<Tasks> tasks;
}
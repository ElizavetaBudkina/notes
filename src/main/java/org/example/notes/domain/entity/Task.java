package org.example.notes.domain.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.notes.domain.enums.PriorityTask;
import org.example.notes.domain.enums.StatusTask;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tasks_table")
public class Tasks {

    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "header", nullable = false, length = 100)
    private String header;

    @Column(name = "description", nullable = false, length = 400)
    private String description;

    @Column(name = "status", nullable = false, length = 20)
    @Enumerated(EnumType.STRING)
    private StatusTask status;

    @Column(name = "priority", nullable = false, length = 20)
    @Enumerated(EnumType.STRING)
    private PriorityTask priority;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "reporter_id", nullable = false)
    private Users reporter;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "assignee_id", nullable = false)
    private Users assignee;

    @Column(name = "date_time", nullable = false)
    private LocalDateTime dateTime;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name="task_and_comment_table",
        joinColumns= @JoinColumn(name="task_id", referencedColumnName="id"),
        inverseJoinColumns= @JoinColumn(name="comment_id", referencedColumnName="id"))
    private List<Comments> comments;
}
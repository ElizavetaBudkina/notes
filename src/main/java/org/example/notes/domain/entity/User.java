package org.example.notes.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.ColumnDefault;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "users_table")
public class Users {

    @Id
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @ColumnDefault("''")
    @Column(name = "middle_name", nullable = false, length = 50)
    private String middleName;

    @Column(name = "second_name", nullable = false, length = 50)
    private String secondName;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Column(name = "password", nullable = false, length = 100)
    private String password;

    @ColumnDefault("'user'")
    @Column(name = "role", nullable = false, length = 50)
    private String role;
}
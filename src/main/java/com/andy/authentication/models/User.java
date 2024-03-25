package com.andy.authentication.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@Table(name = "USERS")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "SQ_USER")
    @Column(name = "USER_ID")
    private Long userId;

    @Column(name = "FULL_NAME", nullable = false, unique = true)
    private String fullName;

    @Column(name = "USER_PASSWORD", nullable = false, unique = true)
    private String password;

    private String mail;

    @CreationTimestamp
    @Column(name = "CREATION_DATE")
    private LocalDate creationDate;

    @UpdateTimestamp
    @Column(name = "UPDATE_DATE")
    private LocalDate updateDate;

}

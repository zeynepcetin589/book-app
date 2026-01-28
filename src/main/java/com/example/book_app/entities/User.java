package com.example.book_app.entities;

import com.example.book_app.enums.UserRole;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message= "Email is required")
    @Column(unique = true)
    private String email;

    @NotBlank(message= "Password is required")
    private String password;
    private String firstName;
    private String lastName;

    @NotBlank(message= "Phone number is required")
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private UserRole role; //e.g. CUSTOMER, ADMIN

    private Boolean isActive;
    private final LocalDateTime createdAt = LocalDateTime.now();

}

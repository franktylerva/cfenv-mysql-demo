package com.example.mysqldemo.usermanagement.common.jpa;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USERS")
@NoArgsConstructor
@Data
public class User {
    @Id
    Long id;
    String email;
}

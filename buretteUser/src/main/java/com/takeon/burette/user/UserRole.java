package com.takeon.burette.user;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private EUserRole name;

    public UserRole() {

    }

    public UserRole(EUserRole name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public EUserRole getName() {
        return name;
    }

    public void setName(EUserRole name) {
        this.name = name;
    }
}
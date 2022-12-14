package ru.kata.spring.boot_security.demo.models;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Enumeration;
import java.util.List;
import java.util.Set;

@Entity
@Table (name = "roles")
public class Role implements GrantedAuthority {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;

    @ManyToMany(mappedBy = "roles")
    private List <User> users;

    public Role() {
    }


    @Override
    public String toString() {
        return name;
    }

    public Role(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }



    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getAuthority() {
        return getName();

    }


}

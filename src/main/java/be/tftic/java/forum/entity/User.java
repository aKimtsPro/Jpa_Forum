package be.tftic.java.forum.entity;

import jakarta.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private long id;

    @Column(name = "user_username",
            nullable = false,
            insertable = true,
            updatable = false,
            unique = true,
//            columnDefinition = "VARCHAR(50)",
            length = 50
    )
    private String username;
    @Column( name = "user_password", nullable = false)
    private String password;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
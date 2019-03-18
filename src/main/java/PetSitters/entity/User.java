package PetSitters.entity;
import org.springframework.data.annotation.Id;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

public class User {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        public String id;

        public String username;
        public String password;

        public User() {}

        public User(String username, String password) {
            this.username = username;
            this.password = password;
        }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String firstName) {
        this.username = firstName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String lastName) {
        this.password = lastName;
    }


    }


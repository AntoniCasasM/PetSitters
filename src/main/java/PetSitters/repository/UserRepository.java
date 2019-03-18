package PetSitters.repository;
import java.util.List;

import PetSitters.entity.User;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Document(collection = "users")
public interface UserRepository extends MongoRepository<User, String> {

        public User findByUsername(String firstName);
        public List<User> findByPassword(String lastName);

    }


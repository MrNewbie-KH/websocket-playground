package playground.websocketchat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import playground.websocketchat.entity.User;

@Repository
 public interface UserRepository extends JpaRepository<User,Long> {
    User findUserByEmail(String email);
}

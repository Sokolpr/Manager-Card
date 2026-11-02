package peanutsh.cardservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import peanutsh.cardservice.model.entity.User;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

}

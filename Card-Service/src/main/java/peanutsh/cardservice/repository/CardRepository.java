package peanutsh.cardservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import peanutsh.cardservice.model.entity.Card;

import java.util.UUID;

public interface CardRepository extends JpaRepository<Card, UUID> {


}

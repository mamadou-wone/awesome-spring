package sn.amir.boss.msscbeerservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sn.amir.boss.msscbeerservice.domain.Beer;

import java.util.UUID;

public interface BeerRepository extends JpaRepository<Beer, UUID > {
}

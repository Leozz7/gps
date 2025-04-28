package spring.boot.desafio.gps.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import spring.boot.desafio.gps.model.poi;

import java.util.List;

public interface poiRepository extends JpaRepository<poi, Long> {

    @Query("SELECT p FROM poi p WHERE p.x BETWEEN :xMin AND :xMax AND p.y BETWEEN :yMin AND :yMax")
    List<poi> findPontosProximos(Long xMin, Long xMax, Long yMin, Long yMax);
}

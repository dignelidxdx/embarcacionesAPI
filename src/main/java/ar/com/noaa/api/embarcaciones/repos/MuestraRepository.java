package ar.com.noaa.api.embarcaciones.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.noaa.api.embarcaciones.entities.Muestra;

@Repository
public interface MuestraRepository extends JpaRepository<Muestra, Integer> {
    
}
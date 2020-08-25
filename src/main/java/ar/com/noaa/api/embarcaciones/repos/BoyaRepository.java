package ar.com.noaa.api.embarcaciones.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.noaa.api.embarcaciones.entities.Boya;

@Repository
public interface BoyaRepository extends JpaRepository<Boya, Integer> { 
    
}
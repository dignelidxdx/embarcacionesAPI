package ar.com.noaa.api.embarcaciones.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.noaa.api.embarcaciones.entities.Boya;
import ar.com.noaa.api.embarcaciones.repos.BoyaRepository;

@Service
public class BoyaService {
    
    @Autowired
    BoyaRepository repoBoya;

    public void createBoya(Boya boya) {
        repoBoya.save(boya);
    }

}
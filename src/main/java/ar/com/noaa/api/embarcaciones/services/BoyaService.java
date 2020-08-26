package ar.com.noaa.api.embarcaciones.services;

import java.util.List;
import java.util.Optional;

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

    public Boya readByIdBoya(Integer id) {
    
        Optional<Boya> opBoya = repoBoya.findById(id);

        if (opBoya.isPresent())
            return opBoya.get();
        else
            return null;       
    }   

    public List<Boya> readAllBoyas() {
        return (repoBoya.findAll());
    }    

    public void updateBoya(Boya boya) {
        repoBoya.save(boya);
    }

}
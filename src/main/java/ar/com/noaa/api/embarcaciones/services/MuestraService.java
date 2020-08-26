package ar.com.noaa.api.embarcaciones.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.noaa.api.embarcaciones.entities.Muestra;
import ar.com.noaa.api.embarcaciones.repos.MuestraRepository;

@Service
public class MuestraService {
    
    @Autowired
    MuestraRepository repoMuestra;

    public void createMuestra(Muestra muestra) {
        repoMuestra.save(muestra);
    }

    public Muestra readByNameMuestra(String name) {
        
        return repoMuestra.findByMatriculaEmbarcacion(name);
    }

    public Muestra readByIdMuestra(Integer id) {
    
        Optional<Muestra> opMuestra = repoMuestra.findById(id);

        if (opMuestra.isPresent())
            return opMuestra.get();
        else
            return null;       
    }   

    public List<Muestra> readAllMuestras() {
        return (repoMuestra.findAll());
    }    

    public void updateBoya(Muestra muestra) {
        repoMuestra.save(muestra);
    }
  
    public void deleteMuestra(Muestra muestra) {
        repoMuestra.delete(muestra);
    }

}
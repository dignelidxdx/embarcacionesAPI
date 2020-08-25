package ar.com.noaa.api.embarcaciones.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.noaa.api.embarcaciones.repos.MuestraRepository;

@Service
public class MuestraService {
    
    @Autowired
    MuestraRepository repoMuestra;

    
}
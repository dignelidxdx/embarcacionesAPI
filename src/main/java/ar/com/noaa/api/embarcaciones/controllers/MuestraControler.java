package ar.com.noaa.api.embarcaciones.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ar.com.noaa.api.embarcaciones.entities.Boya;
import ar.com.noaa.api.embarcaciones.entities.Muestra;
import ar.com.noaa.api.embarcaciones.models.request.NuevaMuestraRequest;
import ar.com.noaa.api.embarcaciones.models.response.GenericResponse;
import ar.com.noaa.api.embarcaciones.services.BoyaService;
import ar.com.noaa.api.embarcaciones.services.MuestraService;

@RestController
public class MuestraControler {
    
    @Autowired
    MuestraService muestraService; 
    @Autowired
    BoyaService boyaService;   

    @PostMapping("/muestras")   
    public ResponseEntity<GenericResponse> createMuestra(@RequestBody Muestra muestra) {
        
        muestraService.createMuestra(muestra);

        GenericResponse r = new GenericResponse(true, "Muestra creada con exito", muestra.getMuestraId());
       
        return ResponseEntity.ok(r);
    }

    @GetMapping("/api/muestras")
    public ResponseEntity<List<Muestra>> readMuestras() {  
        
        return ResponseEntity.ok(muestraService.readAllMuestras());        
    }
    
    @GetMapping("/api/muestras/{id}")
    public ResponseEntity<GenericResponse> readBoyaById(@PathVariable Integer id) {
        
        Optional<Muestra> muestra = Optional.ofNullable(muestraService.readByIdMuestra(id));

        GenericResponse genericRes = new GenericResponse(true, "Muestra creada con exito!!", id);

        if (muestra.isPresent())
            return ResponseEntity.ok(genericRes);

        return ResponseEntity.notFound().build();             
    }

    @GetMapping("/muestras/boyas/{idBoya}")  
        public ResponseEntity<List<NuevaMuestraRequest>> readMuestrasByBoya(@PathVariable Integer idBoya) {

        List<Muestra> listaMuestras = new ArrayList<>();
        Boya boya = boyaService.readByIdBoya(idBoya);              

        List<NuevaMuestraRequest> listaNewMuestras = new ArrayList<>();
        for (Muestra muestra : listaMuestras) {
            NuevaMuestraRequest nuevoMuestra = new NuevaMuestraRequest();
            nuevoMuestra.latitudInstalacion = boya.getLatitudInstalacion();
            nuevoMuestra.longitudInstalacion = boya.getLongitudInstalacion();
            nuevoMuestra.estadoLuz = boya.getEstadoLuz();

            listaNewMuestras.add(nuevoMuestra);
        }

        return ResponseEntity.ok(listaNewMuestras);
    }

    @DeleteMapping("/muestras/{id}")
    public ResponseEntity<GenericResponse> deleteMuestra(@PathVariable Integer id) {

         Optional<Muestra> newMuestra = Optional.ofNullable(muestraService.readByIdMuestra(id));

        if (newMuestra.isPresent()){

            muestraService.deleteMuestra(newMuestra.get());          
            GenericResponse genericResponse = new GenericResponse(true, "Muestra dado de baja", id);
            return ResponseEntity.ok(genericResponse);             
        }        
        return ResponseEntity.notFound().build();   
    }
}
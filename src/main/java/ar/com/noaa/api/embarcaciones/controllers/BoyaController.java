package ar.com.noaa.api.embarcaciones.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.noaa.api.embarcaciones.entities.Boya;
import ar.com.noaa.api.embarcaciones.models.response.GenericResponse;
import ar.com.noaa.api.embarcaciones.services.BoyaService;

@RestController
public class BoyaController {
    
    @Autowired
    BoyaService boyaService;   

    @PostMapping("/boyas")   
    public ResponseEntity<GenericResponse> createBoya(@RequestBody Boya boya) {
        
        boyaService.createBoya(boya);

        GenericResponse r = new GenericResponse(true, "Boya creada con exito", boya.getBoyaId());
       
        return ResponseEntity.ok(r);
    }

    @GetMapping("/boyas")
    public ResponseEntity<List<Boya>> readBoyas() {  
        
        return ResponseEntity.ok(boyaService.readAllBoyas());        
    }
    
    @GetMapping("/boyas/{id}")
    public ResponseEntity<GenericResponse> readBoyaById(@PathVariable Integer id) {
        
        Optional<Boya> boya = Optional.ofNullable(boyaService.readByIdBoya(id));

        GenericResponse genericRes = new GenericResponse(true, "Boya creada con exito!!", id);

        if (boya.isPresent())
            return ResponseEntity.ok(genericRes);

        return ResponseEntity.notFound().build();             
    }

    @PutMapping(("/boyas/{id}"))
    public ResponseEntity<GenericResponse> updateBoyaById(@PathVariable Integer id, @RequestBody Boya nBoya) {

        Optional<Boya> newBoya = Optional.ofNullable(boyaService.readByIdBoya(id));

        if (newBoya.isPresent()) {

            boyaService.updateBoya(nBoya);
            GenericResponse genericRes = new GenericResponse(true, "Boya actualizado con éxito", nBoya.getBoyaId());

            return ResponseEntity.ok(genericRes);            
        }
        return ResponseEntity.notFound().build();
    }


}
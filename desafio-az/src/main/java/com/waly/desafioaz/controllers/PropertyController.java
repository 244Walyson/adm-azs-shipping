package com.waly.desafioaz.controllers;

import com.waly.desafioaz.dtos.PropertyDTO;
import com.waly.desafioaz.services.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/properties")
public class PropertyController {

    @Autowired
    private PropertyService service;

    @GetMapping
    public ResponseEntity<List<PropertyDTO>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PropertyDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }


    @PutMapping("/{id}")
    public ResponseEntity<PropertyDTO> findById(@PathVariable Long id, @RequestBody PropertyDTO dto){
        return ResponseEntity.ok(service.update(id, dto));
    }


    @PostMapping
    public ResponseEntity<PropertyDTO> findById(@RequestBody PropertyDTO dto){
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(service.insert(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

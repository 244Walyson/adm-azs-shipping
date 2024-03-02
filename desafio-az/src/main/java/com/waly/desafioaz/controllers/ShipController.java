package com.waly.desafioaz.controllers;

import com.waly.desafioaz.dtos.ShipDTO;
import com.waly.desafioaz.services.ShipService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/ships")
@Tag(name = "Ship", description = "Controller For Ships")
public class ShipController {
    
    @Autowired
    private ShipService service;

    @GetMapping
    public ResponseEntity<Page<ShipDTO>> findAll(@RequestParam(value = "param", defaultValue = "") String param, Pageable pageable){
        return ResponseEntity.ok(service.findAll(param, pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShipDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }


    @PutMapping("/{id}")
    public ResponseEntity<ShipDTO> update(@PathVariable Long id, @RequestBody ShipDTO dto){
        return ResponseEntity.ok(service.update(id, dto));
    }


    @PostMapping
    public ResponseEntity<ShipDTO> findById(@RequestBody ShipDTO dto){
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(service.insert(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}

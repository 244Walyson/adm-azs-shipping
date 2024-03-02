package com.waly.desafioaz.controllers;

import com.waly.desafioaz.dtos.ClientDTO;
import com.waly.desafioaz.dtos.ClientShipDTO;
import com.waly.desafioaz.services.ClientService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/clients")
@Tag(name = "Client", description = "Controller for clients")
public class ClientController {

    @Autowired
    private ClientService service;

    @GetMapping
    public ResponseEntity<Page<ClientShipDTO>> findAll(@RequestParam(value = "param", defaultValue = "") String param, Pageable pageable){
        return ResponseEntity.ok(service.findAll(param, pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientShipDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }


    @PutMapping("/{id}")
    public ResponseEntity<ClientDTO> update(@PathVariable Long id, @RequestBody ClientDTO dto){
        return ResponseEntity.ok(service.update(id, dto));
    }


    @PostMapping
    public ResponseEntity<ClientDTO> findById(@RequestBody ClientDTO dto){
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(service.insert(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

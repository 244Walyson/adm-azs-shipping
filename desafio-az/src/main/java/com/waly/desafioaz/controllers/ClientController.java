package com.waly.desafioaz.controllers;

import com.waly.desafioaz.dtos.ClientDTO;
import com.waly.desafioaz.dtos.ClientShipDTO;
import com.waly.desafioaz.services.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
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

    @Operation(
            description = "Get all clients paged",
            summary = "Get all clients paged"
    )
    @GetMapping
    public ResponseEntity<Page<ClientShipDTO>> findAll(@RequestParam(value = "param", defaultValue = "") String param, Pageable pageable){
        return ResponseEntity.ok(service.findAll(param, pageable));
    }

    @Operation(
            description = "Get a client by id",
            summary = "Get a client by id",
            responses = {
                    @ApiResponse(description = "Ok", responseCode = "200"),
                    @ApiResponse(description = "Not Found", responseCode = "400"),
            }
    )
    @GetMapping("/{id}")
    public ResponseEntity<ClientShipDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }


    @Operation(
            description = "Update a client",
            summary = "Update a client",
            responses = {
                    @ApiResponse(description = "Ok", responseCode = "200"),
                    @ApiResponse(description = "Bad Request", responseCode = "400"),
                    @ApiResponse(description = "Unprocessable Entity", responseCode = "422")
            }
    )
    @PutMapping("/{id}")
    public ResponseEntity<ClientDTO> update(@Valid @PathVariable Long id, @RequestBody ClientDTO dto){
        return ResponseEntity.ok(service.update(id, dto));
    }


    @Operation(
            description = "Create a new client",
            summary = "Create a new client",
            responses = {
                    @ApiResponse(description = "Created", responseCode = "201"),
                    @ApiResponse(description = "Bad Request", responseCode = "400"),
                    @ApiResponse(description = "Unprocessable Entity", responseCode = "422")
            }
    )
    @PostMapping
    public ResponseEntity<ClientDTO> insert(@Valid @RequestBody ClientDTO dto){
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(service.insert(dto));
    }

    @Operation(
            description = "Delete a client",
            summary = "Delete a client",
            responses = {
                    @ApiResponse(description = "No Content", responseCode = "204"),
                    @ApiResponse(description = "Not Found", responseCode = "404"),
            }
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

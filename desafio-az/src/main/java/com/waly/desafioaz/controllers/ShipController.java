package com.waly.desafioaz.controllers;

import com.waly.desafioaz.dtos.ShipDTO;
import com.waly.desafioaz.services.ShipService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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

    @Operation(
            description = "Get all ships paged",
            summary = "Get all ships paged"
    )
    @GetMapping
    public ResponseEntity<Page<ShipDTO>> findAll(@RequestParam(value = "param", defaultValue = "") String param, Pageable pageable){
        return ResponseEntity.ok(service.findAll(param, pageable));
    }

    @Operation(
            description = "Get a ship by id",
            summary = "Get a ship by id",
            responses = {
                    @ApiResponse(description = "Ok", responseCode = "200"),
                    @ApiResponse(description = "Not Found", responseCode = "400"),
            }
    )
    @GetMapping("/{id}")
    public ResponseEntity<ShipDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }


    @Operation(
            description = "Update a ship",
            summary = "Update a ship",
            responses = {
                    @ApiResponse(description = "Ok", responseCode = "200"),
                    @ApiResponse(description = "Bad Request", responseCode = "400"),
                    @ApiResponse(description = "Unprocessable Entity", responseCode = "422")
            }
    )
    @PutMapping("/{id}")
    public ResponseEntity<ShipDTO> update(@PathVariable Long id, @RequestBody ShipDTO dto){
        return ResponseEntity.ok(service.update(id, dto));
    }


    @Operation(
            description = "Create a new ship",
            summary = "Create a new ship",
            responses = {
                    @ApiResponse(description = "Created", responseCode = "201"),
                    @ApiResponse(description = "Bad Request", responseCode = "400"),
                    @ApiResponse(description = "Unprocessable Entity", responseCode = "422")
            }
    )
    @PostMapping
    public ResponseEntity<ShipDTO> findById(@RequestBody ShipDTO dto){
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(service.insert(dto));
    }

    @Operation(
            description = "Delete a ship",
            summary = "Delete a ship",
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

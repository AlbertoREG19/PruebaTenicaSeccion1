package com.arespejel.pruebatecnica.controllers;

import com.arespejel.pruebatecnica.models.Cargo;
import com.arespejel.pruebatecnica.services.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/carga-csv")
public class CargoController {

    @Autowired
    private CargoService service;

    @GetMapping(path = "/{ruta}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Cargo>> carga(@PathVariable String ruta) throws IOException {
            return ResponseEntity.status(HttpStatus.OK).body(service.carga(ruta));
    }
}

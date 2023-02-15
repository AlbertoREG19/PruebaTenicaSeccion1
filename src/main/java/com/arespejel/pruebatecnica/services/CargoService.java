package com.arespejel.pruebatecnica.services;

import com.arespejel.pruebatecnica.models.Cargo;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface CargoService {

    void carga(String ruta) throws IOException, CsvValidationException;

}

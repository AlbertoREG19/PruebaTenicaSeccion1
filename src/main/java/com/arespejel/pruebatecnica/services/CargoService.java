package com.arespejel.pruebatecnica.services;

import com.arespejel.pruebatecnica.models.Cargo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface CargoService {

    List<Cargo> carga(String ruta) throws IOException;

}

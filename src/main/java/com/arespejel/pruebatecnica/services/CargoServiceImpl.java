package com.arespejel.pruebatecnica.services;

import com.arespejel.pruebatecnica.models.Cargo;
import com.arespejel.pruebatecnica.repository.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CargoServiceImpl implements CargoService{

    @Autowired
    private CargoRepository repository;

    @Override
    public List<Cargo> carga(String ruta) throws IOException {
        FileReader archivo = new FileReader(ruta);
        Cargo cargo = new Cargo();

        BufferedReader reader = new BufferedReader(new FileReader(ruta));
        String lines = reader.lines().skip(1).collect(Collectors.joining("\n"));
        String [] rows = lines.split("\n");

        Arrays.stream(rows).forEach(row -> {
            String[] data = row.split(",");
            cargo.setId(data[0]);
            cargo.setCompanyName(data[1]);
            cargo.setCompanyId(data[2]);
            cargo.setAmount(new BigDecimal(data[3]));
            cargo.setStatus(data[4]);
            cargo.setCreatedAt(new Date(data[5]));
            cargo.setUpdatedAt(new Date(data[6]));

            repository.save(cargo);
        });
        reader.close();
        return (List<Cargo>) repository.findAll();


    }
}

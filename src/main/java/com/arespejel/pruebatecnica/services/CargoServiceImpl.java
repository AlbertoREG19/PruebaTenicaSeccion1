package com.arespejel.pruebatecnica.services;

import com.arespejel.pruebatecnica.models.Cargo;
import com.arespejel.pruebatecnica.models.Companies;
import com.arespejel.pruebatecnica.repository.CargoRepository;
import com.arespejel.pruebatecnica.repository.CompaniesRepository;
import com.arespejel.pruebatecnica.services.Utils.Fechas;
import com.arespejel.pruebatecnica.services.Utils.SaveCompanies;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.math.BigDecimal;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class CargoServiceImpl implements CargoService {

    @Autowired
    private CargoRepository cargoRepository;

    @Autowired
    private CompaniesRepository companiesRepository;

    @Override
    public void carga(String ruta) throws IOException, CsvValidationException {
        Stream<String[]> lines = new BufferedReader(new FileReader(ruta)).lines().skip(1).map(line -> line.split(","));

        Cargo carga = new Cargo();
        Companies com = new Companies();
        lines.forEach(line -> {
            if (line.length >= 6) {
                SaveCompanies.saveCompanies(companiesRepository, line[2], line[1], Fechas.fecha(line[5]));

                Optional<Cargo> optional = cargoRepository.findById(line[0]);
                if (optional.isEmpty()) {
                    carga.setId(line[0]);//0 id
                    carga.setCompanyName(line[1]);//1 name
                    carga.setCompanyId(line[2]);// 2 id
                    carga.setAmount(Double.parseDouble((line[3])));// 3 amount
                    carga.setStatus(line[4]);//4 status
                    carga.setCreatedAt(Fechas.fecha(line[5]));//
                    if (line.length >= 7) {
                        carga.setUpdatedAt(Fechas.fecha(line[6]));
                        cargoRepository.save(carga);
                    } else {
                        cargoRepository.save(carga);
                    }
                }
            }
        });
    }
}
/*com.setId(line[2]);
        com.setCompanyName(line[1]);
        com.setCreatedAt(Fechas.fecha(line[5]));
        companiesRepository.save(com);

        com.setId(line[2]);
        com.setCompanyName(line[1]);
        com.setCreatedAt(Fechas.fecha(line[5]));
        companiesRepository.save(com);



        else if(line.length>=7){
                    carga.setId(line[0]);//0 id
                    carga.setCompanyName(line[1]);//1 name
                    carga.setCompanyId(line[2]);// 2 id
                    carga.setAmount(new BigDecimal(line[3]));// 3 amount
                    carga.setStatus(line[4]);//4 status
                    carga.setCreatedAt(Fechas.fecha(line[5]));//
                carga.setUpdatedAt(Fechas.fecha(line[6]));

                    repository.save(carga);
                }





        */
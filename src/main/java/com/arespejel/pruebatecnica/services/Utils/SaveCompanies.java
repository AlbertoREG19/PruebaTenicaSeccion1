package com.arespejel.pruebatecnica.services.Utils;

import com.arespejel.pruebatecnica.models.Companies;
import com.arespejel.pruebatecnica.repository.CompaniesRepository;

import java.sql.Timestamp;
import java.util.Optional;

public class SaveCompanies {

    public static void saveCompanies(CompaniesRepository companiesRepository, String id, String name, Timestamp fecha) {
        Companies companies = new Companies();
        Optional<Companies> optiona = companiesRepository.findById(id);

        if (optiona.isEmpty()) {
            companies.setId(id);
            companies.setCompanyName(name);
            companies.setCreatedAt(fecha);
            companiesRepository.save(companies);
        }
    }
}

package com.arespejel.pruebatecnica.models;

import com.arespejel.pruebatecnica.services.Utils.Fechas;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class CompaniesTest {

    @Test
    void testCompanies(){
        Companies companies = new Companies();
        companies.setId("cbf1c8b09cd5b549416d49d220a40cbd317f952e");
        companies.setCompanyName("MiPasajefy");
        companies.setCreatedAt(Fechas.fecha("2019-03-19"));

        assertEquals(companies.getId(), "cbf1c8b09cd5b549416d49d220a40cbd317f952e");
        assertEquals(companies.getCompanyName(), "MiPasajefy");
        assertEquals(companies.getCreatedAt(), Fechas.fecha("2019-03-19"));

    }
}

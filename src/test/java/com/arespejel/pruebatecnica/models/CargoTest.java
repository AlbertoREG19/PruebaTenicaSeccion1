package com.arespejel.pruebatecnica.models;

import com.arespejel.pruebatecnica.services.Utils.Fechas;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class CargoTest {

    @Test
    void testCargo(){
        Cargo cargo= new Cargo();
        cargo.setId("48ba4bdbfb56ceebb32f2bd0263e759be942af3d");
        cargo.setCompanyId("cbf1c8b09cd5b549416d49d220a40cbd317f952e");
        cargo.setCompanyName("MiPasajefy");
        cargo.setAmount(3.0);
        cargo.setStatus("voided");
        cargo.setCreatedAt(Fechas.fecha("2019-03-19"));

        assertEquals(cargo.getId(),"48ba4bdbfb56ceebb32f2bd0263e759be942af3d");
        assertEquals(cargo.getCompanyId(),"cbf1c8b09cd5b549416d49d220a40cbd317f952e");
        assertEquals(cargo.getCompanyName(),"MiPasajefy");
        assertEquals(cargo.getAmount(),3.0);
        assertEquals(cargo.getStatus(),"voided");
        assertEquals(cargo.getCreatedAt(),Fechas.fecha("2019-03-19"));

    }
}

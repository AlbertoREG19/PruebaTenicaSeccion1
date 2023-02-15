package com.arespejel.pruebatecnica.services.Utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Fechas {

    public static Timestamp fecha(String fecha){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date parsedDate;
        try {
            parsedDate = dateFormat.parse(fecha);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return new Timestamp(parsedDate.getTime());
    }
}

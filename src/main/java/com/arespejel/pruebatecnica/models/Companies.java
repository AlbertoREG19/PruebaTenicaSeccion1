package com.arespejel.pruebatecnica.models;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Entity
@Table(name = "companies")
public class Companies {

    @Id
    private String id;

    @Column(name = "company_name")
    private String companyName;

    @Column(name="created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp createdAt;
}

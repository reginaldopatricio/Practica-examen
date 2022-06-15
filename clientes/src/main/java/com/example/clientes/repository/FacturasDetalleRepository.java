package com.example.clientes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.clientes.model.FacturasDetalle;

public interface FacturasDetalleRepository extends JpaRepository<FacturasDetalle, Long> {

}

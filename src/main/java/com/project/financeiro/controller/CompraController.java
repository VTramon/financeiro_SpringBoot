package com.project.financeiro.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.financeiro.model.Compra;
import com.project.financeiro.repository.CompraRepository;
import com.project.financeiro.services.compra.GetAllCompras;

@RestController
@RequestMapping("compra")
public class CompraController {

    @Autowired
    CompraRepository compraRepository;

    @Autowired
    GetAllCompras getAllCompras;

    @GetMapping("/{userId}")
    ResponseEntity<List<Compra>> getAllCompras(@PathVariable UUID userId) {
        List<Compra> compras = getAllCompras.execute(userId);

        if (!compras.isEmpty()) {
            return new ResponseEntity<>(compras, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @PostMapping
    ResponseEntity<Compra> compra(@RequestBody Compra compra) {
        return new ResponseEntity<Compra>(compraRepository.save(compra), HttpStatus.OK);
    }

    // @GetMapping("/{id}")
    // ResponseEntity<Compra> getById(@RequestBody UUID userId, @PathVariable UUID
    // compraId) {
    // Optional<Compra> compra = compraRepository.findById(compraId);
    // if (!compra.isEmpty()) {
    // return new ResponseEntity<>(compra.get(), HttpStatus.OK);
    // }
    // return new ResponseEntity<>(null, HttpStatus.OK);
    // }
}

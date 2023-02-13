package com.project.financeiro.services.compra;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.financeiro.model.Compra;
import com.project.financeiro.repository.CompraRepository;

@Service
public class GetAllCompras {

    @Autowired
    CompraRepository compraRepository;

    public List<Compra> execute(UUID userId) {
        List<Compra> compras = compraRepository.findAll();

        List<Compra> result = compras.stream().map(item -> {
            // System.out.println(item.getUserId());
            // System.out.println(userId.equals(item.getUserId()));
            // System.out.println("\n\n\n");
            if (userId.equals(item.getUserId())) {
                return item;
            }
            return null;
        }).toList();

        return result;
    }
}

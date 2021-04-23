package com.platzi.market.persistence;

import com.platzi.market.persistence.crud.ProductoCrudRepository;
import com.platzi.market.persistence.entity.Producto;

import java.util.List;
import java.util.Optional;

public class ProductoRepository {

    private ProductoCrudRepository productoCrudRepository;

    public List<Producto> getAll(){
        return (List<Producto>) productoCrudRepository.findAll();
    }

    public List<Producto> getByCategoria( int idCategoria ){ return productoCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategoria); }

    public Optional<Producto> getByCodigoBarras( String codigoBarras ){ return productoCrudRepository.findByCodigoBarras(codigoBarras);}

    public Optional<List<Producto>> getEscasos( int cantidad ){
        return productoCrudRepository.finByCantidadStockLessThanAndEstado(cantidad, true);
    }

    public Optional<List<Producto>> getByNombre( String nombre ){ return productoCrudRepository.findByNombreLike( nombre ); }
}

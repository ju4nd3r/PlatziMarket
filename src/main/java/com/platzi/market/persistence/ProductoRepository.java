package com.platzi.market.persistence;

import com.platzi.market.persistence.crud.ProductoCrudRepository;
import com.platzi.market.persistence.entity.Producto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/*
Como esta es una clase que está interactuando directamente con la base de datos
es buena práctica decorarla con una anotación, en este caso @Repository.

Con esto le indicamos a Spring que esta clase se encarga de interactuar con la BD
 */
@Repository
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

    public Optional<Producto> getProducto(int idProducto){
        return productoCrudRepository.findById(idProducto);
    }

    public Producto save(Producto producto){
        return productoCrudRepository.save(producto);
    }

    public void delete(int idProducto){
        productoCrudRepository.deleteById(idProducto);
    }
}

package com.platzi.market.persistence.crud;

import com.platzi.market.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

/*
Extendemos de la interface CrudRepository en donde se le indica primero, el tipo
de Objeto de la entidad y segundo, el tipo de dato de la clave primaria de esa entidad
 */
public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {
}

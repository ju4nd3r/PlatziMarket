package com.platzi.market.persistence.crud;

import com.platzi.market.persistence.entity.Producto;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

/*
Extendemos de la interface CrudRepository en donde se le indica primero, el tipo
de Objeto de la entidad y segundo, el tipo de dato de la clave primaria de esa entidad
 */
public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {

    /*
    Si se fuera a usar de manera nativa, especificando la consulta, lo haríamos con
    la sgte anotación arriba del método:

    @Query(value = "SELECT * FROM productos WHERE id_categoria = ?", nativeQuery = true)

    NOTA: Haciendo uso de esta consulta nativa, no es necesario seguir las reglas de nombramiento
    del los query methods
     */
    List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);

    Optional<List<Producto>> finByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado );

    Optional<Producto> findByCodigoBarras(String codigoBarras);

    Optional<List<Producto>> findByNombreLike(String nombre);
}

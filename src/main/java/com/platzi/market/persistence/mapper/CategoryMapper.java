package com.platzi.market.persistence.mapper;

import com.platzi.market.domain.Category;
import com.platzi.market.persistence.entity.Categoria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

/*
Con la anotación @Mapper indicamos que esta interfaz en una
mapeadora/traductora de Categoría, con el atributo  componentModel = "spring", indicamos que
es un componente de Spring
 */
@Mapper(componentModel = "spring")
public interface CategoryMapper {

    /*
    Para especificar cómo se quiere hacer la traducción se utiliza @Mappings
    y los atributos los traduciomos uno a uno con @Mapping
     */
    @Mappings({
            @Mapping(source = "idCategoria", target = "categoryId"),
            @Mapping(source = "descripcion", target = "category"),
            @Mapping(source = "estado", target = "active")
    })
    Category toCategory(Categoria categoria);

    @InheritInverseConfiguration//Indicamos que realice el mapeo a la inversa a como está arriba
    @Mapping(target = "productos", ignore = true)//Cuando vaya a mapear la lista de productos de categoría, ignórala
    Categoria toCategoria(Category category);

}

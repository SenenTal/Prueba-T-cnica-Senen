/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senen.articulos.repository;

import com.senen.articulos.DTO.ArticulosCategoriaDTO;
import com.senen.articulos.DTO.ArticulosUsuariosDTO;
import com.senen.articulos.entities.Articulos;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author senen
 */
@Repository
public interface ArticulosRepository extends JpaRepository<Articulos, Long>{
    
    @Query(value = "SELECT * FROM fn_llamar_articulos()", nativeQuery = true)
    List<ArticulosCategoriaDTO> listarArticulos();
    
    @Transactional
    @Query(value = "SELECT * FROM fn_crear_articulo(:titulo, :descripcion, "
            + ":precio, :categoria, :ubicacion, :imagen, :id_usuario", nativeQuery = true)
    Articulos crearArticulo(@Param("titulo") String titulo, @Param("descripcion") String descripcion,
            @Param("precio") float precio, @Param("categoria") String categoria, 
            @Param("ubicacion") String ubicacion, @Param("imagen") String imagen, 
            @Param("id_usuario") Long idUsuario);
    
    @Modifying
    @Transactional
    @Query(value = "CALL sp_delete_articulo_id(:id)", nativeQuery = true)
    void borrarArticulo(@Param(":id") Long id);
    
    @Transactional
    @Query(value = "SELECT * FROM fn_buscar_por_categoria(:categoria)", nativeQuery = true)
    List<ArticulosCategoriaDTO> buscarPorCategoria(@Param(":categoria") String categoria);
    
    @Transactional
    @Query(value = "SELECT * FROM fn_buscar_nombre_articulo(:titulo)", nativeQuery = true)
    List<ArticulosCategoriaDTO> buscarPorTitulo(@Param("titulo") String titulo);
    
    @Transactional
    @Query(value = "SELECT * FROM fn_obtener_articulos_por_id(:id)", nativeQuery = true)
    ArticulosCategoriaDTO buscarPorId(@Param("id") Long id_articulo);
    
    @Transactional
    @Query(value = "SELECT * FROM fn_modificar_articulo_1(:articulo_id, :usuario_id, :titulo, :descripcion,"
            + " :precio, :categoria, :estado_articulo, :ubicacion, CURRENT_TIMESTAMP)", nativeQuery = true)
    ArticulosCategoriaDTO modificarArticulo1(@Param("articulo_id") Long id_articulo, @Param("usuario_id") Long id_usuario,
            @Param("titulo") String titulo, @Param("descripcion") String descripcion, @Param("precio") float precio,
            @Param("categoria") String categoria, @Param("estado_articulo") boolean estadoArticulo, 
            @Param("ubicacion") String ubicacion);
    
    @Transactional
    @Query(value = "SELECT * FROM fn_modificar_articulo_2(:articulo_id, :usuario_id, :titulo, :descripcion,"
            + " :precio, :categoria, :estado_articulo, :ubicacion, CURRENT_TIMESTAMP, :imagen)", nativeQuery = true)
    ArticulosCategoriaDTO modificarArticulo2(@Param("articulo_id") Long id_articulo, @Param("usuario_id") Long id_usuario,
            @Param("titulo") String titulo, @Param("descripcion") String descripcion, @Param("precio") float precio,
            @Param("categoria") String categoria, @Param("estado_articulo") boolean estadoArticulo, 
            @Param("ubicacion") String ubicacion, @Param("imagen") String imagen);
    
    @Transactional
    @Query(value = "SELECT * FROM fn_listar_articulos_usuario(:id_usuario)", nativeQuery = true)
    List<ArticulosCategoriaDTO> obtenerArticulosDeUsuario(@Param("id_usuario") Long id);
    
    @Transactional
    @Query(value = "SELECT * FROM fn_listar_articulos_usuarios()", nativeQuery = true)
    List<ArticulosUsuariosDTO> obtenerArticulosYUsuarios();
    
    
}

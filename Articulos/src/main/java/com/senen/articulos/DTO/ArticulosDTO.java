/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.senen.articulos.DTO;

import java.time.LocalDateTime;

/**
 *
 * @author senen
 */
public interface ArticulosDTO {
    Long getId();
    
    String getTitulo();
    
    String getDescripcion();
    
    float getPrecio();
    
    String getCategoria();
    
    boolean getEstadoArticulo();
    
    String getUbicacion();
    
    //LocalDateTime getFechaPublicacion();
    
    String getImagen();
    
    //Long getIdUsuario();
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petgato.manterUsuario.repository;

import com.petgato.manterUsuario.model.GrupoUsuario;
import com.petgato.padrao.repository.AdapterRepository;
import java.util.List;

/**
 *
 * @author alessandra
 */
public class GrupoUsuarioRepository extends AdapterRepository<GrupoUsuario, Long> {

    @Override
    public List<GrupoUsuario> findAll() {
        return getEntityManager().createQuery("SELECT gu FROM GrupoUsuario gu", GrupoUsuario.class).getResultList();
            }     

    @Override
    public GrupoUsuario findById(Long value) {
        return getEntityManager().find(GrupoUsuario.class, value);
    }  
}

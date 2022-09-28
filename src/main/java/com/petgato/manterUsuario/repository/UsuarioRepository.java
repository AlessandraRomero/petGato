/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petgato.manterUsuario.repository;

import com.petgato.manterUsuario.model.Usuario;
import com.petgato.padrao.repository.AdapterRepository;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author alessandra
 */
public class UsuarioRepository extends AdapterRepository<Usuario, Long>{
    
    @Override
    public List<Usuario> findAll() {
         Session session = (Session) getEntityManager().getDelegate();
        return session.createQuery("SELECT user FROM Usuario user", Usuario.class).list();
    }    
}

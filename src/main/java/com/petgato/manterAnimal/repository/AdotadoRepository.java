/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petgato.manterAnimal.repository;

import com.petgato.manterAnimal.model.Adotado;
import com.petgato.padrao.repository.AdapterRepository;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author alessandra
 */
public class AdotadoRepository extends AdapterRepository<Adotado, Long>{
    
    @Override
    public List<Adotado> findAll() {
        Session session = (Session) getEntityManager().getDelegate();
        return session.createQuery("SELECT adotado FROM Adotado adotado", Adotado.class).list();
    }
}

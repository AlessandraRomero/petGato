/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petgato.manterAnimal.repository;

import com.petgato.manterAnimal.model.Especie;
import com.petgato.padrao.repository.AdapterRepository;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author alessandra
 */
public class EspecieRepository extends AdapterRepository<Especie, Long>{
    
    @Override
    public List<Especie> findAll() {
        Session session = (Session) getEntityManager().getDelegate();
        return session.createQuery("SELECT especie FROM Especie especie", Especie.class).list();
    }
}

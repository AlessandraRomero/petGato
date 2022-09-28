/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petgato.manterAnimal.repository;

import com.petgato.manterAnimal.model.Raca;
import com.petgato.manterAnimal.model.Visita;
import com.petgato.padrao.repository.AdapterRepository;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author alessandra
 */
public class VisitaRepository extends AdapterRepository<Visita, Long>{
    
    @Override
    public List<Visita> findAll() {
        Session session = (Session) getEntityManager().getDelegate();
        return session.createQuery("SELECT visita FROM Visita visita", Visita.class).list();
    }
}

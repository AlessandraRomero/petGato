/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petgato.manterAnimal.repository;

import com.petgato.manterAnimal.model.Raca;
import com.petgato.padrao.repository.AdapterRepository;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author alessandra
 */
public class RacaRepository extends AdapterRepository<Raca, Long>{
    
    @Override
    public List<Raca> findAll() {
        Session session = (Session) getEntityManager().getDelegate();
        return session.createQuery("SELECT raca FROM Raca raca", Raca.class).list();
    }
}

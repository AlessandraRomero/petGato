/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petgato.manterAnimal.repository;

import com.petgato.manterAnimal.model.Animal;
import com.petgato.padrao.repository.AdapterRepository;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author alessandra
 */
public class AnimalRepository extends AdapterRepository<Animal, Long>{
    
    @Override
    public List<Animal> findAll() {
        Session session = (Session) getEntityManager().getDelegate();
        return session.createQuery("SELECT animal FROM Animal animal", Animal.class).list();
    }
}

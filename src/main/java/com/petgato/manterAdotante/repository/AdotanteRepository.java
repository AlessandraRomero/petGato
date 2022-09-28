/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petgato.manterAdotante.repository;

import com.petgato.manterAdotante.model.Adotante;
import com.petgato.padrao.repository.AdapterRepository;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author alessandra
 */
public class AdotanteRepository extends AdapterRepository<Adotante, Long> {
    
    @Override
    public List<Adotante> findAll() {
        Session session = (Session) getEntityManager().getDelegate();
        return session.createQuery("SELECT adotante FROM Adotante adotante", Adotante.class).list();
    }
}

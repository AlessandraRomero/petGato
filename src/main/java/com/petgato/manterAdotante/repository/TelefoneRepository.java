/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petgato.manterAdotante.repository;

import com.petgato.manterAdotante.model.Telefone;
import com.petgato.padrao.repository.AdapterRepository;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author alessandra
 */
public class TelefoneRepository extends AdapterRepository<Telefone, Long> {
    
    @Override
    public List<Telefone> findAll() {
        Session session = (Session) getEntityManager().getDelegate();
        return session.createQuery("SELECT tel FROM Telefone tel", Telefone.class).list();
    }
}

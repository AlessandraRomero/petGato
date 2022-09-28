/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petgato.manterLogradouro.repository;

import com.petgato.manterLogradouro.model.Logradouro;
import com.petgato.padrao.repository.AdapterRepository;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author alessandra
 */
public class LogradouroRepository extends AdapterRepository<Logradouro, Long> {

    @Override
    public List<Logradouro> findAll() {
        Session session = (Session) getEntityManager().getDelegate();
        return session.createQuery("SELECT log FROM Logradouro log", Logradouro.class).list();
    }
}

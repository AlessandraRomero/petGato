/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petgato.manterProntuario.repository;

import com.petgato.manterProntuario.model.Produto;
import com.petgato.manterProntuario.model.Prontuario;
import com.petgato.padrao.repository.AdapterRepository;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author alessandra
 */
public class ProntuarioRepository extends AdapterRepository<Prontuario, Long> {


    @Override
    public List<Prontuario> findAll() {
        Session session = (Session) getEntityManager().getDelegate();
        return session.createQuery("SELECT pront FROM Prontuario pront", Prontuario.class).list();
    }
}

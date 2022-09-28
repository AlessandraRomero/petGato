/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petgato.manterCidade.repository;

import com.petgato.manterCidade.model.Cidade;
import com.petgato.padrao.repository.AdapterRepository;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author alessandra
 */
public class CidadeRepository extends AdapterRepository<Cidade, Long> {

    @Override
    public List<Cidade> findAll() {
        Session session = (Session) getEntityManager().getDelegate();
        return session.createQuery("SELECT cidade FROM Cidade cidade", Cidade.class).list();
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petgato.manterProntuario.repository;

import com.petgato.manterLogradouro.model.Logradouro;
import com.petgato.manterProntuario.model.GrupoProduto;
import com.petgato.padrao.repository.AdapterRepository;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author alessandra
 */
public class GrupoProdutoRepository extends AdapterRepository<GrupoProduto, Long> {

    @Override
    public List<GrupoProduto> findAll() {
        Session session = (Session) getEntityManager().getDelegate();
        return session.createQuery("SELECT grup FROM GrupoProduto grup", GrupoProduto.class).list();
    }
}

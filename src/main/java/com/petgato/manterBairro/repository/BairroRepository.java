/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petgato.manterBairro.repository;

import com.petgato.manterBairro.model.Bairro;
import com.petgato.manterCidade.model.Cidade;
import com.petgato.padrao.repository.AdapterRepository;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author alessandra
 */
public class BairroRepository extends AdapterRepository<Bairro, Long>{
    
    @Override
    public List<Bairro> findAll() {
        Session session = (Session) getEntityManager().getDelegate();
        return session.createQuery("SELECT bairro FROM Bairro bairro", Bairro.class).list();
    }
}

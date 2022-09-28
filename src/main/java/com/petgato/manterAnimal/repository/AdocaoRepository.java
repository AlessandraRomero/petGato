/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petgato.manterAnimal.repository;

import com.petgato.manterAnimal.model.Adocao;
import com.petgato.manterBairro.model.Bairro;
import com.petgato.padrao.repository.AdapterRepository;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author alessandra
 */
public class AdocaoRepository extends AdapterRepository<Adocao, Long>{
    
    @Override
    public List<Adocao> findAll() {
        Session session = (Session) getEntityManager().getDelegate();
        return session.createQuery("SELECT adocao FROM Adocao adocao", Adocao.class).list();
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petgato.manterProntuario.repository;

import com.petgato.manterProntuario.model.ItemAtendimento;
import com.petgato.padrao.repository.AdapterRepository;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author alessandra
 */
public class ItemAtendimentoRepository extends AdapterRepository<ItemAtendimento, Long> {

     @Override
    public List<ItemAtendimento> findAll() {
        Session session = (Session) getEntityManager().getDelegate();
        return session.createQuery("SELECT itemAtend FROM ItemAtendimento itemAtend", ItemAtendimento.class).list();
    }
    
     @Override
    public ItemAtendimento findById(Long value) {
        return getEntityManager().find(ItemAtendimento.class, value);
    }  
}

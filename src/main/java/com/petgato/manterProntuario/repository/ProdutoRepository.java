/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petgato.manterProntuario.repository;

import com.petgato.manterProntuario.model.Produto;
import com.petgato.padrao.repository.AdapterRepository;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author alessandra
 */
public class ProdutoRepository extends AdapterRepository<Produto, Long> {

     @Override
    public List<Produto> findAll() {
        Session session = (Session) getEntityManager().getDelegate();
        return session.createQuery("SELECT prod FROM Produto prod", Produto.class).list();
    }
    
    @Override
    public Produto findById(Long value) {
        return getEntityManager().find(Produto.class, value);
    }  
}

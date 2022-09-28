/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petgato.manterAdotante.repository;

import com.petgato.manterAdotante.model.Endereco;
import com.petgato.padrao.repository.AdapterRepository;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author alessandra
 */
public class EnderecoRepository extends AdapterRepository<Endereco, Long> {
    
    @Override
    public List<Endereco> findAll() {
        Session session = (Session) getEntityManager().getDelegate();
        return session.createQuery("SELECT end FROM Endereco end", Endereco.class).list();
    }
}

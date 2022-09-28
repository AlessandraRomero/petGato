/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petgato.manterProntuario.repository;


import com.petgato.manterProntuario.model.Atendimento;
import com.petgato.padrao.repository.AdapterRepository;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author alessandra
 */
public class AtendimentoRepository extends AdapterRepository<Atendimento, Long> {

    public List<Atendimento> findAll() {
        Session session = (Session) getEntityManager().getDelegate();
        return session.createQuery("SELECT atend FROM Atendimento atend", Atendimento.class).list();
    }
}

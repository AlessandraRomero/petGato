/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petgato.manterProntuario.repository;

import com.petgato.manterProntuario.model.Prontuario;
import com.petgato.padrao.repository.AdapterRepository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
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
    
     public List<Prontuario> findByNome(String value) {
        EntityManager em = getEntityManager();
        String condicao = "";
        List<Prontuario> prontuarios = null;
        boolean hasNome = value != null && !value.isBlank() && !value.isEmpty();
        if (hasNome) {
            condicao = "WHERE pront.nome LIKE ?1 ";
        }

        Query query = em.createQuery("SELECT pront FROM Prontuario pront " + condicao);
        if (hasNome) {
            prontuarios = query.setParameter(1, "%" + value + "%")
                    .getResultList();
        } else {
            prontuarios = query.getResultList();
        }
        close();
        return prontuarios;
    }
}

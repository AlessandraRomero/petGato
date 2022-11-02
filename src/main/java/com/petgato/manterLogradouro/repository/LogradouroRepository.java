/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petgato.manterLogradouro.repository;

import com.petgato.manterLogradouro.model.Logradouro;
import com.petgato.padrao.repository.AdapterRepository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author alessandra
 */
public class LogradouroRepository extends AdapterRepository<Logradouro, Long> {

     @Override
    public List<Logradouro> findAll() {
        List<Logradouro> logs = getEntityManager().createQuery("SELECT log FROM Logradouro log", Logradouro.class).getResultList();
        super.close();
        return  logs;
    }

    @Override
    public Logradouro findById(Long value) {
        Logradouro log =  getEntityManager().find(Logradouro.class, value);
        return log;
    }

    public List<Logradouro> findByNome(String value) {
        EntityManager em = getEntityManager();
        String condicao = "";
        List<Logradouro> logs = null;
        boolean hasNome = value != null && !value.isBlank() && !value.isEmpty();
        if (hasNome) {
            condicao = "WHERE log.nome LIKE ?1 ";
        }

        Query query = em.createQuery("SELECT log FROM Logradouro log " + condicao);
        if (hasNome) {
            logs = query.setParameter(1, "%" + value + "%")
                    .getResultList();
        } else {
            logs = query.getResultList();
        }
        close();
        return logs;
    }
}

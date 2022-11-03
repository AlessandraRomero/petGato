/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petgato.manterAnimal.repository;

import com.petgato.manterAnimal.model.Especie;
import com.petgato.padrao.repository.AdapterRepository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author alessandra
 */
public class EspecieRepository extends AdapterRepository<Especie, Long> {

    @Override
    public List<Especie> findAll() {
        List<Especie> esps = getEntityManager().createQuery("SELECT esp FROM Especie esp", Especie.class).getResultList();
        super.close();
        return esps;
    }

    @Override
    public Especie findById(Long value) {
        Especie esp = getEntityManager().find(Especie.class, value);
        return esp;
    }

    public List<Especie> findByNome(String value) {
        EntityManager em = getEntityManager();
        String condicao = "";
        List<Especie> esps = null;
        boolean hasNome = value != null && !value.isBlank() && !value.isEmpty();
        if (hasNome) {
            condicao = "WHERE esp.nome LIKE ?1 ";
        }

        Query query = em.createQuery("SELECT esp FROM Especie esp " + condicao);
        if (hasNome) {
            esps = query.setParameter(1, "%" + value + "%")
                    .getResultList();
        } else {
            esps = query.getResultList();
        }
        close();
        return esps;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petgato.manterAnimal.repository;

import com.petgato.manterAnimal.model.Raca;
import com.petgato.padrao.repository.AdapterRepository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author alessandra
 */
public class RacaRepository extends AdapterRepository<Raca, Long> {

    @Override
    public List<Raca> findAll() {
        List<Raca> racas = getEntityManager().createQuery("SELECT raca FROM Raca raca", Raca.class).getResultList();
        super.close();
        return racas;
    }

    @Override
    public Raca findById(Long value) {
        Raca raca = getEntityManager().find(Raca.class, value);
        return raca;
    }

    public List<Raca> findByNome(String value) {
        EntityManager em = getEntityManager();
        String condicao = "";
        List<Raca> racas = null;
        boolean hasNome = value != null && !value.isBlank() && !value.isEmpty();
        if (hasNome) {
            condicao = "WHERE raca.nome LIKE ?1 ";
        }

        Query query = em.createQuery("SELECT raca FROM Raca raca " + condicao);
        if (hasNome) {
            racas = query.setParameter(1, "%" + value + "%")
                    .getResultList();
        } else {
            racas = query.getResultList();
        }
        close();
        return racas;
    }
}

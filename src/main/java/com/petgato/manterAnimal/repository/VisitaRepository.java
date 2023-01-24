/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petgato.manterAnimal.repository;

import com.petgato.manterAnimal.model.Visita;
import com.petgato.padrao.repository.AdapterRepository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author alessandra
 */
public class VisitaRepository extends AdapterRepository<Visita, Long>{
    
    @Override
    public List<Visita> findAll() {
        List<Visita> visitas = getEntityManager().createQuery("SELECT visita FROM Visita visita", Visita.class).getResultList();
        super.close();
        return visitas;
    }

    @Override
    public Visita findById(Long value) {
        Visita visita = getEntityManager().find(Visita.class, value);
        return visita;
    }

    public List<Visita> findByNome(String value) {
        EntityManager em = getEntityManager();
        String condicao = "";
        List<Visita> visita = null;
        boolean hasNome = value != null && !value.isBlank() && !value.isEmpty();
        if (hasNome) {
            condicao = "WHERE esp.nome LIKE ?1 ";
        }

        Query query = em.createQuery("SELECT visita FROM Visita visita " + condicao);
        if (hasNome) {
            visita = query.setParameter(1, "%" + value + "%")
                    .getResultList();
        } else {
            visita = query.getResultList();
        }
        close();
        return visita;
    }
}

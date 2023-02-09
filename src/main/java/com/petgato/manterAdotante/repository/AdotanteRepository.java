/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petgato.manterAdotante.repository;

import com.petgato.manterAdotante.model.Adotante;
import com.petgato.padrao.repository.AdapterRepository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author alessandra
 */
public class AdotanteRepository extends AdapterRepository<Adotante, Long> {
    
     @Override
    public List<Adotante> findAll() {
        List<Adotante> adotantes = getEntityManager()
                .createQuery("SELECT adotante FROM Adotante adotante", Adotante.class)
                .getResultList();
        super.close();
        return  adotantes;
    }

    @Override
    public Adotante findById(Long value) {
        Adotante adotante =  getEntityManager().find(Adotante.class, value);
        return adotante;
    }

    public List<Adotante> findByNome(String value) {
        EntityManager em = getEntityManager();
        String condicao = "";
        List<Adotante> adotantes = null;
        boolean hasNome = value != null && !value.isBlank() && !value.isEmpty();
        if (hasNome) {
            condicao = "WHERE adotante.nome LIKE ?1 ";
        }

        Query query = em.createQuery("SELECT adotante FROM Adotante adotante " + condicao);
        if (hasNome) {
            adotantes = query.setParameter(1, "%" + value + "%")
                    .getResultList();
        } else {
            adotantes = query.getResultList();
        }
        close();
        return adotantes;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petgato.manterAdotante.criteriaBuilder;

import static com.petgato.configuracao.EntityManagerUtil.getEntityManager;
import com.petgato.manterAdotante.model.Adotante;
import com.petgato.manterBairro.model.Bairro;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author alessandra
 */
public class AdotanteCriteriaBuilder {

    EntityManager em = getEntityManager();

    public List<Adotante> findBy(String nome, Bairro bairro) {

        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Adotante> query = builder.createQuery(Adotante.class);
        Root<Adotante> root = query.from(Adotante.class);

        List<Predicate> predicates = new ArrayList();       
        
        if (nome != null) {
            Predicate p = builder.equal(root.get("nome"), nome);
            predicates.add(p);
        }

        if (bairro != null) {
            Join<Adotante, Bairro> especieJoin = root.join("bairro", JoinType.INNER);            
            Predicate p = builder.equal(especieJoin.get("id"), bairro.getId());
            predicates.add(p);
        }
        query.select(root);
        query.where(builder.and(predicates.toArray(new Predicate[]{})));
        
        TypedQuery<Adotante> typedQuery = em.createQuery(query);
        return typedQuery.getResultList();
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petgato.manterAnimal.criteriaBuilder;

import static com.petgato.configuracao.EntityManagerUtil.getEntityManager;
import com.petgato.manterAnimal.model.Animal;
import com.petgato.manterAnimal.model.Especie;
import java.time.LocalDate;
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
public class AnimalCriteriaBuilder {

    EntityManager em = getEntityManager();

    public List<Animal> findBy(String nome, LocalDate dataResgate, Especie especie) {

        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Animal> query = builder.createQuery(Animal.class);
        Root<Animal> root = query.from(Animal.class);

        List<Predicate> predicates = new ArrayList();       
        
        if (nome != null) {
            Predicate p = builder.equal(root.get("nome"), nome);
            predicates.add(p);
        }

        if (dataResgate != null) {
            Predicate p = builder.equal(root.get("dataResgate"), dataResgate);
            predicates.add(p);
        }

        if (especie != null) {
            Join<Animal, Especie> especieJoin = root.join("especie", JoinType.INNER);            
            Predicate p = builder.equal(especieJoin.get("id"), especie.getId());
            predicates.add(p);
        }
        query.select(root);
        query.where(builder.and(predicates.toArray(new Predicate[]{})));
        
        TypedQuery<Animal> typedQuery = em.createQuery(query);
        return typedQuery.getResultList();
    }
}

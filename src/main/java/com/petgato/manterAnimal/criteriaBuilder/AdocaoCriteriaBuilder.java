/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petgato.manterAnimal.criteriaBuilder;

import static com.petgato.configuracao.EntityManagerUtil.getEntityManager;
import com.petgato.manterAdotante.model.Adotante;
import com.petgato.manterAnimal.model.Adocao;
import com.petgato.manterUsuario.model.Usuario;
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
public class AdocaoCriteriaBuilder {

    EntityManager em = getEntityManager();

    public List<Adocao> findBy(LocalDate inicio, LocalDate fim, Adotante adotante, Usuario atendente) {

        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Adocao> query = builder.createQuery(Adocao.class);
        Root<Adocao> root = query.from(Adocao.class);

        List<Predicate> predicates = new ArrayList();

        if (inicio != null && fim != null) {
            Predicate onStart = builder.greaterThanOrEqualTo(root.get("dataEmissao"), inicio);
            Predicate onEnd = builder.lessThanOrEqualTo(root.get("dataEmissao"), fim);
            predicates.add(onStart);
            predicates.add(onEnd);

        }
        if (adotante != null) {
            Join<Adocao, Adotante> especieJoin = root.join("adotante", JoinType.INNER);
            Predicate p = builder.equal(especieJoin.get("id"), adotante.getId());
            predicates.add(p);
        }

        if (atendente != null) {
            Join<Adocao, Usuario> especieJoin = root.join("atendente", JoinType.INNER);
            Predicate p = builder.equal(especieJoin.get("id"), atendente.getId());
            predicates.add(p);
        }

        query.select(root);
        query.where(builder.and(predicates.toArray(new Predicate[]{})));

        TypedQuery<Adocao> typedQuery = em.createQuery(query);
        return typedQuery.getResultList();
    }
}

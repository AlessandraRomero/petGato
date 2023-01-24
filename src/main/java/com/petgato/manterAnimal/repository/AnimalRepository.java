/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petgato.manterAnimal.repository;

import com.petgato.manterAnimal.model.Animal;
import com.petgato.padrao.repository.AdapterRepository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author alessandra
 */
public class AnimalRepository extends AdapterRepository<Animal, Long> {

    @Override
    public List<Animal> findAll() {
        List<Animal> animais = getEntityManager().createQuery("SELECT animal FROM Animal animal", Animal.class).getResultList();
        super.close();
        return animais;
    }

    @Override
    public Animal findById(Long value) {
        Animal animal = getEntityManager().find(Animal.class, value);
        return animal;
    }

    public List<Animal> findByNome(String value) {
        EntityManager em = getEntityManager();
        String condicao = "";
        List<Animal> animais = null;
        boolean hasNome = value != null && !value.isBlank() && !value.isEmpty();
        if (hasNome) {
            condicao = "WHERE animal.nome LIKE ?1 ";
        }

        Query query = em.createQuery("SELECT animal FROM Animal animal " + condicao);
        if (hasNome) {
            animais = query.setParameter(1, "%" + value + "%")
                    .getResultList();
        } else {
            animais = query.getResultList();
        }
        close();
        return animais;
    }
}

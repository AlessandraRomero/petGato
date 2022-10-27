/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.petgato.padrao.repository;

import java.util.List;

/**
 *
 * @author alessandra
 */
public interface Repository<T, K> {
    
    void save(T value);
    void update(T value);
    void delete(T value);
    List<T> findAll();
    T findById(K value);
    T findByName(K value);
}

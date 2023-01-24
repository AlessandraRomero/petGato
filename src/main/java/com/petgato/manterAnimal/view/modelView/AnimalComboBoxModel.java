/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petgato.manterAnimal.view.modelView;

import com.petgato.manterAnimal.model.Animal;
import com.petgato.manterAnimal.repository.AnimalRepository;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author alessandra
 */
public class AnimalComboBoxModel extends AbstractListModel<Animal> implements ComboBoxModel<Animal>{
    
    private AnimalRepository repository;
    private List<Animal> lista = new ArrayList();
    private Animal selecionado;

    public AnimalComboBoxModel() {
        repository = new AnimalRepository();
        refresh();
    }
     
    public void refresh(){
        int index = 0;
        lista = repository.findAll();
        
        setSelectedItem(null);
        fireIntervalAdded(this, 0, index);
    }
    
    @Override
    public int getSize() {
        return lista.size();
    }

    @Override
    public Animal getElementAt(int i) {
       return lista.get(i);
    }

    @Override
    public void setSelectedItem(Object o) {
        selecionado = (Animal) o;
    }

    @Override
    public Object getSelectedItem() {
        return selecionado;
    }    
}

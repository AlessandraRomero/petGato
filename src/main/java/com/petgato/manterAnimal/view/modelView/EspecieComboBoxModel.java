/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petgato.manterAnimal.view.modelView;

import com.petgato.manterAnimal.model.Especie;
import com.petgato.manterAnimal.repository.EspecieRepository;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author alessandra
 */
public class EspecieComboBoxModel extends AbstractListModel<Especie> implements ComboBoxModel<Especie>{
    
    private EspecieRepository repository;
    private List<Especie> lista = new ArrayList();
    private Especie selecionado;

    public EspecieComboBoxModel() {
        repository = new EspecieRepository();
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
    public Especie getElementAt(int i) {
       return lista.get(i);
    }

    @Override
    public void setSelectedItem(Object o) {
        selecionado = (Especie) o;
    }

    @Override
    public Object getSelectedItem() {
        return selecionado;
    }    
}

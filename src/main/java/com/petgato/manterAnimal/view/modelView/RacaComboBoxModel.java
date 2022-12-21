/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petgato.manterAnimal.view.modelView;

import com.petgato.manterAnimal.model.Raca;
import com.petgato.manterAnimal.repository.RacaRepository;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author alessandra
 */
public class RacaComboBoxModel extends AbstractListModel<Raca> implements ComboBoxModel<Raca>{
    
    private RacaRepository repository;
    private List<Raca> lista = new ArrayList();
    private Raca selecionado;

    public RacaComboBoxModel() {
        repository = new RacaRepository();
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
    public Raca getElementAt(int i) {
       return lista.get(i);
    }

    @Override
    public void setSelectedItem(Object o) {
        selecionado = (Raca) o;
    }

    @Override
    public Object getSelectedItem() {
        return selecionado;
    }    
}

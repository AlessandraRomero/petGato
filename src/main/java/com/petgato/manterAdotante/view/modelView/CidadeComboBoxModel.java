/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petgato.manterAdotante.view.modelView;

import com.petgato.manterCidade.model.Cidade;
import com.petgato.manterCidade.repository.CidadeRepository;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author alessandra
 */
public class CidadeComboBoxModel extends AbstractListModel<Cidade> implements ComboBoxModel<Cidade>{

    private CidadeRepository repository;
    private List<Cidade> lista  = new ArrayList();
    private Cidade selecionado;

    public CidadeComboBoxModel() {
        repository = new CidadeRepository();
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
    public Cidade getElementAt(int i) {
       return lista.get(i);
    }

    @Override
    public void setSelectedItem(Object o) {
        selecionado = (Cidade) o;
    }

    @Override
    public Object getSelectedItem() {
        return selecionado;
    }    
}

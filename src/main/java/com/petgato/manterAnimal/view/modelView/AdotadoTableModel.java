/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petgato.manterAnimal.view.modelView;

import com.petgato.manterAnimal.model.Adotado;
import com.petgato.padrao.componentsModel.PetGatoTableModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alessandra
 */
public class AdotadoTableModel extends PetGatoTableModel{
    
    private String colunas[] = {"id", "Nome", "Data Adoção", "Adotado?"};
    private List<Adotado> lista= new ArrayList();

    public AdotadoTableModel() {
 
    }
    
    public void setLista(List<Adotado> lista){
        this.lista = lista;
    }
    
    public void adicionar(Adotado adotado){
        lista.add(adotado);
        fireTableStructureChanged();
    }
    
     public void remover(Adotado adotado){
        lista.remove(adotado);
        fireTableStructureChanged();
    }

    @Override
    public void atualizar() {
           
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    @Override
    public Object getValueAt(int row, int column) {
        Adotado log = lista.get(row);
        switch (column) {
            case 0:
                return log.getId();
            case 1:
                return log.getAdocao();
            case 2:
            default:
                return null;
        }
    }
}

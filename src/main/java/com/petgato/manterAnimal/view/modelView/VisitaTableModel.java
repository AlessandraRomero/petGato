/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petgato.manterAnimal.view.modelView;

import com.petgato.manterAnimal.model.Adotado;
import com.petgato.manterAnimal.model.Visita;
import com.petgato.padrao.componentsModel.PetGatoTableModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alessandra
 */
public class VisitaTableModel extends PetGatoTableModel{
    
    private String colunas[] = {"id", "Data Visita", "Observação", "Status"};
    private List<Visita> lista= new ArrayList();

    public VisitaTableModel() {
 
    }
    
    public void setLista(List<Visita> lista){
        this.lista = lista;
    }
    
    public void adicionar(Visita visita){
        lista.add(visita);
        fireTableStructureChanged();
    }
    
     public void remover(Visita visita){
        lista.remove(visita);
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
        Visita visita = lista.get(row);
        switch (column) {
            case 0:
                return visita.getId();
            case 1:
                return visita.getDataVisita();
            case 2:
                return visita.getObservacao();
            case 3:
                return visita.getStatus();
            default:
                return null;
        }
    }
}

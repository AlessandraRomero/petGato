/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petgato.manterAnimal.view.modelView;

import com.petgato.manterAnimal.model.Adocao;
import com.petgato.manterAnimal.model.Adotado;
import com.petgato.padrao.componentsModel.PetGatoTableModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alessandra
 */
public class AdocaoTableModel extends PetGatoTableModel{
    
    private String colunas[] = {"id", "DT Emissão", "Adotante", "Atendente", "Status"};
    private List<Adocao> lista= new ArrayList();

    public AdocaoTableModel() {
 
    }
    
    public void setLista(List<Adocao> lista){
        this.lista = lista;
    }
    
    public void adicionar(Adocao adocao){
        lista.add(adocao);
        fireTableStructureChanged();
    }
    
     public void remover(Adocao adocao){
        lista.remove(adocao);
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
        Adocao adocao = lista.get(row);
        switch (column) {
            case 0:
                return adocao.getId();
            case 1:
                return adocao.getDataEmissao();
            case 2:
                return adocao.getAdotante().getNome();
            case 3:
                return adocao.getAtendente().getNome();
            case 4:
                return adocao.getStatus();
            default:
                return null;
        }
    }
}

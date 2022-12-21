/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petgato.manterCidade.view.modelView;

import com.petgato.manterCidade.model.Cidade;
import com.petgato.manterCidade.repository.CidadeRepository;
import com.petgato.padrao.componentsModel.PetGatoTableModel;
import java.util.List;

/**
 *
 * @author alessandra
 */
public class CidadeTableModel extends PetGatoTableModel {
   
    private String colunas[] = {"id", "Cidade", "uf"};
    private List<Cidade> lista;
    private CidadeRepository repository;
    
     public CidadeTableModel() {
        repository = new CidadeRepository();

        this.lista = repository.findAll();
    }
    
     public void atualizar(){
       atualizar(null);
    }
    
    public void atualizar(String nome){
        lista.clear();
        lista.addAll(repository.findByNome(nome));
        fireTableStructureChanged();
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
        Cidade cidade = lista.get(row);

        switch (column) {
            case 0:
                return cidade.getId();

            case 1:
                return cidade.getNome();
                
            case 2: 
                return cidade.getUf();
                
            default:
                return null;
        }
    }
}

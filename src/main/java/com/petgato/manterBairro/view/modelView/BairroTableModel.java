/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petgato.manterBairro.view.modelView;

import com.petgato.manterBairro.model.Bairro;
import com.petgato.manterBairro.repository.BairroRepository;
import com.petgato.padrao.componentsModel.PetGatoTableModel;
import java.util.List;

/**
 *
 * @author alessandra
 */
public class BairroTableModel extends PetGatoTableModel{
    
     private String colunas[] = {"id", "nome"};
    private List<Bairro> lista;
    private BairroRepository repository;
    
    public BairroTableModel() {
        repository = new BairroRepository();

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
        Bairro bairro = lista.get(row);

        switch (column) {
            case 0:
                return bairro.getId();

            case 1:
                return bairro.getNome();
            default:
                return null;
        }
    }
}

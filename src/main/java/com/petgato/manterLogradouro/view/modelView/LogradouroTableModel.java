/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petgato.manterLogradouro.view.modelView;

import com.petgato.manterLogradouro.model.Logradouro;
import com.petgato.manterLogradouro.repository.LogradouroRepository;
import com.petgato.padrao.componentsModel.PetGatoTableModel;
import java.util.List;

/**
 *
 * @author alessandra
 */
public class LogradouroTableModel extends PetGatoTableModel{
    
    private String colunas[] = {"id", "nome"};
    private List<Logradouro> lista;
    private LogradouroRepository repository;
    
    public LogradouroTableModel() {
        repository = new LogradouroRepository();

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
        Logradouro log = lista.get(row);

        switch (column) {
            case 0:
                return log.getId();

            case 1:
                return log.getNome();
            default:
                return null;
        }
    }
}

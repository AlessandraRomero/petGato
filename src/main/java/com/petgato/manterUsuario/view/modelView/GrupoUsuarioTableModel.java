/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petgato.manterUsuario.view.modelView;

import com.petgato.manterUsuario.model.GrupoUsuario;
import com.petgato.manterUsuario.repository.GrupoUsuarioRepository;
import com.petgato.padrao.componentsModel.PetGatoTableModel;
import java.util.List;

/**
 *
 * @author alessandra
 */
public class GrupoUsuarioTableModel extends PetGatoTableModel {

    private String colunas[] = {"id", "nome"};
    private List<GrupoUsuario> lista;
    private GrupoUsuarioRepository repository;

    public GrupoUsuarioTableModel() {
        repository = new GrupoUsuarioRepository();

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
        GrupoUsuario grupoUsuario = lista.get(row);

        switch (column) {
            case 0:
                return grupoUsuario.getId();

            case 1:
                return grupoUsuario.getNome();
            default:
                return null;
        }
    }
}

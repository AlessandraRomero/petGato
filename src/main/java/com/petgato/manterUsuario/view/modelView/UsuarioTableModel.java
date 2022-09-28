/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petgato.manterUsuario.view.modelView;
import com.petgato.manterUsuario.model.Usuario;
import com.petgato.manterUsuario.repository.UsuarioRepository;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author alessandra
 */
public class UsuarioTableModel extends AbstractTableModel {

    private String colunas[] = {"id", "username", "senha", "bloqueado", "situacao"};
    private List<Usuario> lista;
    private UsuarioRepository repository;

    public UsuarioTableModel() {
        repository = new UsuarioRepository();

        this.lista = repository.findAll();
    }

    public void atualizar() {
        lista.clear();
        lista.addAll(repository.findAll());
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

        Usuario usuario = lista.get(row);

        switch (column) {
            case 0:
                return usuario.getId();

            case 1:
                return usuario.getNome();
            default:
                return null;
        }
    }
}

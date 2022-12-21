/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petgato.manterUsuario.view.modelView;

import com.petgato.manterUsuario.model.GrupoUsuario;
import com.petgato.manterUsuario.model.Usuario;
import com.petgato.manterUsuario.repository.UsuarioRepository;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author alessandra
 */
public class UsuarioTableModel extends AbstractTableModel {

    private String colunas[] = {"id", "Nome", "Sobrenome", "Nascimento", "Email", "Username", "Grupo Usuário", "Bloqueado",};
    private List<Usuario> lista;
    private UsuarioRepository repository;

    public UsuarioTableModel() {
        repository = new UsuarioRepository();

        this.lista = repository.findAll();
    }

    public void atualizar() {
        atualizar(null);
    }

    public void atualizar(String nome) {
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
            case 2:
                return usuario.getSobrenome();
            case 3:
                return usuario.getIdade();
            case 4:
                return usuario.getEmail();
            case 5:
                return usuario.getUsername();
            case 6:
                return usuario.getGrupoUsuario().getNome();
            case 7:
                return usuario.isBloqueado() ? "Sim": "Não";
            default:
                return null;
        }
    }
}

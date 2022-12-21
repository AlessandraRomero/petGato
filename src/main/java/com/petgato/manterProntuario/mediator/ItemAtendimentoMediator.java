/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petgato.manterProntuario.mediator;

import com.petgato.manterProntuario.controller.ItemAtendimentoController;
import com.petgato.manterProntuario.model.ItemAtendimento;
import com.petgato.manterProntuario.view.modelView.ItemAtendimentoTableModel;
import com.petgato.padrao.mediator.AbstractMediator;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author alessandra
 */
public class ItemAtendimentoMediator extends AbstractMediator{
    
    private JTextField txtId;
    private JTextField txtQuantidade;
    private JTextField txtBuscar;
    private ItemAtendimentoController controle;
    private ItemAtendimentoTableModel model; 
    
      public ItemAtendimentoMediator registerTxtId(JTextField txtId) {
        this.txtId = txtId;
        return this;
    }

    public ItemAtendimentoMediator registerTxtQuantidade(JTextField txtQuantidade) {
        this.txtQuantidade = txtQuantidade;
        return this;
    }

    public ItemAtendimentoMediator registerTxtBuscar(JTextField txtBuscar) {
        this.txtBuscar = txtBuscar;
        return this;
    }

    public ItemAtendimentoMediator registerController(ItemAtendimentoController controle) {
        this.controle = controle;
        return this;
    }

    public ItemAtendimentoMediator registerGrupoUsuarioTableModel(ItemAtendimentoTableModel model) {
        this.model = model;
        return this;
    }
    
    private Long getIdGrupoFromTable() {
        int linha = tabela.getSelectedRow();

        if (linha >= 0) {
            return (Long) model.getValueAt(linha, 0);
        }
        JOptionPane.showMessageDialog(null, "Para realizar a operação você deve selecionar uma linha da tabela",
                "Aviso", JOptionPane.WARNING_MESSAGE);
        return null;
    }

    private ItemAtendimento getGrupo() {
        Long id = getIdGrupoFromTable();

        if (id != null) {
            return controle.buscarPorId(id);
        }
        return null;
    }

    public void alterar() {
        ItemAtendimento item = getGrupo();

        if (item != null) {
            txtId.setText(item.getId().toString());
            txtQuantidade.setText(String.valueOf(item.getQuantidade()));
            tab.setSelectedIndex(1);
        }
    }

    public void limpar() {
        txtId.setText("");
        txtQuantidade.setText("");
    }

    public void novo() {
        tab.setSelectedIndex(1);
        limpar();
    }

    public void excluir() {
        Long id = getIdGrupoFromTable();
        if (id != null) {
            controle.deletar(id);
            model.atualizar();
            JOptionPane.showMessageDialog(null, "Exclusão realizada", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private boolean isCampoTextoValido(JTextField campo) {
        return !(campo.getText().isEmpty() || campo.getText().isBlank());
    }

    public void gravar() {
        boolean idValido = isCampoTextoValido(txtId);
        if (isCampoTextoValido(txtQuantidade)) {
            if (idValido) {
                controle.atualizar(Long.parseLong(txtId.getText()), Integer.parseInt(txtQuantidade.getText()));
            } else {
                controle.cadastrar(Integer.parseInt(txtQuantidade.getText()));
            }
            limpar();
            model.atualizar();
            tab.setSelectedIndex(0);
        } else {
            JOptionPane.showMessageDialog(null, "Campo nome não deve ser vazio", "aviso", JOptionPane.WARNING_MESSAGE);
            txtQuantidade.requestFocusInWindow();
        }
    }
    
    public void buscar(){
        model.atualizar(txtBuscar.getText());
    }

    public void cancelar() {
        limpar();
        tab.setSelectedIndex(0);
    }     
}

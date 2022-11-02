/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petgato.manterProntuario.mediator;

import com.petgato.manterProntuario.controller.ProdutoController;
import com.petgato.manterProntuario.model.Produto;
import com.petgato.manterProntuario.view.modelView.ProdutoTableModel;
import com.petgato.padrao.mediator.AbstractMediator;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author alessandra
 */
public class ProdutoMediator extends AbstractMediator{

   private  JTextField txtId;
    private JTextField txtNome;
    private JTextField txtBuscar;
    private ProdutoController controle;
    private ProdutoTableModel model; 
    
      public ProdutoMediator registerTxtId(JTextField txtId) {
        this.txtId = txtId;
        return this;
    }

    public ProdutoMediator registerTxtNome(JTextField txtNome) {
        this.txtNome = txtNome;
        return this;
    }

    public ProdutoMediator registerTxtBuscar(JTextField txtBuscar) {
        this.txtBuscar = txtBuscar;
        return this;
    }

    public ProdutoMediator registerController(ProdutoController controle) {
        this.controle = controle;
        return this;
    }

    public ProdutoMediator registerGrupoUsuarioTableModel(ProdutoTableModel model) {
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

    private Produto getGrupo() {
        Long id = getIdGrupoFromTable();

        if (id != null) {
            return controle.buscarPorId(id);
        }
        return null;
    }

    public void alterar() {
        Produto grupo = getGrupo();

        if (grupo != null) {
            txtId.setText(grupo.getId().toString());
            txtNome.setText(grupo.getNome());
            tab.setSelectedIndex(1);
        }
    }

    public void limpar() {
        txtId.setText("");
        txtNome.setText("");
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
        if (isCampoTextoValido(txtNome)) {
            if (idValido) {
                controle.atualizar(Long.parseLong(txtId.getText()), txtNome.getText());
            } else {
                controle.cadastrar(txtNome.getText());
            }
            limpar();
            model.atualizar();
            tab.setSelectedIndex(0);
        } else {
            JOptionPane.showMessageDialog(null, "Campo nome não deve ser vazio", "aviso", JOptionPane.WARNING_MESSAGE);
            txtNome.requestFocusInWindow();
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

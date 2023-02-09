/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petgato.manterCidade.mediator;

import com.petgato.manterCidade.controller.CidadeController;
import com.petgato.manterCidade.model.Cidade;
import com.petgato.manterCidade.view.modelView.CidadeTableModel;
import com.petgato.padrao.mediator.AbstractMediator;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author alessandra
 */
public class CidadeMediator extends AbstractMediator{
    
    private JTextField txtId;
    private JTextField txtNome;
    private JTextField txtUf;
    private JTextField txtBuscar;
    private CidadeController controle;
    private CidadeTableModel model;
    
     public CidadeMediator  registerTxtId(JTextField txtId) {
        this.txtId = txtId;
        return this;
    }

    public CidadeMediator registerTxtNome(JTextField txtNome) {
        this.txtNome = txtNome;
        return this;
    }
    
    public CidadeMediator registerTxtUf(JTextField txtUf) {
        this.txtUf = txtUf;
        return this;
    }

    public CidadeMediator registerTxtBuscar(JTextField txtBuscar) {
        this.txtBuscar = txtBuscar;
        return this;
    }

    public CidadeMediator registerController(CidadeController controle) {
        this.controle = controle;
        return this;
    }

    public CidadeMediator registerGrupoUsuarioTableModel(CidadeTableModel model) {
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

    private Cidade getGrupo() {
        Long id = getIdGrupoFromTable();

        if (id != null) {
            return controle.buscarPorId(id);
        }
        return null;
    }

    public void alterar() {
        Cidade cidade = getGrupo();

        if (cidade != null) {
            txtId.setText(cidade.getId().toString());
            txtNome.setText(cidade.getNome());
            txtUf.setText(cidade.getUf());
            tab.setSelectedIndex(1);
        }
    }

    public void limpar() {
        txtId.setText("");
        txtNome.setText("");
        txtUf.setText("");
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
                controle.atualizar(Long.parseLong(txtId.getText()), txtNome.getText(), txtUf.getText());
            } else {
                controle.cadastrar(txtNome.getText(), txtUf.getText());
            }
            limpar();
            model.atualizar();
            tab.setSelectedIndex(0);
        } else {
            JOptionPane.showMessageDialog(null, "Campo não deve ser vazio", "aviso", JOptionPane.WARNING_MESSAGE);
            txtNome.requestFocusInWindow();
            txtUf.requestFocusInWindow();
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

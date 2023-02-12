/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petgato.manterUsuario.mediator;

import com.petgato.manterUsuario.controller.UsuarioController;
import com.petgato.manterUsuario.model.GrupoUsuario;
import com.petgato.manterUsuario.model.Usuario;
import com.petgato.manterUsuario.view.modelView.UsuarioTableModel;
import com.petgato.padrao.mediator.AbstractMediator;
import com.toedter.calendar.JDateChooser;
import java.time.ZoneId;
import java.util.Date;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author alessandra
 */
public class UsuarioMediator extends AbstractMediator {

    private JTextField txtId;
    private JTextField txtNome;
    private JTextField txtSobrenome;
    private JDateChooser jDateChooserNascimento;
    private JTextField txtEmail;
    private JTextField txtUsuario;
    private JTextField txtSenha;
    private JTextField txtBuscar;
    private JComboBox comboBoxGU;
    private JCheckBox jCheckBoxBloqueado;
    private UsuarioController controle;
    private UsuarioTableModel model;

    public UsuarioMediator registerjCheckBoxBloqueado(JCheckBox jCheckBoxBloqueado) {
        this.jCheckBoxBloqueado = jCheckBoxBloqueado;
        return this;
    }

    public UsuarioMediator registerTxtSobrenome(JTextField txtSobrenome) {
        this.txtSobrenome = txtSobrenome;
        return this;
    }

    public UsuarioMediator registerTxtIdade(JDateChooser jDateChooserNascimento) {
        this.jDateChooserNascimento = jDateChooserNascimento;
        return this;
    }

    public UsuarioMediator registerTxtEmail(JTextField txtEmail) {
        this.txtEmail = txtEmail;
        return this;
    }

    public UsuarioMediator registerTxtUsuario(JTextField txtUsuario) {
        this.txtUsuario = txtUsuario;
        return this;
    }

    public UsuarioMediator registerTxtSenha(JTextField txtSenha) {
        this.txtSenha = txtSenha;
        return this;
    }

    public UsuarioMediator registerJComboBoxGU(JComboBox comboBoxGU) {
        this.comboBoxGU = comboBoxGU;
        return this;
    }

    public UsuarioMediator registerTxtId(JTextField txtId) {
        this.txtId = txtId;
        return this;
    }

    public UsuarioMediator registerTxtNome(JTextField txtNome) {
        this.txtNome = txtNome;
        return this;
    }

    public UsuarioMediator registerTxtBuscar(JTextField txtBuscar) {
        this.txtBuscar = txtBuscar;
        return this;
    }

    public UsuarioMediator registerController(UsuarioController controle) {
        this.controle = controle;
        return this;
    }

    public UsuarioMediator registerUsuarioTableModel(UsuarioTableModel model) {
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

    private Usuario getGrupo() {
        Long id = getIdGrupoFromTable();

        if (id != null) {
            return controle.buscarPorId(id);
        }
        return null;
    }

    public void alterar() {
        Usuario usuario = getGrupo();

        if (usuario != null) {
            txtId.setText(usuario.getId().toString());
            txtSobrenome.setText(usuario.getSobrenome());
            txtNome.setText(usuario.getNome());
            jDateChooserNascimento.setDate(Date.from(usuario.getIdade().atStartOfDay(ZoneId.systemDefault()).toInstant()));
            txtEmail.setText(usuario.getEmail());
            txtUsuario.setText(usuario.getUsername());
            txtSenha.setText(usuario.getSenha());
            comboBoxGU.setSelectedItem(usuario.getGrupoUsuario());
            jCheckBoxBloqueado.setSelected(usuario.isBloqueado());

            tab.setSelectedIndex(1);
        }
    }

    public void limpar() {
        txtId.setText("");
        txtNome.setText("");
        txtSobrenome.setText("");
        jDateChooserNascimento.setDate(null);
        txtEmail.setText("");
        txtUsuario.setText("");
        txtSenha.setText("");
        comboBoxGU.setSelectedItem(null);
        jCheckBoxBloqueado.setSelected(false);
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
                controle.atualizar(Long.parseLong(txtId.getText()), txtNome.getText(), txtSobrenome.getText(),
                        jDateChooserNascimento.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
                        txtEmail.getText(), txtUsuario.getText(), txtSenha.getText(), jCheckBoxBloqueado.isSelected(), (GrupoUsuario) comboBoxGU.getSelectedItem());
            } else {
                controle.cadastrar(txtNome.getText(), txtSobrenome.getText(),
                        jDateChooserNascimento.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
                        txtEmail.getText(), txtUsuario.getText(), txtSenha.getText(), jCheckBoxBloqueado.isSelected(), (GrupoUsuario) comboBoxGU.getSelectedItem());
            }
            limpar();
            model.atualizar();
            tab.setSelectedIndex(0);
        } else {
            JOptionPane.showMessageDialog(null, "Campo " +txtNome+ " não deve ser vazio", "aviso", JOptionPane.WARNING_MESSAGE);
            txtNome.requestFocusInWindow();
        }
    }

    public void buscar() {
        model.atualizar(txtBuscar.getText());
    }

    public void cancelar() {
        limpar();
        tab.setSelectedIndex(0);
    }
}

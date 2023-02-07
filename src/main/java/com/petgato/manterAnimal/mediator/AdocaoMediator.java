/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petgato.manterAnimal.mediator;

import com.petgato.manterAdotante.model.Adotante;
import com.petgato.manterAnimal.controller.AdocaoController;
import com.petgato.manterAnimal.model.Adocao;
import com.petgato.manterAnimal.model.enums.Status;
import com.petgato.manterAnimal.view.modelView.AdocaoTableModel;
import com.petgato.manterUsuario.model.Usuario;
import com.petgato.padrao.mediator.AbstractMediator;
import com.toedter.calendar.JDateChooser;
import java.time.ZoneId;
import java.time.LocalDate;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author alessandra
 */
public class AdocaoMediator extends AbstractMediator {

    private JTextField txtId;
    private JDateChooser jDateDataEmissao;
    private JComboBox comboBoxAdotante;
    private JComboBox comboBoxAdotado;
    private JComboBox comboBoxAtendende;
    private JTextField txtStatus;
    private JDateChooser jDateDataVisita;
    private JComboBox comboBoxSituacao;
    private JTextField txtObservacao;
    private JDateChooser jDateDataAdocao;

    private AdocaoController controle;
    private AdocaoTableModel model;

    private VisitaMediator visitaMediator = new VisitaMediator();
    private AdotadoMediator adotadoMediator = new AdotadoMediator();

    public AdocaoMediator registerVisitaMediator(VisitaMediator visitaMediator) {
        this.visitaMediator = visitaMediator;
        return this;
    }

    public AdocaoMediator registerAdotadoMediator(AdotadoMediator adotadoMediator) {
        this.adotadoMediator = adotadoMediator;
        return this;
    }

    public AdocaoMediator registerTxtId(JTextField txtId) {
        this.txtId = txtId;
        return this;
    }

    public AdocaoMediator registerJDateDataEmissao(JDateChooser jDateDataEmissao) {
        this.jDateDataEmissao = jDateDataEmissao;
        return this;
    }

    public AdocaoMediator registerComboBoxAdotante(JComboBox comboBoxAdotante) {
        this.comboBoxAdotante = comboBoxAdotante;
        return this;
    }

    public AdocaoMediator registerComboBoxAdotado(JComboBox comboBoxAdotado) {
        this.comboBoxAdotado = comboBoxAdotado;
        return this;
    }

    public AdocaoMediator registerComboBoxAtendente(JComboBox comboBoxAtendende) {
        this.comboBoxAtendende = comboBoxAtendende;
        return this;
    }

    public AdocaoMediator registerTxtStatus(JTextField txtStatus) {
        this.txtStatus = txtStatus;
        return this;
    }

    public AdocaoMediator registerJDateDataVisita(JDateChooser jDateDataVisita) {
        this.jDateDataVisita = jDateDataVisita;
        return this;
    }

    public AdocaoMediator registerComboBoxSituacao(JComboBox comboBoxSituacao) {
        this.comboBoxSituacao = comboBoxSituacao;
        return this;
    }

    public AdocaoMediator registerTxtJDateDataAdocao(JDateChooser jDateDataAdocao) {
        this.jDateDataAdocao = jDateDataAdocao;
        return this;
    }

    public AdocaoMediator registerAdocaoController(AdocaoController controle) {
        this.controle = controle;
        return this;
    }

    private Long getIdAdocaoFromTable() {
        int linha = tabela.getSelectedRow();

        if (linha >= 0) {
            return (Long) model.getValueAt(linha, 0);
        }
        JOptionPane.showMessageDialog(null, "Para realizar a operação você deve selecionar uma linha da tabela",
                "Aviso", JOptionPane.WARNING_MESSAGE);
        return null;
    }

    private Adocao getAdocao() {
        Long id = getIdAdocaoFromTable();
        if (id != null) {
            return controle.buscarPorId(id);
        }
        return null;
    }

    public void alterar() {
        Adocao adocoes = getAdocao();

        if (adocoes != null) {
            visitaMediator.registerAdocao(adocoes);
            txtId.setText(adocoes.getId().toString());
            comboBoxAtendende.setSelectedItem(adocoes.getAtendente());
            txtStatus.setText(adocoes.getStatus().toString());
            comboBoxAdotante.setSelectedItem(adocoes.getAdotante());
            comboBoxAdotado.setSelectedItem(adocoes.getAdotados());
            visitaMediator.carregarDados(adocoes.getVisitas());
            adotadoMediator.carregarDados(adocoes.getAdotados());
            tab.setSelectedIndex(1);
        }
    }

    public void limpar() {
        txtId.setText("");
        comboBoxAtendende.setSelectedItem(null);
        comboBoxAdotante.setSelectedItem(null);
        comboBoxAdotado.setSelectedItem(null);

    }

    public void novo() {
        tab.setSelectedIndex(1);
        limpar();
        visitaMediator.registerAdocao(new Adocao.AdocaoBuilder().build());
    }

    public void excluir() {
        Long id = getIdAdocaoFromTable();
        if (id != null) {
            controle.deletar(id);
            model.atualizar();
            JOptionPane.showMessageDialog(null, "Exclusão realizada",
                    "Confirmação", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private boolean isCampoTextoValido(JTextField campo) {
        return !(campo.getText().isEmpty() || campo.getText().isBlank());
    }

    private boolean isCamposValidos() {
        return comboBoxAtendende.getSelectedItem() != null && comboBoxAdotante.getSelectedItem() != null;
    }

    public void gravar() {
        boolean idValido = isCampoTextoValido(txtId);
        if (isCamposValidos()) {
            if (idValido) {
                controle.atualizar(
                        Long.parseLong(txtId.getText()),
                        jDateDataEmissao.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
                        isCampoTextoValido(txtStatus) ? Status.valueOf(txtStatus.getText()) : Status.PENDENTE,
                        (Adotante) comboBoxAdotante.getSelectedItem(),
                        (Usuario) comboBoxAtendende.getSelectedItem(),
                        adotadoMediator.getDados(),
                        visitaMediator.getDados()
                );

            } else {
                controle.cadastrar(LocalDate.now(ZoneId.systemDefault()),
                        isCampoTextoValido(txtStatus) ? Status.valueOf(txtStatus.getText()) : Status.PENDENTE,
                        (Adotante) comboBoxAdotante.getSelectedItem(),
                        (Usuario) comboBoxAtendende.getSelectedItem(),
                        adotadoMediator.getDados(),
                        visitaMediator.getDados());
            }
            limpar();
            model.atualizar();
            tab.setSelectedIndex(0);
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum campo deve ser vazio", "aviso", JOptionPane.WARNING_MESSAGE);

        }
    }

    public void buscar() {
   
    }

    public void cancelar() {
        limpar();
        tab.setSelectedIndex(0);
    }
}

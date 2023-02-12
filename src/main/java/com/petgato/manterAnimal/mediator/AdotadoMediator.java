/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petgato.manterAnimal.mediator;

import com.petgato.manterAnimal.model.Adocao;
import com.petgato.manterAnimal.model.Adotado;
import com.petgato.manterAnimal.model.AdotadoId;
import com.petgato.manterAnimal.model.Animal;
import com.petgato.manterAnimal.view.modelView.AdotadoTableModel;
import com.petgato.padrao.mediator.AbstractMediator;
import com.toedter.calendar.JDateChooser;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author alessandra
 */
public class AdotadoMediator extends AbstractMediator {

    private JTextField txtIdAdotado;
    private JDateChooser jDataAdocao;
    private Adocao adocao;
    private JComboBox comboBoxAnimal;
    private JRadioButton jRadioButtonS;
    private JRadioButton jRadioButtonN;
    private JRadioButton jRadioButtonAnalise;
    private JTable tabelaAdotado;

    private AdotadoTableModel model;

    public AdotadoMediator registerTabelaAdotado(JTable tabelaAdotado) {
        this.tabelaAdotado = tabelaAdotado;
        return this;
    }

    public AdotadoMediator registerTxtIdAdotado(JTextField txtIdAdotado) {
        this.txtIdAdotado = txtIdAdotado;
        return this;
    }

    public AdotadoMediator registerjDataAdocao(JDateChooser jDataAdocao) {
        this.jDataAdocao = jDataAdocao;
        return this;
    }

    public AdotadoMediator registerAdocao(Adocao adocao) {
        this.adocao = adocao;
        return this;
    }

    public AdotadoMediator registerComboBoxAdotado(JComboBox comboBoxAnimal) {
        this.comboBoxAnimal = comboBoxAnimal;
        return this;
    }

    public AdotadoMediator registerJRadioButtonS(JRadioButton jRadioButtonS) {
        this.jRadioButtonS = jRadioButtonS;
        return this;
    }

    public AdotadoMediator registerJRadioButtonN(JRadioButton jRadioButtonN) {
        this.jRadioButtonN = jRadioButtonN;
        return this;
    }

    public AdotadoMediator registerJRadioButtonAnalise(JRadioButton jRadioButtonAnalise) {
        this.jRadioButtonAnalise = jRadioButtonAnalise;
        return this;
    }

//    public VisitaMediator registerTxtBuscar(JTextField txtBuscar) {
//        this.txtBuscar = txtBuscar;
//        return this;
//    }
    public AdotadoMediator registerAdotadoTableModel(AdotadoTableModel model) {
        this.model = model;
        return this;
    }

    private Long getIdAdotadoFromTable() {
        int linha = tabelaAdotado.getSelectedRow();

        if (linha >= 0) {
            return (Long) model.getValueAt(linha, 0);
        }
        JOptionPane.showMessageDialog(null, "Para realizar a operação você deve selecionar uma linha da tabela",
                "Aviso", JOptionPane.WARNING_MESSAGE);
        return null;
    }

    private Adotado getAdotado() {
        Long id = getIdAdotadoFromTable();

        if (id != null) {
            return null;
        }
        return null;
    }

    public List<Adotado> getDados() {
        return model.getAdotados();
    }

    public void carregarDados(List<Adotado> lista) {
        model.setLista(lista);
    }

    public void alterar() {
        Adotado adotado = getAdotado();

        if (adotado != null) {
            txtIdAdotado.setText(adotado.getId().toString());
            if (adotado.getIsAdotado() != null) {
                jRadioButtonAnalise.setSelected(true);

            } else if (adotado.isAdotado()) {
                jRadioButtonS.setSelected(true);
            } else {
                jRadioButtonN.setSelected(true);
            }
//            jDataAdocao.setDate(Date.from(adotado.getDataAdocao().atStartOfDay(ZoneId.systemDefault()).toInstant()));
            comboBoxAnimal.setSelectedItem(adotado.getAnimal());
        }
    }

    public void limpar() {
        txtIdAdotado.setText("");
        comboBoxAnimal.setSelectedItem(null);
        jRadioButtonAnalise.setSelected(true);
    }

    public void novo() {
        tab.setSelectedIndex(1);
        limpar();
    }

    public void excluir() {
        int linhaAdotado = tabelaAdotado.getSelectedRow();
        Adotado adotado = model.getValue(linhaAdotado);
        if (adotado != null) {
            model.remover(adotado);
            model.atualizar();
            JOptionPane.showMessageDialog(null, "Exclusão realizada", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private boolean isCampoTextoValido(JTextField campo) {
        return !(campo.getText().isEmpty() || campo.getText().isBlank());
    }

    public void gravar() {
        boolean idValido = txtIdAdotado.getText().matches("\\d+");
        AdotadoId adotadoId = new AdotadoId(adocao.proximaSequenciaAdotado(), null);
        if (!idValido) {

            Adotado adotado = new Adotado.AdotadoBuilder()
                    .withDataAdocao(LocalDate.now(ZoneId.systemDefault()))
                    .withAnimal((Animal) comboBoxAnimal.getSelectedItem())
                    .withIsAdotado(
                            (jRadioButtonAnalise.isSelected() ? null : jRadioButtonS.isSelected())
                    )
                    .withId(adotadoId)
                    .build();

            limpar();
            model.adicionar(adotado);
        } else {
            int linhaAdotado = tabelaAdotado.getSelectedRow();
            Adotado adotado = model.getValue(linhaAdotado);
            adotado.setAnimal((Animal) comboBoxAnimal.getSelectedItem());
            adotado.setAdotado(
                    (jRadioButtonAnalise.isSelected() ? null : jRadioButtonS.isSelected())
            );
            adotado.setId(adotadoId);
        }
        model.fireTableStructureChanged();
    }

    public void buscar() {

    }

    public void cancelar() {
        limpar();
        tab.setSelectedIndex(0);
    }
}

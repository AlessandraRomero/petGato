/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petgato.manterAnimal.mediator;

import com.petgato.manterAnimal.controller.AnimalController;
import com.petgato.manterAnimal.criteriaBuilder.AnimalCriteriaBuilder;
import com.petgato.manterAnimal.model.Animal;
import com.petgato.manterAnimal.model.Especie;
import com.petgato.manterAnimal.model.Raca;
import com.petgato.manterAnimal.view.modelView.AnimalTableModel;
import com.petgato.padrao.mediator.AbstractMediator;
import com.toedter.calendar.JDateChooser;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author alessandra
 */
public class AnimalMediator extends AbstractMediator {

    private JTextField txtId;
    private JTextField txtNome;
    private JTextField txtIdade;
    private JTextField txtSexo;
    private JTextField txtPeso;
    private JDateChooser jDateDataResgate;
    private JDateChooser jDateDataResgateBuscar;
    private JTextField txtBuscar;
    private JComboBox comboBoxRaca;
    private JComboBox comboBoxEspecie;
    private AnimalController controle;
    private AnimalTableModel model;
    private List<Animal> resultados;

    public AnimalMediator registerTxtId(JTextField txtId) {
        this.txtId = txtId;
        return this;
    }

    public AnimalMediator registerTxtNome(JTextField txtNome) {
        this.txtNome = txtNome;
        return this;
    }

    public AnimalMediator registerTxtIdade(JTextField txtIdade) {
        this.txtIdade = txtIdade;
        return this;
    }

    public AnimalMediator registerTxtSexo(JTextField txtSexo) {
        this.txtSexo = txtSexo;
        return this;
    }

    public AnimalMediator registerTxtPeso(JTextField txtPeso) {
        this.txtPeso = txtPeso;
        return this;
    }

    public AnimalMediator registerJDateDataResgate(JDateChooser jDateDataResgate) {
        this.jDateDataResgate = jDateDataResgate;
        return this;
    }

    public AnimalMediator registerJDateDataResgateBuscar(JDateChooser jDateDataResgateBuscar) {
        this.jDateDataResgateBuscar = jDateDataResgateBuscar;
        return this;
    }

    public AnimalMediator registerComboBoxRaca(JComboBox comboBoxRaca) {
        this.comboBoxRaca = comboBoxRaca;
        return this;
    }

    public AnimalMediator registerComboBoxEspecie(JComboBox comboBoxEspecie) {
        this.comboBoxEspecie = comboBoxEspecie;
        return this;
    }

    public AnimalMediator registerTxtBuscar(JTextField txtBuscar) {
        this.txtBuscar = txtBuscar;
        return this;
    }

    public AnimalMediator registerController(AnimalController controle) {
        this.controle = controle;
        return this;
    }

    public AnimalMediator registerAnimalTableModel(AnimalTableModel model) {
        this.model = model;
        return this;
    }

    private Long getIdAnimalFromTable() {
        int linha = tabela.getSelectedRow();

        if (linha >= 0) {
            return (Long) model.getValueAt(linha, 0);
        }
        JOptionPane.showMessageDialog(null, "Para realizar a operação você deve selecionar uma linha da tabela",
                "Aviso", JOptionPane.WARNING_MESSAGE);
        return null;
    }

    private Animal getAnimal() {
        Long id = getIdAnimalFromTable();
        if (id != null) {
            return controle.buscarPorId(id);
        }
        return null;
    }

    public void alterar() {
        Animal animais = getAnimal();

        if (animais != null) {
            txtId.setText(animais.getId().toString());
            txtNome.setText(animais.getNome());
            txtIdade.setText(String.valueOf(animais.getIdade()));
            txtSexo.setText(animais.getSexo());
            txtPeso.setText(String.valueOf(animais.getPeso()));
            if (animais.getDataResgate() != null) {
                jDateDataResgate.setDate(Date.from(animais.getDataResgate().atStartOfDay(ZoneId.systemDefault()).toInstant()));
            }
            comboBoxRaca.setSelectedItem(animais.getRaca());
            comboBoxEspecie.setSelectedItem(animais.getEspecie());
            tab.setSelectedIndex(1);
        }
    }

    public void limpar() {
        txtId.setText("");
        txtNome.setText("");
        txtIdade.setText("");
        txtSexo.setText("");
        txtPeso.setText("");
        jDateDataResgate.setDate(null);
        comboBoxRaca.setSelectedItem(null);
        comboBoxEspecie.setSelectedItem(null);
        jDateDataResgateBuscar.setDate(null);
    }

    public void novo() {
        tab.setSelectedIndex(1);
        limpar();
    }

    public void excluir() {
        Long id = getIdAnimalFromTable();
        if (id != null) {
            int resposta = JOptionPane.showConfirmDialog(null, "Deseja excluir esse registro?",
                    "Confirmação", JOptionPane.YES_OPTION);
            if (resposta == JOptionPane.YES_OPTION) {
                controle.deletar(id);
                model.atualizar();
                JOptionPane.showMessageDialog(null, "Excluído com sucesso!",
                        "Confirmação", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    private boolean isCampoTextoValido(JTextField campo) {
        return !(campo.getText().isEmpty() || campo.getText().isBlank());
    }

    private boolean isCamposValidos() {
        return comboBoxRaca.getSelectedItem() != null && comboBoxEspecie.getSelectedItem() != null;
    }

    public void gravar() {
        boolean idValido = isCampoTextoValido(txtId);
        if (isCampoTextoValido(txtNome) && isCampoTextoValido(txtIdade)
                && isCampoTextoValido(txtSexo) && isCampoTextoValido(txtPeso)
                && jDateDataResgate.getDate() != null && comboBoxRaca.getSelectedItem() != null && comboBoxEspecie.getSelectedItem() != null) {
            if (idValido) {
                controle.atualizar(Long.parseLong(txtId.getText()), txtNome.getText(),
                        Float.parseFloat(txtIdade.getText()),
                        txtSexo.getText(), Float.parseFloat(txtPeso.getText()),
                        jDateDataResgate.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
                        (Raca) comboBoxRaca.getSelectedItem(), (Especie) comboBoxEspecie.getSelectedItem());
            } else {
                controle.cadastrar(txtNome.getText(), Float.parseFloat(txtIdade.getText()),
                        txtSexo.getText(), Float.parseFloat(txtPeso.getText()),
                        jDateDataResgate.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
                        (Raca) comboBoxRaca.getSelectedItem(), (Especie) comboBoxEspecie.getSelectedItem());
            }
            limpar();
            model.atualizar();
            tab.setSelectedIndex(0);
        } else {
            if (txtNome.getText().isEmpty() || txtNome.getText().isBlank()) {
                JOptionPane.showMessageDialog(null, "Campo Nome deve ser preenchido", "aviso", JOptionPane.WARNING_MESSAGE);
                txtNome.requestFocusInWindow();
            } else if (txtIdade.getText().isEmpty() || txtIdade.getText().isBlank()) {
                JOptionPane.showMessageDialog(null, "Campo Idade deve ser preenchido", "aviso", JOptionPane.WARNING_MESSAGE);
                txtIdade.requestFocusInWindow();
            } else if (txtPeso.getText().isEmpty() || txtPeso.getText().isBlank()) {
                JOptionPane.showMessageDialog(null, "Campo Peso deve ser preenchido", "aviso", JOptionPane.WARNING_MESSAGE);
                txtPeso.requestFocusInWindow();
            } else if (txtSexo.getText().isEmpty() || txtSexo.getText().isBlank()) {
                JOptionPane.showMessageDialog(null, "Campo Sexo deve ser preenchido", "aviso", JOptionPane.WARNING_MESSAGE);
                txtSexo.requestFocusInWindow();
            } else if (comboBoxEspecie.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(null, "Campo Espécie deve ser selecionado", "aviso", JOptionPane.WARNING_MESSAGE);
                comboBoxEspecie.requestFocusInWindow();
            } else if ((comboBoxRaca.getSelectedItem() == null)) {
                JOptionPane.showMessageDialog(null, "Campo Raça deve ser selecionado", "aviso", JOptionPane.WARNING_MESSAGE);
                comboBoxRaca.requestFocusInWindow();
            } else if (jDateDataResgate.getDate() == null) {
                JOptionPane.showMessageDialog(null, "Campo Data Resgate deve ser selecionado", "aviso", JOptionPane.WARNING_MESSAGE);
                jDateDataResgate.requestFocusInWindow();
            }
        }
    }

    public void buscar() {
        String nome = null;
        Especie especie = null;
        LocalDate dataResgateBuscar = null;

        if (txtBuscar.getText().isBlank() == false && txtBuscar.getText().isEmpty() == false) {
            nome = txtBuscar.getText();
        }
        if (comboBoxEspecie.getSelectedItem() != null) {
            especie = (Especie) comboBoxEspecie.getSelectedItem();
        }
        if (jDateDataResgateBuscar.getDate() != null) {
            dataResgateBuscar = jDateDataResgateBuscar.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        }
        AnimalCriteriaBuilder builder = new AnimalCriteriaBuilder();
        this.resultados = builder.findBy(nome, dataResgateBuscar, especie);

        limpar();
        model.atualizar(this.resultados);

    }

    public void cancelar() {
        limpar();
        tab.setSelectedIndex(0);
    }

    public void gerarPDF() throws FileNotFoundException, JRException {
        InputStream input = null;
        try {
            JRBeanCollectionDataSource itemsJRBeam = new JRBeanCollectionDataSource(model.getLista());

            Map<String, Object> parameters = new HashMap();

            input = new FileInputStream(new File("/home/alessandra/NetBeansProjects/petGato/src/main/java/com/petgato/manterAnimal/relatorioAnimal/relatorio_animal.jrxml"));

            JasperDesign jasperDesign = JRXmlLoader.load(input);

            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, itemsJRBeam);

            // Abre o preview do jasper da pra salvar em pdf por ele
            JasperViewer.viewReport(jasperPrint);

            System.out.println("Generating PDF");

            // Exporta como PDF diretamente
            OutputStream outputStream = new FileOutputStream(new File("relatorio_animal.pdf"));
            JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(AnimalMediator.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                input.close();
            } catch (IOException ex) {
                Logger.getLogger(AnimalMediator.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

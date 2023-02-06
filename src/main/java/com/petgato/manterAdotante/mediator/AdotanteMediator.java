/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.petgato.manterAdotante.mediator;

import com.petgato.manterAdotante.controller.AdotanteController;
import com.petgato.manterAdotante.criteriaBuilder.AdotanteCriteriaBuilder;
import com.petgato.manterAdotante.model.Adotante;
import com.petgato.manterAdotante.view.modelView.AdotanteTableModel;
import com.petgato.manterBairro.model.Bairro;
import com.petgato.manterCidade.model.Cidade;
import com.petgato.manterLogradouro.model.Logradouro;
import com.petgato.padrao.mediator.AbstractMediator;
import com.toedter.calendar.JDateChooser;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
public class AdotanteMediator extends AbstractMediator {

    private JTextField txtId;
    private JTextField txtNome;
    private JTextField txtSobrenome;
    private JDateChooser jDateChooserNascimento;
    private JTextField txtEmail;
    private JTextField txtRg;
    private JTextField txtCpf;
    private JTextField txtTelefone;
    private JTextField txtReferencia;
    private JTextField txtComplemento;
    private JTextField txtNumero;
    private JTextField txtBuscar;
    private JComboBox comboBoxBairro;
    private JComboBox comboBoxBairroBuscar;
    private JComboBox comboBoxCidade;
    private JComboBox comboBoxLogradouro;
    private List<Adotante> resultados;

    private AdotanteController controle;
    private AdotanteTableModel model;

    public AdotanteMediator registerTxtSobrenome(JTextField txtSobrenome) {
        this.txtSobrenome = txtSobrenome;
        return this;
    }

    public AdotanteMediator registerTxtIdade(JDateChooser jDateChooserNascimento) {
        this.jDateChooserNascimento = jDateChooserNascimento;
        return this;
    }

    public AdotanteMediator registerTxtEmail(JTextField txtEmail) {
        this.txtEmail = txtEmail;
        return this;
    }

    public AdotanteMediator registerTxtRg(JTextField txtRg) {
        this.txtRg = txtRg;
        return this;
    }

    public AdotanteMediator registerTxtCpf(JTextField txtCpf) {
        this.txtCpf = txtCpf;
        return this;
    }

    public AdotanteMediator registerTxtId(JTextField txtId) {
        this.txtId = txtId;
        return this;
    }

    public AdotanteMediator registerTxtNome(JTextField txtNome) {
        this.txtNome = txtNome;
        return this;
    }

    public AdotanteMediator registerTxtNumero(JTextField txtNumero) {
        this.txtNumero = txtNumero;
        return this;
    }

    public AdotanteMediator registerTxtTelefone(JTextField txtTelefone) {
        this.txtTelefone = txtTelefone;
        return this;
    }

    public AdotanteMediator registerComboBoxCidade(JComboBox comboBoxCidade) {
        this.comboBoxCidade = comboBoxCidade;
        return this;
    }

    public AdotanteMediator registerComboBoxBairro(JComboBox comboBoxBairro) {
        this.comboBoxBairro = comboBoxBairro;
        return this;
    }

    public AdotanteMediator registerComboBoxBairroBuscar(JComboBox comboBoxBairroBuscar) {
        this.comboBoxBairroBuscar = comboBoxBairroBuscar;
        return this;
    }

    public AdotanteMediator registerComboBoxLogradouro(JComboBox comboBoxLogradouro) {
        this.comboBoxLogradouro = comboBoxLogradouro;
        return this;
    }

    public AdotanteMediator registerTxtReferencia(JTextField txtReferencia) {
        this.txtReferencia = txtReferencia;
        return this;
    }

    public AdotanteMediator registerTxtComplemento(JTextField txtComplemento) {
        this.txtComplemento = txtComplemento;
        return this;
    }

    public AdotanteMediator registerTxtBuscar(JTextField txtBuscar) {
        this.txtBuscar = txtBuscar;
        return this;
    }

    public AdotanteMediator registerController(AdotanteController controle) {
        this.controle = controle;
        return this;
    }

    public AdotanteMediator registerUsuarioTableModel(AdotanteTableModel model) {
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

    private Adotante getGrupo() {
        Long id = getIdGrupoFromTable();

        if (id != null) {
            return controle.buscarPorId(id);
        }
        return null;
    }

    public void alterar() {
        Adotante adotante = getGrupo();

        if (adotante != null) {
            txtId.setText(adotante.getId().toString());
            txtSobrenome.setText(adotante.getSobrenome());
            txtNome.setText(adotante.getNome());
            if (adotante.getIdade() != null) {
                jDateChooserNascimento.setDate(Date.from(adotante.getIdade().atStartOfDay(ZoneId.systemDefault()).toInstant()));
            }
            txtEmail.setText(adotante.getEmail());
            txtRg.setText(adotante.getRg());
            txtCpf.setText(adotante.getCpf());
            txtTelefone.setText(adotante.getTelefone());
            txtReferencia.setText(adotante.getReferencia());
            txtComplemento.setText(adotante.getComplemento());
            txtNumero.setText(adotante.getNumero());
            comboBoxCidade.setSelectedItem(adotante.getCidade());
            comboBoxBairro.setSelectedItem(adotante.getBairro());
            comboBoxLogradouro.setSelectedItem(adotante.getLogradouro());
            tab.setSelectedIndex(1);
        }
    }

    public void limpar() {
        txtId.setText("");
        txtNome.setText("");
        txtSobrenome.setText("");
        jDateChooserNascimento.setDate(null);
        txtEmail.setText("");
        txtRg.setText("");
        txtCpf.setText("");
        txtTelefone.setText("");
        txtReferencia.setText("");
        txtComplemento.setText("");
        txtNumero.setText("");
        comboBoxCidade.setSelectedItem(null);
        comboBoxBairro.setSelectedItem(null);
        comboBoxLogradouro.setSelectedItem(null);
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
                        txtEmail.getText(), txtRg.getText(), txtCpf.getText(), txtTelefone.getText(),
                        txtReferencia.getText(), txtComplemento.getText(), txtNumero.getText(),
                        (Cidade) comboBoxCidade.getSelectedItem(), (Bairro) comboBoxBairro.getSelectedItem(),
                        (Logradouro) comboBoxLogradouro.getSelectedItem());
            } else {
                controle.cadastrar(txtNome.getText(), txtSobrenome.getText(),
                        jDateChooserNascimento.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(),
                        txtEmail.getText(), txtRg.getText(), txtCpf.getText(), txtTelefone.getText(),
                        txtReferencia.getText(), txtComplemento.getText(), txtNumero.getText(),
                        (Cidade) comboBoxCidade.getSelectedItem(), (Bairro) comboBoxBairro.getSelectedItem(),
                        (Logradouro) comboBoxLogradouro.getSelectedItem());
            }
            limpar();
            model.atualizar();
            tab.setSelectedIndex(0);
        } else {
            JOptionPane.showMessageDialog(null, "Campo não deve ser vazio", "aviso", JOptionPane.WARNING_MESSAGE);
            txtNome.requestFocusInWindow();
        }
    }

    public void buscar() {
        String nome = null;
        Bairro bairro = null;

        if (txtBuscar.getText().isBlank() == false && txtBuscar.getText().isEmpty() == false) {
            nome = txtBuscar.getText();
        }
        if (comboBoxBairro.getSelectedItem() != null) {
            bairro = (Bairro) comboBoxBairro.getSelectedItem();
        }
        AdotanteCriteriaBuilder builder = new AdotanteCriteriaBuilder();
        this.resultados = builder.findBy(nome, bairro);

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

            input = new FileInputStream(new File("/home/alessandra/NetBeansProjects/petGato/src/main/java/com/petgato/reports/relatorio_adotante.jrxml"));

            JasperDesign jasperDesign = JRXmlLoader.load(input);

            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, itemsJRBeam);

            // Abre o preview do jasper da pra salvar em pdf por ele
            JasperViewer.viewReport(jasperPrint);

            System.out.println("Generating PDF");

            // Exporta como PDF diretamente
            OutputStream outputStream = new FileOutputStream(new File("relatorio_adotante.pdf"));
            JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(AdotanteMediator.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                input.close();
            } catch (IOException ex) {
                Logger.getLogger(AdotanteMediator.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

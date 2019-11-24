/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uag.ufrpe.IU.controladores;

import br.uag.ufrpe.negocio.fachada.FachadaGerente;
import br.uag.ufrpe.negocio.entidades.Data;
import br.uag.ufrpe.negocio.NegocioOnibus;
import br.uag.ufrpe.negocio.NegocioPassageiro;
import br.uag.ufrpe.negocio.NegocioPassagem;
import br.uag.ufrpe.negocio.NegocioViagem;
import br.uag.ufrpe.negocio.excecoes.motorista.MotoristaNaoDisponivelException;
import br.uag.ufrpe.negocio.excecoes.onibus.OnibusNaoDisponivelException;
import br.uag.ufrpe.negocio.excecoes.onibus.OnibusNaoExisteException;
import br.uag.ufrpe.negocio.excecoes.viagem.ViagemJaExisteException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author Itamar Jr
 */
public class CadastroViagemController implements Initializable {

    private FachadaGerente fachadaGerente;

    @FXML
    private TextField txtPlacaOnibus;
    @FXML
    private TextField txtOrigem;
    @FXML
    private TextField txtDestino;
    @FXML
    private DatePicker dateSaida;
    @FXML
    private TextField txtHSaida;
    @FXML
    private DatePicker dateChegada;
    @FXML
    private TextField txtHChegada;

    @FXML
    private Label erroPlaca;
    @FXML
    private Label erroDatasHoras;
    @FXML
    private Label erroHoraSaida;
    @FXML
    private Label erroHoraChegada;

    public CadastroViagemController() {
        fachadaGerente = FachadaGerente.getFachadaGerente();
    }

    @FXML
    private void cadastrarViagem(ActionEvent event) {

        Alert alertaErro = new Alert(Alert.AlertType.ERROR);
        alertaErro.setTitle("Erro");
        alertaErro.setHeaderText("Erro ao preencher os dados");

        Alert alertaConfirmacao = new Alert(Alert.AlertType.CONFIRMATION);
        alertaConfirmacao.setTitle("Confirmação");
        alertaConfirmacao.setHeaderText("Confirmação ao cadastrar");

        boolean verifica = true;

        String placa = txtPlacaOnibus.getText();
        String origem = txtOrigem.getText();
        String destino = txtDestino.getText();
        String horarioSaida = txtHSaida.getText();
        String horarioChegada = txtHChegada.getText();

        String dataSaida = "";
        String dataChegada = "";
        String dataHoraChegada = null;
        String dataHoraSaida = null;

        if (placa.length() < 7) {
            erroPlaca.setText("Placa inválida");
            verifica = false;
        }

        //Checa a hora de Saida
        try {
            dataSaida = Data.converterDataParaString(dateSaida.getValue());
            dataHoraSaida = dataSaida + " " + horarioSaida;
            Data.converteStringEmDataHora(dataHoraSaida);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
            //Label hora saida
            erroHoraSaida.setText("Hora inválida");
            verifica = false;
        }

        //Checa a hora de chegada
        try {
            dataChegada = Data.converterDataParaString(dateChegada.getValue());
            dataHoraChegada = dataChegada + " " + horarioChegada;
            Data.converteStringEmDataHora(dataHoraChegada);

            if (!Data.verificaDataHoraSaidaDataHoraChegadaValida(dataHoraSaida, dataHoraChegada)) {
                erroDatasHoras.setText("Data de Chegada menor do que a data de Saída");
                verifica = false;
            }
        } catch (Exception ex) {
            //Label hora chegada
            System.out.println(ex.getMessage());
            ex.printStackTrace();
            erroHoraChegada.setText("Hora inválida");
            verifica = false;
        }

        if (verifica) {
            //Se entrar aqui, passou por todas as verificações, e vai tentar cadastrar.
            try {
                fachadaGerente.adicionarViagem(placa, origem, destino, horarioSaida, horarioChegada, dataSaida, dataChegada);
                alertaConfirmacao.setAlertType(Alert.AlertType.CONFIRMATION);
                alertaConfirmacao.setContentText("Viagem cadastrada com sucesso!");
                alertaConfirmacao.show();

            } catch (Exception ex) {
                ex.printStackTrace();
                alertaErro.setContentText(ex.getMessage());
                alertaErro.show();

            }

        } else {
            alertaErro.setContentText("Erro ao preencher os dados!");
            alertaErro.show();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}

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

    public CadastroViagemController() {
        fachadaGerente = new FachadaGerente();
    }

    @FXML
    private void cadastrarViagem(ActionEvent event) {
        boolean verifica = true;
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle("Erro");
        alerta.setHeaderText("Erro ao preencher os dados");

        String placa = txtPlacaOnibus.getText();
        String origem = txtOrigem.getText();
        String destino = txtDestino.getText();
        String horarioSaida = txtHSaida.getText();
        String horarioChegada = txtHChegada.getText();

        String dataSaida = "";
        String dataChegada = "";
        String dataHoraChegada = "";
        String dataHoraSaida = "";

        try { //Checa a hora
            dataSaida = Data.converterDataParaString(dateChegada.getValue());
            dataChegada = Data.converterDataParaString(dateChegada.getValue());

            dataHoraChegada = dataChegada + " " + horarioChegada;
            dataHoraSaida = dataSaida + " " + horarioSaida;

            Data.converteStringEmDataHora(dataHoraChegada);
            Data.converteStringEmDataHora(dataHoraSaida);
            
        } catch (Exception ex) {
            alerta.setContentText(ex.getMessage());
            alerta.show();
            verifica = false;
        }

        if (!Data.verificaDataHoraSaidaDataHoraChegadaValida(dataHoraSaida, dataHoraChegada)) {
            alerta.setContentText("Data de Saída menor do que a data de Chegada");
            alerta.show();
        } else if (verifica) {

            try {
                fachadaGerente.adicionarViagem(placa, origem, destino, horarioSaida, horarioChegada, dataSaida, dataChegada);
                alerta.setAlertType(Alert.AlertType.CONFIRMATION);
                alerta.setTitle("Confirmação");
                alerta.setHeaderText("Viagem Cadastrada");
                alerta.setContentText("Viagem cadastrada com sucesso!");
                alerta.show();

            } catch (Exception ex) {
                alerta.setContentText(ex.getMessage());
                alerta.show();

            }
            
        } 
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}

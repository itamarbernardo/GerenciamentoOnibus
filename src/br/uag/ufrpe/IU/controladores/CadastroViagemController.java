/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uag.ufrpe.IU.controladores;

import br.uag.ufrpe.fachada.FachadaGerente;
import br.uag.ufrpe.negocio.Data;
import br.uag.ufrpe.negocio.NegocioOnibus;
import br.uag.ufrpe.negocio.NegocioPassageiro;
import br.uag.ufrpe.negocio.NegocioPassagem;
import br.uag.ufrpe.negocio.NegocioViagem;
import br.uag.ufrpe.negocio.excecoes.MotoristaNaoDisponivelException;
import br.uag.ufrpe.negocio.excecoes.OnibusNaoDisponivelException;
import br.uag.ufrpe.negocio.excecoes.OnibusNaoExisteException;
import br.uag.ufrpe.negocio.excecoes.ViagemJaExisteException;
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

    public CadastroViagemController(){
        //Falta instanciar a fachada gerente!
    }
    
    @FXML
    private void cadastrarViagem(ActionEvent event) {
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
        String dataHoraChegada;
        String dataHoraSaida;

        try { //Checa a hora
            dataSaida = Data.converterDataParaString(dateChegada.getValue());
            dataChegada = Data.converterDataParaString(dateChegada.getValue());

            dataHoraChegada = dataChegada + " " + horarioChegada;
            dataHoraSaida = dataSaida + " " + horarioSaida;

            Data.converteStringEmDataHora(dataHoraChegada);
            Data.converteStringEmDataHora(dataHoraSaida);

        } catch (DateTimeParseException ex) {
            alerta.setContentText(ex.getMessage());
            alerta.show();
        }

        if (!Data.verificaDataInicioDataFimValida(dataSaida, dataChegada)) {
            alerta.setContentText("Data de Saída menor do que a data de Chegada");
            alerta.show();
        } else {

            try {
                fachadaGerente.adicionarViagem(placa, origem, destino, horarioSaida, horarioChegada, dataSaida, dataChegada);
                alerta.setAlertType(Alert.AlertType.CONFIRMATION);
                alerta.setTitle("Confirmação");
                alerta.setHeaderText("Viagem Cadastrada");
                alerta.setContentText("Viagem cadastrada com sucesso!");
                alerta.show();
                
            } catch (ViagemJaExisteException ex) {
                alerta.setContentText(ex.getMessage());
                alerta.show();

            } catch (MotoristaNaoDisponivelException ex) {
                alerta.setContentText(ex.getMessage());
                alerta.show();

            } catch (OnibusNaoDisponivelException ex) {
                alerta.setContentText(ex.getMessage());
                alerta.show();

            } catch (OnibusNaoExisteException ex) {
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

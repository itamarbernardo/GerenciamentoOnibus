package br.uag.ufrpe.negocio.entidades;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import java.util.Map;
import br.uag.ufrpe.negocio.entidades.Motorista;


/**
 * Essa classe representa os onibus que serão ofertados pela empresa de acordo
 * com motorita, a placa do carro, os tipos de poltronas e seus repectivos
 * assentos;
 *
 * @author Emily Santos;
 */
public class Onibus{

    private static int totalOnibus = 0;
    private Map<Integer, String> poltronas;
    private int totalPoltronas;
    private Motorista motorista;
    private String placa;

    /**
     *
     * @param motorista infoma od dados do respectivo motorista que irá conduzir
     * o ônibus;
     * @param placa informa a placa do ônibus;
     * @param totalPoltronas mostra o total de poltronas ofertados pelo onibus;
     * @param poltronasObeso informa uma lista com os valores das poltronas que
     * representam as de obeso;
     * @param poltronasTotalReclinavel mostra uma lista com os valores das
     * poltronas que representam poltronas totalmente reclináveis;
     * @param poltronasReclinavel representa uma lista de valores com as
     * poltronas que são parcialmente reclináveis;
     */
    public Onibus(Motorista motorista, String placa, int totalPoltronas, List<Integer> poltronasObeso, List<Integer> poltronasTotalReclinavel, List<Integer> poltronasReclinavel) {
        this.motorista = motorista;
        this.placa = placa;
        poltronas = new HashMap<>();
        this.totalPoltronas = totalPoltronas;
        poltronas = inicializaPoltronas(poltronasObeso, poltronasTotalReclinavel, poltronasReclinavel);
        totalOnibus++;
    }

    /**
     * Metodo para inicializar o HashMap poltronas com os valores de cada
     * poltrona especial;
     *
     * @param poltronasObeso mostra uma lista com o numero das poltronas de
     * obeso no onibus;
     * @param poltronasTotalReclinavel mostra uma lista com o numeros das
     * poltronas totalmente reclináveis dentro do ônibus
     * @param poltronasReclinavel informa uma lista com os numeros das poltronas
     * que são parcialmente reclinaveis;
     */
    public Map<Integer, String> inicializaPoltronas(List<Integer> poltronasObeso, List<Integer> poltronasTotalReclinavel, List<Integer> poltronasReclinavel) {
        Map<Integer, String> poltronas = new HashMap<>();
        
        for (int i = 1; i <= totalPoltronas; i++) {
            poltronas.put(i, "Convencional");
        }
        for (Integer poltronaObeso : poltronasObeso) {
            if (poltronas.containsKey(poltronaObeso)) {
                poltronas.put(poltronaObeso, "Obeso");
            }
        }
        for (Integer poltronaReclinavel : poltronasReclinavel) {
            if (poltronas.containsKey(poltronaReclinavel)) {
                poltronas.put(poltronaReclinavel, "Reclinavel");
            }
        }
        for (Integer poltronaTotalReclinavel : poltronasTotalReclinavel) {
            if (poltronas.containsKey(poltronaTotalReclinavel)) {
                poltronas.put(poltronaTotalReclinavel, "TotalReclinavel");
            }
        }
        return poltronas;
    }

    public Map<Integer, String> getPoltronas() {
        return poltronas;
    }

    public void setPoltronas(Map<Integer, String> poltronas) {
        this.poltronas = poltronas;
    }

    public int getTotalPoltronas() {
        return totalPoltronas;
    }

    public void setTotalPoltronas(int totalPoltronas) {
        this.totalPoltronas = totalPoltronas;
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;

    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }


    public int getQuantidadeAssentos() {
        return totalPoltronas;
    }

    public int getQuantidadeAssentosObeso() {
        int cont = 0;
        for (Map.Entry<Integer, String> quantidade : poltronas.entrySet()) {
            if (poltronas.containsValue("Obeso")) {
                cont++;
            }
        }
        return cont;
    }

    public int getQuantidadeAssentosReclinaveis() {
        int cont = 0;
        for (Map.Entry<Integer, String> quantidade : poltronas.entrySet()) {
            if (poltronas.containsValue("Reclinavel")) {
                cont++;
            }
        }
        return cont;
    }

    public int getQuantidadeAssentosTotalmenteReclinaveis() {
        int cont = 0;
        for (Map.Entry<Integer, String> quantidade : poltronas.entrySet()) {
            if (poltronas.containsValue("TotalReclinavel")) {
                cont++;
            }
        }
        return cont;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Onibus) {
            Onibus onibus = (Onibus) obj;
            if (placa.equals(onibus.getPlaca())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "ONIBUS { Motorista: " + motorista + " | Placa do ônibus: " + placa + " | Total de poltronas: " + totalPoltronas + " | Total poltronas para Obesos: " + getQuantidadeAssentosObeso() + " | Total poltronas Reclináveis: " + getQuantidadeAssentosReclinaveis() + " | Total poltronas totalmente reclináveis: " + getQuantidadeAssentosTotalmenteReclinaveis() + "}";
    }

}

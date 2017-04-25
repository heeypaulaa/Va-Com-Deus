package vacomdeus.modelo;

import vacomdeus.modelo.StatusVoo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Voo {
    /*estes dados são enviados via arquivo texto seguindo um padrao de dados em classe chamado Json*/
    private int numeroVoo;
    private String companhiaAerea;
    private String idAviao;
    private Date dataHorario;
    private StatusVoo statusVoo;/*confimado, cancelado e atrasado*/
    private String destino;
    private String origem;
    private Double carga;

    public Voo() {
        super();
    }

    public Voo(int numeroVoo, String companhiaAerea, String idAviao, Date dataHorario, StatusVoo statusVoo,
               String destino, String origem, Double carga) {
        this.numeroVoo = numeroVoo;
        this.companhiaAerea = companhiaAerea;
        this.idAviao = idAviao;
        this.dataHorario = dataHorario;
        this.statusVoo = statusVoo;
        this.destino = destino;
        this.origem = origem;
        this.carga = carga;
    }

    public int getNumeroVoo() {
        return numeroVoo;
    }

    public void setNumeroVoo(int numeroVoo) {
        this.numeroVoo = numeroVoo;
    }

    public String getCompanhiaAerea() {
        return companhiaAerea;
    }

    public void setCompanhiaAerea(String companhiaAerea) {
        this.companhiaAerea = companhiaAerea;
    }

    public String getidAviao() {
        return idAviao;
    }

    public void setidAviao(String idAviao) {
        this.idAviao = idAviao;
    }

    public Date getDataHorario() {
        return dataHorario;
    }

    public void setDataHorario(Date dataHorario) {
        this.dataHorario = dataHorario;
    }

    public StatusVoo getStatusVoo() {
        return statusVoo;
    }

    public void setStatusVoo(StatusVoo statusVoo) {
        this.statusVoo = statusVoo;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Double getCarga() {
        return carga;
    }

    public void setCarga(Double carga) {
        this.carga = carga;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        return "Número do Voo:" + numeroVoo + ",  Companhia Aérea: " + companhiaAerea + ",  ID Avião:" + idAviao
                + ",  Data e Horário:" + sdf.format(dataHorario) + ",  Status Voo:" + statusVoo + ",  Destino:"
                + destino + ",  Origem: " + origem + ",  Carga: " + carga;
    }


}
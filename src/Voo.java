import java.util.Date;

public class Voo {
    /*estes dados são enviados via arquivo texto seguindo um padrao de dados em classe chamado Json*/
    private int numeroVoo;
    private String companhiaAerea;
    private String idAviao;
    private Date data;
    private Date horarioVoo;
    private StatusVoo statusVoo;/*confimado, cancelado e atrasado*/
    private String destino;
    private String origem;


    public Voo() {

        super();
    }

    public Voo(int numeroVoo, String companhiaAerea, String idAviao, Date data, Date horarioVoo, StatusVoo statusVoo,
               String destino, String origem) {
        super();
        this.numeroVoo = numeroVoo;
        this.companhiaAerea = companhiaAerea;
        this.idAviao = idAviao;
        this.data = data;
        this.horarioVoo = horarioVoo;
        this.statusVoo = statusVoo;
        this.destino = destino;
        this.origem = origem;
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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getHorarioVoo() {
        return horarioVoo;
    }

    public void setHorarioVoo(Date horarioVoo) {
        this.horarioVoo = horarioVoo;
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

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    @Override
    public String toString() {
        return "Número do Voo: " + numeroVoo + "\tCompanhia Aérea: " + companhiaAerea + "\tAvião: " + idAviao
                + "\tData: " + data + "\tHorário do Voo=" + horarioVoo + "\tStatus Voo: " + statusVoo + "\tDestino: "
                + destino + "\tOrigem: " + origem;
    }


}
package vacomdeus.modelo;

public class Aviao {

    private Double autonomia;
    private Double altura;
    private Double tamanhoEnvergaduraAsa;
    private Double comprimento;
    final Double capacidadeCarga = 30.0;
    private int capacidadePassageiros;
    private String id;

    public Aviao(Double autonomia, Double altura, Double tamanhoEnvergaduraAsa, Double comprimento,
                 int capacidadePassageiros, String id) {
        super();
        this.autonomia = autonomia;
        this.altura = altura;
        this.tamanhoEnvergaduraAsa = tamanhoEnvergaduraAsa;
        this.comprimento = comprimento;
        this.capacidadePassageiros = capacidadePassageiros;
        this.id = id;
    }

    public Aviao() {
        super();
    }

    @Override
    public String toString() {
        return "Autonomia: " + autonomia + ", altura:" + altura + ", Tamanho Envergadura da Asa:"
                + tamanhoEnvergaduraAsa + ", comprimento:" + comprimento + ", Capacidade  de Carga:" + capacidadeCarga
                + ", Capacidade Passageiros: " + capacidadePassageiros + ", id:" + id;

    }

    public Double getAutonomia() {
        return autonomia;
    }

    public void setAutonomia(Double autonomia) {
        this.autonomia = autonomia;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Double getTamanhoEnvergaduraAsa() {
        return tamanhoEnvergaduraAsa;
    }

    public void setTamanhoEnvergaduraAsa(Double tamanhoEnvergaduraAsa) {
        this.tamanhoEnvergaduraAsa = tamanhoEnvergaduraAsa;
    }

    public Double getComprimento() {
        return comprimento;
    }

    public void setComprimento(Double comprimento) {
        this.comprimento = comprimento;
    }

    public int getCapacidadePassageiros() {
        return capacidadePassageiros;
    }

    public void setCapacidadePassageiros(int capacidadePassageiros) {
        this.capacidadePassageiros = capacidadePassageiros;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
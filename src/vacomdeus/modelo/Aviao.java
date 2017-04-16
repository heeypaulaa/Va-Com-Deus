package vacomdeus.modelo;

public class Aviao {

    private Double autonomia;
    private Double altura;
    private Double tamanhoEnvergaduraAsa;
    private Double comprimento;
    private Double capacidadeCarga;
    private int capacidadePassageiros;
    private String id;

    public Aviao(Double autonomia, Double altura, Double tamanhoEnvergaduraAsa, Double comprimento,
                 Double capacidadeCarga, int capacidadePassageiros, String id) {
        super();
        this.autonomia = autonomia;
        this.altura = altura;
        this.tamanhoEnvergaduraAsa = tamanhoEnvergaduraAsa;
        this.comprimento = comprimento;
        this.capacidadeCarga = capacidadeCarga;
        this.capacidadePassageiros = capacidadePassageiros;
        this.id = id;
    }

    public Aviao() {
        super();
    }

    @Override
    public String toString() {
        System.out.print(99);
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

    public Double getCapacidadeCarga() {
        return capacidadeCarga;
    }

    public void setCapacidadeCarga(Double capacidadeCarga) {
        this.capacidadeCarga = capacidadeCarga;
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
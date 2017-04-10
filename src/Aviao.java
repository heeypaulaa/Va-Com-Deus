
public class Aviao {

    private float autonomia;
    private float altura;
    private float tamanhoEnvergaduraAsa;
    private float comprimento;
    private float capacidadeCarga;
    private int capacidadePassageiros;
    private String id;

    public Aviao(float autonomia, float altura, float tamanhoEnvergaduraAsa, float comprimento, float capacidadeCarga,
                 int capacidadePassageiros, String id) {
        super();
        this.autonomia = autonomia;
        this.altura = altura;
        this.tamanhoEnvergaduraAsa = tamanhoEnvergaduraAsa;
        this.comprimento = comprimento;
        this.capacidadeCarga = capacidadeCarga;
        this.capacidadePassageiros = capacidadePassageiros;
        this.id = id;
    }

    public float getAutonomia() {
        return autonomia;
    }

    public void setAutonomia(float autonomia) {
        this.autonomia = autonomia;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getTamanhoEnvergaduraAsa() {
        return tamanhoEnvergaduraAsa;
    }

    public void setTamanhoEnvergaduraAsa(float tamanhoEnvergaduraAsa) {
        this.tamanhoEnvergaduraAsa = tamanhoEnvergaduraAsa;
    }

    public float getComprimento() {
        return comprimento;
    }

    public void setComprimento(float comprimento) {
        this.comprimento = comprimento;
    }

    public float getCapacidadeCarga() {
        return capacidadeCarga;
    }

    public void setCapacidadeCarga(float capacidadeCarga) {
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
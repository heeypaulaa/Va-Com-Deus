package vacomdeus.dao;

import vacomdeus.modelo.Aviao;

import java.util.ArrayList;

public class Companhia {
    private String nome;
    public ArrayList<Aviao> avioes = new ArrayList<Aviao>();
    private int numVoos = 0;

    public Companhia(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public int getNumVoos() {
        return numVoos;
    }

    public void setNumVoos(int numVoos) {
        this.numVoos = numVoos;
    }

    public void setNovoAviao(Aviao aviao) {
        if (!aviao.getId().equals(null) && aviao.getAltura() > 0 && aviao.getAutonomia() > 0 &&
                aviao.getCapacidadePassageiros() > 0 && aviao.getComprimento() > 0 && aviao.getTamanhoEnvergaduraAsa() > 0) {
            avioes.add(aviao);
        }
    }

}

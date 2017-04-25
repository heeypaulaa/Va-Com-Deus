package vacomdeus.dao;

import vacomdeus.modelo.Aviao;

import java.util.ArrayList;

public class Companhia {
    private String nome;
    private ArrayList<Aviao> avioes = new ArrayList<Aviao>();
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

    public ArrayList<Aviao> getListAvioes() {
        return avioes;
    }

    public Aviao getAviao(String id) {
        if (!avioes.equals(null)) {
            for (Aviao a : avioes) {
                if (a.getId().equals(id))
                    return a;
            }
        }
        return null;
    }

    public boolean removeAviao(Aviao a) {
        avioes.remove(a);
        return false;
    }

    public String toString() {
        String aux = getNome() + "\n";
        if (!avioes.equals(null)) {
            for (Aviao a : avioes) {
                aux = aux + a.toString() + "\n";
            }
        } else {
            aux = aux + "Não há nenhum avião cadastrado nesta Companhia";
        }
        return aux;
    }

}

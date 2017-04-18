package vacomdeus.dao;

import vacomdeus.modelo.*;

import javax.swing.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Aeroporto {

    private static ArrayList<Aviao> avioes = new ArrayList<Aviao>();
    private static ArrayList<Passageiro> passageiros = new ArrayList<Passageiro>();
    private static ArrayList<Voo> voos = new ArrayList<Voo>();

    public static Date StringToDate(String data) {  /*muda string para date*/
        Date date = null;
        try {
            DateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm"); /*formato da data*/
            date = formato.parse(data); /*muda para date*/
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static boolean validarCPF(String cpf) {
        if (cpf != null) {
            return cpf.matches("[0-9]{3}+[.]{1}+[0-9]{3}+[.]{1}+[0-9]{3}+[-]{1}+[0-9]{2}");
        }
        return false;
    }

    public static boolean validarEmail(String email) {
        if (email != null) {

            //String nome = email.getNome();

            return email.matches("[a-zA-z]{1}+[a-zA-z0-9-_.]{0,}+[@]{1}+[A-Za-z0-9-]{1,}+"
                    + "(\\.[A-Za-z0-9]{1,}+)*(\\.[A-Za-z]{1,})$");

        }
        return false;
    }

	/*AVIÃO*/
    public static boolean cadastrarAviao(Aviao aviao) {
        if ((aviao.getAltura() < 1) || (aviao.getId().equals(null)) || (aviao.getAutonomia() < 1) ||
                (aviao.getCapacidadeCarga() < 1) || (aviao.getCapacidadePassageiros() < 1) ||
                (aviao.getComprimento() < 1) || (aviao.getTamanhoEnvergaduraAsa() < 1)) {
            return false;
        }
        avioes.add(aviao);
        return true;
    }

    public static boolean editaAviao(Aviao aviao) {
        for (Aviao a : avioes) {
            if (a.equals(aviao)) {
                Aviao aux = aviao;
                aux.setAltura(1.5);
                avioes.set(avioes.indexOf(a), aux);
                return true;
            }
        }
        return false;
    }

    public static boolean removeAviao(Aviao aviao) {
        if (existeAviao(aviao) == false) {
            return false;
        }
        avioes.remove(aviao);
        return true;
    }

    public static void listarAvioes() {
        for (Aviao a : avioes) {
            System.out.println(a.toString());
        }
    }

    /*PASSAGEIROS*/
    public static boolean cadastrarPassageiros(Passageiro passageiro) {
        if (passageiro.getCpf().equals(null) || passageiro.getDataNascimento().equals(null) || passageiro.getEmail().equals(null) ||
                passageiro.getNome().equals(null) || (passageiro.getNumeroVoo() > 0) || passageiro.getTelefone().equals(null)) {
            return false;
        }
        passageiros.add(passageiro);
        return true;
    }

    public static boolean editaPassageiro(Passageiro passageiro) {
        for (Passageiro p : passageiros) {
            if (p.equals(passageiro)) {
                Passageiro aux = passageiro;
                aux.setEmail("");
                passageiros.set(passageiros.indexOf(p), aux);
                return true;
            }
        }
        return false;
    }

    public static boolean removePassageiro(Passageiro passageiro) {
        if ((existePassageiro(passageiro)) == false) {
            return false;
        }
        passageiros.remove(passageiro);
        return true;
    }

    public static void listarPassageiros() {
        for (Passageiro p : passageiros) {
            System.out.println(p.toString());
        }
    }

    /*VOOS*/
    public static boolean cadastrarVoos(Voo voo) {
        if ((voo.getNumeroVoo() > 0) || voo.getCompanhiaAerea().equals(null) || voo.getDataHorario().equals(null) ||
                voo.getDestino().equals(null) || voo.getOrigem().equals(null) || voo.getidAviao().equals(null) ||
                voo.getStatusVoo().equals(null)) {
            if (voos.size() < 100) {
                voos.add(voo);
                return true;
            }
        }
        return false;
    }

    public static boolean editaVoo(Voo voo) {
        for (Voo v : voos) {
            if (v.equals(voo)) {
                Voo aux = voo;
                aux.setDestino("Arcos");
                ;
                voos.set(voos.indexOf(v), aux);
                return true;
            }
        }
        return false;
    }

    public static boolean removeVoo(Voo voo) {
        if ((existeVoo(voo)) == true) {
            voos.remove(voo);
            return true;
        }
        return false;

    }

    public static void listarVoos() {
        String result = "";
        if ((voos.size()) == 0) {
            result = "Não possui nenhum voo cadastrado";
        } else {
            for (Voo v : voos) {
                result = result + v.toString() + "\n";
            }
        }
        JOptionPane.showMessageDialog(null, result);
    }


    public static void listarVoosData(Date data) {
        String result = "";
        int i = 0;
        for (Voo v : voos) {
            if (v.getDataHorario().equals(data)) {
                result = result + v.toString() + "\n";
                i++;
            }
        }
        if (i == 0) {
            result = "Não tem nenhum Voo cadastrado nesta data";
        }
        JOptionPane.showMessageDialog(null, result);
    }

    public static void listarVoosPassageiro(Passageiro passageiro) {
        String result = "";
        for (Passageiro p : passageiros) {
            if (p.equals(passageiro)) {
                result = result + voos.toString() + "\n";
            }
        }
        JOptionPane.showMessageDialog(null, result);
    }

    public static void listarPassageirosV1oo(Voo voo) {
        String result = "";
        if (existeIdVoo(voo.getNumeroVoo()) == false) {
            result = "Os passageiros não foram listados pois esse voo não existe";
        }
        for (Voo v : voos) {
            if (v.equals(voo)) {
                result = result + passageiros.toString() + "\n";
            }
        }
        JOptionPane.showMessageDialog(null, result);
    }

    public static boolean existeIdAviao(String id) {
        for (Aviao a : avioes) {
            if (a.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public static boolean existeIdVoo(int id) {
        for (Voo v : voos) {
            if (v.getNumeroVoo() == (id)) {
                return true;
            }
        }
        return false;
    }

    public static boolean existeVoo(Voo voo) {
        for (Voo v : voos) {
            if (v.equals(voo)) {
                return true;
            }
        }
        return false;
    }

    public static boolean existeAviao(Aviao aviao) {
        for (Aviao a : avioes) {
            if (a.equals(aviao)) {
                return true;
            }
        }
        return false;
    }

    public static boolean existePassageiro(Passageiro passageiro) {
        for (Passageiro p : passageiros) {
            if (p.equals(passageiro)) {
                return true;
            }
        }
        return false;
    }

    public static Date dataAtual() throws ParseException {
        Date d = new Date();
        String dStr = java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(d);
        Date date = null;
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        date = (java.util.Date) formatter.parse(dStr);
        return date;
    }

}

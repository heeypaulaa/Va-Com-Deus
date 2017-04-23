package vacomdeus.dao;

import vacomdeus.modelo.*;

import javax.swing.*;
import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.Reader;



public class Aeroporto {

    private static ArrayList<Aviao> avioes = new ArrayList<Aviao>();
    private static ArrayList<Passageiro> passageiros = new ArrayList<Passageiro>();
    private static ArrayList<Voo> voos = new ArrayList<Voo>();

    public static Date StringToDateHour(String data) {  /*muda string para date*/
        Date date = null;
        try {
            DateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm"); /*formato da data*/
            date = formato.parse(data); /*muda para date*/
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static Date StringToDate(String data) {  //muda string para date*/
        Date date = null;
        try {
            DateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); /*formato da data*/
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
                (aviao.getCapacidadePassageiros() < 1) || (aviao.getComprimento() < 1) ||
                (aviao.getTamanhoEnvergaduraAsa() < 1)) {
            return false;
        }
        avioes.add(aviao);
        return true;
    }

    public static boolean editaAviao(Aviao aviao) {
        for (Aviao a : avioes) {
            if (a.getId().equals(aviao.getId())) {
                avioes.set(avioes.indexOf(a), aviao);
                return true;
            }
        }
        return false;
    }

    public static boolean removeAviao(String id) {
        if (existeIdAviao(id) == false) {
            return false;
        }
        avioes.remove(getAviao(id));
        return true;
    }

    public static void listarAvioes() {
        String aux = "";
        if (avioes.size() > 0) {
            for (Aviao a : avioes) {
                aux = aux + a.toString();
            }
        } else {
            aux = "Não há nenhum avião cadastrado";
        }
        JOptionPane.showMessageDialog(null, aux, "Aviões Cadastrados", JOptionPane.INFORMATION_MESSAGE);
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
        if (passageiros != null) {
            for (Passageiro p : passageiros) {
                if (p.getCpf().equals(passageiro.getCpf())) {
                    passageiros.set(passageiros.indexOf(p), passageiro);
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean removePassageiro(String cpf) {
        if (passageiros != null) {
            for (Passageiro p : passageiros) {
                if (p.getCpf().equals(cpf))
                    passageiros.remove(p);
                return true;
            }
        }
        return false;
    }

    public static void listarPassageiros() {
        for (Passageiro p : passageiros) {
            System.out.println(p.toString());
        }
    }

    public static Passageiro getPassageiro(String cpf) {
        if (passageiros != null) {
            for (Passageiro p : passageiros) {
                if (p.getCpf().equals(cpf)) {
                    return p;
                }
            }
        }
        return null;
    }

    /*VOOS*/
    public static boolean cadastrarVoos(Voo voo) {
        if ((voo.getNumeroVoo() > 0) || voo.getCompanhiaAerea().equals(null) || voo.getDataHorario().equals(null) ||
                voo.getDestino().equals(null) || voo.getOrigem().equals(null) || voo.getidAviao().equals(null) ||
                voo.getStatusVoo().equals(null) || voo.getCarga() > 0) {
            if (voos.size() < 100) {
                voos.add(voo);
                return true;
            }
        }
        return false;
    }

    public static boolean editaVoo(Voo voo) {
        if (voos != null) {
            for (Voo v : voos) {
                if (v.getidAviao().equals(voo.getidAviao())) {
                    voos.set(voos.indexOf(v), voo);
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean removeVoo(String id) {
        if (voos != null) {
            for (Voo v : voos) {
                if (v.getidAviao().equals(id)) ;
                voos.remove(v);
                return true;
            }
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
        JOptionPane.showMessageDialog(null, result, "Voos Cadastrados", JOptionPane.PLAIN_MESSAGE);
    }

    /*LISTAR*/
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
        JOptionPane.showMessageDialog(null, result, "Voos Por Data", JOptionPane.PLAIN_MESSAGE);
    }

    public static void listarVoosPassageiro(Passageiro passageiro) {
        String result = "";
        for (Passageiro p : passageiros) {
            if (p.equals(passageiro)) {
                result = result + voos.toString() + "\n";
            }
        }
        JOptionPane.showMessageDialog(null, result, "Voos por Passageiros", JOptionPane.PLAIN_MESSAGE);
    }

    public static void listarPassageirosVoo(Voo voo) {
        String result = "";
        if (existeIdVoo(voo.getNumeroVoo()) == false) {
            result = "Os passageiros não foram listados pois esse voo não existe";
        }
        for (Voo v : voos) {
            if (v.equals(voo)) {
                result = result + passageiros.toString() + "\n";
            }
        }
        JOptionPane.showMessageDialog(null, result, "Passageiros do Voo", JOptionPane.PLAIN_MESSAGE);
    }

    /*EXISTE*/
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

    public static Aviao getAviao(String id) {

        for (Aviao a : avioes) {
            if (a.getId().equals(id)) {
                return a;
            }
        }
        return null;
    }

    public static boolean exportarDadosAvioes() {
        Gson gson = new Gson();
        try {
            //Escreve Json convertido em arquivo chamado "file.json"
            FileWriter writer = new FileWriter("avioes.json");
            for (Aviao a : avioes) {
                String aux = gson.toJson(a);
                // System.out.println(aux);
                writer.write(aux);
                writer.write("\n");//Não sei se pode ter esse \n

            }
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    public static boolean exportarDadosVoos() {
        Gson gson = new Gson();
        try {
            //Escreve Json convertido em arquivo chamado "file.json"
            FileWriter writer = new FileWriter("voos.json");
            for (Voo v : voos) {
                String aux = gson.toJson(v);
                // System.out.println(aux);
                writer.write(aux);
                writer.write("\n");//Não sei se pode ter esse \n

            }
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    public static boolean exportarDadosPassageiros() {
        Gson gson = new Gson();
        try {
            FileWriter writer = new FileWriter("passageiros.json");
            for (Passageiro p : passageiros) {
                String aux = gson.toJson(p);
                // System.out.println(aux);
                writer.write(aux);
                writer.write("\n");//Não sei se pode ter esse \n

            }
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    public static boolean importarDadosAviao(String nomeArq) {
        Gson gson = new Gson();
        Aviao aviao = new Aviao();
        try {
            FileReader reader;
            reader = new FileReader(nomeArq);
            BufferedReader leitor = new BufferedReader(reader);

            String linha = leitor.readLine(); // lê a primeira linha
            aviao = gson.fromJson(linha, Aviao.class);
            //avioes.add(aviao);
            //System.out.printf(aviao.toString());
            while (linha != null) {
                aviao = gson.fromJson(linha, Aviao.class);
                System.out.printf(aviao.toString());
                avioes.add(aviao);

                linha = leitor.readLine(); // lê da segunda até a última linha
            }

            leitor.close();
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
                    e.getMessage());
        }


        return true;

    }

    public static boolean importarDadosVoo(String nomeArq) {
        Gson gson = new Gson();
        Voo voo = new Voo();
        try {
            FileReader reader;
            reader = new FileReader(nomeArq);
            BufferedReader leitor = new BufferedReader(reader);

            String linha = leitor.readLine(); // lê a primeira linha
            voo = gson.fromJson(linha, Voo.class);
            while (linha != null) {
                voo = gson.fromJson(linha, Voo.class);
                voos.add(voo);
                linha = leitor.readLine(); // lê da segunda até a última linha
            }

            leitor.close();
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
                    e.getMessage());
        }
        return true;

    }


    public static boolean importarDadosPassageiro(String nomeArq) {
        Gson gson = new Gson();
        Passageiro passageiro = new Passageiro();
        try {
            FileReader reader;
            reader = new FileReader(nomeArq);
            BufferedReader leitor = new BufferedReader(reader);

            String linha = leitor.readLine(); // lê a primeira linha
            passageiro = gson.fromJson(linha, Passageiro.class);
            while (linha != null) {
                passageiro = gson.fromJson(linha, Passageiro.class);
                passageiros.add(passageiro);
                linha = leitor.readLine(); // lê da segunda até a última linha
            }

            leitor.close();
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
                    e.getMessage());
        }
        return true;

    }
}

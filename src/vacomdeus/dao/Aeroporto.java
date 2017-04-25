package vacomdeus.dao;

import com.google.gson.Gson;
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
    public static ArrayList<Companhia> companhias = new ArrayList<Companhia>();
    //private static ArrayList<Aviao> avioes = new ArrayList<Aviao>();/*APAGAR TALVEZ*/
    private static ArrayList<Passageiro> passageiros = new ArrayList<Passageiro>();
    private static ArrayList<Voo> voos = new ArrayList<Voo>();

    public static boolean existeAviaoCadastrado() {
        if (companhias.size() == 0) {
            return false;
        } else {
            for (Companhia c : companhias) {
                if (c.getListAvioes().size() > 0) {
                    return true;
                }
            }


        }
        return false;
    }

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
            return email.matches("[a-zA-z]{1}+[a-zA-z0-9-_.]{0,}+[@]{1}+[A-Za-z0-9-]{1,}+"
                    + "(\\.[A-Za-z0-9]{1,}+)*(\\.[A-Za-z]{1,})$");
        }
        return false;
    }

    public static boolean limpaAeroporto() {
        if (!companhias.equals(null)) {
            for (Companhia c : companhias) {
                removeCompanhia(c.getNome());
            }
            return true;
        }
        return false;
    }

	/*AVIÃO*/
    public static boolean cadastrarAviao(Aviao aviao, String companhia) {
        if (!companhias.equals(null)) {
            int id;
            for (Companhia c : companhias) {
                if (c.getNome().equals(companhia)) {
                    id = companhias.indexOf(c);
                    companhias.get(id).setNovoAviao(aviao);
                }
            }
        }
        return true;
    }

    public static boolean editaAviao(Aviao aviao, String companhia) {/*arrumar depois*/
        Companhia c = getCompanhia(companhia);
        if (!c.getListAvioes().equals(null)) {
            int id = companhias.indexOf(c);
            for (Aviao a : c.getListAvioes()) {
                if (a.getId().equals(aviao.getId())) {
                    companhias.get(id).getListAvioes().set(id, aviao);
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean removeAviao(String id, String companhia) {/*arrumado*/
        if (existeIdAviao(id, companhia) == false) {
            return false;
        }
        Companhia c = getCompanhia(companhia);
        /*remove todos os voos deste avião*/
        for (Voo v : voos) {
            if (v.getidAviao().equals(id))
                removeVoo(v.getNumeroVoo());
        }
        return c.removeAviao(c.getAviao(id));
    }

    public static void listarAvioes() {
        String aux = "";
        if ((companhias.size() == 0) || companhias.equals(null)) {
            aux = "Não há nenhum avião cadastrado neste Aeroporto";
        } else {
            for (Companhia c : companhias) {
                 aux = c.toString() ;
            }

        }
        JOptionPane.showMessageDialog(null, aux, "Aviões Cadastrados", JOptionPane.INFORMATION_MESSAGE);
    }

    /*
     *APAGAR
    public static Aviao getAviao(String id) {
        if (!companhias.equals(null))
            for (Companhia c : companhias) {
                if (!c.avioes.equals(null))
                    for (Aviao a : c.avioes) {
                        if (a.getId().equals(id))
                            return a;
                    }
            }
        return null;
    }*/

    public static boolean existeIdAviao(String id) {
        if (!companhias.equals(null))
            for (Companhia c : companhias) {
                if (!c.getListAvioes().equals(null))
                    for (Aviao a : c.getListAvioes()) {
                        if (a.getId().equals(id))
                            return true;
                    }
            }
        return false;
    }

    public static boolean existeIdAviao(String id, String companhia) {
        Companhia c = getCompanhia(companhia);
        if (!c.getListAvioes().equals(null))
            for (Aviao a : c.getListAvioes()) {
                if (a.getId().equals(id))
                    return true;
            }
        return false;
    }

    /*COMPANHIAS*/
    public static Companhia getCompanhia(String nome) {
        if (!companhias.equals(null)) {
            for (Companhia c : companhias) {
                if (c.getNome().equals(nome))
                    return c;
            }
        }
        return null;
    }

    public static boolean existeCompanhia(String nome) {
        if (!companhias.equals(null)) {
            for (Companhia c : companhias) {
                if (c.getNome().equals(nome))
                    return true;
            }
        }
        return false;
    }

    public static boolean cadastraCompanhia(String nome) {
        if (nome != null) {
            Companhia c = new Companhia(nome);
            return companhias.add(c);
        }
        return false;
    }

    public static boolean removeCompanhia(String nome) {
        if (!companhias.equals(null)) {
            Companhia c = getCompanhia(nome);
            for (Aviao a : c.getListAvioes()) {
                removeAviao(a.getId(), nome);
            }
            return companhias.remove(c);
        }
        return false;
    }

    /*PASSAGEIROS*/
    public static boolean cadastrarPassageiros(Passageiro passageiro) {
        if (passageiro.getCpf().equals(null) || passageiro.getDataNascimento().equals(null) || passageiro.getEmail().equals(null) ||
                passageiro.getNome().equals(null) || (passageiro.getNumeroVoo() < 0) || passageiro.getTelefone().equals(null)) {
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

    public static boolean existePassageiro(Passageiro passageiro) {
        for (Passageiro p : passageiros) {
            if (p.equals(passageiro)) {
                return true;
            }
        }
        return false;
    }


    /*VOOS*/
    public static boolean cadastrarVoos(Voo voo, String companhia) {
        if ((voo.getNumeroVoo() > 0) || voo.getDataHorario().equals(null) || voo.getDestino().equals(null) ||
                voo.getOrigem().equals(null) || voo.getidAviao().equals(null) || voo.getStatusVoo().equals(null) ||
                voo.getCarga() > 0) {
            if (voos.size() < 100) {
                voos.add(voo);
                if (!voo.getStatusVoo().equals(3)) {
                    Companhia c = getCompanhia(companhia);
                    int id = companhias.indexOf(c);
                    companhias.get(id).setNumVoos(c.getNumVoos() + 1);
                }
                return true;
            }
        }
        return false;
    }

    public static boolean editaVoo(Voo voo, String companhia) {
        if (voos != null) {
            for (Voo v : voos) {
                if (v.getidAviao().equals(voo.getidAviao()) && (v.getCompanhiaAerea().equals(companhia))) {
                    if ((v.getStatusVoo() != voo.getStatusVoo()) && voo.getStatusVoo().equals(3)) {
                        Companhia c = getCompanhia(companhia);
                        int id = companhias.indexOf(c);
                        companhias.get(id).setNumVoos(c.getNumVoos() - 1);
                    }
                    voos.set(voos.indexOf(v), voo);
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean exiteVooCompanhia(int numeroVoo, String nomecompanhia) {
        if (voos != null) {
            for (Voo v : voos) {
                if (v.getCompanhiaAerea().equals(nomecompanhia) && v.getNumeroVoo() == numeroVoo) {
                    return true;
                }
            }
        }
        return false;
    }


    public static boolean removeVoo(int num) {/*arrumado*/
        if (voos != null) {
            for (Voo v : voos) {
                if (v.getNumeroVoo() == num) ;
                /*roda a lista de Passageiros e remove todos que tem o mesmo numero de voo*/
                for (Passageiro p : passageiros) {
                    if (p.getNumeroVoo() == num) {
                        removePassageiro(p.getCpf());
                    }
                }
                /*pega companhia para decrementar o numero de voos por companhia*/
                Companhia c = getCompanhia(v.getCompanhiaAerea());
                int id = companhias.indexOf(c);
                companhias.get(id).setNumVoos(c.getNumVoos() - 1);
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

    public static boolean existeVoo(int numVoo) {
        if (!voos.equals(null))
            for (Voo v : voos) {
                if (v.getNumeroVoo() == numVoo)
                    return true;
            }
        return false;
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
        if (existeVoo(voo.getNumeroVoo()) == false) {
            result = "Os passageiros não foram listados pois esse voo não existe";
        }
        for (Voo v : voos) {
            if (v.equals(voo)) {
                result = result + passageiros.toString() + "\n";
            }
        }
        JOptionPane.showMessageDialog(null, result, "Passageiros do Voo", JOptionPane.PLAIN_MESSAGE);
    }

    public static String listarCompanhias() {
        if (!companhias.equals(null)) {
            String lista = "";
            for (Companhia c : companhias) {
                lista = lista + c.getNome() + "  ";
            }
            return lista;
        }
        return null;
    }


    public static Date dataAtual() throws ParseException {
        Date d = new Date();
        String dStr = java.text.DateFormat.getDateInstance(DateFormat.MEDIUM).format(d);
        Date date = null;
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        date = (java.util.Date) formatter.parse(dStr);
        return date;
    }

    public static boolean exportarDadosAvioes(String nomeArq) {
        Gson gson = new Gson();
        try {
            //Escreve Json convertido em arquivo chamado "file.json"
            FileWriter writer = new FileWriter(nomeArq);
            if (!companhias.equals(null)) {
                for (Companhia c : companhias) {
                    if (!c.getListAvioes().equals(null)) {
                        for (Aviao a : c.getListAvioes()) {
                            String aux = gson.toJson(a);
                            // System.out.println(aux);
                            writer.write(aux);
                            writer.write("\n");//Não sei se pode ter esse \n
                        }
                    }
                }
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
                //System.out.printf(aviao.toString());
                //avioes.add(aviao);
                Companhia c = getCompanhia(aviao.getCompanhia());
                companhias.get(companhias.indexOf(c)).setNovoAviao(aviao);


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

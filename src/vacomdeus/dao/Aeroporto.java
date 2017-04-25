package vacomdeus.dao;

import com.google.gson.Gson;
import vacomdeus.modelo.*;

import javax.swing.*;
import java.awt.*;
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

    public static boolean validarTelefone(String telefone) {
        if (telefone != null) {
            return telefone.matches("[(]{1}+[0-9]{3}+[)]{1}+[0-9]{4}+[-]{1}+[0-9]{4}");
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
        if (!companhias.isEmpty()) {
            for (Companhia c : companhias) {
                removeCompanhia(c.getNome());
            }
            return true;
        }
        return false;
    }

    /*AVIÃO*/
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

    public static boolean cadastrarAviao(Aviao aviao, String companhia) {
        if (!companhias.isEmpty()) {
            int id;
            for (Companhia c : companhias) {
                if (c.getNome().equals(companhia)) {
                    id = companhias.indexOf(c);
                    companhias.get(id).setNovoAviao(aviao);
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean editaAviao(Aviao aviao, String companhia) {/*arrumar depois*/
        Companhia c = getCompanhia(companhia);
        if (!c.getListAvioes().isEmpty()) {
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
        if (!voos.isEmpty()) {
            int tam = voos.size();
            for (Voo v : voos) {
                if (v.getidAviao().equals(id)) {
                    removeVoo(v.getNumeroVoo());
                }
                if (tam == 1)
                    break;
            }
        }
        return c.removeAviao(c.getAviao(id));
    }

    public static void listarAvioes() {
        String aux = "";
        if ((companhias.size() == 0) || companhias.equals(null)) {
            aux = "Não há nenhum avião cadastrado neste Aeroporto";
        } else {
            for (Companhia c : companhias) {
                aux = aux + c.toString();
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
        if (!companhias.isEmpty())
            for (Companhia c : companhias) {
                if (!c.getListAvioes().isEmpty())
                    for (Aviao a : c.getListAvioes()) {
                        if (a.getId().equals(id))
                            return true;
                    }
            }
        return false;
    }

    public static boolean existeIdAviao(String id, String companhia) {
        Companhia c = getCompanhia(companhia);
        if (!c.getListAvioes().isEmpty())
            for (Aviao a : c.getListAvioes()) {
                if (a.getId().equals(id))
                    return true;
            }
        return false;
    }

    /*COMPANHIAS*/
    public static Companhia getCompanhia(String nome) {
        if (!companhias.isEmpty()) {
            for (Companhia c : companhias) {
                if (c.getNome().equals(nome))
                    return c;
            }
        }
        return null;
    }

    public static boolean existeCompanhia(String nome) {
        if (!companhias.isEmpty()) {
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
        if (!companhias.isEmpty()) {
            Companhia c = getCompanhia(nome);
            if (!c.getListAvioes().isEmpty()) {
                int tam = c.getListAvioes().size();
                for (Aviao a : c.getListAvioes()) {
                    removeAviao(a.getId(), nome);
                    if (tam == 1)
                        break;
                }
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
        if (!passageiros.isEmpty()) {
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
        if (!passageiros.isEmpty()) {
            int tam = passageiros.size();
            for (Passageiro p : passageiros) {
                if (p.getCpf().equals(cpf)) {
                    passageiros.remove(p);
                    return true;
                }
                if (tam == 1)
                    break;
            }
        }
        return false;
    }

    public static void listarPassageiros() {
        String aux = "";
        if (passageiros.size() == 0) {
            aux = "Nenhum passageiro Cadastrado";
        } else {
            for (Passageiro p : passageiros) {
                aux = aux + p.toString() + "\n";
                //System.out.println(p.toString());
            }
        }
        JOptionPane.showMessageDialog(null, aux, "Passageiros Cadastrados", JOptionPane.PLAIN_MESSAGE);
    }


    public static Passageiro getPassageiro(String cpf) {
        if (!passageiros.isEmpty()) {
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
        if (!voos.isEmpty()) {
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
        if (!voos.isEmpty()) {
            for (Voo v : voos) {
                if (v.getCompanhiaAerea().equals(nomecompanhia) && v.getNumeroVoo() == numeroVoo) {
                    return true;
                }
            }
        }
        return false;
    }


    public static boolean removeVoo(int num) {/**/
        if (!voos.isEmpty()) {
            for (Voo v : voos) {
                if (v.getNumeroVoo() == num) {
                    if (!passageiros.isEmpty()) {
                /*roda a lista de Passageiros e remove todos que tem o mesmo numero de voo*/
                        int tam = passageiros.size();
                        for (Passageiro p : passageiros) {
                            if (p.getNumeroVoo() == num) {
                                removePassageiro(p.getCpf());
                            }
                            if (tam == 1)
                                break;
                        }
                    }
                /*pega companhia para decrementar o numero de voos por companhia*/
                    String s = v.getCompanhiaAerea();
                    Companhia c = getCompanhia(s);
                    int id = companhias.indexOf(c);
                    companhias.get(id).setNumVoos(c.getNumVoos() - 1);
                    voos.remove(v);
                    return true;
                }
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
        if (!voos.isEmpty())
            for (Voo v : voos) {
                if (v.getNumeroVoo() == numVoo)
                    return true;
            }
        return false;
    }

    public static Voo getVoo(int numVoo) {
        if (!voos.isEmpty()) {
            for (Voo v : voos) {
                if (v.getNumeroVoo() == numVoo)
                    return v;
            }
        }
        return null;
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
        if (!companhias.isEmpty()) {
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
            if (!companhias.isEmpty()) {
                for (Companhia c : companhias) {
                    if (!c.getListAvioes().isEmpty()) {
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

    public static boolean exportarDadosVoos(String nomeArq) {
        Gson gson = new Gson();
        try {
            //Escreve Json convertido em arquivo chamado "file.json"
            FileWriter writer = new FileWriter(nomeArq);
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

    public static boolean exportarDadosPassageiros(String nomeArq) {
        Gson gson = new Gson();
        try {
            FileWriter writer = new FileWriter(nomeArq);
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
            //aviao = gson.fromJson(linha, Aviao.class);
            //avioes.add(aviao);
            //System.out.printf(aviao.toString());
            while (linha != null) {
                aviao = gson.fromJson(linha, Aviao.class);
                //System.out.printf(aviao.toString());
                //avioes.add(aviao);
                // System.out.println(aviao.toString());
                if (Aeroporto.existeCompanhia(aviao.getCompanhia()) == false) {
                    Aeroporto.cadastraCompanhia(aviao.getCompanhia());
                    // JOptionPane.showMessageDialog(null, "Avião não cadastrado pois não existe esta companhia");
                }
                Aeroporto.cadastrarAviao(aviao, aviao.getCompanhia());
                //Companhia c = getCompanhia(aviao.getCompanhia());
                //System.out.println(c.getNome());
                //companhias.get(companhias.indexOf(c)).setNovoAviao(aviao);


                linha = leitor.readLine(); // lê da segunda até a última linha
            }

            leitor.close();
        } catch (IOException e) {
            return false;
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
            return false;
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
            return false;
        }
        return true;

    }
}

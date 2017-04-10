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
        voos.add(voo);

        return true;

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
        voos.remove(voo);
        return true;
    }

    public static void listarVoo() {
        for (Voo v : voos) {
            System.out.println(v.toString());
        }
    }

}

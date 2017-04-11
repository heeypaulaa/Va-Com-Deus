import sun.security.krb5.internal.crypto.dk.AesDkCrypto;

import javax.swing.JOptionPane;

public class Principal {

    /*AVIÃO*/
    public static void menuCadastrarAviao() {
        Aviao aviao = new Aviao();
        aviao.setId(JOptionPane.showInputDialog("Cadastro Avião\nID:"));
        aviao.setAltura(Double.parseDouble(JOptionPane.showInputDialog("Cadastro Avião\nAltura:")));
        aviao.setAutonomia(Double.parseDouble(JOptionPane.showInputDialog("Cadastro Avião\nAutonomia:")));
        aviao.setComprimento(Double.parseDouble(JOptionPane.showInputDialog("Cadastro Avião\nComprimento:")));
        aviao.setCapacidadeCarga(Double.parseDouble(JOptionPane.showInputDialog("Cadastro Avião\nCapacidade de Carga:")));
        aviao.setCapacidadePassageiros(Integer.parseInt(JOptionPane.showInputDialog("Cadastro Avião\nCapacidade Passageiros:")));
        if ((Aeroporto.cadastrarAviao(aviao)) == true) {
            JOptionPane.showMessageDialog(null, "Avião Cadastrado com sucesso");
        } else {
            JOptionPane.showMessageDialog(null, "Erro - Avião não cadastrado");
        }
    }

    public static void menuRemoverAviao() {
        Aviao aviao = new Aviao();
        aviao.setId(JOptionPane.showInputDialog("Excluir Avião\nID:"));
        aviao.setAltura(Double.parseDouble(JOptionPane.showInputDialog("Excluir Avião\nAltura:")));
        aviao.setAutonomia(Double.parseDouble(JOptionPane.showInputDialog("Excluir Avião\nAutonomia:")));
        aviao.setComprimento(Double.parseDouble(JOptionPane.showInputDialog("Excluir Avião\nComprimento:")));
        aviao.setCapacidadeCarga(Double.parseDouble(JOptionPane.showInputDialog("Ecluir Avião\nCapacidade de Carga:")));
        aviao.setCapacidadePassageiros(Integer.parseInt(JOptionPane.showInputDialog("Excluir Avião\nCapacidade Passageiros:")));
        if ((Aeroporto.removeAviao(aviao)) == true) {
            JOptionPane.showMessageDialog(null, "Avião removido com sucesso");
        } else {
            JOptionPane.showMessageDialog(null, "Erro - Avião não removido");
        }

    }

    /*VOO*/
    public static void menuCadastrarVoo() {
        Voo voo = new Voo();
        voo.setNumeroVoo(Integer.parseInt(JOptionPane.showInputDialog("Cadastro Voo\nNúmero do Voo:")));
        voo.setidAviao(JOptionPane.showInputDialog("Cadastro Voo\nID do avião:")); //id do aviao
        voo.setCompanhiaAerea(JOptionPane.showInputDialog("Cadastro Voo\nCompanhia Aerea:"));
        String data = JOptionPane.showInputDialog("Cadastro Voo\nData:");
        voo.setData(Aeroporto.StringToDate(data));
        String horario = JOptionPane.showInputDialog("Cadastro Voo\nHorário:");
        voo.setHorarioVoo(Aeroporto.StringToDate(horario));
        voo.setOrigem((JOptionPane.showInputDialog("Cadastro Voo\nOrigem:")));
        voo.setDestino((JOptionPane.showInputDialog("Cadastro Voo\nDestino:")));
        int aux;
        aux = Integer.parseInt(JOptionPane.showInputDialog("Cadastro Voo \nStatus Voo:"));
        if (aux == (1)) {
            voo.setStatusVoo(StatusVoo.CONFIRMADO);
        }
        if (aux == (2)) {
            voo.setStatusVoo(StatusVoo.CANCELADO);
        }
        if (aux == (3)) {
            voo.setStatusVoo(StatusVoo.ATRASADO);
        }

        if ((Aeroporto.cadastrarVoos(voo)) == true) {
            JOptionPane.showMessageDialog(null, "Voo Cadastrado com sucesso");
        } else {
            JOptionPane.showMessageDialog(null, "Erro - Voo não cadastrado");
        }
    }

    public static void menuRemoverVoo() {
        Voo voo = new Voo();
        voo.setNumeroVoo(Integer.parseInt(JOptionPane.showInputDialog("Remover Voo\nNúmero do Voo:")));
        voo.setidAviao(JOptionPane.showInputDialog("Remover Voo\nID do avião:")); //id do aviao
        voo.setCompanhiaAerea(JOptionPane.showInputDialog("Remover Voo\nCompanhia Aerea:"));
        String data = JOptionPane.showInputDialog("Remover Voo\nData:");
        voo.setData(Aeroporto.StringToDate(data));
        String horario = JOptionPane.showInputDialog("Remover Voo\nHorário:");
        voo.setHorarioVoo(Aeroporto.StringToDate(horario));
        voo.setOrigem((JOptionPane.showInputDialog("Remover Voo\nOrigem:")));
        voo.setDestino((JOptionPane.showInputDialog("Remover Voo\nDestino:")));
        int aux;
        aux = Integer.parseInt(JOptionPane.showInputDialog("Remover Voo \nStatus Voo:"));
        if (aux == (1)) {
            voo.setStatusVoo(StatusVoo.CONFIRMADO);
        }
        if (aux == (2)) {
            voo.setStatusVoo(StatusVoo.CANCELADO);
        }
        if (aux == (3)) {
            voo.setStatusVoo(StatusVoo.ATRASADO);
        }

        if ((Aeroporto.removeVoo(voo)) == true) {
            JOptionPane.showMessageDialog(null, "Voo removido com sucesso");
        } else {
            JOptionPane.showMessageDialog(null, "Erro - Voo não removido");
        }

    }

    /*PASSAGEIRO*/
    public static void menuCadastrarPassageiro() {
        Passageiro passageiro = new Passageiro();
        passageiro.setNome(JOptionPane.showInputDialog("Cadastro Passageiro\nNome:"));
        String cpf;
        do {
            cpf = JOptionPane.showInputDialog("Cadastro Passageiro\nCPF:");
        } while (Aeroporto.validarCPF(cpf) == false);
        passageiro.setCpf(cpf);
        String aux = JOptionPane.showInputDialog("Cadastro Passageiro\nData de Nascimento:");
        passageiro.setDataNascimento(Aeroporto.StringToDate(aux));
        String email;
        do {
            email = JOptionPane.showInputDialog("Cadastro Passageiro\nEmail:");
        } while (Aeroporto.validarEmail(email) == false);
        passageiro.setEmail(email);
        passageiro.setTelefone(JOptionPane.showInputDialog("Cadastro Passageiro\nTelefone:"));
        passageiro.setNumeroVoo(Integer.parseInt(JOptionPane.showInputDialog("Cadastro Passageiro\nNúmero do Voo:")));

        if ((Aeroporto.cadastrarPassageiros(passageiro)) == true) {
            JOptionPane.showMessageDialog(null, "Passageiro Cadastrado com sucesso");
        } else {
            JOptionPane.showMessageDialog(null, "Erro - Passageiro não cadastrado");
        }
    }

    public static void menuRemoverPassageiro() {

        Passageiro passageiro = new Passageiro();
        passageiro.setNome(JOptionPane.showInputDialog("Remover Passageiro\nNome:"));
        String cpf;
        do {
            cpf = JOptionPane.showInputDialog("Remover Passageiro\nCPF:");
        } while (Aeroporto.validarCPF(cpf) == false);
        passageiro.setCpf(cpf);
        String aux = JOptionPane.showInputDialog("Remover Passageiro\nData de Nascimento:");
        passageiro.setDataNascimento(Aeroporto.StringToDate(aux));
        String email;
        do {
            email = JOptionPane.showInputDialog("Remover Passageiro\nEmail:");
        } while (Aeroporto.validarEmail(email) == false);
        passageiro.setEmail(email);
        passageiro.setTelefone(JOptionPane.showInputDialog("Remover Passageiro\nTelefone:"));
        passageiro.setNumeroVoo(Integer.parseInt(JOptionPane.showInputDialog("Remover Passageiro\nNúmero do Voo:")));
        if ((Aeroporto.removePassageiro(passageiro)) == true) {
            JOptionPane.showMessageDialog(null, "Passageiro removido com sucesso");
        } else {
            JOptionPane.showMessageDialog(null, "Erro - Passageiro não removido");
        }
    }

    public static void main(String[] args) {
        int opcao;
        do {
            opcao = Integer.parseInt(JOptionPane.showInputDialog("1 - Cadastrar Avião\n2 - Editar Avião\n3 - Remover Avião\n"
                    + "4 - Cadastrar Passageiro\n5 - Editar Passageiro\n6 - Remover Passageiro\n"
                    + "7 - Cadastrar Voo\n8 - Editar Voo\n9 - Remover Voo\n10 "));

            switch (opcao) {
                case 1://if (opcao.equals("1")) {
                    menuCadastrarAviao();
                    break;
                case 2://} else if (opcao.equals("2")) {
                    // buscar(lista);
                    break;
                case 3://} else if (opcao.equals("3")) {
                    menuRemoverAviao();
                    break;
                case 4://} else if (opcao.equals("4")) {
                    menuCadastrarPassageiro();
                    break;
                case 5://} else if (opcao.equals("5")) {
                    // imprimir(lista);
                    break;
                case 6://} else if (opcao.equals("6")) {
                    menuRemoverPassageiro();
                    break;
                case 7://} else if (opcao.equals("7")) {
                    menuCadastrarVoo();
                    break;
                case 8://} else if (opcao.equals("8")) {
                    // imprimir(lista);
                    break;
                case 9://} else if (opcao.equals("9")) {
                    menuRemoverVoo();
                    break;
                case 10:
                    Aeroporto.listarVoo();
                    break;
                default:
                    break;
            }
        } while (opcao <= 10);
    }
}

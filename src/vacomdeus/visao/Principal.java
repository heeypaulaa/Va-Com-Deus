package vacomdeus.visao;

import vacomdeus.modelo.*;
import vacomdeus.dao.Aeroporto;

import javax.swing.JOptionPane;
import java.text.ParseException;

public class Principal {

    /*AVIÃO*/
    public static void menuCadastrarAviao() {
        Aviao aviao = new Aviao();
        String id;
        do {
            id = JOptionPane.showInputDialog(null, "ID", "Cadastro Avião", 3);
        } while (Aeroporto.existeIdAviao(id));
        aviao.setId(id);
        aviao.setAltura(Double.parseDouble(JOptionPane.showInputDialog(null, "Altura em metros", "Cadastro Avião", 3)));
        aviao.setAutonomia(Double.parseDouble(JOptionPane.showInputDialog(null, "Autonomia em km", "Cadastro Avião", 3)));
        aviao.setComprimento(Double.parseDouble(JOptionPane.showInputDialog(null, "Comprimento em metros", "Cadastro Avião", 3)));
        aviao.setCapacidadePassageiros(Integer.parseInt(JOptionPane.showInputDialog(null, "Capacidade Passageiros", "Cadastro Avião", 3)));
        aviao.setTamanhoEnvergaduraAsa(Double.parseDouble(JOptionPane.showInputDialog(null, "Tamanho envergadura Asas", "Cadastro Avião", 3)));
        if ((Aeroporto.cadastrarAviao(aviao)) == true) {
            JOptionPane.showMessageDialog(null, "Avião Cadastrado com sucesso", "Cadastro Avião", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Erro - Avião não cadastrado", "Cadastro Avião", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void menuRemoverAviao() {
        String id = JOptionPane.showInputDialog(null, "ID do Avião a ser Excluído", "Excluir Avião", JOptionPane.QUESTION_MESSAGE);
        if ((Aeroporto.removeAviao(id)) == true) {
            JOptionPane.showMessageDialog(null, "Avião removido com sucesso", "Excluir Avião", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Erro - Avião não removido", "Excluir Avião", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void menuEditarAviao() {
        String id = JOptionPane.showInputDialog(null, "ID do Avião a ser Editado", "Editar Avião", JOptionPane.QUESTION_MESSAGE);
        if (Aeroporto.existeIdAviao(id) == false) {
            JOptionPane.showMessageDialog(null, "Avião inexistente", "Editar Avião", JOptionPane.INFORMATION_MESSAGE);
        } else {
            Aviao aviao = new Aviao();
            aviao.setId(id);
            aviao.setAltura(Double.parseDouble(JOptionPane.showInputDialog(null, "Altura em metros", "Editar Avião", 3)));
            aviao.setAutonomia(Double.parseDouble(JOptionPane.showInputDialog(null, "Autonomia em km", "Editar Avião", 3)));
            aviao.setComprimento(Double.parseDouble(JOptionPane.showInputDialog(null, "Comprimento em metros", "Editar Avião", 3)));
            aviao.setCapacidadePassageiros(Integer.parseInt(JOptionPane.showInputDialog(null, "Capacidade Passageiros", "Editar Avião", 3)));
            aviao.setTamanhoEnvergaduraAsa(Double.parseDouble(JOptionPane.showInputDialog(null, "Tamanho envergadura Asas", "Editar Avião", 3)));
            Aeroporto.editaAviao(aviao);
            if ((Aeroporto.editaAviao(aviao)) == true) {
                JOptionPane.showMessageDialog(null, "Avião editado com sucesso", "Editar Avião", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Erro - Avião não editado", "Editar Avião", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /*VOO*/
    public static void menuCadastrarVoo() {
        Voo voo = new Voo();
        int numeroVoo;
        do {
            numeroVoo = Integer.parseInt(JOptionPane.showInputDialog(null, "Número do Voo", "Cadastro Voo", JOptionPane.QUESTION_MESSAGE));
        } while (Aeroporto.existeIdVoo(numeroVoo));
        voo.setNumeroVoo(numeroVoo);
        String idAviao;
        do {
            idAviao = JOptionPane.showInputDialog(null, "ID do avião", "Cadastro Voo", JOptionPane.QUESTION_MESSAGE);
        } while (!Aeroporto.existeIdAviao(idAviao));
        voo.setidAviao(idAviao);
        voo.setCompanhiaAerea(JOptionPane.showInputDialog(null, "Companhia Aerea", "Cadastro Voo", JOptionPane.QUESTION_MESSAGE));
        String dataHora = JOptionPane.showInputDialog(null, "Data e Horário dd/mm/aaaa hh:mm", "Cadastro Voo", JOptionPane.QUESTION_MESSAGE);
        voo.setDataHorario(Aeroporto.StringToDate(dataHora));
        voo.setOrigem((JOptionPane.showInputDialog(null, "Origem", "Cadastro Voo", JOptionPane.QUESTION_MESSAGE)));
        voo.setDestino((JOptionPane.showInputDialog(null, "Destino", "Cadastro Voo", JOptionPane.QUESTION_MESSAGE)));
        voo.setCarga(Double.parseDouble(JOptionPane.showInputDialog(null, "Carga em toneladas", "Cadastro Voo", JOptionPane.QUESTION_MESSAGE)));
        int aux = Integer.parseInt(JOptionPane.showInputDialog(null, "Status Voo", "Cadastro Voo", JOptionPane.QUESTION_MESSAGE));
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
            JOptionPane.showMessageDialog(null, "Voo Cadastrado com sucesso", "Cadastro Voo", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Erro - Voo não cadastrado", "Cadastro Voo", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void menuRemoverVoo() {
        Voo voo = new Voo();
        voo.setNumeroVoo(Integer.parseInt(JOptionPane.showInputDialog(null, "Número do Voo", "Remover Voo", 3)));
        voo.setidAviao(JOptionPane.showInputDialog(null, "ID do avião", "Remover Voo", 3)); //id do aviao
        voo.setCompanhiaAerea(JOptionPane.showInputDialog(null, "Companhia Aerea", "Remover Voo", 3));
        String dataHorario = JOptionPane.showInputDialog(null, "Data e Horaŕio", "Remover Voo", 3);
        voo.setDataHorario(Aeroporto.StringToDate(dataHorario));
        voo.setOrigem((JOptionPane.showInputDialog(null, "Origem", "Remover Voo", 3)));
        voo.setDestino((JOptionPane.showInputDialog(null, "Destino", "Remover Voo", 3)));
        int aux;
        aux = Integer.parseInt(JOptionPane.showInputDialog(null, "Status Voo", "Remover Voo", 3));
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
            JOptionPane.showMessageDialog(null, "Voo removido com sucesso", "Remover Voo", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Erro - Voo não removido, não existe", "Remover Voo", JOptionPane.ERROR_MESSAGE);
        }
    }



    /*PASSAGEIRO*/
    public static void menuCadastrarPassageiro() {
        Passageiro passageiro = new Passageiro();
        passageiro.setNome(JOptionPane.showInputDialog(null, "Nome:", "Cadastro Passageiro",
                3));
        String cpf;
        do {
            cpf = JOptionPane.showInputDialog(null, "CPF:", "Cadastro Passageiro", 3);
        } while (Aeroporto.validarCPF(cpf) == false);
        passageiro.setCpf(cpf);
        String aux = JOptionPane.showInputDialog(null, "Data de Nascimento:", "Cadastro Passageiro",
                3);
        passageiro.setDataNascimento(Aeroporto.StringToDate(aux));
        String email;
        do {
            email = JOptionPane.showInputDialog(null, "Email:", "Cadastro Passageiro", 3);
        } while (Aeroporto.validarEmail(email) == false);
        passageiro.setEmail(email);
        passageiro.setTelefone(JOptionPane.showInputDialog("Cadastro Passageiro\nTelefone:"));
        int numeroVoo;
        do {
            numeroVoo = Integer.parseInt(JOptionPane.showInputDialog("Cadastro Passageiro\nNúmero do Voo:"));
        } while (!Aeroporto.existeIdVoo(numeroVoo));
        passageiro.setNumeroVoo(numeroVoo);
        if ((Aeroporto.cadastrarPassageiros(passageiro)) == true) {
            JOptionPane.showMessageDialog(null, "Passageiro Cadastrado com sucesso", "Cadastro Passageiro", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Erro - Passageiro não cadastrado", "Cadastro Passageiro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void menuRemoverPassageiro() {

        Passageiro passageiro = new Passageiro();
        passageiro.setNome(JOptionPane.showInputDialog(null, "Nome", "Remover Passageiro", 3));
        String cpf;
        do {
            cpf = JOptionPane.showInputDialog(null, "CPF", "Remover Passageiro", 3);
        } while (Aeroporto.validarCPF(cpf) == false);
        passageiro.setCpf(cpf);
        String aux = JOptionPane.showInputDialog(null, "Data de Nascimento", "Remover Passageiro", 3);
        passageiro.setDataNascimento(Aeroporto.StringToDate(aux));
        String email;
        do {
            email = JOptionPane.showInputDialog(null, "Email", "Remover Passageiro", 3);
        } while (Aeroporto.validarEmail(email) == false);
        passageiro.setEmail(email);
        passageiro.setTelefone(JOptionPane.showInputDialog(null, "Telefone", "Remover Passageiro", 3));
        passageiro.setNumeroVoo(Integer.parseInt(JOptionPane.showInputDialog(null, "Número do Voo", "Remover Passageiro", 3)));
        if ((Aeroporto.removePassageiro(passageiro)) == true) {
            JOptionPane.showMessageDialog(null, "Passageiro removido com sucesso", "Remover Passageiro", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Erro - Passageiro não removido", "Remover Passageiro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) throws ParseException {
        int opcao;
        do {
            opcao = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "1 - Cadastrar Avião\n2 - Editar Avião\n3 - Remover Avião\n"
                            + "4 - Cadastrar Passageiro\n5 - Editar Passageiro\n6 - Remover Passageiro\n"
                            + "7 - Cadastrar Voo\n8 - Editar Voo\n9 - Remover Voo\n10 - Listar todos os Voos\n"
                            + "11 - Listar Voos por Data\n12 - Listar Voos do dia\n13 - Listar Voos do Passageiro" +
                            "\n14 - Listar os passageiros de um voo de acordo com o número do voo\n15 - Listar todos os aviões" +
                            "\n17 - Listar todos os passageiros", "Vá Com Deus", 3));

            switch (opcao) {
                case 1:
                    menuCadastrarAviao();
                    break;
                case 2:
                    menuEditarAviao();
                    break;
                case 3:
                    menuRemoverAviao();
                    break;
                case 4:
                    menuCadastrarPassageiro();
                    break;
                case 5:
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
                    Aeroporto.listarVoos();
                    break;
                case 11:
                    String data = JOptionPane.showInputDialog(null, "Digite a data que deseja");
                    Aeroporto.listarVoosData(Aeroporto.StringToDate(data));
                    break;
                case 12:
                    Aeroporto.listarVoosData(Aeroporto.dataAtual());
                    break;
                case 13:
                    //menuListarVoosPassageiro();
                    break;
                case 14: //Listar os passageiros de um voo de acordo com o número do voo

                    break;
                case 15:
                    Aeroporto.listarAvioes();
                    break;
                case 16:
                    Aeroporto.listarPassageiros();
                    break;
                default:
                    break;
            }
        } while (opcao <= 20);
    }
}

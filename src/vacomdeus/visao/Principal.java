package vacomdeus.visao;

import vacomdeus.dao.Companhia;
import vacomdeus.modelo.*;
import vacomdeus.dao.Aeroporto;

import javax.swing.JOptionPane;
import java.text.ParseException;


public class Principal {

    /*AVIÃO*/
    public static void menuCadastrarAviao() {
        Aviao aviao = new Aviao();/*apagar */
        String aux = Aeroporto.listarCompanhias();
        String companhia = JOptionPane.showInputDialog(null, aux + "\nCompanhia:", "Cadastro Avião", 3);
        if (Aeroporto.existeCompanhia(companhia) == false) {
            Aeroporto.cadastraCompanhia(companhia);
        }
        String id;
        do {
            id = JOptionPane.showInputDialog(null, "ID", "Cadastro Avião", 3);
        } while (Aeroporto.existeIdAviao(id, companhia));
        aviao.setId(id);
        aviao.setCompanhia(companhia);
        aviao.setAltura(Double.parseDouble(JOptionPane.showInputDialog(null, "Altura em metros", "Cadastro Avião", 3)));
        aviao.setAutonomia(Double.parseDouble(JOptionPane.showInputDialog(null, "Autonomia em km", "Cadastro Avião", 3)));
        aviao.setComprimento(Double.parseDouble(JOptionPane.showInputDialog(null, "Comprimento em metros", "Cadastro Avião", 3)));
        aviao.setCapacidadePassageiros(Integer.parseInt(JOptionPane.showInputDialog(null, "Capacidade Passageiros", "Cadastro Avião", 3)));
        aviao.setTamanhoEnvergaduraAsa(Double.parseDouble(JOptionPane.showInputDialog(null, "Tamanho envergadura Asas", "Cadastro Avião", 3)));
        if ((Aeroporto.cadastrarAviao(aviao, companhia)) == true) {
            JOptionPane.showMessageDialog(null, "Avião Cadastrado com sucesso", "Cadastro Avião", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Erro - Avião não cadastrado", "Cadastro Avião", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void menuRemoverAviao() { /*passar para aeroporto*/
        String aux = Aeroporto.listarCompanhias();
        String companhia;
        do {
            companhia = JOptionPane.showInputDialog(null, aux + "\nCompanhia do Avião a ser Excluído", "Excluir Avião", JOptionPane.QUESTION_MESSAGE);
        } while (!Aeroporto.existeCompanhia(companhia));
        String id = JOptionPane.showInputDialog(null, "ID do Avião a ser Excluído", "Excluir Avião", JOptionPane.QUESTION_MESSAGE);
        Companhia c = Aeroporto.getCompanhia(companhia);
        if (c.removeAviao(id) == true) {
            JOptionPane.showMessageDialog(null, "Avião removido com sucesso", "Excluir Avião", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Erro - Avião não removido", "Excluir Avião", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void menuEditarAviao() {
        String aux = Aeroporto.listarCompanhias();
        String companhia;
        do {
            companhia = JOptionPane.showInputDialog(null, aux + "\nCompanhia do Avião a ser Editado", "Excluir Avião", JOptionPane.QUESTION_MESSAGE);
        } while (!Aeroporto.existeCompanhia(companhia));
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
            Aeroporto.editaAviao(aviao, companhia);
            if ((Aeroporto.editaAviao(aviao, companhia)) == true) {
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
        } while (Aeroporto.existeVoo(numeroVoo));
        voo.setNumeroVoo(numeroVoo);
        String companhia;
        do {
            companhia = JOptionPane.showInputDialog(null, "Companhia Aerea", "Cadastro Voo", JOptionPane.QUESTION_MESSAGE);
        } while (!Aeroporto.existeCompanhia(companhia));
        voo.setCompanhiaAerea(companhia);
        String idAviao;
        do {
            idAviao = JOptionPane.showInputDialog(null, "ID do avião da companhia " + companhia, "Cadastro Voo", JOptionPane.QUESTION_MESSAGE);
        } while (!Aeroporto.existeIdAviao(idAviao, companhia));
        voo.setidAviao(idAviao);
        String dataHora = JOptionPane.showInputDialog(null, "Data e Horário dd/mm/aaaa hh:mm", "Cadastro Voo", JOptionPane.QUESTION_MESSAGE);
        voo.setDataHorario(Aeroporto.StringToDateHour(dataHora));
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
        if ((Aeroporto.cadastrarVoos(voo, companhia)) == true) {
            JOptionPane.showMessageDialog(null, "Voo Cadastrado com sucesso", "Cadastro Voo", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Erro - Voo não cadastrado", "Cadastro Voo", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void menuRemoverVoo() {
        int aux = Integer.parseInt(JOptionPane.showInputDialog(null, "Número do Voo", "Remover Voo", 3));
        if ((Aeroporto.removeVoo(aux)) == true) {
            JOptionPane.showMessageDialog(null, "Voo removido com sucesso", "Remover Voo", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Erro - Voo não removido, não existe", "Remover Voo", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void menuEditarVoo() {
        Voo voo = new Voo();
        String companhia;
        do {
            companhia = JOptionPane.showInputDialog(null, "Companhia Aerea", "Editar Voo", 3);
        } while (!Aeroporto.existeCompanhia(companhia));
        voo.setCompanhiaAerea(companhia);
        String id;
        do {
            id = (JOptionPane.showInputDialog(null, "ID do avião da companhia " + companhia + " a ser editado", "Editar Voo", 3)); //id do aviao
        } while (!Aeroporto.existeIdAviao(id, companhia));
        voo.setidAviao(id);
        voo.setNumeroVoo(Integer.parseInt(JOptionPane.showInputDialog(null, "Número do Voo", "Editar Voo", 3)));
        String dataHorario = JOptionPane.showInputDialog(null, "Data e Horaŕio", "Editar Voo", 3);
        voo.setDataHorario(Aeroporto.StringToDateHour(dataHorario));
        voo.setOrigem((JOptionPane.showInputDialog(null, "Origem", "Editar Voo", 3)));
        voo.setDestino((JOptionPane.showInputDialog(null, "Destino", "Editar Voo", 3)));
        int aux;
        aux = Integer.parseInt(JOptionPane.showInputDialog(null, "Status Voo", "Editar Voo", 3));
        if (aux == (1)) {
            voo.setStatusVoo(StatusVoo.CONFIRMADO);
        }
        if (aux == (2)) {
            voo.setStatusVoo(StatusVoo.CANCELADO);
        }
        if (aux == (3)) {
            voo.setStatusVoo(StatusVoo.ATRASADO);
        }
        if ((Aeroporto.editaVoo(voo, companhia)) == true) {
            JOptionPane.showMessageDialog(null, "Voo editado com sucesso", "Editar Voo", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Erro - Voo não editado, não existe", "Editar Voo", JOptionPane.ERROR_MESSAGE);
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
        passageiro.setTelefone(JOptionPane.showInputDialog(null, "Telefone:", "Cadastro Passageiro", 3));
        int numeroVoo;
        do {
            numeroVoo = Integer.parseInt(JOptionPane.showInputDialog(null, "Número do Voo:", "Cadastro Passageiro", 3));
        } while (!Aeroporto.existeVoo(numeroVoo));
        passageiro.setNumeroVoo(numeroVoo);
        if ((Aeroporto.cadastrarPassageiros(passageiro)) == true) {
            JOptionPane.showMessageDialog(null, "Passageiro Cadastrado com sucesso", "Cadastro Passageiro", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Erro - Passageiro não cadastrado", "Cadastro Passageiro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void menuRemoverPassageiro() {
        //Passageiro passageiro = new Passageiro();
        //passageiro.setNome(JOptionPane.showInputDialog(null, "Nome", "Remover Passageiro", 3));
        String cpf;
        do {
            cpf = JOptionPane.showInputDialog(null, "CPF", "Remover Passageiro", 3);
        } while (Aeroporto.validarCPF(cpf) == false);
        /*passageiro.setCpf(cpf);
        String aux = JOptionPane.showInputDialog(null, "Data de Nascimento", "Remover Passageiro", 3);
        passageiro.setDataNascimento(Aeroporto.StringToDate(aux));
        String email;
        do {
            email = JOptionPane.showInputDialog(null, "Email", "Remover Passageiro", 3);
        } while (Aeroporto.validarEmail(email) == false);
        passageiro.setEmail(email);
        passageiro.setTelefone(JOptionPane.showInputDialog(null, "Telefone", "Remover Passageiro", 3));
        passageiro.setNumeroVoo(Integer.parseInt(JOptionPane.showInputDialog(null, "Número do Voo", "Remover Passageiro", 3)));
        */
        if ((Aeroporto.removePassageiro(cpf)) == true) {
            JOptionPane.showMessageDialog(null, "Passageiro removido com sucesso", "Remover Passageiro", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Erro - Passageiro não removido", "Remover Passageiro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void menuEditarPassageiro() {
        Passageiro passageiro = new Passageiro();
        String cpf;
        do {
            cpf = JOptionPane.showInputDialog(null, "CPF do Passageiro", "Editar Passageiro", 3);
        } while (Aeroporto.validarCPF(cpf) == false);
        passageiro.setCpf(cpf);
        passageiro = Aeroporto.getPassageiro(cpf);
        passageiro.setNome(JOptionPane.showInputDialog(null, passageiro.getNome(), "Editar Passageiro", 3));
        String email;
        do {
            email = JOptionPane.showInputDialog(null, passageiro.getEmail(), "Editar Passageiro", 3);
        } while (Aeroporto.validarEmail(email) == false);
        passageiro.setEmail(email);
        passageiro.setTelefone(JOptionPane.showInputDialog(null, passageiro.getTelefone(), "Editar Passageiro", 3));
        passageiro.setNumeroVoo(Integer.parseInt(JOptionPane.showInputDialog(null, passageiro.getNumeroVoo(), "Remover Passageiro", 3)));
        if ((Aeroporto.editaPassageiro(passageiro)) == true) {
            JOptionPane.showMessageDialog(null, "Passageiro editado com sucesso", "Editar Passageiro", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Erro - Passageiro não editado", "Editar Passageiro", JOptionPane.ERROR_MESSAGE);
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
                            "\n17 - Listar todos os passageiros\n18 - Exportar Dados Avioes (tem que colocar dos Voos e passageiros)\n19 - Importar Dados", "Vá Com Deus", 3));

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
                    menuEditarPassageiro();
                    break;
                case 6:
                    menuRemoverPassageiro();
                    break;
                case 7:
                    menuCadastrarVoo();
                    break;
                case 8:
                    menuEditarVoo();
                    break;
                case 9:
                    menuRemoverVoo();
                    break;
                case 10:
                    Aeroporto.listarVoos();
                    break;
                case 11:
                    String data = JOptionPane.showInputDialog(null, "Digite a data que deseja");
                    Aeroporto.listarVoosData(Aeroporto.StringToDateHour(data));
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
                case 18:
                    String nomeArq = JOptionPane.showInputDialog(null, "O nome do arquivo ");
                    Aeroporto.exportarDadosAvioes(nomeArq);

                    break;
                case 19:
                    String nomeArqImportar = JOptionPane.showInputDialog(null, "O nome do arquivo ");
                    Aeroporto.importarDadosAviao(nomeArqImportar);

                default:
                    break;
            }
        } while (opcao <= 20);
    }
}

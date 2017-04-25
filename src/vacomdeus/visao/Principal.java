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
        String companhia = JOptionPane.showInputDialog(null, "Companhias já cadastradas: " + aux + "\nCompanhia:", "Cadastro Avião", 3);
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
            companhia = JOptionPane.showInputDialog(null, "Companhias cadastradas: " + aux + "\nCompanhia do Avião a ser Excluído", "Excluir Avião", JOptionPane.QUESTION_MESSAGE);
        } while (!Aeroporto.existeCompanhia(companhia));
        String id = JOptionPane.showInputDialog(null, "ID do Avião a ser Excluído", "Excluir Avião", JOptionPane.QUESTION_MESSAGE);
        Companhia c = Aeroporto.getCompanhia(companhia);
        if (Aeroporto.removeAviao(id, companhia) == true) {
            JOptionPane.showMessageDialog(null, "Avião removido com sucesso", "Excluir Avião", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Erro - Avião não removido", "Excluir Avião", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void menuEditarAviao() {
        String aux = Aeroporto.listarCompanhias();
        String companhia;
        do {
            companhia = JOptionPane.showInputDialog(null, "Companhias cadastradas: " + aux + "\nCompanhia do Avião a ser Editado", "Excluir Avião", JOptionPane.QUESTION_MESSAGE);
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
        if (Aeroporto.existeAviaoCadastrado() == true) {
            String c = Aeroporto.listarCompanhias();
            Voo voo = new Voo();
            int numeroVoo;
            do {
                numeroVoo = Integer.parseInt(JOptionPane.showInputDialog(null, "Número do Voo", "Cadastro Voo", JOptionPane.QUESTION_MESSAGE));
            } while (Aeroporto.existeVoo(numeroVoo));
            voo.setNumeroVoo(numeroVoo);
            String companhia;
            do {
                companhia = JOptionPane.showInputDialog(null, "Companhias cadastradas: " + c + "\nCompanhia do Voo a ser Cadastrado", "Cadastro Voo", JOptionPane.QUESTION_MESSAGE);
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
        } else
            JOptionPane.showMessageDialog(null, "Erro - Não a nenhum avião cadastrado", "Cadastro Voo", JOptionPane.ERROR_MESSAGE);
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
        String c = Aeroporto.listarCompanhias();
        do {
            companhia = JOptionPane.showInputDialog(null, "Companhias cadastradas: " + c + "\nCompanhia do Voo a ser editado", "Editar Voo", 3);
        } while (!Aeroporto.existeCompanhia(companhia));
        voo.setCompanhiaAerea(companhia);
        String id;
        do {
            id = (JOptionPane.showInputDialog(null, "ID do avião da companhia " + companhia + " a ser editado", "Editar Voo", 3)); //id do aviao
        } while (!Aeroporto.existeIdAviao(id, companhia));
        voo.setidAviao(id);
        int numeroVoo;
        do {
            numeroVoo = Integer.parseInt(JOptionPane.showInputDialog(null, "Número do Voo", "Editar Voo", 3));
        } while (!Aeroporto.exiteVooCompanhia(numeroVoo, companhia));
        voo.setNumeroVoo(numeroVoo);
        String dataHorario = JOptionPane.showInputDialog(null, "Data e Horaŕio", "Editar Voo", 3);
        voo.setDataHorario(Aeroporto.StringToDateHour(dataHorario));
        voo.setOrigem((JOptionPane.showInputDialog(null, "Origem", "Editar Voo", 3)));
        voo.setDestino((JOptionPane.showInputDialog(null, "Destino", "Editar Voo", 3)));
        voo.setCarga(Double.parseDouble(JOptionPane.showInputDialog(null, "Carga em toneladas", "Cadastro Voo", JOptionPane.QUESTION_MESSAGE)));
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
        String telefone;
        do {
            telefone = JOptionPane.showInputDialog(null, "Telefone (XXX)XXXX-XXXX:", "Cadastro Passageiro", 3);
        } while (Aeroporto.validarTelefone(telefone) == false);
        passageiro.setTelefone(telefone);
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
        passageiro.setNome(JOptionPane.showInputDialog(null, "Digite o nome atual", "Editar Passageiro", 3));
        String email;
        do {
            email = JOptionPane.showInputDialog(null, "Digite o email atual", "Editar Passageiro", 3);
        } while (Aeroporto.validarEmail(email) == false);
        passageiro.setEmail(email);
        passageiro.setTelefone(JOptionPane.showInputDialog(null, "Digite o telefone atual (XXX)XXXX-XXXX", "Editar Passageiro", 3));
        passageiro.setNumeroVoo(Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o número do voo", "Remover Passageiro", 3)));
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
                            + "4 - Listar todos Aviões\n\n5 - Cadastrar Voo\n6 - Editar Voo\n"
                            + "7 - Remover Voo\n8 - Listar todos Voos\n9 - Listar Voos por data\n10 - Listar Voos de hoje\n\n"
                            + "11 - Cadastrar Passageiro\n12 - Editar Passageiro\n13 - Remover Passageiro" +
                            "\n14 - Listar todos os passageiros\n15 - Listar todos os voos do passageiro" +
                            "\n16 - Listar passageiros do voo\n\n17 - Exportar dados Avioes " +
                            "\n18 - Exportar dados Voos" + "\n19 - Exportar dados Passageiros" +
                            "\n20 - Importar dados Avioes" + "\n21 - Importar dados Voos" +
                            "\n22 - Importar dados Passageiros" + "\n\n23 - Reiniciar dados Aeroporto", "Vá Com Deus", 3));

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
                    Aeroporto.listarAvioes();

                    break;
                case 5:
                    menuCadastrarVoo();
                    break;
                case 6:
                    menuEditarVoo();
                    break;
                case 7:
                    menuRemoverVoo();
                    break;
                case 8:
                    Aeroporto.listarVoos();
                    break;
                case 9:
                    String data = JOptionPane.showInputDialog(null, "Digite a data que deseja");
                    Aeroporto.listarVoosData(Aeroporto.StringToDateHour(data));
                    break;
                case 10:
                    Aeroporto.listarVoosData(Aeroporto.dataAtual());
                    break;
                case 11:
                    menuCadastrarPassageiro();
                    break;
                case 12:
                    menuEditarPassageiro();
                    break;
                case 13:
                    menuRemoverPassageiro();
                    break;
                case 14:
                    Aeroporto.listarPassageiros();
                    break;
                case 15:
                    //menuListarVoosPassageiro();
                    break;
                case 16:

                    break;
                case 17:
                    String nomeArquivoExportarAvioes = JOptionPane.showInputDialog(null, "O nome do arquivo ");
                    if (Aeroporto.exportarDadosAvioes(nomeArquivoExportarAvioes) == false) {
                        JOptionPane.showMessageDialog(null, "Erro ao exportar avioes");
                    } else {
                        JOptionPane.showMessageDialog(null, "Aviões exportados com sucesso");
                    }
                    break;
                case 18:
                    String nomeArquivoExportarVoos = JOptionPane.showInputDialog(null, "O nome do arquivo ");
                    if (Aeroporto.exportarDadosVoos(nomeArquivoExportarVoos) == false) {
                        JOptionPane.showMessageDialog(null, "Erro ao exportar voos");
                    } else {
                        JOptionPane.showMessageDialog(null, "Voos exportados com sucesso");
                    }
                    break;
                case 19:
                    String nomeArquivoExportarPassageiros = JOptionPane.showInputDialog(null, "O nome do arquivo ");
                    if (Aeroporto.exportarDadosPassageiros(nomeArquivoExportarPassageiros) == false) {
                        JOptionPane.showMessageDialog(null, "Erro ao exportar passageiros");
                    } else {
                        JOptionPane.showMessageDialog(null, "Passageiros exportados com sucesso");
                    }
                    break;
                case 20:
                    String nomeArqImportarAvioes = JOptionPane.showInputDialog(null, "O nome do arquivo ");
                    if (Aeroporto.importarDadosAviao(nomeArqImportarAvioes) == false) {
                        JOptionPane.showMessageDialog(null, "Erro ao importar avioes");
                    } else {
                        JOptionPane.showMessageDialog(null, "Avioes importados com sucesso");
                    }
                    break;
                case 21:
                    String nomeArqImportarVoos = JOptionPane.showInputDialog(null, "O nome do arquivo ");
                    if (Aeroporto.importarDadosVoo(nomeArqImportarVoos) == false) {
                        JOptionPane.showMessageDialog(null, "Erro ao importar voos");
                    } else {
                        JOptionPane.showMessageDialog(null, "Voos importados com sucesso");
                    }
                    break;
                case 22:
                    String nomeArqImportarPassageiros = JOptionPane.showInputDialog(null, "O nome do arquivo ");
                    if (Aeroporto.importarDadosPassageiro(nomeArqImportarPassageiros) == false) {
                        JOptionPane.showMessageDialog(null, "Erro ao importar passageiros");
                    } else {
                        JOptionPane.showMessageDialog(null, "Passageiros importados com sucesso");
                    }
                    break;

                default:
                    break;
            }
        } while (opcao <= 25);
    }
}

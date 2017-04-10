import sun.security.krb5.internal.crypto.dk.AesDkCrypto;

import javax.swing.JOptionPane;

public class Principal {

    public static void menuCadastrarAviao() {

        Aviao aviao = new Aviao();
        aviao.setId(JOptionPane.showInputDialog("Cadastro Avião\nID:"));
        aviao.setAltura(Double.parseDouble(JOptionPane.showInputDialog("Cadastro Avião\nAltura:")));
        aviao.setAutonomia(Double.parseDouble(JOptionPane.showInputDialog("Cadastro Avião\nAutonomia:")));
        aviao.setComprimento(Double.parseDouble(JOptionPane.showInputDialog("Cadastro Avião\nComprimento:")));
        aviao.setCapacidadeCarga(Double.parseDouble(JOptionPane.showInputDialog("Cadastro Avião\nCapacidade de Carga:")));
        aviao.setCapacidadePassageiros(Integer.parseInt(JOptionPane.showInputDialog("Cadastro Avião\nCapacidade Passageiros:")));
        Aeroporto.cadastrarAviao(aviao);
    }

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

        Aeroporto.cadastrarPassageiros(passageiro);
    }

    public static void main(String[] args) {
        String opcao;

        do {
            opcao = JOptionPane.showInputDialog("1 - Cadastrar Avião\n2 - Editar Avião\n3 - Excluir Avião\n"
                    + "4 - Cadastrar Passageiro\n5 - Editar Passageiro\n6 - Excluir Passageiro\n"
                    + "7 - Cadastrar Voo\n8 - Editar Voo\n9 - Excluir Voo\n10 ");
            if (opcao != null) {
                if (opcao.equals("1")) {
                    menuCadastrarAviao();
                } else if (opcao.equals("2")) {
                    // buscar(lista);
                } else if (opcao.equals("3")) {
                    // imprimir(lista);
                } else if (opcao.equals("3")) {
                    // imprimir(lista);
                } else if (opcao.equals("4")) {
                    menuCadastrarPassageiro();
                } else if (opcao.equals("5")) {
                    // imprimir(lista);
                } else if (opcao.equals("6")) {
                    // imprimir(lista);
                }
            }

        } while (opcao != null);
    }
}

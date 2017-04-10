import javax.swing.JOptionPane;

public class Principal {

    public static void menuCadastrarAviao() {

        Aviao aviao = new Aviao();
        aviao.setId(JOptionPane.showInputDialog("ID:"));
        aviao.setAltura(Double.parseDouble(JOptionPane.showInputDialog("Altura:")));
        aviao.setAutonomia(Double.parseDouble(JOptionPane.showInputDialog("Autonomia:")));
        aviao.setComprimento(Double.parseDouble(JOptionPane.showInputDialog("Comprimento:")));
        aviao.setCapacidadeCarga(Double.parseDouble(JOptionPane.showInputDialog("Capacidade de Carga:")));
        aviao.setCapacidadePassageiros(Integer.parseInt(JOptionPane.showInputDialog("Capacidade Passageiros:")));

    }

    public static void main(String[] args) {
        String opcao;

        do {
            opcao = JOptionPane.showInputDialog("1 - Cadastrar Avião\n2 - Editar Avião\n3 - Excluir Avião\n"
                    + "4 - Cadastrar Passageiro\n5 - Editar Passageiro\n6 - Excluir Passageiro\n"
                    + "7 - Cadastrar Voo\n8 - Editar Voo\n9 - Excluir Voo\n10");
            if (opcao != null) {
                if (opcao.equals("1")) {
                    // addAluno (lista);
                } else if (opcao.equals("2")) {
                    // buscar(lista);
                } else if (opcao.equals("3")) {
                    // imprimir(lista);
                }
            }
        } while (opcao != null);
    }
}

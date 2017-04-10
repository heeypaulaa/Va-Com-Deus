import javax.swing.JOptionPane;
// teste
public class Principal {

	public static void main (String[] args){
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


public class Principal {

    public static void main (String[] args){
        Aviao a1 = new Aviao(0.0, 0.0, 0.0, 0.0, 0.0, 10, "Jatinho");
        Aviao a2 = new Aviao(1.0, 1.0, 1.0, 0.0, 0.0, 10, "Jatinho");

        Aeroporto.cadastrarAviao(a1);
        Aeroporto.cadastrarAviao(a2);
        Aeroporto.listarAvioes();

        Aeroporto.editaAviao(a1);
        Aeroporto.listarAvioes();

        if (Aeroporto.removeAviao(a1) == true) {
            System.out.println("removeu");
        }
        Aeroporto.listarAvioes();
        
    }
}

package vacomdeus.modelo;

public enum StatusVoo {
    CONFIRMADO(1), CANCELADO(2), ATRASADO(3);
    private final int status;

    StatusVoo(int valor) {
        status = valor;
    }

    public int getStatus() {
        return status;
    }

}
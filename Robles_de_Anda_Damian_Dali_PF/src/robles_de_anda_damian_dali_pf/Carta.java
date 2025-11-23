package robles_de_anda_damian_dali_pf;

public class Carta {

    // * campos
    private String palo;
    private String valor;
    private int valorNumerico;

    // * constructor
    public Carta(String palo, String valor, int valorNumerico) {
        this.palo = palo;
        this.valor = valor;
        this.valorNumerico = valorNumerico;
    }

    // * getters
    public String getPalo() {
        return palo;
    }
    public String getValor() {
        return valor;
    }
    public int getValorNumerico() {
        return valorNumerico;
    }

    // * setters
    public void setPalo(String palo) {
        this.palo = palo;
    }
    public void setValor(String valor) {
        this.valor = valor;
    }
    public void setValorNumerico(int valorNumerico) {
        this.valorNumerico = valorNumerico;
    }

}

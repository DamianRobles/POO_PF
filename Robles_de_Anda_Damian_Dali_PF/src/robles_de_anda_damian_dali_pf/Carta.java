package robles_de_anda_damian_dali_pf;

public class Carta {

    // * campos
    private String palo;
    private String valor;
    private int valorNumerico;
    private String cartaGrafica;

    // * constructor
    public Carta(String palo, String valor, int valorNumerico, String cartaGrafica) {
        this.palo = palo;
        this.valor = valor;
        this.valorNumerico = valorNumerico;
        this.cartaGrafica = cartaGrafica;
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
    public String getCartaGrafica() {
        return cartaGrafica;
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
    public void setCartaGrafica(String cartaGrafica) {
        this.cartaGrafica = cartaGrafica;
    }

}

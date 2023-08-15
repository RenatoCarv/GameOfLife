public class Celula {
    private boolean viva;

    public Celula(boolean viva) {
        this.viva = viva;
    }

    public boolean estaViva() {
        return viva;
    }

    public void setViva(boolean viva) {
        this.viva = viva;
    }
}
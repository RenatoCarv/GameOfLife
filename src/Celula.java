/**
 * Esta classe representa uma célula no contexto do Jogo da Vida.
 */
public class Celula {

    /**
     * Cria uma instância de célula com o estado de vida especificado.
     */
    private final boolean viva;

    /**
     * Verifica se a célula está viva.
     *
     */
    public Celula(boolean viva) {
        this.viva = viva;
    }

    public boolean estaViva() {
        return viva;
    }
}
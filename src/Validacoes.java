/**
 * Esta classe é responsável por verificar e interpretar os argumentos da linha de comando para o
 * Jogo da Vida.
 */
public class Validacoes {
    private int linhas = 10;
    private int colunas = 10;
    private int geracoes = 5;
    private int velocidade = 300;
    private String populacao = null;

    /**
     * Verifica e interpreta os argumentos da linha de comando.
     *
     * @param args Argumentos da linha de comando.
     * @return True se a análise dos argumentos passar ok, false caso contrário.
     */
    public boolean VerificarPartes(String[] args) {
        for (String arg : args) {
            String[] partes = arg.split("=");
            if (partes.length == 2) {
                String parametro = partes[0];
                String valor = partes[1];

                if (parametro.equals("w") && Utils.ehInteiroValido(valor)) {
                    colunas = Integer.parseInt(valor);
                } else if (parametro.equals("h") && Utils.ehInteiroValido(valor)) {
                    linhas = Integer.parseInt(valor);
                } else if (parametro.equals("g") && Utils.ehInteiroValido(valor)) {
                    geracoes = Integer.parseInt(valor);
                } else if (parametro.equals("s") && Utils.ehInteiroValido(valor)) {
                    velocidade = Integer.parseInt(valor);
                } else if (parametro.equals("p")) {
                    populacao = valor;
                } else {
                    return false; // Argumento inválido
                }
            } else {
                return false; // Argumento no formato inválido
            }
        }
        return true; // Análise bem-sucedida
    }

    /**
     * Verifica se os parâmetros são válidos.
     *
     * @return true se os parâmetros forem válidos, false caso contrário.
     */
    public boolean saoParametrosValidos() {
        return colunas > 0 && linhas > 0 && geracoes > 0 && velocidade > 0;
    }

    /**
     * Imprime informações sobre parâmetros inválidos.
     */
    public void ParametrosInvalidos() {
        if (colunas <= 0) System.out.println("colunas = [Não Presente]");
        if (linhas <= 0) System.out.println("linhas = [Não Presente]");
        if (geracoes <= 0) System.out.println("gerações = [Não Presente]");
        if (velocidade <= 0) System.out.println("velocidade = [Não Presente]");
        System.out.println("população = [" + (populacao != null ? populacao : "Não Presente") + "]");
    }

    /**
     * Cria uma instância do jogo com base nos parâmetros.
     *
     * @return Uma instância do jogo GameOfLife com os parâmetros fornecidos.
     */
    public GameOfLife criarInstanciaJogoDaVida() {
        if (populacao != null) {
            return new GameOfLife(colunas, linhas, geracoes, velocidade, populacao);
        } else {
            return new GameOfLife(colunas, linhas, geracoes, velocidade);
        }
    }
}

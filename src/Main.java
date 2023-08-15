/**
 * Esta classe representa o ponto de entrada principal para o programa de simulação do Jogo da Vida.
 * Ela recebe argumentos da linha de comando, verifica-os e executa a simulação.
 */
public class Main {
    /**
     * Método principal do programa.
     *
     * @param args Argumentos da linha de comando fornecidos ao programa.
     */
    public static void main(String[] args) {

        Validacoes validacoes = new Validacoes();
        if (!validacoes.VerificarPartes(args)) {
            return;
        }

        if (!validacoes.saoParametrosValidos()) {
            System.out.println("Parâmetros inválidos fornecidos.");
            validacoes.ParametrosInvalidos();
            System.out.println("Uso: java Principal w=<linhas> h=<colunas> g=<geracoes> s=<velocidade> p=<padrao>");
            return;
        }

        GameOfLife jogo = validacoes.criarInstanciaJogoDaVida();
        jogo.simularGeracoes();
    }
}


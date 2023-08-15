/**
 * Esta classe representa o simulador do Jogo da Vida, que evolui a população de células através de
 * várias gerações.
 */
public class GameOfLife {
    private final int geracoes;
    private final int atrasoMs;
    private final Grade grade;

    /**
     * Cria uma instância do simulador do Jogo da Vida com os parâmetros fornecidos.
     *
     * @param linhas     O número de linhas da grade.
     * @param colunas    O número de colunas da grade.
     * @param geracoes   O número de gerações a serem simuladas.
     * @param atrasoMs   O atraso em milissegundos entre as gerações simuladas.
     */
    public GameOfLife(int linhas, int colunas, int geracoes, int atrasoMs) {
        this.geracoes = geracoes;
        this.atrasoMs = atrasoMs;
        this.grade = new Grade(linhas, colunas);
    }

    /**
     * Cria uma instância do simulador do Jogo da Vida com os parâmetros fornecidos e um padrão de
     * população inicial.
     *
     * @param linhas     O número de linhas da grade.
     * @param colunas    O número de colunas da grade.
     * @param geracoes   O número de gerações a serem simuladas.
     * @param atrasoMs   O atraso em milissegundos entre as gerações simuladas.
     * @param padrao     A representação do padrão de população inicial como uma sequência de caracteres.
     */
    public GameOfLife(int linhas, int colunas, int geracoes, int atrasoMs, String padrao) {
        this.geracoes = geracoes;
        this.atrasoMs = atrasoMs;
        this.grade = new Grade(linhas, colunas, padrao);
    }

    /**
     * Simula a evolução das gerações do Jogo da Vida.
     */
    public void simularGeracoes() {
        for (int geracao = 0; geracao < geracoes; geracao++) {
            grade.imprimirGrade(geracao);
            grade.evoluirGrade();

            for (int i = 0; i < atrasoMs * 1000; i++) {
            }
        }
    }
}
import java.util.Random;
/**
 * Esta classe representa uma grade retangular composta por células do Jogo da Vida.
 */
public class Grade {
    private Celula[][] grade;
    private final int linhas;
    private final int colunas;

    /**
     * Cria uma nova instância da classe Grade com as dimensões especificadas e população inicial fornecida.
     *
     * @param linhas     O número de linhas da grade.
     * @param colunas    O número de colunas da grade.
     * @param populacao  A representação da população inicial da grade (quando passamos valores via CLI).
     */
    public Grade(int linhas, int colunas, String populacao) {
        this.linhas = linhas;
        this.colunas = colunas;
        this.grade = new Celula[linhas][colunas];
        inicializarGrade(populacao);
    }

    /**
     * Cria uma nova instância da classe Grade com as dimensões especificadas e população inicial aleatória.
     *
     * @param linhas  O número de linhas da grade.
     * @param colunas O número de colunas da grade.
     */
    public Grade(int linhas, int colunas) {
        this.linhas = linhas;
        this.colunas = colunas;
        this.grade = new Celula[linhas][colunas];
        inicializarGradeAleatoria();
    }

    /**
     * Inicializa a grade com base na representação de população fornecida via CLI.
     *
     * @param populacao A representação da população inicial da grade (quando passamos valores via CLI).
     */

    private void inicializarGrade(String populacao) {
        String[] linhasPopulacao = populacao.split("#");

        for (int i = 0; i < linhas; i++) {
            String linhaAtual = i < linhasPopulacao.length ? linhasPopulacao[i] : "";

            for (int j = 0; j < colunas; j++) {
                char estadoCelula = (j < linhaAtual.length()) ? linhaAtual.charAt(j) : '0';
                grade[i][j] = new Celula(estadoCelula == '1');
            }
        }
    }

    /**
     * Inicializa a grade com células aleatórias vivas ou mortas.
     */
    private void inicializarGradeAleatoria() {
        Random random = new Random();
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                grade[i][j] = new Celula(random.nextBoolean());
            }
        }
    }

    /**
     * Imprime o estado atual da grade.
     *
     * @param geracao O número da geração atual.
     */
    public void imprimirGrade(int geracao) {
        System.out.println("Geração " + geracao + ":");
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                System.out.print(grade[i][j].estaViva() ? "■ " : "□ ");
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Evolui a grade para a próxima geração de acordo com as regras do Jogo da Vida.
     */
    public void evoluirGrade() {
        Celula[][] novaGrade = new Celula[linhas][colunas];

        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                int vizinhosVivos = contarVizinhosVivos(i, j);
                if (grade[i][j].estaViva()) {
                    novaGrade[i][j] = new Celula(vizinhosVivos == 2 || vizinhosVivos == 3);
                } else {
                    novaGrade[i][j] = new Celula(vizinhosVivos == 3);
                }
            }
        }

        grade = novaGrade;
    }

    /**
     * Conta o número de células vizinhas vivas para uma determinada célula.
     *
     * @param x A posição x da célula na grade.
     * @param y A posição y da célula na grade.
     * @return O número de células vizinhas vivas.
     */
    private int contarVizinhosVivos(int x, int y) {
        int contadorVivos = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue;
                int novoX = x + i;
                int novoY = y + j;
                if (novoX >= 0 && novoX < linhas && novoY >= 0 && novoY < colunas && grade[novoX][novoY].estaViva()) {
                    contadorVivos++;
                }
            }
        }
        return contadorVivos;
    }
}

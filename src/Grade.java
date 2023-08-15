import java.util.Random;

public class Grade {
    private Celula[][] grade;
    private final int linhas;
    private final int colunas;

    public Grade(int linhas, int colunas, String populacao) {
        this.linhas = linhas;
        this.colunas = colunas;
        this.grade = new Celula[linhas][colunas];
        inicializarGrade(populacao);
    }

    public Grade(int linhas, int colunas) {
        this.linhas = linhas;
        this.colunas = colunas;
        this.grade = new Celula[linhas][colunas];
        inicializarGradeAleatoria();
    }

    private void inicializarGrade(String populacao) {
        String[] linhasPopulacao = populacao.split("#");
        for (int i = 0; i < linhas; i++) {
            String linhaAtual = i < linhasPopulacao.length ? linhasPopulacao[i] : "";
            if (linhaAtual.isEmpty()) {
                linhaAtual = "0".repeat(colunas);
            } else if (linhaAtual.length() < colunas) {
                linhaAtual = linhaAtual + "0".repeat(colunas - linhaAtual.length());
            }

            for (int j = 0; j < colunas; j++) {
                char estadoCelula = linhaAtual.charAt(j);
                grade[i][j] = new Celula(estadoCelula == '1');
            }
        }
    }

    private void inicializarGradeAleatoria() {
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                grade[i][j] = new Celula(Math.random() < 0.5);
            }
        }
    }

    private String gerarPopulacaoAleatoria(int tamanho) {
        StringBuilder populacaoAleatoria = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < tamanho; i++) {
            populacaoAleatoria.append(random.nextInt(2));
        }
        return populacaoAleatoria.toString();
    }

    public void imprimirGrade() {
        System.out.println("Nova Grade:");
        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                System.out.print(grade[i][j].estaViva() ? "⭓" : "⭔");
            }
            System.out.println();
        }
        System.out.println();
    }

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

public class GameOfLife {
    private final int geracoes;
    private final int atrasoMillis;
    private final Grade grade;

    public GameOfLife(int linhas, int colunas, int geracoes, int atrasoMillis) {
        this.geracoes = geracoes;
        this.atrasoMillis = atrasoMillis;
        this.grade = new Grade(linhas, colunas);
    }

    public GameOfLife(int linhas, int colunas, int geracoes, int atrasoMillis, String padrao) {
        this.geracoes = geracoes;
        this.atrasoMillis = atrasoMillis;
        this.grade = new Grade(linhas, colunas, padrao);
    }

    public void simularGeracoes() throws InterruptedException {
        for (int geracao = 0; geracao < geracoes; geracao++) {
            grade.imprimirGrade();
            grade.evoluirGrade();
            Thread.sleep(atrasoMillis);
        }
    }
}
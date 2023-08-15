public class Main {
    public static void main(String[] args) throws InterruptedException {
        int largura = 0;
        int altura = 0;
        int geracoes = 0;
        int velocidade = 0;
        String populacao = null;

        boolean parametrosValidos = true;

        for (String arg : args) {
            String[] partes = arg.split("=");
            if (partes.length != 2) {
                parametrosValidos = false;
                break;
            }

            String parametro = partes[0];
            String valor = partes[1];

            if (parametro.equals("w") && Utils.ehInteiroValido(valor)) {
                largura = Integer.parseInt(valor);
            } else if (parametro.equals("h") && Utils.ehInteiroValido(valor)) {
                altura = Integer.parseInt(valor);
            } else if (parametro.equals("g") && Utils.ehInteiroValido(valor)) {
                geracoes = Integer.parseInt(valor);
            } else if (parametro.equals("s") && Utils.ehInteiroValido(valor)) {
                velocidade = Integer.parseInt(valor);
            } else if (parametro.equals("p")) {
                populacao = valor;
            } else {
                parametrosValidos = false;
                System.out.println("Chave ou valor inválido: " + arg);
            }
        }

        if (!parametrosValidos || largura <= 0 || altura <= 0 || geracoes <= 0 || velocidade <= 0) {
            System.out.println("Parâmetros inválidos fornecidos.");
            if (largura <= 0) System.out.println("largura = [Não Presente]");
            if (altura <= 0) System.out.println("altura = [Não Presente]");
            if (geracoes <= 0) System.out.println("gerações = [Não Presente]");
            if (velocidade <= 0) System.out.println("velocidade = [Não Presente]");
            System.out.println("população = [" + (populacao != null ? populacao : "Não Presente") + "]");
            System.out.println("Uso: java Main w=<linhas> h=<colunas> g=<geracoes> s=<velocidade> p=<padrao>");
            return;
        }

        if (populacao == null) {
            populacao = Utils.gerarPopulacaoAleatoria(largura * altura);
        } else if (populacao.length() < largura * altura) {
            populacao = populacao + "0".repeat(largura * altura - populacao.length());
        }

        GameOfLife jogo = new GameOfLife(largura, altura, geracoes, velocidade, populacao);
        jogo.simularGeracoes();
    }
}
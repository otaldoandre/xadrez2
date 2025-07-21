package Code;

public class Peao extends Peca {

    private int linhaO, colunaO, linhaD, colunaD;

    public Peao(int c, Jogador j) {
        super(c, j);
    }

    public boolean movimentoValido(int lo, int co, int ld, int cd) {

        linhaO = lo;
        colunaO = co;
        linhaD = ld;
        colunaD = cd;

        int direcao;

        if (linhaD > 7 || colunaD > 7 || linhaD < 0 || colunaD < 0) {
            return false;
        }

        if (this.cor == 0) {
            direcao = 1;
        } else {
            direcao = -1;
        }

        int diferencaColuna = colunaD - colunaO;
        int diferencaLinha = linhaD - linhaO;

        if (diferencaColuna == 0) {

            // 1 - Avança 2 casas da posição inicial
            if (diferencaLinha == 2 * direcao) {
                // int linhaIntermediaria = linhaO + direcao;
                boolean posInicial = (this.cor == 0 && linhaO == 6) || (this.cor == 1 && linhaO == 1);
                if (posInicial) {
                    return true;
                }
            }

        } else if (Math.abs(diferencaColuna) == 1) {

            // 2 - Avança 1 casa para frente
            if (diferencaLinha == direcao)
                return true;

        }

        return false;

    }

    public String caminho() {
        if (!this.movimentoValido(linhaO, colunaO, linhaD, colunaD)) {
            return "";
        }

        String origem = (8 - linhaO) + "" + (char) ('a' + colunaO);
        String destino = (8 - linhaD) + "" + (char) ('a' + colunaD);
        String meio = "";

        if (Math.abs(linhaD - linhaO) == 2 && colunaO == colunaD) {
            int direcaoLinha;

            if (linhaO < linhaD) {
                direcaoLinha = 1;
            } else {
                direcaoLinha = -1;
            }
            int passoLinha = linhaO + direcaoLinha;
            meio += (8 - passoLinha) + "" + (char) ('a' + colunaD);

        }
        return origem + meio + destino;
    }

    public String Desenho() {

        return "♟";
    }

}

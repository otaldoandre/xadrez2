package Code;

public class Cavalo extends Peca {

    private int linhaO, colunaO, linhaD, colunaD;

    public Cavalo(int c, Jogador j) {
        super(c, j);
    }

    public boolean movimentoValido(int lo, int co, int ld, int cd) {

        linhaO = lo;
        colunaO = co;
        linhaD = ld;
        colunaD = cd;
        
        if (ld > 7 || cd > 7 || ld < 0 || cd < 0) {
            return false;
        }

        int diferencaColuna = Math.abs(cd - co);
        int diferencaLinha = Math.abs(ld - lo);

        if (diferencaLinha == 2 && diferencaColuna == 1 || diferencaLinha == 1 && diferencaColuna == 2) {
            return true;
        } else {
            return false;
        }
    }

    public String caminho() {

        String origem = (8 - linhaO) + "" + (char) ('a' + colunaO);
        String destino = (8 - linhaD) + "" + (char) ('a' + colunaD);

        return origem + destino;

    }

    public String Desenho() {

        return "♞";
    }
}

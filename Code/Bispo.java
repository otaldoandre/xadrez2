package Code;

public class Bispo extends Peca {

    private int linhaO, colunaO, linhaD, colunaD;

    public Bispo(int c, Jogador j) {
        super(c, j);
    }

 public boolean movimentoValido(int lo, int co, int ld, int cd) {

        linhaO = lo;
        colunaO = co;
        linhaD = ld;
        colunaD = cd;
        
        if (linhaD > 7 || colunaD > 7 || linhaD < 0 || colunaD < 0) {
            return false;
        }

        int diferencaColuna = Math.abs(colunaD - colunaO);
        int diferencaLinha = Math.abs(linhaD - linhaO);

        return (diferencaLinha == diferencaColuna);
    }

    public String caminho() {
        if (!this.movimentoValido(linhaO, colunaO, linhaD, colunaD)) {
            return "";
        }
        String origem = (8 - linhaO) + "" + (char) ('a' + colunaO);
        String destino = (8 - linhaD) + "" + (char) ('a' + colunaD);


        return origem + destino;

    }

    public String Desenho() {

        return "♝";
    }

}

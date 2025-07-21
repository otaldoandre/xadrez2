package Code;

public class Torre extends Peca {

    private int linhaO, colunaO, linhaD, colunaD;

    public Torre(int c, Jogador j) {
        super(c, j);
    }

 public boolean movimentoValido(int lo, int co, int ld, int cd) {

        linhaO = lo;
        colunaO = co;
        linhaD = ld;
        colunaD = cd;
        
        if (linhaD > 7 || colunaD > 7 || linhaD < 0 || colunaD < 0) {
            return false;
        } else {
            return (linhaO == linhaD || colunaO == colunaD);
        }

    }

    public String caminho() {
        if (!this.movimentoValido(linhaO, colunaO, linhaD, colunaD)) {
            return "";
        }
        String meio = "";
        String origem = (8 - linhaO) + "" + (char) ('a' + colunaO);
        String destino = (8 - linhaD) + "" + (char) ('a' + colunaD);
        if (linhaO == linhaD) {
            int comeco = Math.min(colunaO, colunaD) + 1;
            int fim = Math.max(colunaO, colunaD);

            for (int i = comeco; i < fim; i++) {
                meio += (8 - linhaO) + "" + (char) ('a' + i);
            }
        } else if (colunaO == colunaD) {
            int comeco  = Math.min(linhaO, linhaD) + 1;
            int fim = Math.max(linhaO, linhaD);

            for (int i = comeco ; i < fim; i++) {
                meio += (8 - i) + "" + (char) ('a' + colunaO);
            }
        }

        return origem + meio + destino;
    }

    public String Desenho() {

        return "♜";
    }

}

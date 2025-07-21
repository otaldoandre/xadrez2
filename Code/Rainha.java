package Code;

public class Rainha extends Peca {

    private int linhaO, colunaO, linhaD, colunaD;

    public Rainha(int c, Jogador j) {
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

        return (linhaO == linhaD || colunaO == colunaD) || (diferencaLinha == diferencaColuna);
    }

    public String caminho() {
        if (!this.movimentoValido(linhaO, colunaO, linhaD, colunaD)) {
            return "";
        }
        String meio = "";
        String origem = (8 - linhaO) + "" + (char) ('a' + colunaO);
        String destino = (8 - linhaD) + "" + (char) ('a' + colunaD);
        int diferencaColuna = Math.abs(colunaD - colunaO);
        int diferencaLinha = Math.abs(linhaD - linhaO);

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
        }else if (diferencaLinha == diferencaColuna){
            int direcaoLinha;
            int direcaoColuna;
            if (linhaO < linhaD){
                direcaoLinha = 1;
            }
            else {
                direcaoLinha = -1;
            }

            if (colunaO < colunaD){
                direcaoColuna = 1;
            }
            else {
                direcaoColuna = -1;
            }

            int passoLinha = linhaO + direcaoLinha ;
            int passoColuna = colunaO + direcaoColuna;

            while (passoLinha != linhaD &&  passoColuna != colunaD) {
                meio += (8 - passoLinha) + "" + (char) ('a' + passoColuna);
                passoLinha = passoLinha + direcaoLinha;
                passoColuna = passoColuna + direcaoColuna;
            }



        }

        return origem + meio + destino;

    }

    public String Desenho() {

        return "♛";
    }
    
}

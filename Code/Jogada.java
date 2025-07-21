package Code;

public class Jogada {

    private int linhaO, colunaO, linhaD, colunaD;

    public final Jogador autor;
    public final Casa casaInicial, casaFinal;
    public Caminho caminho;

    public Jogada() {

        autor = new Jogador();
        casaInicial = new Casa(0);
        casaFinal = new Casa(0);

    }

    public Jogada(Jogador j, Casa i, Casa f, int a, int b, int c, int d) {

        autor = j;
        casaInicial = i;
        casaFinal = f;
        
        linhaO = a;
        colunaO = b;
        linhaD = c;
        colunaD = d;

    }

    //

    public boolean ehValida(Tabuleiro t) {

        Jogo.debugl("ci = " + casaInicial.ocupante);
        Jogo.debugl("cf = " + casaFinal.ocupante);

        try {

            if (casaInicial.ocupante.jogador != autor)
                return false;

        } catch (Exception e) {

            Jogo.debugl("inicial vazia");
            return false;

        }

        try {

            if (casaFinal.ocupante.jogador == autor)
                return false;

        } catch (Exception e) {

            Jogo.debugl("final vazia");
            return true;

        }

        if (!casaInicial.ocupante.movimentoValido(linhaO, colunaO, linhaD, colunaD))
            return false;

        caminho = t.geraCaminho(casaInicial.ocupante.caminho());

        if (!caminho.estaLivre())
            return false;

        return true;

    }

    public boolean ehXeque() {

        return false;

    }

    public boolean ehXequeMate() {

        return false;

    }

}

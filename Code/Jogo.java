package Code;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Jogo {

    private static final String CLEAR = "\033[H\033[0J";

    private Jogador[] jogador;
    private Tabuleiro tabuleiro;

    private Peca[] pecas;

    //

    public static Scanner input = new Scanner(System.in);
    public static StringBuilder sb = new StringBuilder();

    //

    // funcoes uteis

    public static void print(Object message) {

        System.out.print(message);

    }

    public static void debug(Object message) {

        if (Gerenciador.debug)
            System.out.print(message);

    }

    public static void printl(Object message) {

        System.out.println(message);

    }

    public static void debugl(Object message) {

        if (Gerenciador.debug)
            System.out.println(message);

    }

    public static void line(int count) {

        for (int i = 0; i < count; i++)
            System.out.println();

    }

    public static void dline(int count) {

        if (Gerenciador.debug)
            for (int i = 0; i < count; i++)
                System.out.println();

    }

    //

    public void iniciar() {

        input.useDelimiter("\n");

        //

        criaPartida();

        input.close();

    }

    // a sobrecarga de iniciar é usada ao carregar uma partida
    public void iniciar(String caminho) {

        input.useDelimiter("\n");

        //

        criaPartida(caminho);

        input.close();

    }

    private void criaPartida() {

        jogador = new Jogador[2];

        // cria jogadores com seus nomes fornecidos
        printl("insira o nome do jogador 1 (brancas)");
        jogador[0] = new Jogador(input.next(), 0);

        printl("insira o nome do jogador 2 (pretas)");
        jogador[1] = new Jogador(input.next(), 1);

        sb.append(jogador[0]);
        sb.append(jogador[1]);

        //

        tabuleiro = new Tabuleiro();
        pecas = new Peca[32];

        // pecas jogador branco
        pecas[0] = new Torre(0, jogador[0]);
        tabuleiro.setCasa(0, 0, pecas[0]);
        pecas[1] = new Torre(0, jogador[0]);
        tabuleiro.setCasa(0, 7, pecas[1]);
        pecas[2] = new Cavalo(0, jogador[0]);
        tabuleiro.setCasa(0, 1, pecas[2]);
        pecas[3] = new Cavalo(0, jogador[0]);
        tabuleiro.setCasa(0, 6, pecas[3]);
        pecas[4] = new Bispo(0, jogador[0]);
        tabuleiro.setCasa(0, 2, pecas[4]);
        pecas[5] = new Bispo(0, jogador[0]);
        tabuleiro.setCasa(0, 5, pecas[5]);
        pecas[6] = new Rainha(0, jogador[0]);
        tabuleiro.setCasa(0, 3, pecas[6]);
        pecas[7] = new Rei(0, jogador[0]);
        tabuleiro.setCasa(0, 4, pecas[7]);
        pecas[8] = new Peao(0, jogador[0]);
        tabuleiro.setCasa(1, 0, pecas[8]);
        pecas[9] = new Peao(0, jogador[0]);
        tabuleiro.setCasa(1, 1, pecas[9]);
        pecas[10] = new Peao(0, jogador[0]);
        tabuleiro.setCasa(1, 2, pecas[10]);
        pecas[11] = new Peao(0, jogador[0]);
        tabuleiro.setCasa(1, 3, pecas[11]);
        pecas[12] = new Peao(0, jogador[0]);
        tabuleiro.setCasa(1, 4, pecas[12]);
        pecas[13] = new Peao(0, jogador[0]);
        tabuleiro.setCasa(1, 5, pecas[13]);
        pecas[14] = new Peao(0, jogador[0]);
        tabuleiro.setCasa(1, 6, pecas[14]);
        pecas[15] = new Peao(0, jogador[0]);
        tabuleiro.setCasa(1, 7, pecas[15]);

        Peca[] a = new Peca[16];

        for (int i = 0; i < 16; i++)
            a[i] = pecas[i];

        jogador[0].setPecas(a);

        // pecas jogador preto
        pecas[16] = new Torre(1, jogador[1]);
        tabuleiro.setCasa(7, 0, pecas[16]);
        pecas[17] = new Torre(1, jogador[1]);
        tabuleiro.setCasa(7, 7, pecas[17]);
        pecas[18] = new Cavalo(1, jogador[1]);
        tabuleiro.setCasa(7, 1, pecas[18]);
        pecas[19] = new Cavalo(1, jogador[1]);
        tabuleiro.setCasa(7, 6, pecas[19]);
        pecas[20] = new Bispo(1, jogador[1]);
        tabuleiro.setCasa(7, 2, pecas[20]);
        pecas[21] = new Bispo(1, jogador[1]);
        tabuleiro.setCasa(7, 5, pecas[21]);
        pecas[22] = new Rainha(1, jogador[1]);
        tabuleiro.setCasa(7, 3, pecas[22]);
        pecas[23] = new Rei(1, jogador[1]);
        tabuleiro.setCasa(7, 4, pecas[23]);
        pecas[24] = new Peao(1, jogador[1]);
        tabuleiro.setCasa(6, 0, pecas[24]);
        pecas[25] = new Peao(1, jogador[1]);
        tabuleiro.setCasa(6, 1, pecas[25]);
        pecas[26] = new Peao(1, jogador[1]);
        tabuleiro.setCasa(6, 2, pecas[26]);
        pecas[27] = new Peao(1, jogador[1]);
        tabuleiro.setCasa(6, 3, pecas[27]);
        pecas[28] = new Peao(1, jogador[1]);
        tabuleiro.setCasa(6, 4, pecas[28]);
        pecas[29] = new Peao(1, jogador[1]);
        tabuleiro.setCasa(6, 5, pecas[29]);
        pecas[30] = new Peao(1, jogador[1]);
        tabuleiro.setCasa(6, 6, pecas[30]);
        pecas[31] = new Peao(1, jogador[1]);
        tabuleiro.setCasa(6, 7, pecas[31]);

        Peca[] b = new Peca[16];

        for (int i = 0; i < 16; i++)
            b[i] = pecas[16 + i];

        jogador[1].setPecas(b);

        // inicia partida, passando o controle para o jogador branco
        printl("iniciando partida...");
        resfreshScreen();

        partida(0); // 0 = branco, 1 = preto

    }

    private void partida(int ja) {

        Jogada j; // cache

        // loop ate fim do jogo (a ser implementado)
        while (true) {

            j = recebeJogada(ja);

            if (!j.ehValida(tabuleiro)) {// interrupcao por erro ou solicitacao
                final int ultimaQuebra = sb.lastIndexOf("\n");
                if (ultimaQuebra != -1) {
                    sb.delete(ultimaQuebra, sb.length()); // remove a última linha
                }
                break;
            }

            realizaJogada(j);
            ja = (ja == 1) ? 0 : 1; // troca jogador atual

            debugl("jogador atual agora eh: " + jogador[ja].nome);
            j = null; // limpa o cache, por precaucao. futuramente pode gerar uma excecao tratavel

        }

    }

    public static int validyx(Character c) {

        int out = 1;

        if (Character.isLetter(c))
            out = Character.toUpperCase(c) - 64;
        else
            out = Integer.parseInt(c.toString());

        if (out >= 1 && out <= 8)
            return out;
        else
            return 1;

    }

    private Jogada recebeJogada(int ja) {

        String jtxt;
        Jogada j;

        int yo = 0, xo = 0, yd = 0, xd = 0; // cache das coordenadas

        do {

            jtxt = jogador[ja].informaJogada();

            if (jtxt.contains("parar")) { // interrupcao
                debugl("partida interrompida por " + jogador[ja].nome);
                return new Jogada();
            }

            debugl("jogada recebida do jogador " + (ja + 1) + ": " + jtxt);

            //

            // transforma jtxt nas 4 coordenadas necessarias
            yo = validyx(jtxt.charAt(0));
            xo = validyx(jtxt.charAt(1));
            yd = validyx(jtxt.charAt(2));
            xd = validyx(jtxt.charAt(3));

            j = new Jogada(jogador[ja], null, null, yo, xo, yd, xd); // temp

            debugl(yo + " " + xo + " " + yd + " " + xd);

            sb.append(jtxt); // salva a jogada no string builder

            // se todas elas foram validas
            // if (validCoord(yo) && validCoord(xo) && validCoord(yd) && validCoord(xd)) {

            j = new Jogada(jogador[ja], tabuleiro.getCasa(yo, xo), tabuleiro.getCasa(yd, xd), yo, xo, yd, xd);
            debugl(tabuleiro.getCasa(1, 1).cor);

            /// } else
            // continue;

        } while (!j.ehValida(tabuleiro)); // repete enquanto o jogador nao fornecer uma jogada valida

        return j;

    }

    private void realizaJogada(Jogada j) {

        debugl("realizando jogada do jogador " + j.autor.nome + " de peças "
                + ((j.autor.cor == 1) ? "pretas" : "brancas"));

        line(1);

        Peca morta = tabuleiro.setCasa(j.casaFinal, j.casaInicial.ocupante);
        if (morta != null) {
            debugl("morta: " + morta);

        }

        j.casaInicial.ocupante = null;

        resfreshScreen();

    }

    public void resfreshScreen() {

        print(CLEAR);
        tabuleiro.desenho();

    }

    public String registroJogo() {
        String construida = sb.toString();
        return construida;
    }

    // a sobrecarga de criaPartida é usada para carregar a partida
    public void criaPartida(String caminho) {
        jogador = new Jogador[2];
        String jtxt;

        try (BufferedReader reader = new BufferedReader(new FileReader(caminho))) {
            jogador[0] = new Jogador(reader.readLine(), 0);
            jogador[1] = new Jogador(reader.readLine(), 1);

            sb.append(jogador[0]);
            sb.append(jogador[1]);

            tabuleiro = new Tabuleiro();
            pecas = new Peca[32];

            // pecas jogador branco
            pecas[0] = new Torre(0, jogador[0]);
            tabuleiro.setCasa(0, 0, pecas[0]);
            pecas[1] = new Torre(0, jogador[0]);
            tabuleiro.setCasa(0, 7, pecas[1]);
            pecas[2] = new Cavalo(0, jogador[0]);
            tabuleiro.setCasa(0, 1, pecas[2]);
            pecas[3] = new Cavalo(0, jogador[0]);
            tabuleiro.setCasa(0, 6, pecas[3]);
            pecas[4] = new Bispo(0, jogador[0]);
            tabuleiro.setCasa(0, 2, pecas[4]);
            pecas[5] = new Bispo(0, jogador[0]);
            tabuleiro.setCasa(0, 5, pecas[5]);
            pecas[6] = new Rainha(0, jogador[0]);
            tabuleiro.setCasa(0, 3, pecas[6]);
            pecas[7] = new Rei(0, jogador[0]);
            tabuleiro.setCasa(0, 4, pecas[7]);
            pecas[8] = new Peao(0, jogador[0]);
            tabuleiro.setCasa(1, 0, pecas[8]);
            pecas[9] = new Peao(0, jogador[0]);
            tabuleiro.setCasa(1, 1, pecas[9]);
            pecas[10] = new Peao(0, jogador[0]);
            tabuleiro.setCasa(1, 2, pecas[10]);
            pecas[11] = new Peao(0, jogador[0]);
            tabuleiro.setCasa(1, 3, pecas[11]);
            pecas[12] = new Peao(0, jogador[0]);
            tabuleiro.setCasa(1, 4, pecas[12]);
            pecas[13] = new Peao(0, jogador[0]);
            tabuleiro.setCasa(1, 5, pecas[13]);
            pecas[14] = new Peao(0, jogador[0]);
            tabuleiro.setCasa(1, 6, pecas[14]);
            pecas[15] = new Peao(0, jogador[0]);
            tabuleiro.setCasa(1, 7, pecas[15]);

            Peca[] a = new Peca[16];

            for (int i = 0; i < 16; i++)
                a[i] = pecas[i];

            jogador[0].setPecas(a);

            // pecas jogador preto
            pecas[16] = new Torre(1, jogador[1]);
            tabuleiro.setCasa(7, 0, pecas[16]);
            pecas[17] = new Torre(1, jogador[1]);
            tabuleiro.setCasa(7, 7, pecas[17]);
            pecas[18] = new Cavalo(1, jogador[1]);
            tabuleiro.setCasa(7, 1, pecas[18]);
            pecas[19] = new Cavalo(1, jogador[1]);
            tabuleiro.setCasa(7, 6, pecas[19]);
            pecas[20] = new Bispo(1, jogador[1]);
            tabuleiro.setCasa(7, 2, pecas[20]);
            pecas[21] = new Bispo(1, jogador[1]);
            tabuleiro.setCasa(7, 5, pecas[21]);
            pecas[22] = new Rainha(1, jogador[1]);
            tabuleiro.setCasa(7, 3, pecas[22]);
            pecas[23] = new Rei(1, jogador[1]);
            tabuleiro.setCasa(7, 4, pecas[23]);
            pecas[24] = new Peao(1, jogador[1]);
            tabuleiro.setCasa(6, 0, pecas[24]);
            pecas[25] = new Peao(1, jogador[1]);
            tabuleiro.setCasa(6, 1, pecas[25]);
            pecas[26] = new Peao(1, jogador[1]);
            tabuleiro.setCasa(6, 2, pecas[26]);
            pecas[27] = new Peao(1, jogador[1]);
            tabuleiro.setCasa(6, 3, pecas[27]);
            pecas[28] = new Peao(1, jogador[1]);
            tabuleiro.setCasa(6, 4, pecas[28]);
            pecas[29] = new Peao(1, jogador[1]);
            tabuleiro.setCasa(6, 5, pecas[29]);
            pecas[30] = new Peao(1, jogador[1]);
            tabuleiro.setCasa(6, 6, pecas[30]);
            pecas[31] = new Peao(1, jogador[1]);
            tabuleiro.setCasa(6, 7, pecas[31]);

            Peca[] b = new Peca[16];

            for (int i = 0; i < 16; i++)
                b[i] = pecas[16 + i];

            jogador[1].setPecas(b);

            int ja = 0;
            Jogada j; // cache

            jtxt = reader.readLine();
            if (jtxt != null) {
                do {

                    int yo = 0, xo = 0, yd = 0, xd = 0; // cache das coordenadas

                    yo = validyx(jtxt.charAt(0));
                    xo = validyx(jtxt.charAt(1));
                    yd = validyx(jtxt.charAt(2));
                    xd = validyx(jtxt.charAt(3));

                    sb.append(jtxt);

                    j = new Jogada(jogador[ja], null, null, yo, xo, yd, xd); // temp

                    if (!j.ehValida(tabuleiro)) { // interrupcao por erro ou solicitacao
                        final int ultimaQuebra = sb.lastIndexOf("\n");
                        if (ultimaQuebra != -1) {
                            sb.delete(ultimaQuebra, sb.length()); // remove a última linha
                        }
                        break;
                    }

                    j = new Jogada(jogador[ja], tabuleiro.getCasa(yo, xo), tabuleiro.getCasa(yd, xd), yo, xo, yd, xd);

                    ja = (ja == 1) ? 0 : 1; // troca jogador atual

                    j = null; // limpa o cache, por precaucao. futuramente pode gerar uma excecao tratavel

                    jtxt = reader.readLine();
                } while (jtxt != null);
            }
            //

            tabuleiro.desenho();

            printl("Partida carregada.");
            partida(ja); // 0 = branco, 1 = preto

        } catch (IOException | NumberFormatException e) {
            System.out.println("Erro ao carregar o jogo: " + e.getMessage());
        }

    }

}

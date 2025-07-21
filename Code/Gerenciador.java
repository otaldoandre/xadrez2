package Code;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Gerenciador {

public static boolean debug = true;

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);

        try {
            System.out.println("Deseja carregar uma partida ou iniciar uma nova?");
            System.out.println("Para carregar, digite 1, para iniciar uma nova, digite 2.");
            int valor = ler.nextInt();
        if(valor == 2){
            // inicia uma nova partida
            Jogo j = new Jogo();
            j.iniciar();
            System.out.println("Deseja salvar a partida? Caso sim, digite 0");
            if(ler.nextInt() == 0){
                salvar(j);
            }
        } else if(valor == 1){ 
            // carrega um arquivo
            Jogo j = new Jogo();
            System.out.println("Por favor, digite o nome do arquivo que será lido");
            j.iniciar(ler.nextLine());
           System.out.println("Deseja salvar a partida? Caso sim, digite 0");
            if(ler.nextInt() == 0){
                salvar(j);
            }
        } else {
            throw new IllegalArgumentException("Opção inválida.");
        }
        } catch (IllegalArgumentException e) {
           System.out.println("Erro:" + e.getMessage());
        }
    }

    private static void salvar(Jogo j){
        Scanner ler = new Scanner(System.in);

        System.out.println("Como deseja nomear o arquivo?");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ler.nextLine()))) {
            writer.write(j.registroJogo());
            System.out.println("Arquivo salvo com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar o arquivo: " + e.getMessage());
        }
    }
}

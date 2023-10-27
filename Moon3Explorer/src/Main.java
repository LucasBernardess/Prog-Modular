import Jogo.Partida;
import Jogo.Tempo;
import Terreno.Terreno;
import Robo.Robo;
import Robo.Controlador;
import Jogo.Equipe;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.List;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) {

        FileReader readerTerreno = null;
        try {
            readerTerreno = new FileReader("src/terreno.json");

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);

        }
        Gson gson = new Gson();
        Terreno mapa = gson.fromJson(readerTerreno, Terreno.class);

        FileReader readerJogo = null;
        try {
            readerJogo = new FileReader("src/config.json");

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);

        }
        gson = new Gson();
        Partida configuracao = gson.fromJson(readerJogo, Partida.class);

        Tempo tempoDejogo = new Tempo();
        tempoDejogo.setTempoInicial();

        int quantidadeEquipes = configuracao.equipes.size();
        int quantidadeRobos = configuracao.equipes.get(0).robos.size();

        do{
            for(int indiceRobos = 0; indiceRobos<quantidadeRobos; indiceRobos++){
                for(int indiceEquipe = 0; indiceEquipe<quantidadeEquipes; indiceEquipe++){

                    configuracao.equipes.get(indiceEquipe).robos.get(indiceRobos).controlador.movimentarRobo(mapa, configuracao.equipes.get(indiceEquipe).robos.get(indiceRobos));

                    int posicaoX = configuracao.equipes.get(indiceEquipe).robos.get(indiceRobos).posicaoRoboNoEixoX;
                    int posicaoY = configuracao.equipes.get(indiceEquipe).robos.get(indiceRobos).posicaoRoboNoEixoY;

                    double helio3NaCelula = mapa.terreno[posicaoY][posicaoX].getConcentracaoDeHelio3();

                    configuracao.equipes.get(indiceEquipe).robos.get(indiceRobos).prospectaHelio(mapa);

                    System.out.println("Equipe -> " + configuracao.equipes.get(indiceEquipe).getNomeEquipe());
                    System.out.println("Robo -> " + configuracao.equipes.get(indiceEquipe).robos.get(indiceRobos).getNomeRobo());
                    System.out.println("Posicao -> x: " + posicaoX + "\ty: " + posicaoY);
                    System.out.println("Helio3 na célula -> " + helio3NaCelula);
                    System.out.println("Rugosidade na célula -> " + mapa.terreno[posicaoY][posicaoX].getRugosidade());
                    System.out.println("Helio3 coletado pelo robo -> " + configuracao.equipes.get(indiceEquipe).robos.get(indiceRobos).getHelioColetadoPeloRobo());
                    System.out.println("Helio3 coletado pela equipe -> " + configuracao.equipes.get(indiceEquipe).getPontuacaoEquipe());
                    System.out.println("\n");
                }
            }

            tempoDejogo.setTempoFinal();

        }while(configuracao.getDuracao() > tempoDejogo.DuracaoDoJogo());

        System.out.println("Classificação Final:\n");
        for(int indiceEquipe = 0; indiceEquipe<quantidadeEquipes; indiceEquipe++){
            System.out.println("Equipe -> " + configuracao.equipes.get(indiceEquipe).getNomeEquipe());
            System.out.println("Pontuação total -> " + configuracao.equipes.get(indiceEquipe).getPontuacaoEquipe());
            System.out.println("Robos:");
            for(int indiceRobos = 0; indiceRobos<quantidadeRobos; indiceRobos++){
                System.out.println("Nome -> " + configuracao.equipes.get(indiceEquipe).robos.get(indiceRobos).getNomeRobo());
                System.out.println("Pontuação -> " + configuracao.equipes.get(indiceEquipe).robos.get(indiceRobos).getHelioColetadoPeloRobo());
            }
            System.out.println("\n");
        }

        System.out.println("Duração -> " + tempoDejogo.DuracaoDoJogo()/1000 + " segundos");

    }
}
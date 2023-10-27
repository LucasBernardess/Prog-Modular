package Jogo;

import Robo.Robo;
import Jogo.Partida;
import Terreno.Terreno;
import java.util.List;
import java.util.ArrayList;


public class Equipe{
    public String nomeEquipe;
    public List<Robo> robos;
    private double pontuacaoEquipe;

    public Equipe(String nome){
        this.nomeEquipe = nome;
        this.robos = new ArrayList<>();
        this.pontuacaoEquipe = 0;
    }

    public void adicionarRobo(Robo robo){
        this.robos.add(robo);
    }

    public String getNomeEquipe(){
        return nomeEquipe;
    }

    public void somarPontuacao(){
        this.pontuacaoEquipe = 0;
        for(int indiceRobos = 0; indiceRobos < robos.size(); indiceRobos++){
            this.pontuacaoEquipe += robos.get(indiceRobos).getHelioColetadoPeloRobo();
        }
    }

    public double getPontuacaoEquipe(){
        somarPontuacao();
        return pontuacaoEquipe;
    }

    @Override
    public String toString() {
        return "Equipe{" +
                "nomeEquipe='" + nomeEquipe + '\'' +
                ", robos=" + robos +
                ", pontuacaoEquipe=" + pontuacaoEquipe +
                '}';
    }
}
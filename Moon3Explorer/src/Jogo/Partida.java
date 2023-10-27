package Jogo;

import java.util.ArrayList;
import java.util.List;
import Jogo.Equipe;

public class Partida{
    public List<Equipe> equipes;
    public long duracaoPartida;

    public Partida(int tempo){
        this.equipes = new ArrayList<>();
        this.duracaoPartida = tempo;
    }

    public void adicionarEquipe(Equipe equipe){
        equipes.add(equipe);
    }

    public long getDuracao(){
        return duracaoPartida;
    }

    @Override
    public String toString() {
        return "Partida{" +
                "equipes=" + equipes +
                ", duracaoPartida=" + duracaoPartida +
                '}';
    }
}

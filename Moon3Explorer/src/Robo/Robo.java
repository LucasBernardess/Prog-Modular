package Robo;

import Jogo.Tempo;
import Terreno.Celula;
import Terreno.Terreno;
import java.util.concurrent.TimeUnit;

public class Robo{
    private  String nomeRobo;
    public int posicaoRoboNoEixoX;
    public int posicaoRoboNoEixoY;
    private double helioColetadoPeloRobo;
    public Controlador controlador;

    public Robo() {
        this.helioColetadoPeloRobo = 0;
        this.controlador = new Controlador();
    }

    public String getNomeRobo(){
        return nomeRobo;
    }

    public int getPosicaoRoboNoEixoX() {
        return posicaoRoboNoEixoX;
    }

    public void setPosicaoRoboNoEixoX(int novaPosicaoX){
        this.posicaoRoboNoEixoX = novaPosicaoX;
    }

    public int getPosicaoRoboNoEixoY() {
        return posicaoRoboNoEixoY;
    }

    public void setPosicaoRoboNoEixoY(int novaPosicaoY){
        this.posicaoRoboNoEixoY = novaPosicaoY;
    }

    public double getHelioColetadoPeloRobo() {
        return helioColetadoPeloRobo;
    }

    public void setHelioColetadoPeloRobo(double helioColetadoPeloRobo) {
        this.helioColetadoPeloRobo = helioColetadoPeloRobo;
    }

    public void imprimeConcentracaoDeHelio3NaCelula(Celula celula){
        System.out.println("Concentração: " + celula.getConcentracaoDeHelio3());
    }

    public void imprimePosicaoDaCelula(){
        System.out.println("O Robo está nas coordenadas" + getPosicaoRoboNoEixoX() + getPosicaoRoboNoEixoY());
    }

    public void imprimeRugosidadeDaCelula(Celula celula){
        System.out.println("A rugosidade da celula é: " + celula.getRugosidade());
    }

    public int verificaSondasVizinhas(Terreno terreno){
        return 0;
    }

    public void prospectaHelio(Terreno terreno) {
        if(verificaSondasVizinhas(terreno) == 0){
            Tempo tempo = new Tempo();
            long segundos = Math.round((terreno.terreno[posicaoRoboNoEixoY][posicaoRoboNoEixoX].getConcentracaoDeHelio3() * 10));
            if(segundos == 0){
                segundos = 1;
            }
            tempo.sleep(segundos);
            this.helioColetadoPeloRobo += terreno.terreno[posicaoRoboNoEixoY][posicaoRoboNoEixoX].getConcentracaoDeHelio3();
            terreno.terreno[posicaoRoboNoEixoY][posicaoRoboNoEixoX].setConcentracaoDeHelio3(0);
        }
    }

    public void tempoDaPartida(Tempo tempo){
        System.out.println("Tempo de partida -> " + tempo.DuracaoDoJogo()/1000);
    }


}
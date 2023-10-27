package Robo;

import Terreno.Terreno;
import Jogo.Tempo;

public class Controlador {

    private int direcaoDoRobo;

    public Controlador() {
        this.direcaoDoRobo = 0;
    }

    void detectarParede(Terreno terreno, Robo robo){
        if(direcaoDoRobo == 0){
            if(robo.getPosicaoRoboNoEixoY() == terreno.getAltura()-1){
                direcaoDoRobo = direcaoDoRobo + 1;
                detectarParede(terreno, robo);
            }
        }
        if(direcaoDoRobo == 1){
            if(robo.getPosicaoRoboNoEixoX() == terreno.getLargura()-1){
                direcaoDoRobo = direcaoDoRobo + 1;
                detectarParede(terreno, robo);
            }
        }
        if(direcaoDoRobo == 2){
            if(robo.getPosicaoRoboNoEixoY() == 0){
                direcaoDoRobo = direcaoDoRobo + 1;
                detectarParede(terreno, robo);
            }
        }
        if(direcaoDoRobo >= 3){
            if(robo.getPosicaoRoboNoEixoX() == 0){
                direcaoDoRobo = 0;
                detectarParede(terreno, robo);
            }
        }
        return;
    }

    public void movimentarRobo(Terreno terreno, Robo robo){
        detectarParede(terreno, robo);

        int novaPosicaoX = robo.getPosicaoRoboNoEixoX();
        int novaPosicaoY = robo.getPosicaoRoboNoEixoY();

        terreno.terreno[novaPosicaoY][novaPosicaoX].setTemRoboNessaCelula(false);

        if(direcaoDoRobo == 0){
            novaPosicaoY = robo.getPosicaoRoboNoEixoY() + 1;
        }
        if(direcaoDoRobo == 1){
            novaPosicaoX = robo.getPosicaoRoboNoEixoX() + 1;
        }
        if(direcaoDoRobo == 2){
            novaPosicaoY = robo.getPosicaoRoboNoEixoY() - 1;
        }
        if(direcaoDoRobo == 3){
            novaPosicaoX = robo.getPosicaoRoboNoEixoX() - 1;
        }

        if(!terreno.terreno[novaPosicaoX][novaPosicaoY].getTemRoboNessaCelula()){
            long rugosidade = Math.round(terreno.terreno[novaPosicaoY][novaPosicaoX].getRugosidade());
            Tempo time = new Tempo();
            time.sleep(rugosidade*5);
            robo.setPosicaoRoboNoEixoX(novaPosicaoX);
            robo.setPosicaoRoboNoEixoY(novaPosicaoY);
            terreno.terreno[novaPosicaoY][novaPosicaoX].setTemRoboNessaCelula(true);
        } else{
            direcaoDoRobo = direcaoDoRobo + 1;
            movimentarRobo(terreno, robo);
        }
        return;
    }

}
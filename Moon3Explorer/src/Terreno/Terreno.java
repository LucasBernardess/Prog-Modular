package Terreno;
import java.util.Arrays;

public class Terreno {
    public int alturaDoTerreno;
    public int larguraDoTerreno;
    public Celula[][] terreno;

    public Terreno(int altura, int largura) {
        this.alturaDoTerreno = altura;
        this.larguraDoTerreno = largura;
        this.terreno = new Celula[altura][largura];

        // Inicializar cada célula na matriz
        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < largura; j++) {
                this.terreno[i][j] = new Celula();
            }
        }
    }

    public int getAltura() {
        return alturaDoTerreno;
    }

    public void setAltura(int altura) {
        this.alturaDoTerreno = altura;
    }

    public int getLargura() {
        return larguraDoTerreno;
    }

    public void setLargura(int largura) {
        this.larguraDoTerreno = largura;
    }

    public Celula[][] getMatrizDeCelulas() {
        return terreno;
    }

    public void setMatrizDeCelulas(Celula[][] matrizDeCelulas) {
        this.terreno = matrizDeCelulas;
    }

    @Override
    public String toString() {
        return "Terreno{" +
                "altura=" + alturaDoTerreno +
                ", largura=" + larguraDoTerreno +
                ", matrizDeCelulas=" + Arrays.deepToString(terreno) +
                '}';
    }
}
package Terreno;
import java.util.Arrays;
import java.util.Random;
public class Celula {

    private double concentracaoDeHelio3;
    private double coeficienteDeErro;
    private double rugosidade;
    private boolean temRoboNessaCelula;
    private boolean estaSendoSondadaPorAlgumRobo;

    public Celula(){
        this.temRoboNessaCelula = false;
        this.estaSendoSondadaPorAlgumRobo = false;
    }

    public double getConcentracaoDeHelio3() {
        return concentracaoDeHelio3;
    }

    public void setConcentracaoDeHelio3(double concentracaoDeHelio3) {
        this.concentracaoDeHelio3 = concentracaoDeHelio3;
    }

    public double getCoeficienteDeErro() {
        return coeficienteDeErro;
    }

    public void setCoeficienteDeErro(double coeficienteDeErro) {
        this.coeficienteDeErro = coeficienteDeErro;
    }

    public double getRugosidade() {
        return rugosidade;
    }

    public void setRugosidade(double rugosidade) {
        this.rugosidade = rugosidade;
    }

    public boolean getTemRoboNessaCelula() {
        return temRoboNessaCelula;
    }

    public void setTemRoboNessaCelula(boolean temRoboNessaCelula) {
        this.temRoboNessaCelula = temRoboNessaCelula;
    }

    public boolean isEstaSendoSondadaPorAlgumRobo() {
        return estaSendoSondadaPorAlgumRobo;
    }

    public void setEstaSendoSondadaPorAlgumRobo(boolean estaSendoSondadaPorAlgumRobo) {
        this.estaSendoSondadaPorAlgumRobo = estaSendoSondadaPorAlgumRobo;
    }


}
package modelo;

public class SinaisVitais {
    private int batimentoCardiaco;
    private double temperatura;
    private int oxigenacao;
    private int nivelDor;

    public SinaisVitais(int batimentoCardiaco, double temperatura, int oxigenacao, int nivelDor) {
        this.batimentoCardiaco = batimentoCardiaco;
        this.temperatura = temperatura;
        this.oxigenacao = oxigenacao;
        this.nivelDor = nivelDor;
    }

    public int getBatimentoCardiaco() {
        return batimentoCardiaco;
    }

    public void setBatimentoCardiaco(int batimentoCardiaco) {
        this.batimentoCardiaco = batimentoCardiaco;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public int getOxigenacao() {
        return oxigenacao;
    }

    public void setOxigenacao(int oxigenacao) {
        this.oxigenacao = oxigenacao;
    }

    public int getNivelDor() {
        return nivelDor;
    }

    public void setNivelDor(int nivelDor) {
        this.nivelDor = nivelDor;
    }
}

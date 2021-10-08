package br.edu.vianna.pesquisapopulacao.model.domain;

public class Habitante {

    private String sexo,corOlhos,corCabelo;
    private double altura;
    private int idade;

    public Habitante() {
    }

    public Habitante(String sexo, String corOlhos, String corCabelo) {
        this.sexo = sexo;
        this.corOlhos = corOlhos;
        this.corCabelo = corCabelo;
    }


    // metodos













    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCorOlhos() {
        return corOlhos;
    }

    public void setCorOlhos(String corOlhos) {
        this.corOlhos = corOlhos;
    }

    public String getCorCabelo() {
        return corCabelo;
    }

    public void setCorCabelo(String corCabelo) {
        this.corCabelo = corCabelo;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}

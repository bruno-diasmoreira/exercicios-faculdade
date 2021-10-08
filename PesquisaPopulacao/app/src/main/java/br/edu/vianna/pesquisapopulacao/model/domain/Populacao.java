package br.edu.vianna.pesquisapopulacao.model.domain;

import java.util.ArrayList;
import java.util.List;

public  class Populacao {

    public  List<Habitante> habitantes;

    public Populacao() {
        habitantes = new ArrayList<>();
    }

    public List<Habitante> getHabitantes() {
        return habitantes;
    }

    public void addHabitantes(Habitante h) {
        if(h != null)
            habitantes.add(h);
    }


    public double maiorAltura(){

        double maior = this.getHabitantes().get(0).getAltura();

        for(int i = 0; i < this.getHabitantes().size(); i++){

            if(this.getHabitantes().get(i).getAltura() > maior){
                maior = this.getHabitantes().get(i).getAltura();
            }
        }
        return maior;
    }

    public double menorAltura(){

        double menor = this.getHabitantes().get(0).getAltura();

        for(int i = 0; i < this.getHabitantes().size(); i++){

            if(this.getHabitantes().get(i).getAltura() < menor){
                menor = this.getHabitantes().get(i).getAltura();
            }
        }
        return menor;
    }

    public int qntMulheres(){
        int total = 0;

        for(int i =0; i < this.getHabitantes().size(); i++){

            if(this.getHabitantes().get(i).getSexo() == "Feminino"){
                total++;
            }
        }
        return total;
    }

    public int qntHomens(){

        int total = 0;

        for(int i =0; i < this.getHabitantes().size(); i++){

            if(this.getHabitantes().get(i).getSexo() == "Masculino"){
                total++;
            }
        }
        return total;

    }

    public double mediaAlturaMulheres(){

        double media = 0;

        double altura = 0;


        for(int i =0; i < this.getHabitantes().size(); i++){

            if(this.getHabitantes().get(i).getSexo() == "Feminino"){
                altura += this.getHabitantes().get(i).getAltura();
            }
        }



        media =altura / qntMulheres();

        return media;
    }

    public double porcentHomem(){
        return  ((double)qntHomens() / this.getHabitantes().size()) * 100;
    }

    public double porcentMulher(){
        return ((double)qntMulheres() / this.getHabitantes().size()) * 100;
    }


    public double porcentFemininoIdade(){

        int qnt = 0;

        for(int i =0; i < this.getHabitantes().size(); i++){

            if(this.getHabitantes().get(i).getSexo() == "Feminino"){
               if(this.getHabitantes().get(i).getIdade() >=18 && this.getHabitantes().get(i).getIdade() <=35 &&
               this.getHabitantes().get(i).getCorOlhos() == "Verde" && this.getHabitantes().get(i).getCorCabelo() == "Louro"){
                   qnt++;
               }
            }
        }
        return ((double)qnt / this.getHabitantes().size()) * 100;
    }



}

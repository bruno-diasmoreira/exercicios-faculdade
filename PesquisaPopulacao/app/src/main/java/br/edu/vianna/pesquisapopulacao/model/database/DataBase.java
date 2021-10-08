package br.edu.vianna.pesquisapopulacao.model.database;

import br.edu.vianna.pesquisapopulacao.model.domain.Habitante;
import br.edu.vianna.pesquisapopulacao.model.domain.Populacao;

public class DataBase {

    public static Populacao pop = new Populacao();

    public static void save(Habitante h) {

        pop.addHabitantes(h);

    }

}

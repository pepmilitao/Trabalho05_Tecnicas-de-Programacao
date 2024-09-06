package tools.context;
import tools.abstracts.Strategy;

public class Context {

    // Atributo referente à estratégia que será usada
    private Strategy strategia;

    // Definir estratégia
    public Context(Strategy strategia) {

        this.strategia = strategia;
    }

    // Executar ordenação com base na estratégia escolhida
    public Double[] execSort(Double[] arr) {
        return strategia.sortEntities(arr);
    }
}

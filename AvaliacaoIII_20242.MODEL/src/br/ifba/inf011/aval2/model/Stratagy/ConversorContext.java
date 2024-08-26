package br.ifba.inf011.aval2.model.Stratagy;

public class ConversorContext {
    private ConversorStrategy strategy;

    public ConversorContext(ConversorStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(ConversorStrategy strategy) {
        this.strategy = strategy;
    }

    public String converterString(String input) {
        return strategy.converterString(input);
    }

    public String codificar(String input) {
        return strategy.codificar(input);
    }
}
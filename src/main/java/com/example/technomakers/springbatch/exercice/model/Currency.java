package com.example.technomakers.springbatch.exercice.model;

public class Currency {
    private String code;
    private String symbol;
    private String name;

    @Override
    public String toString() {
        return "Currency{" +
                "code='" + code + '\'' +
                ", symbome='" + symbol + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setSymbole(String symbome) {
        this.symbol = symbome;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbole() {
        return symbol;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }
}

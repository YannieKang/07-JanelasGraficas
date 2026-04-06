package br.fiap.viagem;

import br.fiap.carga.Carga;

public class Viagem {
    private double capacidade;
    private int index;
    private Carga[] carga;

    public Viagem() {
        this.capacidade = 10000;
        this.index = 0;
        this.carga = new Carga[20];
    }
}

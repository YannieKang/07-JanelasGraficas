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

    public boolean permitidoReservar(double peso){
        double total = capacidadeReservar();
        return (total + peso) <= capacidade;
    }

    public boolean reservar(Carga carga){
        if (permitidoReservar(carga.getPeso())){
            this.carga[index++] = carga;
            return true;
        }
        return false;
    }

    public double capacidadeReservar(){
        double total = 0;
        for (int i = 0; i < index; i++) {
            total += carga[index].getPeso();
        }
        return total;
    }

    public String getDados(){
        String aux = "";
        for(int i = 0; i < index; i++){
            aux += carga[i].getDados();
        }
        return aux;
    }
}

package br.fiap.viagem;

import br.fiap.carga.Carga;
import br.fiap.cliente.Cliente;

import static java.lang.Integer.parseInt;
import static javax.swing.JOptionPane.showInputDialog;

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
            total += carga[i].getPeso();
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


    //metodo para pesquisar uma carga pelo cnpj
    //vetor contendo as cargas estão na classe viagem, ent faz o metodo na viagem
    public Carga pesquisaReserva(int cnpj){
        int posicao = buscarPorIndice(cnpj);
        if (posicao != -1){
            return carga[posicao];
        }
        return null;
    }

    private int buscarPorIndice(int cnpj){
        for(int i = 0; i < index; i++){
            if (carga[i].getCliente().getCnpj() == cnpj){
                return i;
            }
        }
        return -1;
    }

    public boolean cancelaReserva(int cnpj){
        int posicao = buscarPorIndice(cnpj);
        if(posicao == -1){
            return false;
        }
        else {
            carga[posicao] = carga[index - 1];
            index--;
            return true;
        }
    }
}

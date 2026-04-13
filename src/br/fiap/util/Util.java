package br.fiap.util;
import br.fiap.carga.Carga;
import br.fiap.cliente.Cliente;
import br.fiap.viagem.Viagem;

import static javax.swing.JOptionPane.*;
import static java.lang.Integer.parseInt;
import static java.lang.Double.parseDouble;

public class Util {
    private Viagem viagem = new Viagem();
    public void menu(){
        int opcao;
        do {
            String aux = "Reserva de Cargas\n";
            aux += "[1] Reservar\n";
            aux += "[2] Pesquisar\n";
            aux += "[3] Visualizar reservas\n";
            aux += "[4] Capacidade reservada\n";
            aux += "[5] Cancelar reserva\n";
            aux += "[6] Finalizar\n";
            opcao = parseInt(showInputDialog(aux));
            if (opcao < 1 || opcao > 6){
                showMessageDialog(null, "Opção inválida");
            }
            else {
                switch (opcao){
                    case 1 -> reservar();
                    case 2 -> pesquisaReserva();
                    case 3 -> visualizarReserva();
                    case 4 -> capacidadeReservada();
                    case 5 -> cancelaReserva();
                    case 6 -> showMessageDialog(null, "Até breve");
                    default -> showMessageDialog(null, "Opção inválida");
                }
            }
        } while (opcao != 6);
    }

    private void pesquisaReserva() {
        int cnpj = parseInt(showInputDialog("CNPJ para busca"));
        Carga carga = viagem.pesquisaReserva(cnpj);
        if(carga == null){
            showMessageDialog(null, "CNPJ não encontrado");
        }
        else {
            showMessageDialog(null, carga.getDados());
        }
    }

    private void capacidadeReservada() {
        showMessageDialog(null, "Capacidade atual: " + viagem.capacidadeReservar());
    }

    private void reservar() {
        int cnpj;
        String destino, nomeCliente;

        cnpj = parseInt(showInputDialog("CNPJ"));
        destino = showInputDialog("Destino da carga:");
        nomeCliente = showInputDialog("Nome do cliente:");
        Cliente cliente = new Cliente(cnpj, nomeCliente);
        Carga carga = new Carga(destino, cliente);
        if (viagem.reservar(carga)){
            showMessageDialog(null, "Carga reservada com sucesso");
        }
        else {
            showMessageDialog(null, "Entre em contato com a administração");
        }
    }


    private void visualizarReserva(){
        showMessageDialog(null, viagem.getDados());
    }

    private void cancelaReserva(){
        int cnpj = parseInt(showInputDialog("CNPJ para busca"));
        if (viagem.cancelaReserva(cnpj)){
            showMessageDialog(null, "Carga cancelada");
        }
        else {
            showMessageDialog(null, "Carga não encontrada");
        }
    }
}

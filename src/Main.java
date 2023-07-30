//Nome: Gabriel Fellipe Marquardt
//Turma: MI-72

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Quantos produtos:");
        int quantidade = sc.nextInt();
        double valor;
        int i = 0;
        String[] nome = new String[quantidade];

        for (i = 0; i < quantidade; i++) {
            System.out.println("Qual o nome:");
            nome[i] = sc.next();
            System.out.println("Qual o preco:");
            valor = sc.nextDouble();
        }

        Unidades(quantidade, nome);
    }

    public static void Unidades(int quantidade, String nome[]) {
        int[][] produtosDiarios = new int[quantidade][30];

        for (int i = 0; i < quantidade; i++) {
            for (int j = 0; j < 30; j++) {
                System.out.println("Quantas unidades do produto " + nome[i] + " foram vendidas no dia " + j);
                produtosDiarios[i][j] = sc.nextInt();
            }
        }

        int[] mensal = VendasMensais(produtosDiarios, quantidade);
        int[] diario = VendasDiarias(produtosDiarios, quantidade);

        Relatorio(nome, quantidade, diario, mensal);
    }

    public static int[] VendasMensais(int[][] produtosDiarios, int quantidade) {
        int[] mensal = new int[quantidade];

        for (int i = 0; i < quantidade; i++) {
            int totalMensal = 0;
            for (int j = 0; j < 30; j++) {
                totalMensal += produtosDiarios[i][j];
            }
            mensal[i] = totalMensal;
        }

        return mensal;
    }

    public static int[] VendasDiarias(int produtosDiarios[][], int quantidade) {
        int[] diario = new int[30];

        for (int j = 0; j < 30; j++) {
            int totalDiario = 0;
            for (int i = 0; i < quantidade; i++) {
                totalDiario += produtosDiarios[i][j];
            }
            diario[j] = totalDiario;
        }

        return diario;
    }

    public static void Relatorio(String nome[], int quantidade, int diario[], int mensal[]) {
        for (int i = 0; i < quantidade; i++) {
            System.out.println("O produto " + nome[i] + " vendeu " + mensal[i] + " no mês ");
            for (int j = 0; j < 30; j++) {
                System.out.println("O produto " + nome[i] + " vendeu " + diario[j] + " no dia " + j);
            }
        }
    }
}

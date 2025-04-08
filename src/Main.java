import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String nomeDigitado;

        ArrayList<String> nomes = new ArrayList<>();

        System.out.println("Digite o nome de pelo menos 5 alunos.");
        System.out.println(" ");

        for (int i = 0; i < 5; i++) {
            System.out.print("Digite o " + (i + 1) + "º nome: ");
            String nome = scanner.nextLine();

            while (nome.trim().isEmpty()) {
                System.out.println("O nome não pode estar vazio. Tente novamente:");
                nome = scanner.nextLine();
            }

            nomes.add(nome);
        }

        System.out.println("Nomes de alunos na lista: " + nomes);
        System.out.println(" ");
        System.out.println("Escolha um nome que deseja remover da lista.");
        nomeDigitado = scanner.nextLine();

        while (!nomes.contains(nomeDigitado)) {
            System.out.println("Por favor escolha um nome que esteja na lista.");
            nomeDigitado = scanner.nextLine();
        }

        while (!nomeDigitado.equalsIgnoreCase("S")) {
            if (nomes.contains(nomeDigitado)) {
                System.out.println("Tem certeza de que quer remover " + nomeDigitado + " da lista? (S/N)");
                String confirmacao = scanner.nextLine();

                if (confirmacao.equalsIgnoreCase("N")) {
                    System.out.println("Operação cancelada. Digite o nome do(a) aluno(a) que deseja remover:");
                    nomeDigitado = scanner.nextLine();
                    while (!nomes.contains(nomeDigitado)) {
                        System.out.println("Por favor escolha um nome que esteja na lista.");
                        nomeDigitado = scanner.nextLine();
                    }
                }
                else if (confirmacao.equalsIgnoreCase("S")) {
                    nomes.remove(nomeDigitado);
                    System.out.println("O nome do(a) aluno(a) " + nomeDigitado + " foi removido com sucesso.");
                    break;
                }
                else {
                    System.out.println("Por favor, escolha entre S (para sim) ou N (para não).");
                    scanner.nextLine();
                }
            }
        }

        System.out.println("Lista final: " + nomes);

        scanner.close();
    }
}
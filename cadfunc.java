import java.util.ArrayList;
import java.util.Scanner;

//Clase func.
class Func {

        //Atributos privados: essas variáveis guardam os dados dos funcionárioa. São privadas para garantir encapsulamento
    private String nome;
    private int idade;
    private int cadastro;

        //Armazena no atributo interno o valor que está chegando.
    public Func(String nome, int idade, int cadastro) {
        this.nome = nome;
        this.idade = idade;
        this.cadastro = cadastro;
    }

        //Exibe os dados do funcionário.
    public void exibirInformacoes() {
        System.out.println("\n===== Dados do(a) Funcionário(a) =====");
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade + " anos");
        System.out.println("Cadastro: " + cadastro);
    }
}

        //Classe Principal.
public class Main {
    public static void main(String[] args) {
        //Lê as entradas do teclado.
        Scanner sc = new Scanner(System.in);
        //Armazena os funcionários cadastrados.
        ArrayList<Func> lista = new ArrayList<>();

        //Usada para controlar o menu.
        int opcao = 0;

        // Bloco de repetição.
        do {
        //Menu de opções.
            System.out.println("\n=== MENU ===");
            System.out.println("1 - Cadastrar funcionário(a)");
            System.out.println("2 - Listar funcionários(as)");
            System.out.println("3 - Sair");

            System.out.print("Escolha: ");

            while (!sc.hasNextInt()) {
                System.out.print("Valor inválido! Digite 1, 2 ou 3: ");
                sc.next(); 
            }
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
        //Cadastrar funcionário.
                case 1:
                    System.out.println("\n=== Cadastro de Funcionário ===");

                    System.out.print("Nome: ");
                    String nome = sc.nextLine();

        //Garante que uma idade válida foi selecionada.
                    int idade = 0;
                    System.out.print("Idade: ");
                    while (true) {
                        if (sc.hasNextInt()) {
                            idade = sc.nextInt();
                            if (idade > 0 && idade < 70) {
                                break;
                            } else {
                                System.out.print("Idade inválida! Digite novamente: ");
                            }
                        } else {
                            System.out.print("Entrada inválida! Digite apenas números: ");
                            sc.next(); 
                        }
                    }

        //Garante que um cadastro válido foi inserido.
                    int cadastro = 0;
                    System.out.print("Cadastro: ");
                    while (true) {
                        if (sc.hasNextInt()) {
                            cadastro = sc.nextInt();
                            if (cadastro > 00000000 && cadastro < 99999999) {
                                break;
                            } else {
                                System.out.print("Cadastro inválido! Digite novamente: ");
                            }
                        } else {
                            System.out.print("Entrada inválida! Digite apenas números: ");
                            sc.next();
                        }
                    }

        //Adiciona um funcionário na lista.
                    lista.add(new Func(nome, idade, cadastro));
                    System.out.println("Funcionário cadastrado com sucesso!");
                    break;

        //Exibe os funcionários cadatrados.
                case 2:
                    if (lista.isEmpty()) {
                        System.out.println("\nNenhum funcionario cadastrado ainda.");
                    } else {
                        System.out.println("\n=== Lista de Funcionarios ===");
                        for (Func a : lista) {
                            a.exibirInformacoes();
                        }
                    }
                    break;

        //Responsável por finalizar o programa.
                case 3:
                    System.out.println("\nEncerrando o programa...");
                    break;

        //Se o usuário digitar algo fora de 1, 2 ou 3, mostra opção inválida.
                default:
                    System.out.println("Opção invalida! Escolha novamente.");
            }

        //Fecha o laço.
        } while (opcao != 3);


        //Fecha o Scanner, encerrando a leitura de teclado com segurança.
        sc.close();
    }
}
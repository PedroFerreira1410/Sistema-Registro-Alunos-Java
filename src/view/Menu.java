package view;
import service.AlunoService;

import java.util.Scanner;

public class Menu {
    private Scanner scanner;
    private AlunoService alunoService;

    //construtor
    public Menu()
    {
        scanner = new Scanner(System.in);
        alunoService = new AlunoService();
    }

    public void iniciar()
    {
        int opcao;
        do{
            exibirMenu();
            opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao)
            {

                //Cadastrar aluno
                case 1:
                    System.out.println("Digite o nome do aluno(a): ");
                    String nome = scanner.nextLine();

                    System.out.println("Digite a idade do aluno(a): ");
                    int idade = scanner.nextInt();

                    scanner.nextLine();

                    System.out.println("Digite o curso do aluno(a): ");
                    String curso = scanner.nextLine();

                    alunoService.cadastrarAluno(nome, idade, curso);
                    break;

                    //Listar aluno
                case 2:
                    alunoService.listarAluno();
                    break;

                    //Exibir aluno
                case 3:
                    System.out.println("Digite o id do aluno(a): ");
                    int id = scanner.nextInt();

                    alunoService.exibirAluno(id);
                    break;

                    //Atualizar aluno
                case 4:
                    System.out.println("Digite o id do aluno(a): ");
                    id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Digite o novo nome: ");
                    nome = scanner.nextLine();

                    System.out.print("Digite a nova idade: ");
                    idade = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Digite o novo curso: ");
                    curso = scanner.nextLine();

                    alunoService.atualizarAluno(id, nome, idade, curso);
                    break;

                    //Excluir aluno
                case 5:
                    System.out.println("Digite o id do aluno(a): ");
                    id = scanner.nextInt();

                    alunoService.excluirAluno(id);
                    break;

                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
            System.out.println();
        }while (opcao != 0);
    }
    private void exibirMenu(){
        System.out.println("===== MENU =====");
        System.out.println("1 - Cadastrar aluno");
        System.out.println("2 - Listar alunos");
        System.out.println("3 - Exibir aluno");
        System.out.println("4 - Atualizar aluno");
        System.out.println("5 - Excluir aluno");
        System.out.println("0 - Sair");
        System.out.print("Escolha: ");
    }
}

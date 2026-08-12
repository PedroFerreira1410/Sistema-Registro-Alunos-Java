package service;
import model.Aluno;
import java.util.ArrayList;

public class AlunoService
{

    private int proximoId = 1;
    private ArrayList<Aluno> alunos;
    int id;

    public Aluno buscarAluno(int id)
    {
        for(Aluno aluno : alunos)
        {
            if(aluno.getId() == id)
            {
                return aluno;
            }
        }
        return null;
    }

    //Construtor
    public AlunoService()
    {
        alunos = new ArrayList<>();
    }

    public void cadastrarAluno(String nome, int idade, String curso)
    {
        //Validação
        if(nome.isBlank() || idade <= 0 || curso.isBlank())
        {
            System.out.println("Dados inválidos.");
            return;
        }

        id = proximoId;

        Aluno aluno = new Aluno(id, nome, idade, curso); //Criando o objeto aluno
        alunos.add(aluno); //Adicionando esse objeto na lista

        System.out.println("Cadastro realizado!");
        proximoId++;
    }

    public void listarAluno()
    {
        if(alunos.isEmpty())
        {
            System.out.println("Nenhum aluno cadastrado");
            return;
        }
        else
        {
            for(Aluno aluno : alunos)
            {
                System.out.println("ID: " + aluno.getId() +
                        " | Nome: " + aluno.getNome() +
                        " | Idade: " + aluno.getIdade() +
                        " | Curso: " + aluno.getCurso());
            }
        }
    }

    public void exibirAluno(int id)
    {
        Aluno aluno = buscarAluno(id);

        if(aluno == null)
        {
            System.out.println("Aluno não encontrado.");
            return;
        }

        System.out.println("ID: " + aluno.getId());
        System.out.println("Nome: " + aluno.getNome());
        System.out.println("Idade: " + aluno.getIdade());
        System.out.println("Curso: " + aluno.getCurso());
    }

    public void atualizarAluno(int id, String nome, int idade, String curso)
    {
        Aluno aluno = buscarAluno(id);

        if(aluno == null)
        {
            System.out.println("Aluno não encontrado.");
            return;
        }

        if (nome.isBlank() || idade <= 0 || curso.isBlank()) {
            System.out.println("Dados inválidos.");
            return;
        }

        aluno.setNome(nome);
        aluno.setIdade(idade);
        aluno.setCurso(curso);

        System.out.println("Aluno atualizado com sucesso!");
    }

    public void excluirAluno(int id)
    {
        Aluno aluno = buscarAluno(id);

        if(aluno == null)
        {
            System.out.println("Aluno não encontrado.");
            return;
        }

        alunos.remove(aluno);
        System.out.println("Aluno excluído com sucesso!");
    }

}

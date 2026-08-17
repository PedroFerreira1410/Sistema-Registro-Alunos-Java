package service;
import model.Aluno;
import java.util.List;
import repository.AlunoRepository;

public class AlunoService
{

    public Aluno buscarAluno(int id)
    {
        return alunoRepository.buscarPorId(id);
    }

    //Construtor
    private AlunoRepository alunoRepository;
    public AlunoService()
    {
        alunoRepository = new AlunoRepository();
    }

    public void cadastrarAluno(String nome, int idade, String curso)
    {
        //Validação
        if(nome.isBlank() || idade <= 0 || curso.isBlank())
        {
            System.out.println("Dados inválidos.");
            return;
        }

        Aluno aluno = new Aluno(nome, idade, curso); //Criando o objeto aluno
        alunoRepository.cadastrarAluno(aluno);

        System.out.println("Cadastro realizado!");
    }

    public void listarAluno()
    {

        List<Aluno> alunos = alunoRepository.listarAlunos();

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
        Aluno aluno = alunoRepository.buscarPorId(id);

        //Valida se o aluno existe
        if(aluno == null)
        {
            System.out.println("Aluno não encontrado.");
            return;
        }

        //verifica se os novos dados de nome, idade e curso são válidos
        if (nome.isBlank() || idade <= 0 || curso.isBlank()) {
            System.out.println("Dados inválidos.");
            return;
        }

        aluno.setNome(nome);
        aluno.setIdade(idade);
        aluno.setCurso(curso);

        alunoRepository.atualizarAluno(aluno);

        System.out.println("Aluno atualizado com sucesso!");
    }

    public void excluirAluno(int id)
    {
        Aluno aluno = alunoRepository.buscarPorId(id);

        if(aluno == null)
        {
            System.out.println("Aluno não encontrado.");
            return;
        }

        alunoRepository.excluirAluno(id);
        System.out.println("Aluno excluído com sucesso!");
    }

}

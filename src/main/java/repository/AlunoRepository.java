package repository;
import model.Aluno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AlunoRepository
{
    public Aluno buscarPorId(int id) {

        String sql = "SELECT * FROM aluno WHERE id = ?";

        try (Connection conexao = Conexao.conectar(); PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, id);

            try (ResultSet resultado = stmt.executeQuery()) {

                if (resultado.next()) {

                    int idAluno = resultado.getInt("id");
                    String nome = resultado.getString("nome");
                    int idade = resultado.getInt("idade");
                    String curso = resultado.getString("curso");

                    return new Aluno(idAluno, nome, idade, curso);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void cadastrarAluno(Aluno aluno)
    {
        String sql = "INSERT INTO aluno (nome, idade, curso) VALUES (?, ?, ?)";

        try (Connection conexao = Conexao.conectar(); PreparedStatement stmt = conexao.prepareStatement(sql))
        {

            stmt.setString(1, aluno.getNome());
            stmt.setInt(2, aluno.getIdade());
            stmt.setString(3, aluno.getCurso());

            stmt.executeUpdate();

        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    public List<Aluno> listarAlunos()
    {

        List<Aluno> alunos = new ArrayList<>();

        String sql = "SELECT * FROM aluno";

        try (Connection conexao = Conexao.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet resultado = stmt.executeQuery()) {

            while (resultado.next()) {

                int id = resultado.getInt("id");
                String nome = resultado.getString("nome");
                int idade = resultado.getInt("idade");
                String curso = resultado.getString("curso");

                Aluno aluno = new Aluno(id, nome, idade, curso);

                alunos.add(aluno);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return alunos;
    }

    public void atualizarAluno(Aluno aluno) {

        String sql = "UPDATE aluno SET nome = ?, idade = ?, curso = ? WHERE id = ?";

        try (Connection conexao = Conexao.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, aluno.getNome());
            stmt.setInt(2, aluno.getIdade());
            stmt.setString(3, aluno.getCurso());
            stmt.setInt(4, aluno.getId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluirAluno(int id) {

        String sql = "DELETE FROM aluno WHERE id = ?";

        try (Connection conexao = Conexao.conectar();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, id);

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


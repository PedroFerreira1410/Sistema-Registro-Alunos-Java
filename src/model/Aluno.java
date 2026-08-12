package model;

public class Aluno {
    //Atributos - características que o aluno terá
    private int id;
    private String nome;
    private int idade;
    private String curso;

    //Construtor - metodo pra criar objetos e inicializar atributos
    public Aluno(int id, String nome, int idade, String curso){
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.curso = curso;
    }

    //getters e setters

    //pro id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //pro nome
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    //pra idade
    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    //pro curso
    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
}

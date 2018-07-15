package br.ufs.cienciainformacao.myapplication.classes.categoria;

/**
 * Created by Micael on 20/03/2017.
 */

public class Categoria {
    private String nome;
    private int id;

    public Categoria(String nome, int id) {
        this.nome = nome;
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }
}

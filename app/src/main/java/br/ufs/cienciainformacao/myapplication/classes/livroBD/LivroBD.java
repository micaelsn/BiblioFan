package br.ufs.cienciainformacao.myapplication.classes.livroBD;

/**
 * Created by Micael on 26/03/2017.
 */

public class LivroBD {
    private int id;
    private String diretorio;
    private String titulo;

    public LivroBD(){
    }

    public LivroBD(int id, String diretorio, String titulo){
        this.id = id;
        this.diretorio = diretorio;
        this.titulo = titulo;
        }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDiretorio() {
        return diretorio;
    }

    public void setDiretorio(String diretorio) {
        this.diretorio = diretorio;
    }
}

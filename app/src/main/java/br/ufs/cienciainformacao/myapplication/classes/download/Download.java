package br.ufs.cienciainformacao.myapplication.classes.download;

/**
 * Created by Micael on 27/01/2017.
 */

public class Download {
    private int data;
    private int paginas;
    private int isbn;
    private String titulo;
    private String autor;
    private String editora;
    private String categoria;
    private String areaDeInteresse;

    public Download(){

    }

    public Download( int data, int paginas, int isbn, String titulo, String autor,String editora,
                     String categoria, String areaDeInteresse){
        this.data = data;
        this.paginas = paginas;
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.categoria = categoria;
        this.areaDeInteresse = areaDeInteresse;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getAreaDeInteresse() {
        return areaDeInteresse;
    }

    public void setAreaDeInteresse(String areaDeInteresse) {
        this.areaDeInteresse = areaDeInteresse;
    }
}

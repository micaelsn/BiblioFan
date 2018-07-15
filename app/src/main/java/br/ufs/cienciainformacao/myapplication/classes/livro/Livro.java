package br.ufs.cienciainformacao.myapplication.classes.livro;

/**
 * Created by Micael on 17/03/2017.
 */

public class Livro {
    private long isbn;
    private int paginas;
    private String titulo;
    private String autor;
    private String editora;
    private String categoria;
    private String areaDeInteresse;
    private String arquivo;

    public Livro(){

    }

    public Livro(long isbn, int paginas, String titulo, String autor, String editora,
                 String categoria, String areaDeInteresse, String arquivo){
        this.isbn = isbn;
        this.paginas = paginas;
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.categoria = categoria;
        this.areaDeInteresse = areaDeInteresse;
        this.arquivo = arquivo;
    }

    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(long isbn) {
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

    public String getArquivo() {
        return arquivo;
    }

    public void setArquivo(String arquivo) {
        this.arquivo = arquivo;
    }
}

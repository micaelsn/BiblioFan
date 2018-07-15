package br.ufs.cienciainformacao.myapplication.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import br.ufs.cienciainformacao.myapplication.classes.download.Download;
import br.ufs.cienciainformacao.myapplication.classes.historico.Historico;
import br.ufs.cienciainformacao.myapplication.classes.historico.HistoricoListAdapter;
import br.ufs.cienciainformacao.myapplication.classes.livro.Livro;

/**
 * Created by Micael on 27/01/2017.
 */

public class BD extends SQLiteOpenHelper {
    private static final int VERSAO_BANCO = 1;
    private static final String BANCO_BIBLIOTECA = "biblioteca";
    private static final String TABELA_LIVRO = "tb_livros";
    private static final String COLUNA_ISBN = "_id";
    private static final String COLUNA_PAGINAS = "paginas";
    private static final String COLUNA_ARQUIVO = "arquivo";
    private static final String COLUNA_AUTOR = "autor";
    private static final String COLUNA_TITULO = "titulo";
    private static final String COLUNA_EDITORA = "editora";
    private static final String COLUNA_CATEGORIA = "categoria";
    private static final String COLUNA_AREA_DE_INTERESSE = "area_de_interesse";
    private static final String TABELA_DOWNLOAD = "tb_download";
    private static final String COLUNA_ISBN_DOWNLOAD = "isbn";
    private static final String COLUNA_DATA = "_id";
    private static final String TABELA_HISTORICO = "tb_historico";
    private static final String COLUNA_PESQUISA = "pesquisa";

    public BD(Context context) {
        super(context, BANCO_BIBLIOTECA, null, VERSAO_BANCO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String QUERY_LIVRO = "CREATE TABLE " + TABELA_LIVRO + "("
                + COLUNA_ISBN + " INTEGER PRIMARY KEY, " + COLUNA_PAGINAS + " INTEGER, "
                + COLUNA_ARQUIVO + " TEXT, " + COLUNA_AUTOR + " TEXT, " + COLUNA_TITULO + " TEXT, " +
                COLUNA_EDITORA + " TEXT, " + COLUNA_CATEGORIA + " TEXT, " + COLUNA_AREA_DE_INTERESSE
                + " TEXT)";
        String QUERY_DOWNLOAD = "CREATE TABLE " + TABELA_DOWNLOAD + "(" + COLUNA_DATA + " INTEGER PRIMARY KEY, "
                + COLUNA_ISBN_DOWNLOAD + " INTEGER, "+ COLUNA_TITULO +
                " TEXT, " + COLUNA_AUTOR + " TEXT, " + COLUNA_AREA_DE_INTERESSE + " TEXT, " +
                COLUNA_CATEGORIA + " TEXT)";
        String QUERY_HISTORICO = "CREATE TABLE " + TABELA_HISTORICO + "(" + COLUNA_DATA +
                " INTEGER PRIMARY KEY, " + COLUNA_PESQUISA + " TEXT)";
        db.execSQL(QUERY_LIVRO);
        db.execSQL(QUERY_DOWNLOAD);
        db.execSQL(QUERY_HISTORICO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    /* CRUD ABAIXO*/

    public void addLivro(Livro livro){
        SQLiteDatabase bd = this.getWritableDatabase();
        //capturar os valores pra o banco
        ContentValues values = new ContentValues();
        values.put(COLUNA_ISBN, livro.getIsbn());
        values.put(COLUNA_PAGINAS, livro.getPaginas());
        values.put(COLUNA_ARQUIVO, livro.getArquivo());
        values.put(COLUNA_AUTOR, livro.getAutor());
        values.put(COLUNA_TITULO, livro.getTitulo());
        values.put(COLUNA_EDITORA, livro.getEditora());
        values.put(COLUNA_CATEGORIA, livro.getCategoria());
        values.put(COLUNA_AREA_DE_INTERESSE, livro.getAreaDeInteresse());
        bd.insert(TABELA_LIVRO, null, values);
        bd.close();
    }

    public void addDownload(Download download){
        SQLiteDatabase bd = this.getWritableDatabase();
        //capturar os valores pra o banco
        ContentValues values = new ContentValues();

        values.put(COLUNA_DATA, download.getData());
        values.put(COLUNA_PAGINAS, download.getPaginas());
        values.put(COLUNA_ISBN_DOWNLOAD, download.getIsbn());
        values.put(COLUNA_TITULO, download.getTitulo());
        values.put(COLUNA_AUTOR, download.getAutor());
        values.put(COLUNA_AREA_DE_INTERESSE, download.getAreaDeInteresse());
        values.put(COLUNA_CATEGORIA, download.getCategoria());
        bd.insert(TABELA_DOWNLOAD, null, values);
        bd.close();
    }

    public void addHistorico(Historico historico){
        SQLiteDatabase bd = this.getWritableDatabase();
        //capturar os valores pra o banco
        ContentValues values = new ContentValues();

        values.put(COLUNA_DATA, historico.getData());
        values.put(COLUNA_PESQUISA, historico.getPesquisa());
        bd.insert(TABELA_HISTORICO, null, values);
        bd.close();
    }

    public List<Historico> carregaDados(){
        SQLiteDatabase db = this.getReadableDatabase();
        List<Historico> historicoList;

        Cursor cursor;

        String[] campos = {COLUNA_DATA, COLUNA_PESQUISA};
        cursor = db.query(TABELA_HISTORICO, campos, null, null, null, null, null, null);
        historicoList = new ArrayList<>();

        if (cursor.moveToFirst()) {


            do {
                Historico historico = new Historico();
                historico.setData(cursor.getInt(0));
                historico.setPesquisa(cursor.getString(1));
                historicoList.add(historico);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return historicoList;
    }

    void apagarLivro(Livro livro){
        SQLiteDatabase bd = this.getWritableDatabase();

        bd.delete(TABELA_LIVRO, COLUNA_ISBN + " = ? ", new String[]{ String.valueOf(livro.getIsbn())});
        bd.close();
    }
}
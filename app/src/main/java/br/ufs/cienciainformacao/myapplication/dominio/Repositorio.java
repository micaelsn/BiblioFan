package br.ufs.cienciainformacao.myapplication.dominio;

import android.content.Context;
import android.database.*;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ArrayAdapter;

import java.util.List;

import br.ufs.cienciainformacao.myapplication.classes.historico.Historico;
import br.ufs.cienciainformacao.myapplication.classes.historico.HistoricoListAdapter;

/**
 * Created by Micael on 23/03/2017.
 */

public class Repositorio {
    private SQLiteDatabase conn;

    Repositorio(SQLiteDatabase conn){
        this.conn = conn;
    }

    public HistoricoListAdapter buscaHistorico(Context context, List<Historico> historicos){
        HistoricoListAdapter historico = new HistoricoListAdapter(context, historicos);
        String[] campos =  {"_id", "pesquisa"};
        Cursor cursor = conn.query("tb_historico", campos, null, null, null, null, null, null);

        return null;
    }
}

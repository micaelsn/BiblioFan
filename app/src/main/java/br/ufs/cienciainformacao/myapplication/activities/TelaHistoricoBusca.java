package br.ufs.cienciainformacao.myapplication.activities;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import br.ufs.cienciainformacao.myapplication.R;
import br.ufs.cienciainformacao.myapplication.classes.historico.Historico;
import br.ufs.cienciainformacao.myapplication.classes.historico.HistoricoListAdapter;
import br.ufs.cienciainformacao.myapplication.database.BD;

public class TelaHistoricoBusca extends AppCompatActivity {
    private ListView lstHistorico;
    private HistoricoListAdapter adapter;
    private List<Historico> historicoList;
    private Historico historico;
    private BD bd = new BD(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_tela_historico_busca);

        lstHistorico = (ListView) findViewById(R.id.lstHistorico);
        try {

           historicoList = bd.carregaDados();
           adapter = new HistoricoListAdapter(getApplicationContext(), historicoList);
           lstHistorico.setAdapter(adapter);
        }catch (Exception e){
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setMessage("Error pesquisa: " + e.getMessage());
            dlg.setNeutralButton("ok", null);
            dlg.show();
        }
    }

}

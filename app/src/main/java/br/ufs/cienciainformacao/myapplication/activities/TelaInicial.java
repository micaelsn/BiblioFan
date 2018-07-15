package br.ufs.cienciainformacao.myapplication.activities;

import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import br.ufs.cienciainformacao.myapplication.R;
import br.ufs.cienciainformacao.myapplication.database.BD;

public class TelaInicial extends AppCompatActivity implements View.OnClickListener{
    private Button btnBusca;
    private Button btnLivros;
    private Button btnHistorico;
    private Button btnInteresses;
    private Button btnDownloads;

    //private Button btnSendData;
    //private Firebase ref;
    private BD bd;
    private SQLiteDatabase conn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_tela_inicial);
        btnBusca = (Button)findViewById(R.id.btnBusca);
        btnLivros = (Button)findViewById(R.id.btnLivros);
        btnInteresses = (Button)findViewById(R.id.btnInteresses);
        btnDownloads = (Button)findViewById(R.id.btnDownloads);
        btnHistorico = (Button)findViewById(R.id.btnHistorico);

        btnBusca.setOnClickListener(this);
        btnLivros.setOnClickListener(this);
        btnInteresses.setOnClickListener(this);
        btnDownloads.setOnClickListener(this);
        btnHistorico.setOnClickListener(this);
        /*TESTE CRUD*/
        try{
            bd = new BD(this);
            conn = bd.getWritableDatabase();
            Toast.makeText(TelaInicial.this, "Bem vindo", Toast.LENGTH_LONG).show();
        }catch (SQLException e){
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setMessage("Erro: " + e.getMessage());
            dlg.setNeutralButton("ok", null);
            dlg.show();
        }
    }

    @Override
    public void onClick(View v) {
        if (v == btnBusca) {
            Intent it = new Intent(this, TelaOpcoesDeBusca.class);
            startActivity(it);
        }else{
            if (v == btnLivros){
                Intent it = new Intent(this, TelaGaleriaLivros.class);
                startActivity(it);
            } else {
                if (v == btnInteresses){
                    Intent it = new Intent(this, TelaAreasInteresse.class);
                    startActivity(it);
                } else{
                    if (v == btnDownloads){
                        Intent it = new Intent(this, TelaDownload.class);
                        startActivity(it);
                    } else
                        if (v == btnHistorico){
                            Intent it = new Intent(this, TelaHistoricoBusca.class);
                            startActivity(it);
                        }
                }
            }
        }
    }
}
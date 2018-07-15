package br.ufs.cienciainformacao.myapplication.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.ufs.cienciainformacao.myapplication.R;
import br.ufs.cienciainformacao.myapplication.classes.categoria.Categoria;
import br.ufs.cienciainformacao.myapplication.classes.categoria.CategoriaGridAdapter;

public class TelaOpcoesDeBusca extends AppCompatActivity implements View.OnClickListener{
    private Button btnPesquisar;
    private GridView gridView;
    private CategoriaGridAdapter adapter;
    private String listaTitulos[] = {"bruxas", "animais", "robo", "yuri","super herois"};
    private int listaIcones[] = {R.mipmap.bruxas, R.mipmap.animais, R.mipmap.robo, R.mipmap.yuri,
                                    R.mipmap.superherois};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_opcoes_de_busca);
        btnPesquisar = (Button)findViewById(R.id.btnPesquisar);
        gridView = (GridView) findViewById(R.id.categoria_dwonload);

        adapter = new CategoriaGridAdapter(getApplicationContext(), listaIcones, listaTitulos);

        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent it = new Intent(getApplicationContext(),TelaDownloadCategoria.class);
                startActivity(it);

                Toast.makeText(getApplicationContext(), listaTitulos[position], Toast.LENGTH_SHORT).show();
            }
        });

        btnPesquisar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == btnPesquisar) {
            Intent it = new Intent(this, TelaPesquisa.class);
            startActivity(it);
        }
    }
}

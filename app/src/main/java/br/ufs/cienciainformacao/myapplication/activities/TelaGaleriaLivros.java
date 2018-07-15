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
import br.ufs.cienciainformacao.myapplication.classes.livroBD.LivroBD;
import br.ufs.cienciainformacao.myapplication.classes.livroBD.LivroGridAdapter;

public class TelaGaleriaLivros extends AppCompatActivity {
    private GridView gridLivros;
    private List<LivroBD> livrosList;
    private LivroGridAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_tela_galeria_livros);
        gridLivros = (GridView)findViewById(R.id.lista_arquivos);

        LivroBD livroBD1 = new LivroBD(1,"kekjjkf","livro1");
        LivroBD livroBD2 = new LivroBD(2,"kekjjkf","livro2");
        LivroBD livroBD3 = new LivroBD(3,"kekjjkf","livro3");
        LivroBD livroBD4 = new LivroBD(4,"kekjjkf","livro4");
        LivroBD livroBD5 = new LivroBD(5,"kekjjkf","livro5");
        LivroBD livroBD6 = new LivroBD(6,"kekjjkf","livro6");
        LivroBD livroBD7 = new LivroBD(7,"kekjjkf","livro7");
        LivroBD livroBD8 = new LivroBD(8,"kekjjkf","livro8");

        livrosList = new ArrayList<>();

        livrosList.add(livroBD1);
        livrosList.add(livroBD2);
        livrosList.add(livroBD3);
        livrosList.add(livroBD4);
        livrosList.add(livroBD5);
        livrosList.add(livroBD6);
        livrosList.add(livroBD7);
        livrosList.add(livroBD8);

        adapter = new LivroGridAdapter(getApplicationContext(), livrosList);

        gridLivros.setAdapter(adapter);

        gridLivros.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent it = new Intent(getApplicationContext(),TelaLeitura.class);
                startActivity(it);
                Toast.makeText(getApplicationContext(), livrosList.get(position).getTitulo(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}

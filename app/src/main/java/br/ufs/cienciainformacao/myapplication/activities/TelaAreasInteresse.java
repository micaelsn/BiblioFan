package br.ufs.cienciainformacao.myapplication.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import br.ufs.cienciainformacao.myapplication.R;

public class TelaAreasInteresse extends AppCompatActivity {
    private Button btnInteresse;
    private Button btnDownloads;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_areas_interesse);
        btnInteresse = (Button)findViewById(R.id.btnInteresse);
        btnDownloads = (Button)findViewById(R.id.btnDownloads);

    }
}

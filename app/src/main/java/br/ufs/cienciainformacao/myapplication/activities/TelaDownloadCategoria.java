package br.ufs.cienciainformacao.myapplication.activities;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import br.ufs.cienciainformacao.myapplication.R;
import br.ufs.cienciainformacao.myapplication.classes.firebase_referencia.FirebaseRef;
import br.ufs.cienciainformacao.myapplication.classes.livro.Livro;
import br.ufs.cienciainformacao.myapplication.classes.livro.LivroListAdapter;

/**
 * Created by Micael on 21/03/2017.
 */

public class TelaDownloadCategoria extends AppCompatActivity implements View.OnClickListener{
    private ListView listArquivos;
    private List<Livro> listLivros;
    private LivroListAdapter adapter;
    private static final int DIALOG_DOWNLOAD_PROGRESSO = 1 ;
    private ProgressDialog progressDialog;

    private FirebaseDatabase firebase;
    private DatabaseReference referencia;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_download_categoria);

        verificar_permicao();

    }

    private void verificar_permicao() {
        if(ActivityCompat.checkSelfPermission(this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != getPackageManager().PERMISSION_GRANTED){
            requestPermissions(new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE},100);
            return;
        }
        inicialize();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == 100 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
            inicialize();
        }else {
            verificar_permicao();
        }
    }

    /*INICIALIZAÇÃO*/
    private void inicialize() {

        listArquivos = (ListView)findViewById(R.id.list_arquivos);

        try {
            firebase = FirebaseDatabase.getInstance();
            int id = 1;
            referencia = firebase.getReference(FirebaseRef.REFERENCIA_LIVRO);

            listLivros = new ArrayList<>();

            adapter = new LivroListAdapter(getApplicationContext(), listLivros);
            listArquivos.setAdapter(adapter);

            while (id <= FirebaseRef.TAMANHO) {
                referencia.child("" + id).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        Livro livro = dataSnapshot.getValue(Livro.class);
                        if (livro.getCategoria().contains(FirebaseRef.REFERENCIA_ANIMAIS)) {
                            listLivros.add(livro);
                            adapter.notifyDataSetChanged();
                            listArquivos.setAdapter(adapter);
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
                id++;
            }
            listArquivos.setOnItemClickListener(new AdapterView.OnItemClickListener(){
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    String url = (String) view.getTag();

                    new DownloadFileAsync().execute(url);
                    //bd.addLivro(new Livro());
                    //Toast.makeText(getApplicationContext(), "Isbn " + view.getTag(), Toast.LENGTH_SHORT).show();
                }
            });
        }catch (Exception e){
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setMessage("Error pesquisa: " + e.getMessage());
            dlg.setNeutralButton("ok", null);
            dlg.show();
        }
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id){
            case DIALOG_DOWNLOAD_PROGRESSO:
                progressDialog = new ProgressDialog(this);
                progressDialog.setMessage("Download Arquivo...");
                progressDialog.setProgressStyle(progressDialog.STYLE_HORIZONTAL);
                progressDialog.setCancelable(false);
                progressDialog.show();
                return progressDialog;
            default:
                return null;
        }
    }
    class DownloadFileAsync extends AsyncTask<String, String, String> {
        @Override
        protected String doInBackground(String... strings) {
            int cont;
            try {
                URL url = new URL(strings[0]);
                URLConnection conction = url.openConnection();
                conction.connect();

                int lengthOfFile = conction.getContentLength();
                Log.d("ANDRO_ASYNC","Tamanho do arquivo" + lengthOfFile);
                InputStream input = new BufferedInputStream(url.openStream());
                OutputStream output = new FileOutputStream("sdcard/Download/ola.pdf");

                byte data[] = new byte[1024];
                long total = 0;
                while((cont = input.read(data)) != -1){
                    total +=cont;
                    publishProgress(""+(int)((total * 100 / lengthOfFile)));
                    output.write(data, 0, cont);
                }
                output.flush();
                output.close();
                input.close();

            }catch (Exception e){
                Log.e("Errinho", e.getMessage());
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            dismissDialog(DIALOG_DOWNLOAD_PROGRESSO);
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            showDialog(DIALOG_DOWNLOAD_PROGRESSO);
        }

        @Override
        protected void onProgressUpdate(String... values) {
            Log.d("ANDRO_ASYNC", values[0]);
            progressDialog.setProgress(Integer.parseInt(values[0]));
        }

        @Override
        protected void onCancelled(String s) {
            super.onCancelled(s);
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
        }
    }
}

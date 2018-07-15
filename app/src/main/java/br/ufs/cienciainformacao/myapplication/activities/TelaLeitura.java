package br.ufs.cienciainformacao.myapplication.activities;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.pdf.PdfRenderer;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.graphics.pdf.*;
import java.io.File;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;

import br.ufs.cienciainformacao.myapplication.R;

public class TelaLeitura extends AppCompatActivity {
    private ImageView imagem;
    private Button btnAnt, btnProx;
    private int pagina = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_tela_leitura);
        btnAnt = (Button)findViewById(R.id.btnAnt);
        btnProx = (Button)findViewById(R.id.btnProx);


        btnProx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pagina++;
                render();
            }
        });
        btnAnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pagina++;
                render();
            }
        });

        render();
    }


   // @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void render(){
        Bitmap img = null;
        try{
            imagem = (ImageView)findViewById(R.id.imagem);
            int REQ_WIDTH = imagem.getWidth();
            int REQ_HEIGHT = imagem.getHeight();
            Bitmap bitmap = Bitmap.createBitmap(REQ_WIDTH, REQ_HEIGHT, Bitmap.Config.ARGB_4444);
            //URL url = new URL("http://www.ufjf.br/revistaveredas/files/2009/11/ARTIGO-Maira-Avelar-e-Janaina-Rabelo.pdf");
            //HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
            //InputStream input = conexao.getInputStream();
            //img = BitmapFactory.decodeStream(input);
            File file = new File("/sdcard/Download/ola.pdf");
            PdfRenderer renderer = new PdfRenderer(ParcelFileDescriptor.open(file, ParcelFileDescriptor.MODE_READ_ONLY));
            //PdfRenderer(ParcelFileDescriptor.open(file, ParcelFileDescriptor.MODE_READ_ONLY));
            if(pagina < 0){
                pagina = 0;
            } else if(pagina > renderer.getPageCount()){
                pagina = renderer.getPageCount() - 1;
            }

            Matrix m = imagem.getImageMatrix();
            Rect rect = new Rect(0, 0, REQ_WIDTH, REQ_HEIGHT);
            renderer.openPage(pagina).render(bitmap, rect, m, PdfRenderer.Page.RENDER_MODE_FOR_DISPLAY);
            imagem.setImageMatrix(m);
            imagem.setImageBitmap(bitmap);
            imagem.invalidate();
        } catch (Exception e){
            AlertDialog.Builder dlg = new AlertDialog.Builder(this);
            dlg.setMessage("Error ao abrir arquivo " + e.getMessage());
            dlg.setNeutralButton("ok", null);
            dlg.show();
        }
    }
}

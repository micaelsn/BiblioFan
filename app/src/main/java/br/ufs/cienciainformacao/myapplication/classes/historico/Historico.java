package br.ufs.cienciainformacao.myapplication.classes.historico;

import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Micael on 27/01/2017.
 */

public class Historico {
    private int data;
    private String pesquisa;
    private long data2;

    public Historico(){
    }

    public Historico(int data, String pesquisa){
        this.data = data;
        this.pesquisa = pesquisa;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public String getPesquisa() {
        return pesquisa;
    }

    public void setPesquisa(String pesquisa) {
        this.pesquisa = pesquisa;
    }

    public long getDataPesquisa() {
        return data2;
    }

    public void setDataPesquisa(long data) {
        this.data2 = data;
    }

    public String data(){
        SimpleDateFormat formatoBrasil = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.SSS");
        Date data = new Date(getDataPesquisa());
        Log.i("Data da",""+getData());
        Log.i("Data da",""+data);
        return formatoBrasil.format(data);
    }
}

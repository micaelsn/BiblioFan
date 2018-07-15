package br.ufs.cienciainformacao.myapplication.classes.historico;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.ufs.cienciainformacao.myapplication.R;

/**
 * Created by Micael on 20/03/2017.
 */

public class HistoricoListAdapter extends BaseAdapter{
    private Context context;
    private List<Historico> historicos;

    public HistoricoListAdapter(Context context, List<Historico> historicos) {
        this.context = context;
        this.historicos = historicos;
    }

    @Override
    public int getCount() {
        return historicos.size();
    }

    @Override
    public Object getItem(int position) {
        return historicos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = View.inflate(context, R.layout.act_list_historico, null);
        TextView textData = (TextView)v.findViewById(R.id.text_data);
        TextView textPesquisa = (TextView)v.findViewById(R.id.text_pesquisa);

        textData.setText(historicos.get(position).data());
        textPesquisa.setText(historicos.get(position).getPesquisa());

        return v;
    }
}

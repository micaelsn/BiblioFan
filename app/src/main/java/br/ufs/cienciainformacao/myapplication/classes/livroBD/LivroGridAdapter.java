package br.ufs.cienciainformacao.myapplication.classes.livroBD;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.ufs.cienciainformacao.myapplication.R;

/**
 * Created by Micael on 26/03/2017.
 */

public class LivroGridAdapter extends BaseAdapter{
    private Context context;
    private List<LivroBD> livroBDs;
    private LayoutInflater inflater;

    public LivroGridAdapter(Context context, List<LivroBD> livroBDs) {
        this.context = context;
        this.livroBDs = livroBDs;
    }

    @Override
    public int getCount() {
        return livroBDs.size();
    }

    @Override
    public Object getItem(int position) {
        return livroBDs.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View grindView = convertView;

        if (convertView == null){
            inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            grindView = inflater.inflate(R.layout.act_list_livro_leitura,null);
        }

        TextView nomeLivro = (TextView) grindView.findViewById(R.id.titulo_livro);
        ImageView imagemPdf = (ImageView) grindView.findViewById(R.id.pdf_logo);

        nomeLivro.setText(livroBDs.get(position).getTitulo());
        imagemPdf.setImageResource(R.mipmap.unnamed);
        return grindView;
    }
}

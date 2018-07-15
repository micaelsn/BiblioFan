package br.ufs.cienciainformacao.myapplication.classes.categoria;

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
 * Created by Micael on 20/03/2017.
 */

public class CategoriaGridAdapter extends BaseAdapter {
    private Context context;
    private int icons[];
    private String letters[];
    private LayoutInflater inflater;

    public CategoriaGridAdapter(Context context, int icons[], String letters[]) {
        this.context = context;
        this.icons = icons;
        this.letters = letters;
    }

    @Override
    public int getCount() {
        return letters.length;
    }

    @Override
    public Object getItem(int position) {
        return letters[position];
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
            grindView = inflater.inflate(R.layout.act_grid_categoria,null);
        }

        TextView nomeCategoria = (TextView) grindView.findViewById(R.id.nome_categoria);
        ImageView imagemCategoria = (ImageView) grindView.findViewById(R.id.nome_imagem_categoria);

        imagemCategoria.setImageResource(icons[position]);
        nomeCategoria.setText(letters[position]);

        return grindView;
    }
}

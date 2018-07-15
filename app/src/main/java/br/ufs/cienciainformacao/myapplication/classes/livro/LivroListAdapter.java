package br.ufs.cienciainformacao.myapplication.classes.livro;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.ufs.cienciainformacao.myapplication.R;

/**
 * Created by Micael on 18/03/2017.
 */

public class LivroListAdapter extends BaseAdapter{
    private Context context;
    private List<Livro> livroList;

    public LivroListAdapter(Context context, List<Livro> livroList) {
        this.context = context;
        this.livroList = livroList;
    }

    @Override
    public int getCount() {
        return livroList.size();
    }

    @Override
    public Object getItem(int position) {
        return livroList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = View.inflate(context, R.layout.act_item_livro, null);
        TextView txtTitulo = (TextView)v.findViewById(R.id.titulo_livro);
        TextView txtAutor = (TextView)v.findViewById(R.id.autor_livro);
        TextView txtPaginas = (TextView)v.findViewById(R.id.paginas_livro);
        ImageView imagem = (ImageView)v.findViewById(R.id.imagemPDF);

        txtTitulo.setText(livroList.get(position).getTitulo());
        txtAutor.setText("Autor: "+livroList.get(position).getAutor());
        txtPaginas.setText(livroList.get(position).getPaginas()+" Páginas");
        imagem.setImageResource(R.mipmap.unnamed);

        v.setTag(livroList.get(position).getArquivo());
        return v;
    }
}

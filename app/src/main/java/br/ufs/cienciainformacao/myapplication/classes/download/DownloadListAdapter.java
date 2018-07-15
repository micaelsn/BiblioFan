package br.ufs.cienciainformacao.myapplication.classes.download;

import android.content.Context;
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

public class DownloadListAdapter extends BaseAdapter {
    private Context context;
    private List<Download> downloads;

    public DownloadListAdapter(Context context, List<Download> downloads) {
        this.context = context;
        this.downloads = downloads;
    }

    @Override

    public int getCount() {
        return downloads.size();
    }

    @Override
    public Object getItem(int position) {
        return downloads.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = View.inflate(context, R.layout.act_grid_categoria, null);
        TextView nomeCategoria = (TextView)v.findViewById(R.id.nome_categoria);
        ImageView imagemCategoria = (ImageView)v.findViewById(R.id.nome_imagem_categoria);

        nomeCategoria.setText(downloads.get(position).getCategoria());
        if (downloads.get(position).getCategoria().equals("bruxas")){
            imagemCategoria.setImageResource(R.mipmap.bruxas);
        }else {
            if (downloads.get(position).getCategoria().equals("animais")){
                imagemCategoria.setImageResource(R.mipmap.animais);
            }else{
                if (downloads.get(position).getCategoria().equals("robo")){
                    imagemCategoria.setImageResource(R.mipmap.robo);
                }else{
                    if (downloads.get(position).getCategoria().equals("não sei")){
                        imagemCategoria.setImageResource(R.mipmap.yuri);
                    }
                }
            }
        }
        return null;
    }
}

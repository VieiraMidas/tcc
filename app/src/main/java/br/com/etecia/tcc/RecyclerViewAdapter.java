package br.com.etecia.tcc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context context;
    private List<Produto> dadosProduto;

    public RecyclerViewAdapter(Context context, List<Produto> dadosProduto) {
        this.context = context;
        this.dadosProduto = dadosProduto;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.layout_modelo_recycler,parent,false);

        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.MyViewHolder holder, int position) {
        holder.txtProduto.setText(dadosProduto.get(position).getNome());
        holder.imagemLogo.setImageResource(dadosProduto.get(position).getLogo());
    }

    @Override
    public int getItemCount() {
        return dadosProduto.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView txtProduto;
        ImageView imagemLogo;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            txtProduto = itemView.findViewById(R.id.txtnomeproduto);
            imagemLogo = itemView.findViewById(R.id.imglogo);
        }
    }
}

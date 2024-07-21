package com.example.recyclerviewcard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterCardView extends RecyclerView.Adapter<AdapterCardView.ViewHolder> {

    private LayoutInflater layoutInflater;
    private List<ItemModel_CardView> data;

    AdapterCardView(Context context, List<ItemModel_CardView> data){
        this.layoutInflater = LayoutInflater.from(context);
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = layoutInflater.inflate(R.layout.custom_cardview,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        //Bind the textview with data received
        ItemModel_CardView item = data.get(i);
        viewHolder.textTitle.setText(item.getTitle());
        viewHolder.textDescription.setText(item.getDescription());
        viewHolder.imageView.setImageResource(item.getImage());


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView textTitle,textDescription;
        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textTitle = itemView.findViewById(R.id.titleCard);
            textDescription = itemView.findViewById(R.id.descCard);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }

}

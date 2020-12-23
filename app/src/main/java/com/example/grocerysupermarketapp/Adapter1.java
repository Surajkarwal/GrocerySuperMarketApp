package com.example.grocerysupermarketapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class Adapter1 extends RecyclerView.Adapter<Adapter1.ViewHolder> {
    LayoutInflater inflater;
    List<String> item,price,description,image;

    public Adapter1(Context context, List<String> itemp,List<String> pricep,List<String> descp,List<String> imagep )
    {
        this.inflater = LayoutInflater.from(context);
        item = itemp;
        price = pricep;
      description = descp;

        image = imagep;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.layout_1,parent,false);





        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        String items = item.get(position);
        String Prices = price.get(position);

        String img = image.get(position);
String desc = description.get(position);
        holder.item.setText(items);
        holder.price.setText(Prices);
holder.desc.setText(desc);

        Picasso.get().load(img).into(holder.imgca);




    }

    @Override
    public int getItemCount() {
        return item.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView item;
        TextView price;
        TextView desc;

        ImageView imgca;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            item = itemView.findViewById(R.id.item);
            price = itemView.findViewById(R.id.Price);
            desc = itemView.findViewById(R.id.desc);
            imgca = itemView.findViewById(R.id.cardImg);


        }
    }
}

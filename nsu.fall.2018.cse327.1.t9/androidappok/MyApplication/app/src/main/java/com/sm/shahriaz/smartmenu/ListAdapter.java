package com.sm.shahriaz.smartmenu;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    private List<ListItem> listItems;
    private Context context;

    public ListAdapter(List<ListItem> categoryItems, Context context) {
        this.listItems = categoryItems;
        this.context = context;
    }

    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.category_item, parent, false);
        return new ListAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ListAdapter.ViewHolder holder, int position) {
        final ListItem listItem = listItems.get(position);

        holder.textViewHead.setText(listItem.getFoodname());
        holder.textViewDesc.setText(listItem.getFooddetails());

        Picasso.get().load(listItem.getFoodimage()).into(holder.imageFoodImage);

        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ArActivity.class);
                intent.putExtra("armodel", listItem.getArmodel());
                v.getContext().startActivity(intent);
                Toast.makeText(context, "You Clicked "+ listItem.getFoodname(), Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView textViewHead;
        public TextView textViewDesc;
        public ImageView imageFoodImage;
        public RelativeLayout relativeLayout;


        public ViewHolder(View itemView) {
            super(itemView);
            textViewHead = (TextView) itemView.findViewById(R.id.textViewHead);
            textViewDesc = (TextView) itemView.findViewById(R.id.textViewDesc);
            imageFoodImage = (ImageView)itemView.findViewById(R.id.imageFoodImage);
            relativeLayout = (RelativeLayout)itemView.findViewById(R.id.relativelayout);
        }
    }


}

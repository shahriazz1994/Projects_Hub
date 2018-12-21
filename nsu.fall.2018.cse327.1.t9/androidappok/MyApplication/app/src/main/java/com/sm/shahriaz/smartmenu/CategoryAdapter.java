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

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    private List<CategoryItem> categoryItems;
    private Context context;

    public CategoryAdapter(List<CategoryItem> categoryItems, Context context) {
        this.categoryItems = categoryItems;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final CategoryItem categoryItem = categoryItems.get(position);

        holder.textViewHead.setText(categoryItem.getCategoryname());
        holder.textViewDesc.setText(categoryItem.getCategorydetails());

        Picasso.get().load(categoryItem.getCategoryimage()).into(holder.imageFoodImage);

        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  intent = new Intent(v.getContext(), FoodListActivity.class);
                intent.putExtra("id", categoryItem.getId());
                v.getContext().startActivity(intent);
                Toast.makeText(context, "You Clicked "+ categoryItem.getCategoryname(), Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return categoryItems.size();
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

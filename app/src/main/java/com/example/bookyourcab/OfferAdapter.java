package com.example.bookyourcab;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class OfferAdapter extends RecyclerView.Adapter<OfferAdapter.OfferViewHolder> {

    List<String> listOfOffers;

    Context context;
    public OfferAdapter(Context context, List<String> listOfOffers){
        this.context=context;
        this.listOfOffers=listOfOffers;
    }

    class OfferViewHolder extends RecyclerView.ViewHolder{
        TextView offer;
        OfferViewHolder(View itemView){
            super(itemView);
            offer = itemView.findViewById(R.id.name);
        }
    }

    public OfferViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleview,null,false);
        OfferViewHolder offerViewHolder=new OfferViewHolder(view);
        return offerViewHolder;
    }

    public void onBindViewHolder(OfferViewHolder holder, final int position) {
        holder.offer.setText(listOfOffers.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Log.d("Item Clicked",listOfOffers.get(position));
            }
        });
    }
    public int getItemCount() {
        return listOfOffers.size();
    }
}

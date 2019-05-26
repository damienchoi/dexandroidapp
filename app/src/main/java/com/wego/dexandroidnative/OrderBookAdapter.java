package com.wego.dexandroidnative;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class OrderBookAdapter extends RecyclerView.Adapter<OrderBookAdapter.ViewHolder>{

    private ArrayList<OrderBookData> orderBookDataArrayList = null;
    Context context;

    class ViewHolder extends RecyclerView.ViewHolder{

        public TextView order_book_buy;
        public TextView order_book_price_buy;
        public TextView order_book_price_sell;
        public TextView order_book_sell;

        //ViewHolder 생성
        public ViewHolder(View itemView) {
            super(itemView);

            //View를 넘겨받아서 ViewHolder를 완성
            order_book_buy = itemView.findViewById(R.id.order_book_buy);
            order_book_price_buy = itemView.findViewById(R.id.order_book_price_buy);
            order_book_price_sell = itemView.findViewById(R.id.order_book_price_sell);
            order_book_sell = itemView.findViewById(R.id.order_book_sell);

        }
    }

    OrderBookAdapter(ArrayList<OrderBookData> list){
        this.orderBookDataArrayList = list;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        this.context = viewGroup.getContext();

        View itemView = LayoutInflater.from(context).inflate(R.layout.market_detail_orderbook_recycler_item, viewGroup,false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        OrderBookData orderBookData = orderBookDataArrayList.get(position);

        viewHolder.order_book_buy.setText(String.valueOf(orderBookData.getBuy()));
        viewHolder.order_book_price_buy.setText(Double.toString(orderBookData.getBuy_price_token()));
        viewHolder.order_book_price_sell.setText(String.valueOf(orderBookData.getSell_price_token()));
        viewHolder.order_book_sell.setText(String.valueOf(orderBookData.getSell()));
    }

    @Override
    public int getItemCount() {
        return orderBookDataArrayList.size();
    }
}
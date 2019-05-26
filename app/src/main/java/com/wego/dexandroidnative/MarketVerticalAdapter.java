package com.wego.dexandroidnative;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MarketVerticalAdapter extends RecyclerView.Adapter<MarketVerticalAdapter.ViewHolder> {

    private ArrayList<String> mData = null;
    Context context;

    // 아이템 뷰를 저장하는 뷰홀더 클래스.
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView token_name;
        Button add_button;


        ViewHolder(View itemView) {
            super(itemView);

            // 뷰 객체에 대한 참조. (hold strong reference)
            token_name = itemView.findViewById(R.id.token_name);
            add_button = itemView.findViewById(R.id.add_token);
        }
    }

    // 생성자에서 데이터 리스트 객체를 전달받음.
    MarketVerticalAdapter(ArrayList<String> list) {
        mData = list;
    }

    // onCreateViewHolder() - 아이템 뷰를 위한 뷰홀더 객체 생성하여 리턴.
    @Override
    public MarketVerticalAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        this.context = parent.getContext();

        View itemView;

        if (viewType == R.layout.market_vertical_recycler_item) {
            itemView = LayoutInflater.from(context).inflate(R.layout.market_vertical_recycler_item, parent, false);
        } else {
            itemView = LayoutInflater.from(context).inflate(R.layout.market_vertical_recycler_addbtn, parent, false);
        }

//        itemView = inflater.inflate(R.layout.market_vertical_recycler_item, parent, false) ;
        MarketVerticalAdapter.ViewHolder vh = new MarketVerticalAdapter.ViewHolder(itemView);

        return vh;
    }

    // onBindViewHolder() - position에 해당하는 데이터를 뷰홀더의 아이템뷰에 표시.
    @Override
    public void onBindViewHolder(MarketVerticalAdapter.ViewHolder holder, int position) {
        if (position == mData.size()) {
            holder.add_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, "Add", Toast.LENGTH_SHORT).show();
                }
            });
        } else {

            String text = mData.get(position);
            holder.token_name.setText(text);
        }
    }

    // getItemCount() - 전체 데이터 갯수 리턴.
    @Override
    public int getItemCount() {
        return mData.size() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        return (position == mData.size()) ? R.layout.market_vertical_recycler_addbtn : R.layout.market_vertical_recycler_item;
    }
}
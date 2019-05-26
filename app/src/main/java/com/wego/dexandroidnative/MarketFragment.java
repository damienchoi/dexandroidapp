package com.wego.dexandroidnative;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MarketFragment extends Fragment {

    private RecyclerView market_Vertical_Recyler;
    private RecyclerView market_Horizontal_Recyler;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,

                             @Nullable Bundle savedInstanceState) {
        LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.market_fragment,

                container, false);

        ArrayList<String> verti_list = new ArrayList<>();
        ArrayList<String> hori_list = new ArrayList<>();
//        for (int i = 0; i < 100; i++) {
        verti_list.add(String.format("CPGX / ETH"));
        verti_list.add(String.format("HGC / ETH"));
        verti_list.add(String.format("DCMC / ETH"));
        verti_list.add(String.format("UMX / ETH"));

        hori_list.add(String.format("ETH"));
        hori_list.add(String.format("BTC"));
        hori_list.add(String.format("CPGX"));
        hori_list.add(String.format("HGC"));
        hori_list.add(String.format("DCMC"));
        hori_list.add(String.format("UMX"));
        hori_list.add(String.format("ETH"));
        hori_list.add(String.format("BTC"));
        hori_list.add(String.format("CPGX"));
        hori_list.add(String.format("HGC"));
        hori_list.add(String.format("DCMC"));
        hori_list.add(String.format("UMX"));

//        }

        // 리사이클러뷰에 LinearLayoutManager 객체 지정.
        market_Vertical_Recyler = (RecyclerView) layout.findViewById(R.id.vertical_list);
        market_Vertical_Recyler.setLayoutManager(new LinearLayoutManager(getActivity()));

        // 리사이클러뷰에 MarketVerticalAdapter 객체 지정.
        MarketVerticalAdapter ver_adapter = new MarketVerticalAdapter(verti_list);
        market_Vertical_Recyler.setAdapter(ver_adapter);

        market_Horizontal_Recyler = (RecyclerView) layout.findViewById(R.id.horizontal_list);
        market_Horizontal_Recyler.setLayoutManager(new LinearLayoutManager(getActivity()));
        market_Horizontal_Recyler.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));


        // 리사이클러뷰에 MarketVerticalAdapter 객체 지정.
        MarketHorizontalAdapter hori_adapter = new MarketHorizontalAdapter(hori_list);
        market_Horizontal_Recyler.setAdapter(hori_adapter);
        return layout;
    }
}


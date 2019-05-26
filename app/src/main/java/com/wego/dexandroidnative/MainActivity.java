package com.wego.dexandroidnative;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    ViewPager pager;
    private DrawerLayout mDrawerLayout;
    ImageView navi;

    int requestCode = 1001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //권한을 얻었는지 확인하는 부분
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED){

            //권한을 설명 해줘야 할 필요가 있는지
            if(ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.INTERNET)){
                //권한을 설명해준다
            }
            else{
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.INTERNET}, requestCode);
            }
        }

        initialize();

        pager = (ViewPager) findViewById(R.id.pager);
        LinearLayout market_btn = (LinearLayout) findViewById(R.id.market_btn);
        LinearLayout order_btn = (LinearLayout) findViewById(R.id.order_btn);
        LinearLayout wallet_btn = (LinearLayout) findViewById(R.id.wallet_btn);

        pager.setAdapter(new pagerAdapter(getSupportFragmentManager()));
        pager.setCurrentItem(0);


        navi = (ImageView) findViewById(R.id.navi);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        navi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawerLayout.openDrawer(GravityCompat.START);
            }
        });

        View.OnClickListener movePageListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int tag = (int) view.getTag();
                pager.setCurrentItem(tag);
            }
        };

        market_btn.setOnClickListener(movePageListener);
        market_btn.setTag(0);
        order_btn.setOnClickListener(movePageListener);
        order_btn.setTag(1);
        wallet_btn.setOnClickListener(movePageListener);
        wallet_btn.setTag(2);

    }

    private void initialize() {

    }


    private class pagerAdapter extends FragmentStatePagerAdapter {
        public pagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new MarketFragment();
                case 1:
                    return new OrderFragment();
                case 2:
                    return new Wallet_Fragment();
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            // total page count
            return 3;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode == this.requestCode){
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Log.d("test", "permission granted");
            }
            else{
                Log.d("test", "permission denied");
            }
        }
    }

}
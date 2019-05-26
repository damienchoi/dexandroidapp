package com.wego.dexandroidnative;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.wego.dexandroidnative.contracts.CpublicDex_sol_CpublicDex;
import com.wego.dexandroidnative.utilities.Web3jConstant;
import com.wego.dexandroidnative.utilities.Web3jFactory;

import org.web3j.crypto.Credentials;
import org.web3j.crypto.ECKeyPair;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthGetBalance;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;
import org.web3j.utils.Convert;
import org.web3j.utils.Numeric;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;


//import com.wego.dexandroidnative.LoginActivity.web3j;


public class MarketDetailToken extends AppCompatActivity implements View.OnClickListener {

    ArrayList<OrderBookData> mArrayList;
    OrderBookData[] date;
    Button btnBuy;
    Button btnSell;
    ImageView price_chart;
    ImageView depth_chart;
    ImageView chart_image;


    boolean isInfura = true;

    static CpublicDex_sol_CpublicDex cpublicDexContract;
//    static CpublicDex_sol_ReserveToken reserveTokenContract;
//    static CpublicDex_sol_SafeMath safeMathContract;
//    static CpublicDex_sol_Token tokenContract = null;

    static public Web3j web3j = null;
    static String clientUrl = null;
    public static Credentials CREDENTIALS = null;
    static ECKeyPair KEY_PAIR = null;
    public static String ADDRESS = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market_detail);


        StartConnect();
        Web3ClientVersion client = null;
        try {
            client = web3j.web3ClientVersion().sendAsync().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        Log.d("Test", "Connected to :" + client.getWeb3ClientVersion());

        initialize();
        mArrayList = new ArrayList<>();
        date = new OrderBookData[10];

        for (int i = 0; i < 10; i++) {
            date[i] = new OrderBookData(0 + i, 0.0003, 0.000964, 10 - i);
            mArrayList.add(date[i]);
        }

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.order_book_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        OrderBookAdapter orderBookAdapter = new OrderBookAdapter(mArrayList);
        recyclerView.setAdapter(orderBookAdapter);
        KEY_PAIR = new ECKeyPair(Numeric.toBigInt(Web3jConstant.TEST_PK), Numeric.toBigInt(Web3jConstant.TEST_ACCOUNT));
        CREDENTIALS = Credentials.create(Web3jConstant.TEST_PK);
        //CREDENTIALS = Credentials.create(Web3jConstant.ADMIN_PK, Web3jConstant.ADMIN_ADDRESS);
        ADDRESS = CREDENTIALS.getAddress();

        try{
            CpublicDex_sol_CpublicDex cpublicDexLoaded = loadCpublicDexContract();
        }catch(Exception e){
            e.printStackTrace();
        }

        try {

            //Display Balance
            EthGetBalance ethGetBalance = web3j.ethGetBalance(ADDRESS, DefaultBlockParameterName.LATEST).sendAsync().get();
            BigInteger balanceinWei = ethGetBalance.getBalance();
            BigDecimal weiToEther = Convert.fromWei(balanceinWei.toString(), Convert.Unit.ETHER);
            Log.d("test", "getEthBalance function test result :::::::::: " + weiToEther.toString());
            BigInteger balanceinWei2 = MarketDetailToken.cpublicDexContract.balanceOf(Web3jConstant.TOKEN_ADDRESS ,ADDRESS).sendAsync().get();
            BigDecimal weiToEther2 = Convert.fromWei(balanceinWei2.toString(), Convert.Unit.ETHER);
            Log.d("test", "BALANCEOF: " + weiToEther2.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    private void initialize() {
        btnBuy = (Button) findViewById(R.id.token_buy);
        btnSell = (Button) findViewById(R.id.token_sell);
        price_chart = (ImageView) findViewById(R.id.price_chart);
        depth_chart = (ImageView) findViewById(R.id.depth_chart);
        chart_image = (ImageView) findViewById(R.id.chart_image);


        btnBuy.setOnClickListener(this);
        btnSell.setOnClickListener(this);
        price_chart.setOnClickListener(this);
        depth_chart.setOnClickListener(this);


    }

    public void onClick(View v) {


        switch (v.getId()) {
            case R.id.token_buy:
                //Toast.makeText(this, "Buy", Toast.LENGTH_SHORT).show();
                Toast.makeText(this, "Buy", Toast.LENGTH_SHORT).show();
                break;
            case R.id.token_sell:
                Toast.makeText(this, "Sell", Toast.LENGTH_SHORT).show();
                break;
            case R.id.price_chart:
                chart_image.setImageResource(R.drawable.price_chart);
                break;
            case R.id.depth_chart:
                chart_image.setImageResource(R.drawable.depth_chart);

        }
    }

    public String argsToUrl() {

        String result;

        if(isInfura){
            result = Web3jConstant.INFURA_ADDRESS;
        }
        else{
            String ip = Web3jConstant.IP;
            String port = Web3jConstant.PORT;
            result = String.format("http://%s:%s", ip, port);
        }

        return result;
    }


    public void StartConnect() {
        clientUrl = argsToUrl();
        web3j = Web3jFactory.build(new HttpService(clientUrl));
    }

    public CpublicDex_sol_CpublicDex loadCpublicDexContract() throws Exception {
        cpublicDexContract = CpublicDex_sol_CpublicDex.load(Web3jConstant.CONTRACT_ADDRESS, web3j, CREDENTIALS, Web3jConstant.GAS_PRICE, Web3jConstant.GAS_LIMIT_CP_TX.multiply(BigInteger.valueOf(2)));
        String contractAddress = cpublicDexContract.getContractAddress();
        Log.d("Test", "CpublicDex Contract Address :" + contractAddress);
        return cpublicDexContract;
    }
}

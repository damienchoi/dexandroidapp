package com.wego.dexandroidnative.utilities;

import java.math.BigInteger;

public class Web3jConstant {

    //Demo
    //public static final String INFURA_ADDRESS = "";

    //Ropsten Contract V2 Infura
    public static  final String INFURA_ADDRESS ="";
    //Ropsten Contract V1 Infura:
    //public static final String INFURA_ADDRESS = "";
    //PrivateTestNet:
    public static final String IP = "";
    public static final String PORT = "";

    public static final BigInteger GAS_PRICE = BigInteger.valueOf(5_500_000L);

    public static final BigInteger GAS_LIMIT_CP_TX = BigInteger.valueOf(1_000_000);
    public static final BigInteger GAS_LIMIT_WITHBALNCE_TX = BigInteger.valueOf(500_000L);

    public static final int CONFIRMATION_ATTEMPTS = 2;
    public static final int SLEEP_DURATION = 200;


    //Demo:
//    public static final String CONTRACT_ADDESS = "";
//    public static final String ADMIN_ADDRESS = "";
//    public static final String ADMIN_PK = "";



    //Ropsten Contract V2:
    public static final String CONTRACT_ADDRESS = "";
    //Ropsten Contract V1
//    public static final String CONTRACT_ADDRESS = "";
    //TestNeta:
    //public static final String CONTRACT_ADDRESS = "";

    public static final String TOKEN_ADDRESS = "";

    public static final String TEST_ACCOUNT = "";

    public static final String TEST_PK = "";

    public static final String TEST_MNEMONIC = "";

    public static final String TEST_RECEIVER = "";


}

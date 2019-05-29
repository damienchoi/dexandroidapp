package com.wego.dexandroidnative.contracts;

import java.math.BigInteger;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 4.3.0.
 */
public class CpublicDex_sol_SafeMath extends Contract {
    private static final String BINARY = "608060405234801561001057600080fd5b5060aa8061001f6000396000f300608060405260043610603f576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff16806321f15d76146044575b600080fd5b348015604f57600080fd5b50606e6004803603810190808035151590602001909291905050506070565b005b801515607b57600080fd5b505600a165627a7a72305820d7986b1067b984e87f54aee1364f851efa9aeaa4b1a04afa7ee4b1aae872707e0029";

    public static final String FUNC_ASSERTVALUE = "assertValue";

    @Deprecated
    protected CpublicDex_sol_SafeMath(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected CpublicDex_sol_SafeMath(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected CpublicDex_sol_SafeMath(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected CpublicDex_sol_SafeMath(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public void assertValue(Boolean _assertion) {
        throw new RuntimeException("cannot call constant function with void return type");
    }

    @Deprecated
    public static CpublicDex_sol_SafeMath load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new CpublicDex_sol_SafeMath(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static CpublicDex_sol_SafeMath load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new CpublicDex_sol_SafeMath(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static CpublicDex_sol_SafeMath load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new CpublicDex_sol_SafeMath(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static CpublicDex_sol_SafeMath load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new CpublicDex_sol_SafeMath(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<CpublicDex_sol_SafeMath> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(CpublicDex_sol_SafeMath.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<CpublicDex_sol_SafeMath> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(CpublicDex_sol_SafeMath.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<CpublicDex_sol_SafeMath> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(CpublicDex_sol_SafeMath.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<CpublicDex_sol_SafeMath> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(CpublicDex_sol_SafeMath.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}

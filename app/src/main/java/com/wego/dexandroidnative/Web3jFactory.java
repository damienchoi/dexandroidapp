package com.wego.dexandroidnative;

import org.web3j.protocol.Web3j;
import org.web3j.protocol.Web3jService;
import org.web3j.protocol.core.JsonRpc2_0Web3j;

import java.util.concurrent.ScheduledExecutorService;

public class Web3jFactory {
    public static Web3j build(Web3jService web3jService) {
        return new JsonRpc2_0Web3j(web3jService);
    }

    public static Web3j build(
            Web3jService web3jService, long pollingInterval,
            ScheduledExecutorService scheduledExecutorService) {
        return new JsonRpc2_0Web3j(web3jService, pollingInterval, scheduledExecutorService);
    }
}

package com.wego.dexandroidnative.contracts;

import io.reactivex.Flowable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Bool;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Bytes32;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.abi.datatypes.generated.Uint8;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
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
public class CpublicDex_sol_CpublicDex extends Contract {
    private static final String BINARY = "608060405234801561001057600080fd5b50612e03806100206000396000f3006080604052600436106100db576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff1680630a19b14a146100e05780630b927666146101be57806319774d431461024957806321f15d76146102ae578063278b8c0e146102dd5780632d804ca2146103915780632e1a7d4d14610450578063338b5dea1461047d578063508493bc146104ca5780636c86888b146105415780639e281a981461064a578063bb5f462914610697578063d0e30db014610700578063f7888aec1461070a578063fb6e155f14610781575b600080fd5b3480156100ec57600080fd5b506101bc600480360381019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919080359060200190929190803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803590602001909291908035906020019092919080359060200190929190803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803560ff169060200190929190803560001916906020019092919080356000191690602001909291908035906020019092919050505061085c565b005b3480156101ca57600080fd5b50610247600480360381019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919080359060200190929190803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803590602001909291908035906020019092919080359060200190929190505050610e0a565b005b34801561025557600080fd5b50610298600480360381019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919080356000191690602001909291905050506110d5565b6040518082815260200191505060405180910390f35b3480156102ba57600080fd5b506102db6004803603810190808035151590602001909291905050506110fa565b005b3480156102e957600080fd5b5061038f600480360381019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919080359060200190929190803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803590602001909291908035906020019092919080359060200190929190803560ff16906020019092919080356000191690602001909291908035600019169060200190929190505050611109565b005b34801561039d57600080fd5b5061043a600480360381019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919080359060200190929190803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803590602001909291908035906020019092919080359060200190929190803573ffffffffffffffffffffffffffffffffffffffff1690602001909291905050506115ca565b6040518082815260200191505060405180910390f35b34801561045c57600080fd5b5061047b60048036038101908080359060200190929190505050611799565b005b34801561048957600080fd5b506104c8600480360381019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919080359060200190929190505050611a16565b005b3480156104d657600080fd5b5061052b600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050611d83565b6040518082815260200191505060405180910390f35b610630600480360381019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919080359060200190929190803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803590602001909291908035906020019092919080359060200190929190803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803560ff1690602001909291908035600019169060200190929190803560001916906020019092919080359060200190929190803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050611da8565b604051808215151515815260200191505060405180910390f35b34801561065657600080fd5b50610695600480360381019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919080359060200190929190505050611e6a565b005b3480156106a357600080fd5b506106e6600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803560001916906020019092919050505061222d565b604051808215151515815260200191505060405180910390f35b61070861225c565b005b34801561071657600080fd5b5061076b600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803573ffffffffffffffffffffffffffffffffffffffff16906020019092919050505061242d565b6040518082815260200191505060405180910390f35b610846600480360381019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919080359060200190929190803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803590602001909291908035906020019092919080359060200190929190803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803560ff169060200190929190803560001916906020019092919080356000191690602001909291905050506124b3565b6040518082815260200191505060405180910390f35b6000308c8c8c8c8c8c604051602001808873ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166c010000000000000000000000000281526014018773ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166c010000000000000000000000000281526014018681526020018573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166c010000000000000000000000000281526014018481526020018381526020018281526020019750505050505050506040516020818303038152906040526040518082805190602001908083835b602083101515610994578051825260208201915060208101905060208303925061096f565b6001836020036101000a03801982511681845116808217855250505050505090500191505060405180910390209050600160008773ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000206000826000191660001916815260200190815260200160002060009054906101000a900460ff1680610b9057508573ffffffffffffffffffffffffffffffffffffffff1660018260405160200180807f19457468657265756d205369676e6564204d6573736167653a0a333200000000815250601c0182600019166000191681526020019150506040516020818303038152906040526040518082805190602001908083835b602083101515610acd5780518252602082019150602081019050602083039250610aa8565b6001836020036101000a0380198251168184511680821785525050505050509050019150506040518091039020878787604051600081526020016040526040518085600019166000191681526020018460ff1660ff1681526020018360001916600019168152602001826000191660001916815260200194505050505060206040516020810390808403906000865af1158015610b6e573d6000803e3d6000fd5b5050506020604051035173ffffffffffffffffffffffffffffffffffffffff16145b8015610b9c5750874311155b8015610c0957508a610c06600260008973ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020600084600019166000191681526020019081526020016000205484612921565b11155b1515610c1457600080fd5b610c228c8c8c8c8a8761294b565b610c84600260008873ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020600083600019166000191681526020019081526020016000205483612921565b600260008873ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060008360001916600019168152602001908152602001600020819055507f6effdda786735d5033bfad5f53e5131abcced9e52be6c507b62d639685fbed6d8c838c8e868e02811515610d1157fe5b048a33604051808773ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018681526020018573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018481526020018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001965050505050505060405180910390a1505050505050505050505050565b600030878787878787604051602001808873ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166c010000000000000000000000000281526014018773ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166c010000000000000000000000000281526014018681526020018573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166c010000000000000000000000000281526014018481526020018381526020018281526020019750505050505050506040516020818303038152906040526040518082805190602001908083835b602083101515610f425780518252602082019150602081019050602083039250610f1d565b6001836020036101000a0380198251168184511680821785525050505050509050019150506040518091039020905060018060003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000206000836000191660001916815260200190815260200160002060006101000a81548160ff0219169083151502179055507f3f7f2eda73683c21a15f9435af1028c93185b5f1fa38270762dc32be606b3e8587878787878733604051808873ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018781526020018673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018581526020018481526020018381526020018273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200197505050505050505060405180910390a150505050505050565b6002602052816000526040600020602052806000526040600020600091509150505481565b80151561110657600080fd5b50565b6000308a8a8a8a8a8a604051602001808873ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166c010000000000000000000000000281526014018773ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166c010000000000000000000000000281526014018681526020018573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166c010000000000000000000000000281526014018481526020018381526020018281526020019750505050505050506040516020818303038152906040526040518082805190602001908083835b602083101515611241578051825260208201915060208101905060208303925061121c565b6001836020036101000a03801982511681845116808217855250505050505090500191505060405180910390209050600160003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000206000826000191660001916815260200190815260200160002060009054906101000a900460ff168061143d57503373ffffffffffffffffffffffffffffffffffffffff1660018260405160200180807f19457468657265756d205369676e6564204d6573736167653a0a333200000000815250601c0182600019166000191681526020019150506040516020818303038152906040526040518082805190602001908083835b60208310151561137a5780518252602082019150602081019050602083039250611355565b6001836020036101000a0380198251168184511680821785525050505050509050019150506040518091039020868686604051600081526020016040526040518085600019166000191681526020018460ff1660ff1681526020018360001916600019168152602001826000191660001916815260200194505050505060206040516020810390808403906000865af115801561141b573d6000803e3d6000fd5b5050506020604051035173ffffffffffffffffffffffffffffffffffffffff16145b151561144857600080fd5b88600260003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060008360001916600019168152602001908152602001600020819055507f1e0b760c386003e9cb9bcf4fcf3997886042859d9b6ed6320e804597fcdb28b08a8a8a8a8a8a338b8b8b604051808b73ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018a81526020018973ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018881526020018781526020018681526020018573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018460ff1660ff168152602001836000191660001916815260200182600019166000191681526020019a505050505050505050505060405180910390a150505050505050505050565b60008030898989898989604051602001808873ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166c010000000000000000000000000281526014018773ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166c010000000000000000000000000281526014018681526020018573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166c010000000000000000000000000281526014018481526020018381526020018281526020019750505050505050506040516020818303038152906040526040518082805190602001908083835b60208310151561170357805182526020820191506020810190506020830392506116de565b6001836020036101000a03801982511681845116808217855250505050505090500191505060405180910390209050600260008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000206000826000191660001916815260200190815260200160002054915050979650505050505050565b806000808073ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020541015151561180d57600080fd5b61187c6000808073ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000205482612d8b565b6000808073ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020819055503373ffffffffffffffffffffffffffffffffffffffff168160405160006040518083038185875af192505050151561191c57600080fd5b7ff341246adaac6f497bc2a656f546ab9e182111d630394f0c57c710a59a2cb567600033836000808073ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002054604051808573ffffffffffffffffffffffffffffffffffffffff1681526020018473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200183815260200182815260200194505050505060405180910390a150565b60008273ffffffffffffffffffffffffffffffffffffffff1614151515611a3c57600080fd5b8173ffffffffffffffffffffffffffffffffffffffff166323b872dd3330846040518463ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018281526020019350505050602060405180830381600087803b158015611b1357600080fd5b505af1158015611b27573d6000803e3d6000fd5b505050506040513d6020811015611b3d57600080fd5b81019080805190602001909291905050501515611b5957600080fd5b611bde6000808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000205482612921565b6000808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020819055507fdcbc1c05240f31ff3ad067ef1ee35ce4997762752e3a095284754544f4c709d78233836000808773ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002054604051808573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200183815260200182815260200194505050505060405180910390a15050565b6000602052816000526040600020602052806000526040600020600091509150505481565b6000826000808f73ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000205410158015611e46575082611e438e8e8e8e8e8e8e8e8e8e6124b3565b10155b1515611e555760009050611e5a565b600190505b9c9b505050505050505050505050565b60008273ffffffffffffffffffffffffffffffffffffffff1614151515611e9057600080fd5b806000808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000205410151515611f1a57600080fd5b611f9f6000808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000205482612d8b565b6000808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020819055508173ffffffffffffffffffffffffffffffffffffffff1663a9059cbb33836040518363ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200182815260200192505050602060405180830381600087803b1580156120c157600080fd5b505af11580156120d5573d6000803e3d6000fd5b505050506040513d60208110156120eb57600080fd5b8101908080519060200190929190505050151561210757600080fd5b7ff341246adaac6f497bc2a656f546ab9e182111d630394f0c57c710a59a2cb5678233836000808773ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002054604051808573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200183815260200182815260200194505050505060405180910390a15050565b60016020528160005260406000206020528060005260406000206000915091509054906101000a900460ff1681565b6122cb6000808073ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000205434612921565b6000808073ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020819055507fdcbc1c05240f31ff3ad067ef1ee35ce4997762752e3a095284754544f4c709d7600033346000808073ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002054604051808573ffffffffffffffffffffffffffffffffffffffff1681526020018473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200183815260200182815260200194505050505060405180910390a1565b60008060008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002054905092915050565b600080600080308e8e8e8e8e8e604051602001808873ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166c010000000000000000000000000281526014018773ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166c010000000000000000000000000281526014018681526020018573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166c010000000000000000000000000281526014018481526020018381526020018281526020019750505050505050506040516020818303038152906040526040518082805190602001908083835b6020831015156125ef57805182526020820191506020810190506020830392506125ca565b6001836020036101000a03801982511681845116808217855250505050505090500191505060405180910390209250600160008973ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000206000846000191660001916815260200190815260200160002060009054906101000a900460ff16806127eb57508773ffffffffffffffffffffffffffffffffffffffff1660018460405160200180807f19457468657265756d205369676e6564204d6573736167653a0a333200000000815250601c0182600019166000191681526020019150506040516020818303038152906040526040518082805190602001908083835b6020831015156127285780518252602082019150602081019050602083039250612703565b6001836020036101000a0380198251168184511680821785525050505050509050019150506040518091039020898989604051600081526020016040526040518085600019166000191681526020018460ff1660ff1681526020018360001916600019168152602001826000191660001916815260200194505050505060206040516020810390808403906000865af11580156127c9573d6000803e3d6000fd5b5050506020604051035173ffffffffffffffffffffffffffffffffffffffff16145b80156127f75750894311155b15156128065760009350612910565b6128688d600260008b73ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000206000866000191660001916815260200190815260200160002054612d8b565b91508a6128f06000808f73ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060008b73ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020548f612da4565b8115156128f957fe5b0490508082101561290c57819350612910565b8093505b5050509a9950505050505050505050565b600080828401905061294184821015801561293c5750838210155b6110fa565b8091505092915050565b6129d06000808873ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000205482612d8b565b6000808873ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002081905550612ad46000808873ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000205482612921565b6000808873ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002081905550612bec6000808673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000205486612bdd8685612da4565b811515612be657fe5b04612d8b565b6000808673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060008473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002081905550612d046000808673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000205486612cf58685612da4565b811515612cfe57fe5b04612921565b6000808673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002081905550505050505050565b6000612d99838311156110fa565b818303905092915050565b6000808284029050612dcd6000851480612dc85750838583811515612dc557fe5b04145b6110fa565b80915050929150505600a165627a7a7230582089df73290174f258db75bcffcd4543cb5f1ac1498697d02379fa6f4e9916fb1e0029";

    public static final String FUNC_TRADE = "trade";

    public static final String FUNC_ORDER = "order";

    public static final String FUNC_ORDERFILLS = "orderFills";

    public static final String FUNC_ASSERTVALUE = "assertValue";

    public static final String FUNC_CANCELORDER = "cancelOrder";

    public static final String FUNC_AMOUNTFILLED = "amountFilled";

    public static final String FUNC_WITHDRAW = "withdraw";

    public static final String FUNC_DEPOSITTOKEN = "depositToken";

    public static final String FUNC_TOKENS = "tokens";

    public static final String FUNC_TESTTRADE = "testTrade";

    public static final String FUNC_WITHDRAWTOKEN = "withdrawToken";

    public static final String FUNC_ORDERS = "orders";

    public static final String FUNC_DEPOSIT = "deposit";

    public static final String FUNC_BALANCEOF = "balanceOf";

    public static final String FUNC_AVAILABLEVOLUME = "availableVolume";

    public static final Event ORDER_EVENT = new Event("Order", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}, new TypeReference<Address>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Address>() {}));
    ;

    public static final Event CANCEL_EVENT = new Event("Cancel", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}, new TypeReference<Address>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Address>() {}, new TypeReference<Uint8>() {}, new TypeReference<Bytes32>() {}, new TypeReference<Bytes32>() {}));
    ;

    public static final Event TRADE_EVENT = new Event("Trade", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Uint256>() {}, new TypeReference<Address>() {}, new TypeReference<Uint256>() {}, new TypeReference<Address>() {}, new TypeReference<Address>() {}));
    ;

    public static final Event DEPOSIT_EVENT = new Event("Deposit", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event WITHDRAW_EVENT = new Event("Withdraw", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Address>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
    ;

    @Deprecated
    protected CpublicDex_sol_CpublicDex(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected CpublicDex_sol_CpublicDex(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected CpublicDex_sol_CpublicDex(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected CpublicDex_sol_CpublicDex(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteCall<TransactionReceipt> trade(String tokenGet, BigInteger amountGet, String tokenGive, BigInteger amountGive, BigInteger expires, BigInteger nonce, String user, BigInteger v, byte[] r, byte[] s, BigInteger amount) {
        final Function function = new Function(
                FUNC_TRADE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(tokenGet), 
                new org.web3j.abi.datatypes.generated.Uint256(amountGet), 
                new org.web3j.abi.datatypes.Address(tokenGive), 
                new org.web3j.abi.datatypes.generated.Uint256(amountGive), 
                new org.web3j.abi.datatypes.generated.Uint256(expires), 
                new org.web3j.abi.datatypes.generated.Uint256(nonce), 
                new org.web3j.abi.datatypes.Address(user), 
                new org.web3j.abi.datatypes.generated.Uint8(v), 
                new org.web3j.abi.datatypes.generated.Bytes32(r), 
                new org.web3j.abi.datatypes.generated.Bytes32(s), 
                new org.web3j.abi.datatypes.generated.Uint256(amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> order(String tokenGet, BigInteger amountGet, String tokenGive, BigInteger amountGive, BigInteger expires, BigInteger nonce) {
        final Function function = new Function(
                FUNC_ORDER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(tokenGet), 
                new org.web3j.abi.datatypes.generated.Uint256(amountGet), 
                new org.web3j.abi.datatypes.Address(tokenGive), 
                new org.web3j.abi.datatypes.generated.Uint256(amountGive), 
                new org.web3j.abi.datatypes.generated.Uint256(expires), 
                new org.web3j.abi.datatypes.generated.Uint256(nonce)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> orderFills(String param0, byte[] param1) {
        final Function function = new Function(FUNC_ORDERFILLS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(param0), 
                new org.web3j.abi.datatypes.generated.Bytes32(param1)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public void assertValue(Boolean _assertion) {
        throw new RuntimeException("cannot call constant function with void return type");
    }

    public RemoteCall<TransactionReceipt> cancelOrder(String tokenGet, BigInteger amountGet, String tokenGive, BigInteger amountGive, BigInteger expires, BigInteger nonce, BigInteger v, byte[] r, byte[] s) {
        final Function function = new Function(
                FUNC_CANCELORDER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(tokenGet), 
                new org.web3j.abi.datatypes.generated.Uint256(amountGet), 
                new org.web3j.abi.datatypes.Address(tokenGive), 
                new org.web3j.abi.datatypes.generated.Uint256(amountGive), 
                new org.web3j.abi.datatypes.generated.Uint256(expires), 
                new org.web3j.abi.datatypes.generated.Uint256(nonce), 
                new org.web3j.abi.datatypes.generated.Uint8(v), 
                new org.web3j.abi.datatypes.generated.Bytes32(r), 
                new org.web3j.abi.datatypes.generated.Bytes32(s)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> amountFilled(String tokenGet, BigInteger amountGet, String tokenGive, BigInteger amountGive, BigInteger expires, BigInteger nonce, String user) {
        final Function function = new Function(FUNC_AMOUNTFILLED, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(tokenGet), 
                new org.web3j.abi.datatypes.generated.Uint256(amountGet), 
                new org.web3j.abi.datatypes.Address(tokenGive), 
                new org.web3j.abi.datatypes.generated.Uint256(amountGive), 
                new org.web3j.abi.datatypes.generated.Uint256(expires), 
                new org.web3j.abi.datatypes.generated.Uint256(nonce), 
                new org.web3j.abi.datatypes.Address(user)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> withdraw(BigInteger amount) {
        final Function function = new Function(
                FUNC_WITHDRAW, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> depositToken(String token, BigInteger amount) {
        final Function function = new Function(
                FUNC_DEPOSITTOKEN, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(token), 
                new org.web3j.abi.datatypes.generated.Uint256(amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> tokens(String param0, String param1) {
        final Function function = new Function(FUNC_TOKENS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(param0), 
                new org.web3j.abi.datatypes.Address(param1)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> testTrade(String tokenGet, BigInteger amountGet, String tokenGive, BigInteger amountGive, BigInteger expires, BigInteger nonce, String user, BigInteger v, byte[] r, byte[] s, BigInteger amount, String sender, BigInteger weiValue) {
        final Function function = new Function(
                FUNC_TESTTRADE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(tokenGet), 
                new org.web3j.abi.datatypes.generated.Uint256(amountGet), 
                new org.web3j.abi.datatypes.Address(tokenGive), 
                new org.web3j.abi.datatypes.generated.Uint256(amountGive), 
                new org.web3j.abi.datatypes.generated.Uint256(expires), 
                new org.web3j.abi.datatypes.generated.Uint256(nonce), 
                new org.web3j.abi.datatypes.Address(user), 
                new org.web3j.abi.datatypes.generated.Uint8(v), 
                new org.web3j.abi.datatypes.generated.Bytes32(r), 
                new org.web3j.abi.datatypes.generated.Bytes32(s), 
                new org.web3j.abi.datatypes.generated.Uint256(amount), 
                new org.web3j.abi.datatypes.Address(sender)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteCall<TransactionReceipt> withdrawToken(String token, BigInteger amount) {
        final Function function = new Function(
                FUNC_WITHDRAWTOKEN, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(token), 
                new org.web3j.abi.datatypes.generated.Uint256(amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<Boolean> orders(String param0, byte[] param1) {
        final Function function = new Function(FUNC_ORDERS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(param0), 
                new org.web3j.abi.datatypes.generated.Bytes32(param1)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<TransactionReceipt> deposit(BigInteger weiValue) {
        final Function function = new Function(
                FUNC_DEPOSIT, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public RemoteCall<BigInteger> balanceOf(String token, String user) {
        final Function function = new Function(FUNC_BALANCEOF, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(token), 
                new org.web3j.abi.datatypes.Address(user)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> availableVolume(String tokenGet, BigInteger amountGet, String tokenGive, BigInteger amountGive, BigInteger expires, BigInteger nonce, String user, BigInteger v, byte[] r, byte[] s, BigInteger weiValue) {
        final Function function = new Function(
                FUNC_AVAILABLEVOLUME, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(tokenGet), 
                new org.web3j.abi.datatypes.generated.Uint256(amountGet), 
                new org.web3j.abi.datatypes.Address(tokenGive), 
                new org.web3j.abi.datatypes.generated.Uint256(amountGive), 
                new org.web3j.abi.datatypes.generated.Uint256(expires), 
                new org.web3j.abi.datatypes.generated.Uint256(nonce), 
                new org.web3j.abi.datatypes.Address(user), 
                new org.web3j.abi.datatypes.generated.Uint8(v), 
                new org.web3j.abi.datatypes.generated.Bytes32(r), 
                new org.web3j.abi.datatypes.generated.Bytes32(s)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function, weiValue);
    }

    public List<OrderEventResponse> getOrderEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(ORDER_EVENT, transactionReceipt);
        ArrayList<OrderEventResponse> responses = new ArrayList<OrderEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            OrderEventResponse typedResponse = new OrderEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.tokenGet = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.amountGet = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.tokenGive = (String) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse.amountGive = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
            typedResponse.expires = (BigInteger) eventValues.getNonIndexedValues().get(4).getValue();
            typedResponse.nonce = (BigInteger) eventValues.getNonIndexedValues().get(5).getValue();
            typedResponse.user = (String) eventValues.getNonIndexedValues().get(6).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<OrderEventResponse> orderEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, OrderEventResponse>() {
            @Override
            public OrderEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(ORDER_EVENT, log);
                OrderEventResponse typedResponse = new OrderEventResponse();
                typedResponse.log = log;
                typedResponse.tokenGet = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.amountGet = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.tokenGive = (String) eventValues.getNonIndexedValues().get(2).getValue();
                typedResponse.amountGive = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
                typedResponse.expires = (BigInteger) eventValues.getNonIndexedValues().get(4).getValue();
                typedResponse.nonce = (BigInteger) eventValues.getNonIndexedValues().get(5).getValue();
                typedResponse.user = (String) eventValues.getNonIndexedValues().get(6).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<OrderEventResponse> orderEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(ORDER_EVENT));
        return orderEventFlowable(filter);
    }

    public List<CancelEventResponse> getCancelEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(CANCEL_EVENT, transactionReceipt);
        ArrayList<CancelEventResponse> responses = new ArrayList<CancelEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            CancelEventResponse typedResponse = new CancelEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.tokenGet = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.amountGet = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.tokenGive = (String) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse.amountGive = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
            typedResponse.expires = (BigInteger) eventValues.getNonIndexedValues().get(4).getValue();
            typedResponse.nonce = (BigInteger) eventValues.getNonIndexedValues().get(5).getValue();
            typedResponse.user = (String) eventValues.getNonIndexedValues().get(6).getValue();
            typedResponse.v = (BigInteger) eventValues.getNonIndexedValues().get(7).getValue();
            typedResponse.r = (byte[]) eventValues.getNonIndexedValues().get(8).getValue();
            typedResponse.s = (byte[]) eventValues.getNonIndexedValues().get(9).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<CancelEventResponse> cancelEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, CancelEventResponse>() {
            @Override
            public CancelEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(CANCEL_EVENT, log);
                CancelEventResponse typedResponse = new CancelEventResponse();
                typedResponse.log = log;
                typedResponse.tokenGet = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.amountGet = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.tokenGive = (String) eventValues.getNonIndexedValues().get(2).getValue();
                typedResponse.amountGive = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
                typedResponse.expires = (BigInteger) eventValues.getNonIndexedValues().get(4).getValue();
                typedResponse.nonce = (BigInteger) eventValues.getNonIndexedValues().get(5).getValue();
                typedResponse.user = (String) eventValues.getNonIndexedValues().get(6).getValue();
                typedResponse.v = (BigInteger) eventValues.getNonIndexedValues().get(7).getValue();
                typedResponse.r = (byte[]) eventValues.getNonIndexedValues().get(8).getValue();
                typedResponse.s = (byte[]) eventValues.getNonIndexedValues().get(9).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<CancelEventResponse> cancelEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(CANCEL_EVENT));
        return cancelEventFlowable(filter);
    }

    public List<TradeEventResponse> getTradeEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(TRADE_EVENT, transactionReceipt);
        ArrayList<TradeEventResponse> responses = new ArrayList<TradeEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            TradeEventResponse typedResponse = new TradeEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.tokenGet = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.amountGet = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.tokenGive = (String) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse.amountGive = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
            typedResponse.get = (String) eventValues.getNonIndexedValues().get(4).getValue();
            typedResponse.give = (String) eventValues.getNonIndexedValues().get(5).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<TradeEventResponse> tradeEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, TradeEventResponse>() {
            @Override
            public TradeEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(TRADE_EVENT, log);
                TradeEventResponse typedResponse = new TradeEventResponse();
                typedResponse.log = log;
                typedResponse.tokenGet = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.amountGet = (BigInteger) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.tokenGive = (String) eventValues.getNonIndexedValues().get(2).getValue();
                typedResponse.amountGive = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
                typedResponse.get = (String) eventValues.getNonIndexedValues().get(4).getValue();
                typedResponse.give = (String) eventValues.getNonIndexedValues().get(5).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<TradeEventResponse> tradeEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(TRADE_EVENT));
        return tradeEventFlowable(filter);
    }

    public List<DepositEventResponse> getDepositEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(DEPOSIT_EVENT, transactionReceipt);
        ArrayList<DepositEventResponse> responses = new ArrayList<DepositEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            DepositEventResponse typedResponse = new DepositEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.token = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.user = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse.balance = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<DepositEventResponse> depositEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, DepositEventResponse>() {
            @Override
            public DepositEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(DEPOSIT_EVENT, log);
                DepositEventResponse typedResponse = new DepositEventResponse();
                typedResponse.log = log;
                typedResponse.token = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.user = (String) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
                typedResponse.balance = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<DepositEventResponse> depositEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(DEPOSIT_EVENT));
        return depositEventFlowable(filter);
    }

    public List<WithdrawEventResponse> getWithdrawEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(WITHDRAW_EVENT, transactionReceipt);
        ArrayList<WithdrawEventResponse> responses = new ArrayList<WithdrawEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            WithdrawEventResponse typedResponse = new WithdrawEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.token = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.user = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
            typedResponse.balance = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Flowable<WithdrawEventResponse> withdrawEventFlowable(EthFilter filter) {
        return web3j.ethLogFlowable(filter).map(new io.reactivex.functions.Function<Log, WithdrawEventResponse>() {
            @Override
            public WithdrawEventResponse apply(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(WITHDRAW_EVENT, log);
                WithdrawEventResponse typedResponse = new WithdrawEventResponse();
                typedResponse.log = log;
                typedResponse.token = (String) eventValues.getNonIndexedValues().get(0).getValue();
                typedResponse.user = (String) eventValues.getNonIndexedValues().get(1).getValue();
                typedResponse.amount = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
                typedResponse.balance = (BigInteger) eventValues.getNonIndexedValues().get(3).getValue();
                return typedResponse;
            }
        });
    }

    public Flowable<WithdrawEventResponse> withdrawEventFlowable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(WITHDRAW_EVENT));
        return withdrawEventFlowable(filter);
    }

    @Deprecated
    public static CpublicDex_sol_CpublicDex load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new CpublicDex_sol_CpublicDex(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static CpublicDex_sol_CpublicDex load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new CpublicDex_sol_CpublicDex(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static CpublicDex_sol_CpublicDex load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new CpublicDex_sol_CpublicDex(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static CpublicDex_sol_CpublicDex load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new CpublicDex_sol_CpublicDex(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<CpublicDex_sol_CpublicDex> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(CpublicDex_sol_CpublicDex.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<CpublicDex_sol_CpublicDex> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(CpublicDex_sol_CpublicDex.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<CpublicDex_sol_CpublicDex> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(CpublicDex_sol_CpublicDex.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<CpublicDex_sol_CpublicDex> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(CpublicDex_sol_CpublicDex.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static class OrderEventResponse {
        public Log log;

        public String tokenGet;

        public BigInteger amountGet;

        public String tokenGive;

        public BigInteger amountGive;

        public BigInteger expires;

        public BigInteger nonce;

        public String user;
    }

    public static class CancelEventResponse {
        public Log log;

        public String tokenGet;

        public BigInteger amountGet;

        public String tokenGive;

        public BigInteger amountGive;

        public BigInteger expires;

        public BigInteger nonce;

        public String user;

        public BigInteger v;

        public byte[] r;

        public byte[] s;
    }

    public static class TradeEventResponse {
        public Log log;

        public String tokenGet;

        public BigInteger amountGet;

        public String tokenGive;

        public BigInteger amountGive;

        public String get;

        public String give;
    }

    public static class DepositEventResponse {
        public Log log;

        public String token;

        public String user;

        public BigInteger amount;

        public BigInteger balance;
    }

    public static class WithdrawEventResponse {
        public Log log;

        public String token;

        public String user;

        public BigInteger amount;

        public BigInteger balance;
    }
}

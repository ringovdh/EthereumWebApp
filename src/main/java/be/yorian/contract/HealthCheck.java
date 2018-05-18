package be.yorian.contract;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.3.1.
 */
public class HealthCheck extends Contract {
    private static final String BINARY = "6060604052341561000f57600080fd5b6040516109c03803806109c083398101604052808051906020019091908051820191905050336000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550600160028381548110151561008557fe5b90600052602060002090018190555080600190805190602001906100aa9291906100b2565b505050610157565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106100f357805160ff1916838001178555610121565b82800160010185558215610121579182015b82811115610120578251825591602001919060010190610105565b5b50905061012e9190610132565b5090565b61015491905b80821115610150576000816000905550600101610138565b5090565b90565b61085a806101666000396000f300606060405260043610610083576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff1680631c4d4a0b146100885780636aac924d146101165780638c452fa71461014d57806398724c34146101e95780639f9fba1614610246578063be572d52146102e2578063f6815a751461035c575b600080fd5b341561009357600080fd5b61009b610393565b6040518080602001828103825283818151815260200191508051906020019080838360005b838110156100db5780820151818401526020810190506100c0565b50505050905090810190601f1680156101085780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b341561012157600080fd5b6101376004808035906020019091905050610431565b6040518082815260200191505060405180910390f35b341561015857600080fd5b61016e6004808035906020019091905050610455565b6040518080602001828103825283818151815260200191508051906020019080838360005b838110156101ae578082015181840152602081019050610193565b50505050905090810190601f1680156101db5780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b34156101f457600080fd5b610244600480803590602001908201803590602001908080601f01602080910402602001604051908101604052809392919081815260200183838082843782019150505050505091905050610511565b005b341561025157600080fd5b610267600480803590602001909190505061052b565b6040518080602001828103825283818151815260200191508051906020019080838360005b838110156102a757808201518184015260208101905061028c565b50505050905090810190601f1680156102d45780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b34156102ed57600080fd5b610346600480803590602001909190803590602001908201803590602001908080601f01602080910402602001604051908101604052809392919081815260200183838082843782019150505050505091905050610636565b6040518082815260200191505060405180910390f35b341561036757600080fd5b61037d60048080359060200190919050506106a6565b6040518082815260200191505060405180910390f35b60018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156104295780601f106103fe57610100808354040283529160200191610429565b820191906000526020600020905b81548152906001019060200180831161040c57829003601f168201915b505050505081565b60028181548110151561044057fe5b90600052602060002090016000915090505481565b60038181548110151561046457fe5b90600052602060002090016000915090508054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156105095780601f106104de57610100808354040283529160200191610509565b820191906000526020600020905b8154815290600101906020018083116104ec57829003601f168201915b505050505081565b80600190805190602001906105279291906106d5565b5050565b610533610755565b600160028381548110151561054457fe5b90600052602060002090015414156105f85760018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156105ec5780601f106105c1576101008083540402835291602001916105ec565b820191906000526020600020905b8154815290600101906020018083116105cf57829003601f168201915b50505050509050610631565b6040805190810160405280600c81526020017f6765656e20746f6567616e67000000000000000000000000000000000000000081525090505b919050565b6000600160028481548110151561064957fe5b9060005260206000209001541415610698576003805480600101828161066f9190610769565b9160005260206000209001600084909190915090805190602001906106959291906106d5565b50505b600380549050905092915050565b600060016002838154811015156106b957fe5b9060005260206000209001819055506002805490509050919050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061071657805160ff1916838001178555610744565b82800160010185558215610744579182015b82811115610743578251825591602001919060010190610728565b5b5090506107519190610795565b5090565b602060405190810160405280600081525090565b8154818355818115116107905781836000526020600020918201910161078f91906107ba565b5b505050565b6107b791905b808211156107b357600081600090555060010161079b565b5090565b90565b6107e391905b808211156107df57600081816107d691906107e6565b506001016107c0565b5090565b90565b50805460018160011615610100020316600290046000825580601f1061080c575061082b565b601f01602090049060005260206000209081019061082a9190610795565b5b505600a165627a7a723058201bbda2704306693c32b0a31603db02b82d7cbc31ea4fec9673b2f2204f61b8560029";

    protected HealthCheck(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected HealthCheck(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public RemoteCall<String> dossierStatus() {
        final Function function = new Function("dossierStatus", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<BigInteger> toegang(BigInteger param0) {
        final Function function = new Function("toegang", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<String> schema(BigInteger param0) {
        final Function function = new Function("schema", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> setDossierStatus(String _dossierStatus) {
        final Function function = new Function(
                "setDossierStatus", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_dossierStatus)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<String> getDossierStatus(BigInteger _toegangsId) {
        final Function function = new Function("getDossierStatus", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_toegangsId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> addItem(BigInteger _toegangsId, String _item) {
        final Function function = new Function(
                "addItem", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_toegangsId), 
                new org.web3j.abi.datatypes.Utf8String(_item)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> addVerstrekker(BigInteger _verstrekker_id) {
        final Function function = new Function(
                "addVerstrekker", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_verstrekker_id)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public static RemoteCall<HealthCheck> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, BigInteger _patientID, String _dossierStatus) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_patientID), 
                new org.web3j.abi.datatypes.Utf8String(_dossierStatus)));
        return deployRemoteCall(HealthCheck.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static RemoteCall<HealthCheck> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, BigInteger _patientID, String _dossierStatus) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_patientID), 
                new org.web3j.abi.datatypes.Utf8String(_dossierStatus)));
        return deployRemoteCall(HealthCheck.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static HealthCheck load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new HealthCheck(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static HealthCheck load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new HealthCheck(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }
}

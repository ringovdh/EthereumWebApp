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
    private static final String BINARY = "6060604052341561000f57600080fd5b6040516106e93803806106e98339810160405280805190602001909190805182019190505060018060008481526020019081526020016000208190555060016002600084815260200190815260200160002081905550806000908051906020019061007b929190610083565b505050610128565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106100c457805160ff19168380011785556100f2565b828001600101855582156100f2579182015b828111156100f15782518255916020019190600101906100d6565b5b5090506100ff9190610103565b5090565b61012591905b80821115610121576000816000905550600101610109565b5090565b90565b6105b2806101376000396000f300606060405260043610610078576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff1680632f048afa1461007d5780635c0bbb48146100b457806366cccdc6146100d75780639f9fba16146100fa578063d120f8ed14610196578063ed2e5a9714610275575b600080fd5b341561008857600080fd5b61009e60048080359060200190919050506102ac565b6040518082815260200191505060405180910390f35b34156100bf57600080fd5b6100d560048080359060200190919050506102c4565b005b34156100e257600080fd5b6100f860048080359060200190919050506102df565b005b341561010557600080fd5b61011b60048080359060200190919050506102fb565b6040518080602001828103825283818151815260200191508051906020019080838360005b8381101561015b578082015181840152602081019050610140565b50505050905090810190601f1680156101885780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b34156101a157600080fd5b6101fa600480803590602001909190803590602001908201803590602001908080601f016020809104026020016040519081016040528093929190818152602001838380828437820191505050505050919050506103fe565b6040518080602001828103825283818151815260200191508051906020019080838360005b8381101561023a57808201518184015260208101905061021f565b50505050905090810190601f1680156102675780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b341561028057600080fd5b61029660048080359060200190919050506104b5565b6040518082815260200191505060405180910390f35b60026020528060005260406000206000915090505481565b60018060008381526020019081526020016000208190555050565b6001600260008381526020019081526020016000208190555050565b6103036104cd565b60018060008481526020019081526020016000205414156103c05760008054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156103b45780601f10610389576101008083540402835291602001916103b4565b820191906000526020600020905b81548152906001019060200180831161039757829003601f168201915b505050505090506103f9565b6040805190810160405280600c81526020017f6765656e20746f6567616e67000000000000000000000000000000000000000081525090505b919050565b6104066104cd565b6001600260008581526020019081526020016000205414156104765781600090805190602001906104389291906104e1565b506040805190810160405280600281526020017f6f6b00000000000000000000000000000000000000000000000000000000000081525090506104af565b6040805190810160405280600c81526020017f6765656e20746f6567616e67000000000000000000000000000000000000000081525090505b92915050565b60016020528060005260406000206000915090505481565b602060405190810160405280600081525090565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061052257805160ff1916838001178555610550565b82800160010185558215610550579182015b8281111561054f578251825591602001919060010190610534565b5b50905061055d9190610561565b5090565b61058391905b8082111561057f576000816000905550600101610567565b5090565b905600a165627a7a723058202c50483d7a87209a964696456be932a87a489460f78f4f2fe56d8472db1c999d0029";

    protected HealthCheck(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected HealthCheck(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public RemoteCall<BigInteger> write(BigInteger param0) {
        final Function function = new Function("write", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> addVerstrekkerToRead(BigInteger _verstrekker_id) {
        final Function function = new Function(
                "addVerstrekkerToRead", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_verstrekker_id)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> addVerstrekkerToWrite(BigInteger _verstrekker_id) {
        final Function function = new Function(
                "addVerstrekkerToWrite", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_verstrekker_id)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<String> getDossierStatus(BigInteger _verstrekker_id) {
        final Function function = new Function("getDossierStatus", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_verstrekker_id)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> setDossierStatus(BigInteger _verstrekker_id, String _dossierStatus) {
        final Function function = new Function(
                "setDossierStatus", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_verstrekker_id), 
                new org.web3j.abi.datatypes.Utf8String(_dossierStatus)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> read(BigInteger param0) {
        final Function function = new Function("read", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
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

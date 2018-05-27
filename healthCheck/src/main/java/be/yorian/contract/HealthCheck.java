package be.yorian.contract;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.DynamicArray;
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
    private static final String BINARY = "6060604052341561000f57600080fd5b60405161084d38038061084d83398101604052808051906020019091908051820191906020018051906020019091905050600180600085815260200190815260200160002081905550600160026000858152602001908152602001600020819055506003805480600101828161008591906100b9565b91600052602060002090016000839091909150555081600090805190602001906100b09291906100e5565b5050505061018a565b8154818355818115116100e0578183600052602060002091820191016100df9190610165565b5b505050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061012657805160ff1916838001178555610154565b82800160010185558215610154579182015b82811115610153578251825591602001919060010190610138565b5b5090506101619190610165565b5090565b61018791905b8082111561018357600081600090555060010161016b565b5090565b90565b6106b4806101996000396000f300606060405260043610610099576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff1680632f048afa1461009e578063410d59cc146100d55780635c0bbb481461013f57806366cccdc6146101625780639f9fba1614610185578063a212523214610221578063bfb231d21461024d578063d120f8ed14610284578063ed2e5a97146102ea575b600080fd5b34156100a957600080fd5b6100bf6004808035906020019091905050610321565b6040518082815260200191505060405180910390f35b34156100e057600080fd5b6100e8610339565b6040518080602001828103825283818151815260200191508051906020019060200280838360005b8381101561012b578082015181840152602081019050610110565b505050509050019250505060405180910390f35b341561014a57600080fd5b6101606004808035906020019091905050610397565b005b341561016d57600080fd5b61018360048080359060200190919050506103b2565b005b341561019057600080fd5b6101a660048080359060200190919050506103ce565b6040518080602001828103825283818151815260200191508051906020019080838360005b838110156101e65780820151818401526020810190506101cb565b50505050905090810190601f1680156102135780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b341561022c57600080fd5b61024b60048080359060200190919080359060200190919050506104d1565b005b341561025857600080fd5b61026e600480803590602001909190505061051b565b6040518082815260200191505060405180910390f35b341561028f57600080fd5b6102e8600480803590602001909190803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509190505061053f565b005b34156102f557600080fd5b61030b6004808035906020019091905050610577565b6040518082815260200191505060405180910390f35b60026020528060005260406000206000915090505481565b61034161058f565b600380548060200260200160405190810160405280929190818152602001828054801561038d57602002820191906000526020600020905b815481526020019060010190808311610379575b5050505050905090565b60018060008381526020019081526020016000208190555050565b6001600260008381526020019081526020016000208190555050565b6103d66105a3565b60018060008481526020019081526020016000205414156104935760008054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156104875780601f1061045c57610100808354040283529160200191610487565b820191906000526020600020905b81548152906001019060200180831161046a57829003601f168201915b505050505090506104cc565b6040805190810160405280600c81526020017f6765656e20746f6567616e67000000000000000000000000000000000000000081525090505b919050565b600160026000838152602001908152602001600020541415610517576003805480600101828161050191906105b7565b9160005260206000209001600084909190915055505b5050565b60038181548110151561052a57fe5b90600052602060002090016000915090505481565b6001600260008481526020019081526020016000205414156105735780600090805190602001906105719291906105e3565b505b5050565b60016020528060005260406000206000915090505481565b602060405190810160405280600081525090565b602060405190810160405280600081525090565b8154818355818115116105de578183600052602060002091820191016105dd9190610663565b5b505050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061062457805160ff1916838001178555610652565b82800160010185558215610652579182015b82811115610651578251825591602001919060010190610636565b5b50905061065f9190610663565b5090565b61068591905b80821115610681576000816000905550600101610669565b5090565b905600a165627a7a723058207179c4b682e029c535cbccd434faa6bb3411e0e0301fa2611346003cb15a81890029";

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

    public RemoteCall<List> getItems() {
        final Function function = new Function("getItems", 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Uint256>>() {}));
        return new RemoteCall<List>(
                new Callable<List>() {
                    @Override
                    @SuppressWarnings("unchecked")
                    public List call() throws Exception {
                        List<Type> result = (List<Type>) executeCallSingleValueReturn(function, List.class);
                        return convertToNative(result);
                    }
                });
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

    public RemoteCall<TransactionReceipt> addItem(BigInteger _itemID, BigInteger _verstrekker_id) {
        final Function function = new Function(
                "addItem", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_itemID), 
                new org.web3j.abi.datatypes.generated.Uint256(_verstrekker_id)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> items(BigInteger param0) {
        final Function function = new Function("items", 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
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

    public static RemoteCall<HealthCheck> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, BigInteger _patientID, String _dossierStatus, BigInteger _itemID) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_patientID), 
                new org.web3j.abi.datatypes.Utf8String(_dossierStatus), 
                new org.web3j.abi.datatypes.generated.Uint256(_itemID)));
        return deployRemoteCall(HealthCheck.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static RemoteCall<HealthCheck> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, BigInteger _patientID, String _dossierStatus, BigInteger _itemID) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_patientID), 
                new org.web3j.abi.datatypes.Utf8String(_dossierStatus), 
                new org.web3j.abi.datatypes.generated.Uint256(_itemID)));
        return deployRemoteCall(HealthCheck.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static HealthCheck load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new HealthCheck(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static HealthCheck load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new HealthCheck(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }
    
    @SuppressWarnings("unchecked")
    protected static <S extends Type, T> 
            List<T> convertToNative(List<S> arr) {
        List<T> out = new ArrayList<T>();
        for (Iterator<S> it = arr.iterator(); it.hasNext(); ) {
            out.add((T)it.next().getValue());
        }
        return out;
    }
}

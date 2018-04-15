package be.yorian.server;

import java.io.IOException;
import java.math.BigInteger;
import java.util.concurrent.Future;

import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;

import be.yorian.contract.HealthCheck;
import be.yorian.domain.Contract;
import be.yorian.domain.Dossier;


public class ServerHelper {
	
	private final Web3j web3jServer;
	private final Credentials credentials;

	public ServerHelper() throws IOException, CipherException {
		this.web3jServer = startServer();
		this.credentials = loadCredentials();
	}
	
	public String deployNewContract(Dossier dossier) throws Exception {
		BigInteger gasPrice = new BigInteger("2100000");
		BigInteger gasLimit = new BigInteger("210000");
		String referentie = Integer.toString(dossier.getDossier_id());
		HealthCheck contract = HealthCheck.deploy(web3jServer, credentials, gasPrice , gasLimit, referentie, "status").send();
		System.out.println( "contractaddress: "+contract.getContractAddress());
        
		return contract.getContractAddress();
	}
	
	private Web3j startServer() throws IOException {
		//return Web3j.build(new HttpService("https://rinkeby.infura.io/hfoBoSuqEeGAOHxv0rUP"));
		return Web3j.build(new HttpService());  // defaults to http://localhost:8545/;
	}
	
	private Credentials loadCredentials() throws IOException, CipherException {
		System.out.println("loadCredentials");
		Credentials credentials = WalletUtils.loadCredentials("vdou4ept","/Users/ringo/Library/Ethereum/geth/data/02/keystore/UTC--2018-02-23T20-48-49.446642000Z--f31e8623a6afa9190b433f4b9728faec5d6b19b8");
		return credentials;
	}



	public Web3j getWeb3jServer() {
		return web3jServer;
	}



	public Credentials getCredentials() {
		return credentials;
	}

	public void updateContract(Dossier dossier) throws Exception {
		int hashcode = dossier.getDossier_id();
		String dossierStatus = Integer.toString(hashcode);
		BigInteger min = new BigInteger("20000000000");
		BigInteger max = new BigInteger("4300000");
		String address = dossier.getContract().getContractaddress();
		
		HealthCheck healthCheckContract = HealthCheck.load(address, web3jServer, credentials , min, max);

		RemoteCall<TransactionReceipt> transaction = healthCheckContract.setDossierStatus(dossierStatus);
		dossier.getContract().setTransactieaddress(transaction.send().getTransactionHash());

	}



	
	
	

}

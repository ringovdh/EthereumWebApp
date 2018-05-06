package be.yorian.server;

import java.io.IOException;
import java.math.BigInteger;

import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;

import be.yorian.contract.HealthCheck;
import be.yorian.domain.Dossier;


public class ServerHelper {
	
	private final Web3j web3jServer;
	private final Credentials credentials;

	public ServerHelper() throws IOException, CipherException {
		
		this.web3jServer = startServer();
		this.credentials = loadCredentials();
	}
	
	public String deployNewContract(Dossier dossier) throws Exception {
		BigInteger gasPrice = new BigInteger("21000000");
		BigInteger gasLimit = new BigInteger("2100000");
		
		String referentie = Integer.toString(dossier.getDossier_id());
		String status = dossier.getContract().getDossierstatus();
		
		HealthCheck contract = HealthCheck.deploy(web3jServer, credentials, gasPrice , gasLimit, referentie, status).send();
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
		
		BigInteger min = new BigInteger("20000000000");
		BigInteger max = new BigInteger("4300000");
		String address = dossier.getContract().getContractaddress();
		String dossierStatus = createhash(dossier);
		System.out.println("status1: "+dossierStatus);
		HealthCheck healthCheckContract = HealthCheck.load(address, web3jServer, credentials , min, max);

		RemoteCall<TransactionReceipt> transaction = healthCheckContract.setDossierStatus(dossierStatus);
		dossier.getContract().setTransactieaddress(transaction.send().getTransactionHash());
	}



	public String createhash(Dossier dossier) throws Exception{

		String dossierAsString = dossier.toString();
		int hashcode = dossierAsString.hashCode();
		String dossierStatus = Integer.toString(hashcode);
		System.out.println("status: "+dossierStatus);
	    return dossierStatus;
	}

	public String getDossierStatus(Dossier dossier) throws Exception {
		BigInteger gasPrice = new BigInteger("21000000");
		BigInteger gasLimit = new BigInteger("2100000");
		String address = dossier.getContract().getContractaddress();

		HealthCheck healthCheckContract = HealthCheck.load(address, web3jServer, credentials , gasPrice , gasLimit);
		String dossierStatus = healthCheckContract.getDossierstatus().send();
		System.out.println("status1: "+dossierStatus);
		return dossierStatus;
	}

}

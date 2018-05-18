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
	
	public String deployNewContract(Dossier dossier, String status) throws Exception {
		BigInteger value = new BigInteger("210000000");
		BigInteger gasLimit = new BigInteger("2100000");
		BigInteger patient_id = new BigInteger(dossier.getPatient());
		HealthCheck localeContract = HealthCheck.deploy(web3jServer, credentials, value , gasLimit, patient_id, status).send();
		System.out.println( "contractaddress: "+localeContract.getContractAddress());
        
		return localeContract.getContractAddress();
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
		
		BigInteger value = new BigInteger("0");
		BigInteger gasLimit = new BigInteger("2100000");
		String address = dossier.getContract().getContractaddress();
		String dossierStatus = createhash(dossier);
		BigInteger patient_id = new BigInteger(dossier.getPatient());
		System.out.println("status 1: "+dossierStatus);
		HealthCheck healthCheckContract = HealthCheck.load(address, web3jServer, credentials , value, gasLimit);

		RemoteCall<TransactionReceipt> transaction = healthCheckContract.setDossierStatus(patient_id, dossierStatus);
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
		BigInteger value = new BigInteger("0");
		BigInteger gasLimit = new BigInteger("2100000");
		String address = dossier.getContract().getContractaddress();

		HealthCheck healthCheckContract = HealthCheck.load(address, web3jServer, credentials , value , gasLimit);
		BigInteger patient_id = new BigInteger(dossier.getPatient());
		String dossierStatus = healthCheckContract.getDossierStatus(patient_id).send();
		System.out.println("status1: "+dossierStatus);
		return dossierStatus;
	}

}

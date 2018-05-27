package be.yorian.server;

import java.io.IOException;
import java.math.BigInteger;
import java.util.List;

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
	
	public String deployNewContract(Dossier dossier, String status, int itemID) throws Exception {
		BigInteger value = new BigInteger("210000000");
		BigInteger gasLimit = new BigInteger("2100000");
		BigInteger patient_id = new BigInteger(dossier.getPatient_id());
		BigInteger item_id = BigInteger.valueOf(itemID);
		HealthCheck localeContract = HealthCheck.deploy(web3jServer, credentials, value , gasLimit, patient_id, status, item_id).send();
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
		
		HealthCheck healthCheckContract = getContract(dossier);

		String dossierStatus = createhash(dossier);
		BigInteger patient_id = new BigInteger(dossier.getPatient_id());

		RemoteCall<TransactionReceipt> transaction = healthCheckContract.setDossierStatus(patient_id, dossierStatus);
		dossier.getContract().setTransactieaddress(transaction.send().getTransactionHash());
	}



	public String createhash(Dossier dossier) throws Exception{

		String dossierAsString = dossier.toString();
		int hashcode = dossierAsString.hashCode();
		String dossierStatus = Integer.toString(hashcode);
		System.out.println("lokale status: "+dossierStatus);
	    return dossierStatus;
	}

	public String getDossierStatus(Dossier dossier) throws Exception {
		HealthCheck healthCheckContract = getContract(dossier);
		BigInteger patient_id = new BigInteger(dossier.getPatient_id());
		String dossierStatus = healthCheckContract.getDossierStatus(patient_id).send();
		System.out.println("status from block: "+dossierStatus);
		return dossierStatus;
	}
	
	@SuppressWarnings("unchecked")
	public List<BigInteger> getItems(Dossier dossier) throws Exception {
		HealthCheck healthCheckContract = getContract(dossier);
		
		List<BigInteger> items = healthCheckContract.getItems().send();
		
		return items;
	}

	private HealthCheck getContract(Dossier dossier) {
		BigInteger value = new BigInteger("0");
		BigInteger gasLimit = new BigInteger("2100000");
		String address = dossier.getContract().getContractaddress();
		
		HealthCheck healthCheckContract = HealthCheck.load(address, web3jServer, credentials , value , gasLimit);
		
		return healthCheckContract;
	}

	public void addItem(int itemID, Dossier dossier) {
		HealthCheck healthCheckContract = getContract(dossier);
		
		healthCheckContract.addItem(BigInteger.valueOf(itemID), new BigInteger(dossier.getPatient_id()));
		// TODO Auto-generated method stub
		
	}

}

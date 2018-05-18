pragma solidity ^0.4.17;

contract HealthCheck {
    
    string dossierStatus;
    mapping (uint => uint) public read;
    mapping (uint => uint) public write;
    
    function HealthCheck(uint _patientID, string _dossierStatus) public {
        read[_patientID] = 1;
        write[_patientID] = 1;
        dossierStatus = _dossierStatus;
    }
    
    function addVerstrekkerToRead(uint _verstrekker_id) public {
		read[_verstrekker_id] = 1;
	}
	
	function addVerstrekkerToWrite(uint _verstrekker_id) public {
		write[_verstrekker_id] = 1;
	}
	
	function getDossierStatus(uint _verstrekker_id) public view returns (string){
	    if (read[_verstrekker_id] == 1) {
	        return dossierStatus;
	    } else {
	        return "geen toegang";
	    }
	}
	
	function setDossierStatus(uint _verstrekker_id, string _dossierStatus ) public returns (string){
	    if (write[_verstrekker_id] == 1) {
	        dossierStatus = _dossierStatus;
	        return "ok";
	    } else {
	        return "geen toegang";
	    }
	}

}
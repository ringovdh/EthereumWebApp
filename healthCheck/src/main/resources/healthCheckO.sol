pragma solidity ^0.4.17;

contract HealthCheck {
    
    string dossierStatus;
    mapping (uint => uint) public read;
    mapping (uint => uint) public write;
    uint[] public items;
    
    function HealthCheck(uint _patientID, string _dossierStatus, uint _itemID) public {
        read[_patientID] = 1;
        write[_patientID] = 1;
        items.push(_itemID);
        dossierStatus = _dossierStatus;
    }
    
    function addVerstrekkerToRead(uint _verstrekker_id) public {
		read[_verstrekker_id] = 1;
	}
	
	function addVerstrekkerToWrite(uint _verstrekker_id) public {
		write[_verstrekker_id] = 1;
	}
	
	function addItem(uint _itemID, uint _verstrekker_id) public {
	    if (write[_verstrekker_id] == 1) {
		    items.push(_itemID);
	    }
	}
	
	function getItems() public view returns (uint[])
    {
    	return items;
    }
	
	function getDossierStatus(uint _verstrekker_id) public view returns (string){
	    if (read[_verstrekker_id] == 1) {
	        return dossierStatus;
	    } else {
	        return "geen toegang";
	    }
	}
	
	function setDossierStatus(uint _verstrekker_id, string _dossierStatus ) public{
	    if (write[_verstrekker_id] == 1) {
	        dossierStatus = _dossierStatus;
	    } 
	}
}
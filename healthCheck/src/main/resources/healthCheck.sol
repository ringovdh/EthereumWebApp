pragma solidity ^0.4.17;

contract HealthCheck {
    
    string dossierStatus;
    mapping (uint => uint) public read_write;
    uint[] public items;
    
    function HealthCheck(uint _patientID, string _dossierStatus, uint _itemID) public {
        read_write[_patientID] = 2;
        items.push(_itemID);
        dossierStatus = _dossierStatus;
    }
    
    function addVerstrekkerToRead_write(uint _verstrekker_id, uint _right) public {
		read_write[_verstrekker_id] = _right;
	}
	
	function addItem(uint _itemID, uint _verstrekker_id) public {
	    if (read_write[_verstrekker_id] == 2) {
		    items.push(_itemID);
	    }
	}
	
	function getItems(uint _verstrekker_id) public view returns (uint[]){
	    if (read_write[_verstrekker_id] == 1 || read_write[_verstrekker_id] == 2) {
		    return items;
	    }
    }
	
	function getDossierStatus(uint _verstrekker_id) public view returns (string){
	    if (read_write[_verstrekker_id] == 1 || read_write[_verstrekker_id] == 2) {
	        return dossierStatus;
	    } else {
	        return "no access";
	    }
	}
	
	function setDossierStatus(uint _verstrekker_id, string _dossierStatus ) public{
	    if (read_write[_verstrekker_id] == 2) {
	        dossierStatus = _dossierStatus;
	    } 
	}
}
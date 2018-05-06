pragma solidity ^0.4.21;

contract HealthCheck {
    
    address owner;
    string patientID;
    string dossierStatus;
    
    function HealthCheck(string _patientID, string _dossierStatus) public {
        owner = msg.sender;
        patientID = _patientID;
        dossierStatus = _dossierStatus;
    }
    
    function setDossierStatus(string _dossierStatus) public {
        dossierStatus = _dossierStatus;
    }
    
    function getDossierstatus() public constant returns (string) {
        return dossierStatus;
    }
}
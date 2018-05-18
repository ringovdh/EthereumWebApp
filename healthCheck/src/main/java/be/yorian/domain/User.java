package be.yorian.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

	@Id
	@GeneratedValue
	@Column(name = "user_id")
	private int id;

	private String email;

	@Column(name = "passwd")
	private String password;

	@Column(name = "username")
	private String userName;

	@Column(name = "naam")
	private String naam;
	
	@Column(name = "voornaam")
	private String voornaam;
	
	@Column(name = "discriminator")
	private String discriminator;
	
	
	public int getUserID() {
		return id;
	}
	
	public String getEmail() {
		return email;
	}

	public String getPassword() {
		
		return this.password;
	}

	public String getUsername() {
		
		return this.userName;
	}
	
	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public String getVoornaam() {
		return voornaam;
	}

	public void setVoornaam(String voornaam) {
		this.voornaam = voornaam;
	}
	
	public String getDiscriminator() {
		return discriminator;
	}

	public void setDiscriminator(String discriminator) {
		this.discriminator = discriminator;
	}


}

package dev.nishiduka.gustho.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Supplier {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpnj() {
		return cpnj;
	}

	public void setCpnj(String cpnj) {
		this.cpnj = cpnj;
	}

	public String getIe() {
		return ie;
	}

	public void setIe(String ie) {
		this.ie = ie;
	}

	public String getRazao_social() {
		return razao_social;
	}

	public void setRazao_social(String razao_social) {
		this.razao_social = razao_social;
	}

	public String getNome_fantasia() {
		return nome_fantasia;
	}

	public void setNome_fantasia(String nome_fantasia) {
		this.nome_fantasia = nome_fantasia;
	}

	public List<SupplierContacts> getContacts() {
		return contacts;
	}

	public void setContacts(List<SupplierContacts> contacts) {
		this.contacts = contacts;
	}

	private String name;
	private String cpnj;
	private String ie;
	private String razao_social;
	private String nome_fantasia;
	
	@JsonIgnoreProperties("contacts")
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "supplier", orphanRemoval = true, cascade = CascadeType.DETACH)
    private List<SupplierContacts> contacts;


}

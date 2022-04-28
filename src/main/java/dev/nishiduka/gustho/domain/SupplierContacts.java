package dev.nishiduka.gustho.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class SupplierContacts {

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getPerson_name() {
		return person_name;
	}

	public void setPerson_name(String person_name) {
		this.person_name = person_name;
	}

	public Integer getSupplierId() {
		return supplier.getId();
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String type;
	private String contact;
	private String person_name;
	
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="supplier_id")
	private Supplier supplier;
}

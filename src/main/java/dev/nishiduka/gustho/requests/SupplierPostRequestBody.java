package dev.nishiduka.gustho.requests;

import dev.nishiduka.gustho.domain.SupplierContacts;
import java.util.List;

import lombok.Data;

@Data
public class SupplierPostRequestBody {
    private String name;
	private String cpnj;
	private String ie;
	private String razao_social;
	private String nome_fantasia;
	
	private List<SupplierContacts> contacts;
}

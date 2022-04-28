package dev.nishiduka.gustho.requests;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ClientPutRequestBody {
	private Integer id;
    private String name;
    private String cpf;
    private LocalDate birthdate;
    private String mail;
    private String phone;
}

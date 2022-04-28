package dev.nishiduka.gustho.requests;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ClientPostRequestBody {
    private String name;
    private String cpf;
    private LocalDate birthdate;
    private String mail;
    private String phone;
}

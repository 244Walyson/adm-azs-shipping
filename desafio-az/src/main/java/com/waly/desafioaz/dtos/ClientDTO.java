package com.waly.desafioaz.dtos;

import com.waly.desafioaz.entities.Client;
import com.waly.desafioaz.services.validation.UserInsertValid;
import jakarta.validation.constraints.*;

import java.util.Set;

@UserInsertValid
public class ClientDTO {

    private Long id;
    @NotEmpty(message = "Nome do cliente não pode ser vazio")
    @NotNull(message = "Nome do cliente não pode ser null")
    private String name;
    @NotEmpty(message = "Email do cliente não pode ser vazio")
    @NotNull(message = "Email do cliente não pode ser null")
    @Email(message = "Email invalido")
    private String email;
    @NotEmpty(message = "Número de telefone do cliente não pode ser vazio")
    @NotNull(message = "Número de cliente não pode ser null")
    private String phone;
    @NotEmpty(message = "Cnpj e do cliente não pode ser vazio")
    @NotNull(message = "Cnpj do cliente não pode ser null")
    @Size(min = 14, max = 14, message = "Cnpj invalido")
    private String cnpj;

    public ClientDTO() {
    }

    public ClientDTO(Long id, String name, String email, String phone, String cnpj, Set<ShipDTO> ships) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.cnpj = cnpj;
    }

    public ClientDTO(Client client) {
        this.id = client.getId();
        this.name = client.getName();
        this.email = client.getEmail();
        this.phone = client.getPhone();
        this.cnpj = client.getCnpj();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

}

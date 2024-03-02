package com.waly.azShipMongo.Adapter.model.embedded;

import com.waly.azShipMongo.Adapter.model.entities.ClientEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClientEmbedded {

    private String id;
    private String name;
    private String cnpj;
    private String email;
    private String phone;

    public ClientEmbedded(ClientEntity entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.cnpj = entity.getCnpj();
        this.email = entity.getEmail();
        this.phone = entity.getPhone();
    }
}

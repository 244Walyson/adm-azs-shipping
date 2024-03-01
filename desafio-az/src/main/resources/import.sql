INSERT INTO tb_client (name, email, phone, cnpj) VALUES ('Joao Silva Transportes LTDA', 'joao@gmail.com', '3199543422', '4435434264');

INSERT INTO tb_ship (created_at, description, status, client_id) VALUES (CURRENT_TIMESTAMP, 'Carga de Areia', 1, 1)
INSERT INTO tb_ship (created_at, description, status, client_id) VALUES (CURRENT_TIMESTAMP, 'Carga de Soja', 1, 1)


INSERT INTO tb_property (name, property_value, ship_id) VALUES ('Cubagem', 4000.00, 1);
INSERT INTO tb_property (name, property_value, ship_id) VALUES ('Toneladas', 3000.00, 1);


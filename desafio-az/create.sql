
    create table tb_client (
        id bigserial not null,
        cnpj varchar(255),
        email varchar(255),
        name varchar(255),
        phone varchar(255),
        primary key (id)
    );

    create table tb_property (
        property_value float(53),
        id bigserial not null,
        ship_id bigint,
        name varchar(255),
        primary key (id)
    );

    create table tb_ship (
        status smallint check (status between 0 and 2),
        client_id bigint,
        created_at timestamp(6) with time zone,
        id bigserial not null,
        description varchar(255),
        primary key (id)
    );

    alter table if exists tb_property 
       add constraint FK3rum8dy2y7i3tgyjswtifjyp7 
       foreign key (ship_id) 
       references tb_ship;

    alter table if exists tb_ship 
       add constraint FKavjateklr5me62gqv5fti6n1x 
       foreign key (client_id) 
       references tb_client;
INSERT INTO tb_client (name, email, phone, cnpj) VALUES ('Joao Silva Transportes LTDA', 'joao@gmail.com', '3199543422', '4435434264');
INSERT INTO tb_ship (created_at, description, status, client_id) VALUES (CURRENT_TIMESTAMP, 'Carga de Areia', 1, 1);
INSERT INTO tb_ship (created_at, description, status, client_id) VALUES (CURRENT_TIMESTAMP, 'Carga de Soja', 1, 1);
INSERT INTO tb_property (name, property_value, ship_id) VALUES ('Cubagem', 4000.00, 1);
INSERT INTO tb_property (name, property_value, ship_id) VALUES ('Toneladas', 3000.00, 1);

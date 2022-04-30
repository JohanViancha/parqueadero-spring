INSERT INTO personas (nom_persona, ape_persona,num_documento) VALUES('Juan', 'Rojas',75486);
INSERT INTO personas (nom_persona, ape_persona,num_documento) VALUES('Carlos', 'Diaz',95821);
INSERT INTO personas (nom_persona, ape_persona,num_documento) VALUES('Mayra', 'Gamma',58424);
INSERT INTO personas (nom_persona, ape_persona,num_documento) VALUES('Richard', 'Marco',67454);
INSERT INTO personas (nom_persona, ape_persona,num_documento) VALUES('Ralph', 'Johnson',47254);
INSERT INTO personas (nom_persona, ape_persona,num_documento) VALUES('Johan', 'Viancha',45853);
INSERT INTO personas (nom_persona, ape_persona,num_documento) VALUES('James', 'Gutierrez',36548);
INSERT INTO personas (nom_persona, ape_persona,num_documento) VALUES('Laura', 'Lee',94621);
INSERT INTO personas (nom_persona, ape_persona,num_documento) VALUES('Diego', 'Rodriguez',31458);
INSERT INTO personas (nom_persona, ape_persona,num_documento) VALUES('Oscar', 'Mendez',74692);

INSERT INTO bahia (nom_parq, estado_parq) VALUES('Parqueadero uts', TRUE);
INSERT INTO bahia (nom_parq, estado_parq) VALUES('Parqueadero uts', FALSE);
INSERT INTO bahia (nom_parq, estado_parq) VALUES('Parqueadero uts', FALSE);
INSERT INTO bahia (nom_parq, estado_parq) VALUES('Parqueadero uts', TRUE);
INSERT INTO bahia (nom_parq, estado_parq) VALUES('Parqueadero uts', FALSE);

INSERT INTO tipo_vehiculo (id,tipo)VALUES(1,'Carro');
INSERT INTO tipo_vehiculo (id,tipo)VALUES(2,'Moto');
INSERT INTO tipo_vehiculo (id,tipo)VALUES(3,'Camion');
INSERT INTO tipo_vehiculo (id,tipo)VALUES(4,'Cicla');

INSERT INTO tarifas (id,valor,tipo_id)VALUES(1,2500,1);
INSERT INTO tarifas (id,valor,tipo_id)VALUES(2,1500,2);
INSERT INTO tarifas (id,valor,tipo_id)VALUES(3,4000,3);
INSERT INTO tarifas (id,valor,tipo_id)VALUES(4,500,4);

INSERT INTO vehiculos (id,marca,modelo,placa,tipo_id)VALUES(1,'chevrolet','2010a','abc1',1);
INSERT INTO vehiculos (id,marca,modelo,placa,tipo_id)VALUES(2,'suzuky','20va','qwe2',2);
INSERT INTO vehiculos (id,marca,modelo,placa,tipo_id)VALUES(3,'ford','1032d','vgh4',3);
INSERT INTO vehiculos (id,marca,modelo,placa,tipo_id)VALUES(4,'titanium','2015h','gdr6',4);



INSERT INTO usuarios (persona_id,email,password)VALUES(1,'juancamilo@gmail.com','1234');
INSERT INTO usuarios (persona_id,email,password)VALUES(6,'vianchajohan@gmail.com', '1234');

INSERT INTO ingresos (persona_id,vehiculo_id,usuario_id,bahia_id, fecha_hora_entrada)VALUES(1,2,1,3, '2022-01-10 10:00:00');
INSERT INTO ingresos (persona_id,vehiculo_id,usuario_id,bahia_id, fecha_hora_entrada)VALUES(2,1,1,1, '2022-04-19 18:23:00');
INSERT INTO ingresos (persona_id,vehiculo_id,usuario_id,bahia_id, fecha_hora_entrada)VALUES(2,2,1,3, '2022-05-7 21:41:00');
INSERT INTO ingresos (persona_id,vehiculo_id,usuario_id,bahia_id, fecha_hora_entrada)VALUES(3,1,1,1, '2022-12-20 13:52:00');

INSERT INTO factura (ingreso_id,fecha_hora_salida, valor_pago)VALUES(1,'2022-01-10 13:52:00', 3000);
INSERT INTO factura (ingreso_id,fecha_hora_salida, valor_pago)VALUES(2,'2022-04-19 22:52:00', 5600);
INSERT INTO factura (ingreso_id,fecha_hora_salida, valor_pago)VALUES(3,'2022-05-7 23:41:00', 1300);
INSERT INTO factura (ingreso_id,fecha_hora_salida, valor_pago)VALUES(4,'2022-12-20 16:52:00', 8000);



INSERT INTO roles (nombre) VALUES ('ROLE_USER');
INSERT INTO roles (nombre) VALUES ('ROLE_ADMIN');

INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (1, 1);
INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (2, 2);
INSERT INTO usuarios_roles (usuario_id, role_id) VALUES (2, 1);







/*--------------------------------------------------------------------------*/
--GENERO
/*--------------------------------------------------------------------------*/
insert into genero(nombre) values('Masculino');
insert into genero(nombre) values('Femenino');
/*--------------------------------------------------------------------------*/
--CLIENTE
/*--------------------------------------------------------------------------*/
insert into cliente(ci_cliente,nombre,apellido,fecha_nacimiento,id_genero) values('123456','Joseph','Stalin','2000-06-01',1);
insert into cliente(ci_cliente,nombre,apellido,fecha_nacimiento,id_genero) values('234567','Carlos','Gutierrez','1980-06-07',1);
insert into cliente(ci_cliente,nombre,apellido,fecha_nacimiento,id_genero) values('345678','Armando','Carpas','1999-06-09',1);
insert into cliente(ci_cliente,nombre,apellido,fecha_nacimiento,id_genero) values('456789','Jhon','Connor','1988-03-12',1);
insert into cliente(ci_cliente,nombre,apellido,fecha_nacimiento,id_genero) values('567890','Sandra','Bullock','1980-01-10',2);
insert into cliente(ci_cliente,nombre,apellido,fecha_nacimiento,id_genero) values('987654','Erick','Sanchez','1984-11-02',1);
insert into cliente(ci_cliente,nombre,apellido,fecha_nacimiento,id_genero) values('876543','Monica','Lazarte','1995-04-20',2);
insert into cliente(ci_cliente,nombre,apellido,fecha_nacimiento,id_genero) values('765432','Rodrigo','Fuentes','1997-03-14',1);
insert into cliente(ci_cliente,nombre,apellido,fecha_nacimiento,id_genero) values('654321','Marianne','Rios','2002-07-26',2);
insert into cliente(ci_cliente,nombre,apellido,fecha_nacimiento,id_genero) values('543210','Maria','Gonzales','1990-05-15',2);
/*--------------------------------------------------------------------------*/
--plan area
/*--------------------------------------------------------------------------*/
insert into plan_area(nombre_area,precio) values ('Pilates',100);
insert into plan_area(nombre_area,precio) values ('Aerobicos',80);
insert into plan_area(nombre_area,precio) values ('Aparatos',130);
insert into plan_area(nombre_area,precio) values ('Trotadoras',120);

/*--------------------------------------------------------------------------*/
--promocion
/*--------------------------------------------------------------------------*/

insert into promocion(descuento,nombre)values(0,'Sin promocion');
insert into promocion(descuento,nombre)values(20,'Inauguracion');



/*--------------------------------------------------------------------------*/
--suscripcion
/*--------------------------------------------------------------------------*/
insert into suscripcion(fecha_suscripcion,cantidad_sesiones,sesiones_restantes,ci_cliente,id_promocion,nombre_area)
			values('2018-05-07',30,20,123456,1,'Pilates');
insert into suscripcion(fecha_suscripcion,cantidad_sesiones,sesiones_restantes,ci_cliente,id_promocion,nombre_area)
			values('2018-05-05',30,26,234567,1,'Aparatos');
insert into suscripcion(fecha_suscripcion,cantidad_sesiones,sesiones_restantes,ci_cliente,id_promocion,nombre_area)
			values('2018-05-16',30,16,345678,2,'Aerobicos');
insert into suscripcion(fecha_suscripcion,cantidad_sesiones,sesiones_restantes,ci_cliente,id_promocion,nombre_area)
			values('2018-05-13',30,20,456789,2,'Aparatos');
insert into suscripcion(fecha_suscripcion,cantidad_sesiones,sesiones_restantes,ci_cliente,id_promocion,nombre_area)
			values('2018-05-15',30,16,567890,2,'Aerobicos');
insert into suscripcion(fecha_suscripcion,cantidad_sesiones,sesiones_restantes,ci_cliente,id_promocion,nombre_area)
			values('2018-05-10',30,26,987654,1,'Trotadoras');
insert into suscripcion(fecha_suscripcion,cantidad_sesiones,sesiones_restantes,ci_cliente,id_promocion,nombre_area)
			values('2018-05-19',30,30,876543,2,'Aparatos');
insert into suscripcion(fecha_suscripcion,cantidad_sesiones,sesiones_restantes,ci_cliente,id_promocion,nombre_area)
			values('2018-05-01',30,30,765432,1,'Trotadoras');
insert into suscripcion(fecha_suscripcion,cantidad_sesiones,sesiones_restantes,ci_cliente,id_promocion,nombre_area)
			values('2018-05-03',30,16,654321,1,'Pilates');
insert into suscripcion(fecha_suscripcion,cantidad_sesiones,sesiones_restantes,ci_cliente,id_promocion,nombre_area)
			values('2018-05-10',30,30,543210,1,'Pilates');




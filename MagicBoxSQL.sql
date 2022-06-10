use pruebas_mb;
drop table usuario;

SELECT * FROM COMIDA;

-- TABLA USUARIOtipoComida
CREATE TABLE usuario (
	`email` varchar(200) primary key NOT NULL,
    `nombreUsuario` varchar(80) NOT NULL unique,
  `nombre` varchar(80) DEFAULT NULL,
  `apellido` varchar(80) ,
  `pass` varchar(20) DEFAULT NULL,
  `pais` varchar(30)
  );
  
    -- TABLA COMIDA
   CREATE TABLE comida(
  nombreRestaurante varchar(80) primary key not null,
  foto varchar(80) not null,
  descripcion varchar(400),
  tipoComida varchar(80));
  
 -- TABLA DESTINO
    CREATE TABLE destino(
  ubicacion varchar(80) primary key not null,
  foto varchar(80) not null,
  descripcion varchar(400));
  
  
  -- TABLA CUIDADO
     CREATE TABLE cuidado(
  nombreCuidado varchar(80) primary key not null,
  foto varchar(80) not null,
  descripcion varchar(400),
  tipoCuidado varchar(80));
  
  

  
  -- TABLA INTERMEDIA usuario comidas
  create table usuarios_comidas (
	
	email_usuario varchar(200),
    restaurante_nombre varchar(200),
    fechaAdquisicion date,
    constraint fk_uc_usuario foreign key (email_usuario) references usuario(email),
    constraint fk_uc_comida foreign key (restaurante_nombre) references comida(nombreRestaurante),
    primary key(email_usuario,restaurante_nombre)
  );
    -- METEMOS TODA LA INFORMACIÓN DE LA SELECCIÓN(SELECCIONAMOS UNA COMIDA,
  -- LA COMIDA QUE NOS TOQUE ALMACENAMOS SU INFORMACIÓN EN ESTA TABLA)
  -- EN LA TABLA INTERMEDIA PARA CONSULTAR
  -- MEDIANTE UN SELECT, NECESITAREMOS CONSTRUCTORES VACIOS PARA USAR EL GETTER.
  
  
  -- TABLA INTERMEDIA USUARIO CUIDADOS
  create table usuarios_cuidados (
  	-- id int primary key auto_increment,
	email_usuario varchar(200),
    cuidado_nombre varchar(200),
    fecha date,
    constraint fk_ucui_usuario foreign key (email_usuario) references usuario(email),
    constraint fk_ucui_cuidado foreign key (cuidado_nombre) references cuidado(nombreCuidado),
    primary key (email_usuario,cuidado_nombre)
    );
    -- TABLA INTERMEDIA USUARIO DESTINOS
    
     create table usuarios_destinos (
  -- id int primary key auto_increment,
	email_usuario varchar(200),
    destino_nombre varchar(200),
    fecha date,
    constraint fk_udes_usuario foreign key (email_usuario) references usuario(email),
    constraint fk_udes_destino foreign key (destino_nombre) references destino(ubicacion),
    primary key(email_usuario , destino_nombre)
    );
    
    

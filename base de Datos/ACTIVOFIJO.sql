-- drop tables

DROP TABLE usuario CASCADE CONSTRAINTS;

DROP TABLE detalle CASCADE CONSTRAINTS;

DROP TABLE empleado CASCADE CONSTRAINTS;

DROP TABLE estado CASCADE CONSTRAINTS;

DROP TABLE jornada CASCADE CONSTRAINTS;

DROP TABLE producto CASCADE CONSTRAINTS;

DROP TABLE tipo_empleado CASCADE CONSTRAINTS;

DROP TABLE tipo_producto CASCADE CONSTRAINTS;

DROP TABLE ubicacion CASCADE CONSTRAINTS;

DROP TABLE movimiento CASCADE CONSTRAINTS;

DROP TABLE bodega CASCADE CONSTRAINTS;

DROP TABLE color CASCADE CONSTRAINTS;


-- drop sequences
DROP SEQUENCE seq_usuario;

DROP SEQUENCE seq_empleado;

DROP SEQUENCE seq_detalle;

DROP SEQUENCE seq_estado;

DROP SEQUENCE seq_jornada;

DROP SEQUENCE seq_producto;

DROP SEQUENCE seq_tp_empleado;

DROP SEQUENCE seq_tp_producto;

DROP SEQUENCE seq_ubicacion;

DROP SEQUENCE seq_movimiento;

DROP SEQUENCE seq_bodega;

DROP SEQUENCE seq_color;

-- Creacion de Tablas
CREATE TABLE USUARIO (
    id_usuario VARCHAR2(10) CONSTRAINT pk_usuario PRIMARY KEY,
    nombre_usuario VARCHAR2(50) NOT NULL,
    contrasena VARCHAR2(50) NOT NULL
);


CREATE TABLE detalle (
    fecha_asignacion     DATE NOT NULL,
    producto_id_producto NUMBER NOT NULL,
    empleado_id_empleado NUMBER NOT NULL,

    CONSTRAINT pk_detalle PRIMARY KEY ( producto_id_producto, empleado_id_empleado )
);

CREATE TABLE color (
    id_color NUMBER,
    nombre_color VARCHAR2(80),
    
    CONSTRAINT pk_color PRIMARY KEY (id_color)

);

/*CREATE TABLE supervisor (
    id_supervisor                 NUMBER NOT NULL,
    nombre_completo_supervisor    VARCHAR2(65) NOT NULL,

    CONSTRAINT pk_supervisor PRIMARY KEY (id_supervisor)
);*/

CREATE TABLE empleado (
    id_empleado                 NUMBER NOT NULL,
    run_empleado                VARCHAR2(12) NOT NULL,
    nombre_completo_empleado    VARCHAR2(65) NOT NULL,
    telefono_empleado           VARCHAR2(12) NOT NULL,
    direccion_empleado          VARCHAR2(120) NOT NULL,
    tipo_empleado_id_tipo       NUMBER NOT NULL,
    jornada_id_jornada          NUMBER NOT NULL,
    nombre_supervisor           VARCHAR2(65),
    

    CONSTRAINT pk_empleado PRIMARY KEY (id_empleado)
);


CREATE TABLE estado (
    id_estado    NUMBER NOT NULL,
    descripcion_estado  VARCHAR2(20) NOT NULL,

    CONSTRAINT pk_estado PRIMARY KEY ( id_estado )
);

CREATE TABLE jornada (
    id_jornada   NUMBER NOT NULL,
    descripcion_jornada VARCHAR2(20) NOT NULL,

    CONSTRAINT pk_jornada PRIMARY KEY ( id_jornada )
);

CREATE TABLE producto (
    id_producto             NUMBER NOT NULL,
    numero_activo_producto  NUMBER NOT NULL,
    numero_serie_producto   NUMBER(12) NOT NULL,
    descripcion_producto    VARCHAR2(250) NOT NULL,
    ubicacion_id_ubicacion  NUMBER NOT NULL,
    tipo_producto_id_tipo   NUMBER NOT NULL,
    fecha_llegada_producto  DATE NOT NULL,
    color_id_color          NUMBER NOT NULL,
    costo_producto          NUMBER(8) NOT NULL,
    estado_id_estado        NUMBER NOT NULL,
    litros_producto         NUMBER,

    CONSTRAINT pk_producto PRIMARY KEY ( id_producto )
);

CREATE TABLE tipo_empleado (
    id_tipo_empleado            NUMBER NOT NULL,
    descripcion_tipo_empleado   VARCHAR2(45) NOT NULL,
    
    CONSTRAINT pk_tipo_empleado PRIMARY KEY ( id_tipo_empleado  )
);

CREATE TABLE tipo_producto (
    id_tipo_producto            NUMBER NOT NULL,
    descripcion_tipo_producto   VARCHAR2(30) NOT NULL,

    CONSTRAINT pk_tipo_producto PRIMARY KEY ( id_tipo_producto )
);

CREATE TABLE ubicacion (
    id_ubicacion NUMBER NOT NULL,
    descripcion_ubicacion VARCHAR2(45) NOT NULL,

    CONSTRAINT pk_ubicacion PRIMARY KEY ( id_ubicacion )
);

CREATE TABLE movimiento(
    id_movimiento NUMBER,
    descripcion_movimiento VARCHAR2(200),
    producto_id_producto NUMBER NOT NULL,
    ubicacion_inicio VARCHAR2(80),
    ubicacion_final VARCHAR2(80),
    fecha_movimiento DATE,
    
    CONSTRAINT pk_movimiento PRIMARY KEY (id_movimiento)
);

CREATE TABLE bodega(
    id_bodega NUMBER,
    descripcion_bodega varchar2(80),
    
    constraint pk_bodega primary key(id_bodega)
);

-- Alter Foreign Keys
ALTER TABLE detalle
    ADD CONSTRAINT fk_detalle_empleado FOREIGN KEY ( empleado_id_empleado )
        REFERENCES empleado ( id_empleado );

ALTER TABLE detalle
    ADD CONSTRAINT fk_detalle_producto FOREIGN KEY ( producto_id_producto )
        REFERENCES producto ( id_producto );

ALTER TABLE empleado
    ADD CONSTRAINT fk_empleado_jornada FOREIGN KEY ( jornada_id_jornada )
        REFERENCES jornada ( id_jornada );

ALTER TABLE empleado
    ADD CONSTRAINT fk_empleado_tipo_empleado FOREIGN KEY ( tipo_empleado_id_tipo )
        REFERENCES tipo_empleado ( id_tipo_empleado );

ALTER TABLE producto
    ADD CONSTRAINT fk_producto_estado FOREIGN KEY ( estado_id_estado )
        REFERENCES estado ( id_estado );

ALTER TABLE producto
    ADD CONSTRAINT fk_producto_tipo_producto FOREIGN KEY ( tipo_producto_id_tipo )
        REFERENCES tipo_producto ( id_tipo_producto );

ALTER TABLE producto
    ADD CONSTRAINT fk_producto_ubicacion FOREIGN KEY ( ubicacion_id_ubicacion )
        REFERENCES ubicacion ( id_ubicacion );

ALTER TABLE producto
    ADD CONSTRAINT fk_producto_color FOREIGN KEY ( color_id_color )
        REFERENCES color ( id_color );

ALTER TABLE movimiento
    ADD CONSTRAINT fk_movimiento_producto FOREIGN KEY ( producto_id_producto )
        REFERENCES producto ( id_producto );

-- Create Sequences
CREATE SEQUENCE seq_usuario
    INCREMENT BY 1  
    START WITH 1    
    MINVALUE 1
    NOCYCLE;

CREATE SEQUENCE seq_empleado
    INCREMENT BY 2
    START WITH 100
    MINVALUE 100
    NOCYCLE;

CREATE SEQUENCE seq_detalle
    INCREMENT BY 1
    START WITH 1
    MINVALUE 1
    NOCYCLE;

CREATE SEQUENCE seq_estado
    INCREMENT BY 1
    START WITH 1
    MINVALUE 1
    NOCYCLE;

CREATE SEQUENCE seq_jornada
    INCREMENT BY 1
    START WITH 1
    MINVALUE 1
    NOCYCLE;

CREATE SEQUENCE seq_producto
    INCREMENT BY 1
    START WITH 1
    MINVALUE 1
    NOCYCLE;

CREATE SEQUENCE seq_tp_empleado
    INCREMENT BY 1
    START WITH 1
    MINVALUE 1
    NOCYCLE;

CREATE SEQUENCE seq_tp_producto
    INCREMENT BY 1
    START WITH 1
    MINVALUE 1
    NOCYCLE;

CREATE SEQUENCE seq_ubicacion
    INCREMENT BY 1
    START WITH 1
    MINVALUE 1
    NOCYCLE;
    
CREATE SEQUENCE seq_movimiento
    INCREMENT BY 1
    START WITH 1
    MINVALUE 1
    NOCYCLE;
    
CREATE SEQUENCE seq_bodega
    INCREMENT BY 1
    START WITH 1
    MINVALUE 1
    NOCYCLE;

CREATE SEQUENCE seq_color
    INCREMENT BY 1
    START WITH 1
    MINVALUE 1
    NOCYCLE;

-- INSERT DATOS DE PRUEBAS
INSERT INTO usuario VALUES(seq_usuario.NEXTVAL, 'usuario1','usuario1');
INSERT INTO usuario VALUES(seq_usuario.NEXTVAL, 'felipe','felipe');
INSERT INTO usuario VALUES(seq_usuario.NEXTVAL, 'nestor','nestor');
INSERT INTO usuario VALUES(seq_usuario.NEXTVAL, 'nicolas','nicolas');
INSERT INTO usuario VALUES(seq_usuario.NEXTVAL, 'admin','admin');

--SELECT * FROM USUARIO;
INSERT INTO color VALUES (seq_color.NEXTVAL, 'Blanco');
INSERT INTO color VALUES (seq_color.NEXTVAL, 'Negro');
INSERT INTO color VALUES (seq_color.NEXTVAL, 'Rojo');
INSERT INTO color VALUES (seq_color.NEXTVAL, 'Cafe');
INSERT INTO color VALUES (seq_color.NEXTVAL, 'Rosado');
INSERT INTO color VALUES (seq_color.NEXTVAL, 'Amarillo');

-- supervisor, Conserje, Celador, Personal Aseo, Bodeguero
INSERT INTO tipo_empleado VALUES (SEQ_TP_EMPLEADO.NEXTVAL,'Supervisor');
INSERT INTO tipo_empleado VALUES (SEQ_TP_EMPLEADO.NEXTVAL,'Conserje');
INSERT INTO tipo_empleado VALUES (SEQ_TP_EMPLEADO.NEXTVAL,'Celador');
INSERT INTO tipo_empleado VALUES (SEQ_TP_EMPLEADO.NEXTVAL,'Personal Aseo');
INSERT INTO tipo_empleado VALUES (SEQ_TP_EMPLEADO.NEXTVAL,'Bodeguero');

-- diurno, Vespertino, Rotativo
INSERT INTO jornada VALUES (SEQ_JORNADA.NEXTVAL, 'DIURNO');
INSERT INTO jornada VALUES (SEQ_JORNADA.NEXTVAL, 'VESPERTINO');
INSERT INTO jornada VALUES (SEQ_JORNADA.NEXTVAL, 'ROTATIVO');

--enUso, usado, reservado, almacenado, desechado
INSERT INTO estado VALUES (SEQ_ESTADO.NEXTVAL, 'En Uso');
INSERT INTO estado VALUES (SEQ_ESTADO.NEXTVAL, 'Usado');
INSERT INTO estado VALUES (SEQ_ESTADO.NEXTVAL, 'Reservado');
INSERT INTO estado VALUES (SEQ_ESTADO.NEXTVAL, 'Almacenado');
INSERT INTO estado VALUES (SEQ_ESTADO.NEXTVAL, 'Desechado');

INSERT INTO ubicacion VALUES (SEQ_BODEGA.NEXTVAL,'Bodega Central 1');
INSERT INTO ubicacion VALUES (SEQ_BODEGA.NEXTVAL,'Bodega Central 2');


-- solvente, limpiaPiso, desinfectante
INSERT INTO tipo_producto VALUES (SEQ_TP_PRODUCTO.NEXTVAL,'Solvente');
INSERT INTO tipo_producto VALUES (SEQ_TP_PRODUCTO.NEXTVAL,'Limpia Piso');
INSERT INTO tipo_producto VALUES (SEQ_TP_PRODUCTO.NEXTVAL,'Desinfectante');

--  run_empleado, nombre_completo_empleado, telefono_empleado, direccion_empleado, tipo_empleado_id_tipo, jornada_id_jornada
INSERT INTO empleado VALUES(SEQ_EMPLEADO.NEXTVAL,'11.111.111-1','Juan Pérez','987654321','Calle inventada 1',1,1,'NO APLICA');
INSERT INTO empleado VALUES (SEQ_EMPLEADO.NEXTVAL,'22.222.222-2','Epitafio Miranda','987654321','Calle inventada 1',2,1,'NO APLICA');
INSERT INTO empleado VALUES (SEQ_EMPLEADO.NEXTVAL,'33.333.333-3','Reimundo Arriagada','987654321','Calle inventada 1',3,1,'NO APLICA');
INSERT INTO empleado VALUES (SEQ_EMPLEADO.NEXTVAL,'44.444.444-4','Humberto Rojas','987654321','Calle inventada 1',4,1,'NO APLICA');
INSERT INTO empleado VALUES (SEQ_EMPLEADO.NEXTVAL,'55.555.555-5','Sebastian Troncoso','987654321','Calle inventada 1',5,1,'NO APLICA');
INSERT INTO empleado VALUES (SEQ_EMPLEADO.NEXTVAL,'66.666.666-6','Jaime Coloma','987654321','Calle inventada 1',1,2,'NO APLICA');
INSERT INTO empleado VALUES (SEQ_EMPLEADO.NEXTVAL,'77.777.777-7','Alvaro Quesadilla','987654321','Calle inventada 1',1,2,'NO APLICA');
INSERT INTO empleado VALUES (SEQ_EMPLEADO.NEXTVAL,'88.888.888-8','Macarena Fuentes','987654321','Calle inventada 1',2,2,'NO APLICA');
INSERT INTO empleado VALUES (SEQ_EMPLEADO.NEXTVAL,'99.999.999-9','Maria José Peñafiel','987654321','Calle inventada 1',3,2,'NO APLICA');
INSERT INTO empleado VALUES (SEQ_EMPLEADO.NEXTVAL,'12.121.212-1','Antonella Cabezas','987654321','Calle inventada 1',4,2,'NO APLICA');
INSERT INTO empleado VALUES (SEQ_EMPLEADO.NEXTVAL,'23.232.323-2','Paola Tapia','987654321','Calle inventada 1',5,1,'NO APLICA');

INSERT INTO PRODUCTO VALUES (seq_producto.NEXTVAL,321,654,'Solvente2',1,1,sysdate,1,80000,1,50);
INSERT INTO PRODUCTO VALUES (seq_producto.NEXTVAL,1234,23465,'Solvente3',2,2,sysdate,2,20000,2,50);
INSERT INTO PRODUCTO VALUES (seq_producto.NEXTVAL,12322,132446,'Solvente',1,1,sysdate,3,80000,1,50);

INSERT INTO MOVIMIENTO VALUES (seq_movimiento.NEXTVAL,'ENTREGA',1,'Bodega Central 1','Bodega Central 2',SYSDATE);
INSERT INTO MOVIMIENTO VALUES (seq_movimiento.NEXTVAL,'ENTREGA',2,'Bodega Central 2','Bodega Central 1',SYSDATE);
INSERT INTO MOVIMIENTO VALUES (seq_movimiento.NEXTVAL,'ENTREGA',3,'Bodega Central 2','Bodega Central 1',SYSDATE);

commit;
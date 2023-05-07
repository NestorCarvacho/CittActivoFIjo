-- drop tables

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

-- drop sequences

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


-- Creacion de Tablas
CREATE TABLE detalle (
    fecha_asignacion     DATE NOT NULL,
    producto_id_producto NUMBER NOT NULL,
    empleado_id_empleado NUMBER NOT NULL,

    CONSTRAINT pk_detalle PRIMARY KEY ( producto_id_producto, empleado_id_empleado )
);

CREATE TABLE empleado (
    id_empleado                 NUMBER NOT NULL,
    run_empleado                VARCHAR2(12) NOT NULL,
    nombre_completo_empleado    VARCHAR2(65) NOT NULL,
    telefono_empleado           VARCHAR2(12) NOT NULL,
    direccion_empleado          VARCHAR2(120) NOT NULL,
    tipo_empleado_id_tipo       NUMBER NOT NULL,
    jornada_id_jornada          NUMBER NOT NULL,

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
    numero_serie_producto   NUMBER(12) NOT NULL,
    descripcion_producto    VARCHAR2(250) NOT NULL,
    ubicacion_id_ubicacion  NUMBER NOT NULL,
    tipo_producto_id_tipo   NUMBER NOT NULL,
    fecha_llegada_producto  DATE NOT NULL,
    color_producto          VARCHAR2(20) NOT NULL,
    costo_producto          NUMBER(8) NOT NULL,
    estado_id_estado        NUMBER NOT NULL,

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

ALTER TABLE movimiento
    ADD CONSTRAINT fk_movimiento_producto FOREIGN KEY ( producto_id_producto )
        REFERENCES producto ( id_producto );

-- Create Sequences

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
    
-- INSERT DATOS DE PRUEBAS
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


commit;
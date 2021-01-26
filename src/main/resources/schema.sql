CREATE SCHEMA IF NOT EXISTS selecaosastijuridico  AUTHORIZATION sa;

CREATE TABLE IF NOT EXISTS selecaosastijuridico.colaboradores ( 
   id LONG NOT NULL AUTO_INCREMENT, 
   cpf VARCHAR(14) NOT NULL, 
   nome VARCHAR(120) NOT NULL, 
   email VARCHAR(80),
   telefone VARCHAR(11),
   setorid INT,
   PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS selecaosastijuridico.setores ( 
   id LONG NOT NULL AUTO_INCREMENT, 
   descricao VARCHAR(120) NOT NULL,
   PRIMARY KEY (id)
);

ALTER TABLE IF EXISTS selecaosastijuridico.oolaboradores 
ADD FOREIGN KEY (setorid) 
REFERENCES selecaosastijuridico.setores(id);

-- V2: Migrations para adicionar a coluna rank na tabela tb_ninjas

ALTER TABLE tb_ninjas
ADD COLUMN rank VARCHAR(255);
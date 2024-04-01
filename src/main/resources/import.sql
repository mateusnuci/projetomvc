INSERT INTO tb_categoria(id,nome) VALUES(categoria_seq.NEXTVAL,'Smartphone');
INSERT INTO tb_categoria(id,nome) VALUES(categoria_seq.NEXTVAL,'Smart TV');
INSERT INTO tb_categoria(id,nome) VALUES(categoria_seq.NEXTVAL,'Notebook');
INSERT INTO tb_categoria(id,nome) VALUES(categoria_seq.NEXTVAL,'Tablet');
INSERT INTO tb_categoria(id,nome) VALUES(categoria_seq.NEXTVAL,'Mouse');
INSERT INTO tb_categoria(id,nome) VALUES(categoria_seq.NEXTVAL,'Teclado');

INSERT INTO tb_produto(id,nome, descricao, valor, categoria_id) VALUES(produto_seq.NEXTVAL,'Mouse Microsoft', 'Mouse sem fio', 250.0, 5);
INSERT INTO tb_produto(id,nome, descricao, valor, categoria_id) VALUES(produto_seq.NEXTVAL,'Smartphone Samsung Galaxy A54 5G', 'Samsung Galaxy A54 5G', 1799.0, 1);
INSERT INTO tb_produto(id,nome, descricao, valor, categoria_id) VALUES(produto_seq.NEXTVAL,'Smart TV', 'Smart TV LG LED 65 polegadas', 3999, 2);

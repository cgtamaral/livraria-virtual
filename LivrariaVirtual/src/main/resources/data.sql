INSERT INTO Publisher(id, name, about) VALUES(1,'LeYa', 'A LeYa nasceu em 2008, em Portugal, como grupo editorial do qual fazem parte algumas das mais prestigiadas editoras de língua portuguesa. Presente no Brasil desde o ano seguinte, assumiu no país uma posição de destaque na área de edições gerais. Em 2011, a LeYa Brasil se aliou à Casa da Palavra, já consolidada no mercado editorial brasileiro e reconhecida pelo rigor estético e a qualidade de seu conteúdo. Hoje, nossa missão é dar espaço a obras de ficção e não ficção de grandes autores nacionais e estrangeiros que tenham o poder de dialogar de maneira ampla e diversa com seus leitores brasileiros.');

INSERT INTO Author(id, name, biography) VALUES(1, 'George R. R. Martin','George Raymond Richard Martin (Bayonne, 20 de setembro de 1948), nascido George Raymond Martin e mais conhecido como George R. R. Martin ou simplesmente GRRM, é um roteirista e escritor de ficção científica, terror e fantasia estadunidense. É mais conhecido por escrever a série de livros de fantasia épica As Crônicas de Gelo e Fogo. Ele foi declarado como uma das 100 pessoas mais influentes do mundo em 2011 pela revista TIME.');

INSERT INTO Author_Publisher(author_id, publisher_id) VALUES ('1','1');

INSERT INTO BOOK(id, title, language,ISBN10,ISBN13, publisher_id, edition, dimensions, 
weight, unit, price) VALUES(1,'A Guerra dos Tronos. As Crônicas de Gelo e Fogo - Livro 1',
'Português', '8544102921', '978-8544102923',1,'Edição: 1ª (15 de setembro de 2015)','22,8 x 15,6 x 3 cm', 309.0, 'g',36.80);

INSERT INTO Author_Book(author_id, book_id) VALUES(1,1);


/*
 
INSERT INTO Address(id,, fullName, countryRegion, streetAddressm city, stateProvinceRegion, zipCode, deliveryInstructions) VALUES();



*/
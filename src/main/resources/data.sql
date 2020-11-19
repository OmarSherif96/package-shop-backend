DROP TABLE IF EXISTS package,package_product,product;

CREATE TABLE package (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  description VARCHAR(255) NOT NULL,
  price DOUBLE
);


CREATE TABLE product(
   pid INT AUTO_INCREMENT  PRIMARY KEY,
   id       VARCHAR(12) NOT NULL,
  name     VARCHAR(13) NOT NULL,
  usd_price DOUBLE  NOT NULL
);

INSERT INTO product(id,name,usd_price) VALUES ('7dgX6XzU3Wds','Sword',899);
INSERT INTO product(id,name,usd_price) VALUES ('PKM5pGAh9yGm','Axe',799);
INSERT INTO product(id,name,usd_price) VALUES ('7Hv0hA2nmci7','Knife',349);
INSERT INTO product(id,name,usd_price) VALUES ('500R5EHvNlNB','Gold Coin',249);
INSERT INTO product(id,name,usd_price) VALUES ('IP3cv7TcZhQn','Platinum Coin',399);
INSERT INTO product(id,name,usd_price) VALUES ('IJOHGYkY2CYq','Bow',649);
INSERT INTO product(id,name,usd_price) VALUES ('8anPsR2jbfNW','Silver Coin',50);


CREATE TABLE package_product(
package_id int(11) NOT NULL,
product_id int(11) NOT NULL,

PRIMARY KEY (package_id,product_id),

CONSTRAINT FK_PACKAGE
FOREIGN KEY(package_id)
REFERENCES package (id)
ON DELETE NO ACTION ON UPDATE NO ACTION
,

CONSTRAINT FK_PRODUCT
FOREIGN KEY(product_id)
REFERENCES product (pid)
ON DELETE NO ACTION ON UPDATE NO ACTION


)

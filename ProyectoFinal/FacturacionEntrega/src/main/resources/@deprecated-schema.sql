CREATE TABLE client(
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(75) NOT NULL,
    lastname VARCHAR(75) NOT NULL,
    docnumber VARCHAR(11) UNIQUE NOT NULL
);

CREATE TABLE product(
    id INTEGER PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(150) NOT NULL,
    description VARCHAR(150),
    code VARCHAR(50) UNIQUE NOT NULL,
    stock INTEGER,
    price DOUBLE
);

CREATE TABLE invoice (
  id INT PRIMARY KEY AUTO_INCREMENT,
  client_id INT,
  created_at VARCHAR(255),
  total DOUBLE,
  FOREIGN KEY (client_id) REFERENCES client(id)
);

CREATE TABLE invoice_detail (
  id INT PRIMARY KEY AUTO_INCREMENT,
  id_invoice INT NOT NULL,
  id_product INT NOT NULL,
  price DOUBLE NOT NULL,
  quantity INT NOT NULL,
  FOREIGN KEY (id_invoice) REFERENCES invoice(id),
  FOREIGN KEY (id_product) REFERENCES product(id)
);

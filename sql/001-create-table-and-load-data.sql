DROP TABLE IF EXISTS anime;

CREATE TABLE anime (
  id int unsigned AUTO_INCREMENT,
  name VARCHAR(100) NOT NULL,
  episode int NOT NULL,
  PRIMARY KEY(id)
);

INSERT INTO anime (name,episode) VALUES ("鬼滅の刃",24);
INSERT INTO anime (name,episode) VALUES ("呪術廻戦",12);
INSERT INTO anime (name,episode) VALUES ("ワンピース",1072);

CREATE TABLE recipes
(
    recipe_id   INTEGER      NOT NULL AUTO_INCREMENT,
    recipe_name VARCHAR(255) NOT NULL,
    cal         FLOAT        NOT NULL,
    PRIMARY KEY (recipe_id)
);

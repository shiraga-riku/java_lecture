CREATE TABLE `recipes`
(
    `recipe_id`   int          NOT NULL AUTO_INCREMENT,
    `recipe_name` varchar(255) NOT NULL,
    `cal`         float        NOT NULL,
    PRIMARY KEY (`recipe_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

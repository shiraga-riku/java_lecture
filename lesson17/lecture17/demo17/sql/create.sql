DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`
(
    `id`        int          NOT NULL AUTO_INCREMENT,
    `name`      varchar(255) NOT NULL,
    `email`     varchar(255) NOT NULL,
    `is_active` tinyint(1)   NOT NULL DEFAULT '1',
    `password`  varchar(255) NOT NULL DEFAULT 'aaa',
    `login_id`  varchar(255) NOT NULL,
    `role`      varchar(32)  NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `recipes`;
CREATE TABLE `recipes`
(
    `recipe_id`   int          NOT NULL AUTO_INCREMENT,
    `recipe_name` varchar(255) NOT NULL,
    `cal`         float        NOT NULL,
    PRIMARY KEY (`recipe_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `menus`;
CREATE TABLE `menus`
(
    `menu_id`   int          NOT NULL AUTO_INCREMENT,
    `menu_name` varchar(255) NOT NULL,
    `menu_kind` tinyint      NOT NULL,
    PRIMARY KEY (`menu_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

CREATE TABLE `menu_recipe`
(
    `menu_id`   int NOT NULL,
    `recipe_id` int NOT NULL,
    PRIMARY KEY (`menu_id`, `recipe_id`),
    KEY `menu_recipe_fk1` (`menu_id`),
    KEY `menu_recipe_fk2` (`recipe_id`),
    CONSTRAINT `menu_recipe_fk1` FOREIGN KEY (`menu_id`) REFERENCES `menus` (`menu_id`),
    CONSTRAINT `menu_recipe_fk2` FOREIGN KEY (`recipe_id`) REFERENCES `recipes` (`recipe_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;


DROP TABLE IF EXISTS `recipe_likes`;
CREATE TABLE `recipe_likes`
(
    `user_id`   int NOT NULL,
    `recipe_id` int NOT NULL,
    PRIMARY KEY (`user_id`, `recipe_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

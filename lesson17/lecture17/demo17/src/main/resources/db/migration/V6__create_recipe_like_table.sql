CREATE TABLE `recipe_likes`
(
    `user_id`        int          NOT NULL,
    `recipe_id`      int NOT NULL,
    PRIMARY KEY (`user_id`, `recipe_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

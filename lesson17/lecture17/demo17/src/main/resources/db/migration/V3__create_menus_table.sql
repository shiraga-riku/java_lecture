CREATE TABLE `menus`
(
    `menu_id`   int          NOT NULL AUTO_INCREMENT,
    `menu_name` varchar(255) NOT NULL,
    `menu_kind` tinyint      NOT NULL,
    PRIMARY KEY (`menu_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci;

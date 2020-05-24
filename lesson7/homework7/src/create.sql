CREATE TABLE `materials` (
                             `material_id` int NOT NULL,
                             `material_name` varchar(255) NOT NULL,
                             `cal` float NOT NULL
);


CREATE TABLE `menus` (
                         `menu_id` int NOT NULL,
                         `menu_name` varchar(255) NOT NULL
);


CREATE TABLE `menu_recipe` (
                               `menu_id` int NOT NULL,
                               `recipe_id` int NOT NULL,
                               `amount` int NOT NULL
);

CREATE TABLE `recipes` (
                           `recipe_id` int NOT NULL,
                           `recipe_name` varchar(255) NOT NULL
);

CREATE TABLE `recipe_material` (
                                   `recipe_id` int NOT NULL,
                                   `material_id` int NOT NULL,
                                   `amount` int NOT NULL
);

ALTER TABLE `materials`
    ADD PRIMARY KEY (`material_id`);

ALTER TABLE `menus`
    ADD PRIMARY KEY (`menu_id`);

ALTER TABLE `menu_recipe`
    ADD KEY `menu_recipe_fk1` (`menu_id`),
    ADD KEY `menu_recipe_fk2` (`recipe_id`);

ALTER TABLE `recipes`
    ADD PRIMARY KEY (`recipe_id`);

ALTER TABLE `recipe_material`
    ADD PRIMARY KEY (`recipe_id`,`material_id`),
    ADD KEY `recipe_material_fk2` (`material_id`);


ALTER TABLE `materials`
    MODIFY `material_id` int NOT NULL AUTO_INCREMENT;

ALTER TABLE `menus`
    MODIFY `menu_id` int NOT NULL AUTO_INCREMENT;

ALTER TABLE `recipes`
    MODIFY `recipe_id` int NOT NULL AUTO_INCREMENT;

ALTER TABLE `menu_recipe`
    ADD CONSTRAINT `menu_recipe_fk1` FOREIGN KEY (`menu_id`) REFERENCES `menus` (`menu_id`),
    ADD CONSTRAINT `menu_recipe_fk2` FOREIGN KEY (`recipe_id`) REFERENCES `recipes` (`recipe_id`);

ALTER TABLE `recipe_material`
    ADD CONSTRAINT `recipe_material_fk1` FOREIGN KEY (`recipe_id`) REFERENCES `recipes` (`recipe_id`),
    ADD CONSTRAINT `recipe_material_fk2` FOREIGN KEY (`material_id`) REFERENCES `materials` (`material_id`);


SELECT SUM(MR.amount / 100 * RM.amount / 100 * MA.cal) /
       (SELECT count(menu_id) FROM menus) as calavg
FROM menus M
         INNER JOIN menu_recipe MR ON M.menu_id = MR.menu_id
         INNER JOIN recipe_material RM ON MR.recipe_id = RM.recipe_id
         INNER JOIN materials MA ON RM.material_id = MA.material_id;

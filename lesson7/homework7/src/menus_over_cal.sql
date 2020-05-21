SELECT M.menu_id                                       as menu_id,
       M.menu_name                                     as menu_name,
       SUM(MR.amount / 100 * RM.amount / 100 * MA.cal) as cal
FROM menus M
         INNER JOIN menu_recipe MR ON M.menu_id = MR.menu_id
         INNER JOIN recipe_material RM ON MR.recipe_id = RM.recipe_id
         INNER JOIN materials MA ON RM.material_id = MA.material_id
GROUP BY M.menu_id
HAVING cal > 250;

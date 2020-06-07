select
    R.recipe_id,
    R.recipe_name,
    R.cal
from recipes R
         inner join menu_recipe MR
                    on R.recipe_id = MR.recipe_id and
                       MR.menu_id = /*menuId*/5

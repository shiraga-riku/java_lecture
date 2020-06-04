select R.recipe_id,
       R.recipe_name,
       R.cal,
       CASE WHEN RK.user_id is null THEN 0 ELSE 1 END as liked_by_user
from recipes R
         left join recipe_likes RK on R.recipe_id = RK.recipe_id and RK.user_id = /*userId*/1

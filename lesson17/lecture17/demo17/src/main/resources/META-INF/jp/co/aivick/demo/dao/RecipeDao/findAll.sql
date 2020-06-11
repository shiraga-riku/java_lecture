select
    /*%expand*/*
from recipes where
/*%if recipeName != null */
        recipe_name like /* @infix(recipeName) */'name'
/*%end*/

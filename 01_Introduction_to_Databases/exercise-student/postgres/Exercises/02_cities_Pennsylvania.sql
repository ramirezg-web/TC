-- 2. The name and area of all cities in Pennsylvania (PA) (4 rows)

select city_name, area
From city
WHERE state_abbreviation='PA'
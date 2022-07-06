-- 16. The average area of national parks that have camping. Name the column 'average_park_area'.
-- Expected answer is around 3,900.
-- (1 row)

select AVG(AREA) AS average_park_area
from park
GROUP BY has_camping
order by has_camping desc
limit 1;
select year(a.DIFFERENTIATION_DATE) as year, b.max_colony - a.size_of_colony as year_dev, id
from ecoli_data a 
join (select max(size_of_colony) as max_colony, year(DIFFERENTIATION_DATE) year from ecoli_data b group by year(DIFFERENTIATION_DATE)) b on year(a.DIFFERENTIATION_DATE) = b.year order by year(a.differentiation_date) asc, year_dev asc;
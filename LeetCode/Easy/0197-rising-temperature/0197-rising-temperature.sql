-- select Id from (select id, temperature, lag(temperature, 1) over(order by id) as tmp, recordDate from weather order by recordDate) A where A.tmp < A.temperature;

select a.Id Id from weather a join weather b on datediff(a.recordDate,b.recordDate) = 1 and a.temperature > b.temperature;
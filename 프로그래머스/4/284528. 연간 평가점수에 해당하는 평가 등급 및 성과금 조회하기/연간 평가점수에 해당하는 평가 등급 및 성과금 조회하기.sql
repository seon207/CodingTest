SELECT a.emp_no,
       a.emp_name,
       CASE
           WHEN b.avg_score >= 96 THEN 'S'
           WHEN b.avg_score >= 90 THEN 'A'
           WHEN b.avg_score >= 80 THEN 'B'
           ELSE 'C'
       END AS grade,
       CASE
           WHEN b.avg_score >= 96 THEN a.sal * 0.2
           WHEN b.avg_score >= 90 THEN a.sal * 0.15
           WHEN b.avg_score >= 80 THEN a.sal * 0.1
           ELSE 0
       END AS bonus
FROM hr_employees a
JOIN (
    SELECT emp_no, AVG(score) AS avg_score
    FROM hr_grade
    GROUP BY emp_no
) b
ON a.emp_no = b.emp_no
ORDER BY a.emp_no;
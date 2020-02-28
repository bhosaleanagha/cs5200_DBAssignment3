drop procedure if exists getUnansweredQuestions;
DELIMITER //
create procedure getUnansweredQuestions()
BEGIN
select q2.text as quest, q1.answerscount, q2.module from (select a.id,a.questionid,a.text,a.upvotes,count(id) as answerscount from answer a group by questionid having max(correctanswer)=0 and min(correctanswer)=0) q1 join question q2 on q1.questionid = q2.id
group by q2.module having max(q1.answerscount);
END //

Call getUnansweredQuestions;

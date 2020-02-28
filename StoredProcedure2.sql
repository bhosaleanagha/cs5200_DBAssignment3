drop procedure if exists endorsedUsersForWeek;
DELIMITER //
create procedure endorsedUsersForWeek(StartDate Date, EndDate Date)
begin
select id,concat(firstname,' ',lastname) from (select b.postedby,count(b.postedby) from (select a1.text,a1.postedby,a1.questionid,a2.id,a2.postedon from (select a.id,a.text,a.postedon,a.postedby,a.questionid from answer a where correctanswer = 1 )a1 
 join question a2 on a1.questionid = a2.id )b where b.postedon between StartDate and EndDate group by postedby)p1 join
 person p2 on p1.postedby = p2.id order by firstname asc LIMIT 5;
end
//

call endorsedUsersForWeek('2020-02-18','2020-02-25');
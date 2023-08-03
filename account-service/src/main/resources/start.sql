CREATE KEYSPACE bankcloud
    WITH replication = {'class':'SimpleStrategy', 'replication_factor' : 3};

use bankcloud;

CREATE TABLE emp(
                    emp_id int PRIMARY KEY,
                    emp_name text,
                    emp_city text,
                    emp_sal varint,
                    emp_phone varint
);

select * from emp
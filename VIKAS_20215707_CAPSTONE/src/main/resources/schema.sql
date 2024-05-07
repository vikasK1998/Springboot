INSERT INTO customer(id,customer,name,pancard,phn,email) VALUES
(1,'cus1001','Raja','FSJH2766','1234567','raja@g.com'),
(2,'cus1002','Ram','AHFH638','12345678','ram@g.com'),
(3,'cus1003','Arun','FLSNY567','123456789','arun@g.com');

INSERT INTO account(acc_num,accounttype,branch,balance,fk_customer_id) VALUES
(1,'savings','Chennai',100.0,1),
(2,'current','Bangalore',100.0,2),
(3,'salary','Pune',100.0,3);
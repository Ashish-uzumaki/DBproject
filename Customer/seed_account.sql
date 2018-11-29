insert into Customer(name, contact, address, customer_id)
VALUES('John','9848137798','26/c,Hosour road','123456789');

insert into Customer(name, contact, address, customer_id)
VALUES('Sena','9535136084','26/c,Banglore','123456790');

insert into Customer(name, contact, address, customer_id)
VALUES('Clare','966645697','26/c,Hosour road','123456791');

insert into Customer(name, contact, address, customer_id)
VALUES('Ted','9505219935','26/c,Hosour road','123456792');

insert into Customer(name, contact, address, customer_id)
VALUES('Barny','987456321','26/c,Hosour road','123456793');



insert into Account(balance ,accountnumber ,createddate ,account_branch_id , account_customer_id)
VALUES('10000007','123456789','1998-04-05',NULL,'123456793');

insert into Account(balance ,accountnumber ,createddate ,account_branch_id , account_customer_id)
VALUES('5000','987654321','1998-04-06',NULL,'123456791');

insert into Account(balance ,accountnumber ,createddate ,account_branch_id , account_customer_id)
VALUES('14656','999111222','1998-04-07',NULL,'123456792');

insert into Account(balance ,accountnumber ,createddate ,account_branch_id , account_customer_id)
VALUES('30000','129834765','1998-04-08',NULL,'123456790');

insert into Account(balance ,accountnumber ,createddate ,account_branch_id , account_customer_id)
VALUES('40000','444221325','1998-04-09',NULL,'123456791');

insert into Employee(name, salary, type, employee_id) VALUES ("soumith",100000,"zh",1);
insert into Employee(name, salary, type, employee_id) VALUES ("sumanth1",10000,"m",2);
insert into Employee(name, salary, type, employee_id) VALUES ("sumanth2",15000,"m",3);
insert into Employee(name, salary, type, employee_id) VALUES ("Ashish1",15000,"cs",4);
insert into Employee(name, salary, type, employee_id) VALUES ("Ashish2",14000,"cs",5);
insert into Employee(name, salary, type, employee_id) VALUES ("Ashish3",15000,"cs",6);
insert into Employee(name, salary, type, employee_id) VALUES ("Nikhil sai",10,"cc",7);

insert into ZonalHead(zonalhead_id) values(1);
insert into BankManager(bankmanager_id) values(2);
insert into BankManager(bankmanager_id) values(3);
insert into CrossSellingAgent(crossseller_id,commission ) values(4,500);
insert into CrossSellingAgent(crossseller_id, commission ) values(5,300);
insert into CrossSellingAgent(crossseller_id, commission ) values(6,400);
insert into CustomerCare(customercare_id) values(7);

insert into Customer(name, contact, address, customer_id)
VALUES('ashlin','1','26/c,Hosour road',1);

insert into Customer(name, contact, address, customer_id)
VALUES('ashi','2','26/c,Banglore',2);

insert into Customer(name, contact, address, customer_id)
VALUES('ash','3','26/c,Hosour road',3);

insert into Customer(name, contact, address, customer_id)
VALUES('Tashu','4','26/c,Hosour road',4);

insert into Customer(name, contact, address, customer_id)
VALUES('abhi','5','26/c,Hosour road',5);


insert into Account(balance ,accountnumber ,createddate ,account_branch_id , account_customer_id)
VALUES('10000007','1','1998-04-05',NULL,'1');

insert into Account(balance ,accountnumber ,createddate ,account_branch_id , account_customer_id)
VALUES('5000','2','1998-04-06',NULL,'2');

insert into Account(balance ,accountnumber ,createddate ,account_branch_id , account_customer_id)
VALUES('14656','3','1998-04-07',NULL,'3');

insert into Account(balance ,accountnumber ,createddate ,account_branch_id , account_customer_id)
VALUES('30000','4','1998-04-08',NULL,'4');

insert into Account(balance ,accountnumber ,createddate ,account_branch_id , account_customer_id)
VALUES('40000','5','1998-04-09',NULL,'5');

-- type varchar(10),
-- transaction_id int,
-- amount int,
-- transaction_accountnumber int,
insert into Transaction(type,transaction_id,amount,transaction_accountnumber) VALUES ("transfer", 1 ,1000,1);

insert into Loan(amount, type, loan_account_id,loan_manager_id) VALUES (100000,"low",1,2);
insert into Loan( amount, type, loan_account_id,loan_manager_id) VALUES (10000,"low",2);
insert into Loan( amount, type, loan_account_id,loan_manager_id) VALUES (15000,"low",2);
insert into Loan( amount, type, loan_account_id,loan_manager_id) VALUES (15000,"low",2);
-- insert into ( amount, type, loan_account_id,loan_manager_id) VALUES (14000,"low",2);
-- insert into ( amount, type, loan_account_id,loan_manager_id) VALUES (15000,"low",2);
-- insert into ( amount, type, loan_account_id,loan_manager_id) VALUES (10,"low",2);

alter table ZonalHead
add constraint fk_zonalhead_id FOREIGN KEY (zonalhead_id)
REFERENCES Employee(employee_id);


alter table BankManager
add constraint fk_bankmanager_id FOREIGN KEY (bankmanager_id)
REFERENCES Employee(employee_id);

alter table BankManager
add constraint fk_bankmanager_branch_id FOREIGN KEY (bankmanager_branch_id)
REFERENCES Branch(branch_id);

alter table CustomerCare
add constraint fk_customercare_id FOREIGN KEY (customercare_id)
REFERENCES Employee(employee_id);

alter table CustomerCare
add constraint fk_customercare_branch_id FOREIGN KEY (customercare_branch_id)
REFERENCES Branch(branch_id);

alter table CrossSellingAgent
add constraint fk_crossseller_id FOREIGN KEY (crossseller_id)
REFERENCES Employee(employee_id);

alter table CrossSellingAgent
add constraint fk_crossseller_branch_id FOREIGN KEY (crossseller_branch_id)
REFERENCES Branch(branch_id);

alter table Branch
add constraint fk_branch_zonalhead_id FOREIGN KEY (branch_zonalhead_id)
REFERENCES ZonalHead(zonalhead_id);

alter table Branch
add constraint fk_branch_manager_id FOREIGN KEY (branch_manager_id)
REFERENCES BankManager(bankmanager_id);

alter table Account
add constraint fk_account_customer_id FOREIGN KEY (account_customer_id)
REFERENCES Customer(customer_id);

alter table Account
add constraint fk_account_branch_id FOREIGN KEY (account_branch_id)
REFERENCES Branch(branch_id);

alter table Transaction
add constraint fk_transaction_accountnumber FOREIGN KEY (transaction_accountnumber)
REFERENCES Account(accountnumber);

alter table Deposit
add constraint fk_deposit_transaction_id FOREIGN KEY (deposit_transaction_id)
REFERENCES Transaction(transaction_id);

alter table Transfer
add constraint fk_transfer_account_id FOREIGN KEY (transfer_account_id)
REFERENCES Account(accountnumber);

alter table Transfer
add constraint fk_transfer_transaction_id FOREIGN KEY (transfer_transaction_id)
REFERENCES Transaction(transaction_id);

alter table Loan
add constraint fk_loan_account_id FOREIGN KEY (loan_account_id)
REFERENCES Account(accountnumber);

alter table Loan
add constraint fk_loan_manager_id FOREIGN KEY (loan_manager_id)
REFERENCES BankManager(bankmanager_id);
-- 
alter table Insurance
add constraint fk_insurance_account_id FOREIGN KEY (insurance_account_id)
REFERENCES Account(accountnumber);

alter table Insurance
add constraint fk_insurance_crossseller_id FOREIGN KEY (insurance_crossseller_id)
REFERENCES CrossSellingAgent(crossseller_id);

alter table LowValueLoan
add constraint fk_lowvalueloan_id FOREIGN KEY (lowvalueloan_id)
REFERENCES Loan(loan_id);


alter table HighValueLoan
add constraint fk_highvalueloan_id FOREIGN KEY (highvalueloan_id)
REFERENCES Loan(loan_id);

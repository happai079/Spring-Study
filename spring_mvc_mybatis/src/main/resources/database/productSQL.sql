CREATE TABLE product (
	prdNo VARCHAR(20) PRIMARY KEY NOT NULL,
    prdName VARCHAR(20),
    prdPrice INT,
    prdCompany VARCHAR(20),
    prdStock INT
);

INSERT INTO product VALUES ('1001', '모니터', 150000, '삼성', 10),
						   ('1002', '냉장고', 300000, 'LG', 5);
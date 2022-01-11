CREATE TABLE book (
	bookNo VARCHAR(10) PRIMARY KEY NOT NULL,
    bookName VARCHAR(20) NOT NULL,
    bookPrice INT,
    bookAuthor VARCHAR(10),
    pubNo VARCHAR(10)
);

INSERT INTO book VALUES ('001','모두의 네트워크',18000,'이승룡','1'),
						('002','자바의 정석',35000,'남궁성','3'),
                        ('003','자바스크립트 DEEP DIVE',28000,'이웅모','2');
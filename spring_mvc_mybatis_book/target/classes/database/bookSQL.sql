CREATE TABLE book (
	bookNo VARCHAR(10) PRIMARY KEY NOT NULL,
    bookName VARCHAR(20) NOT NULL,
    bookAuthor VARCHAR(10),
    bookPrice int,
    bookDate DATE,
    qtyNo int
);

INSERT INTO book VALUES ('001', '자바의 정석', '남궁성', 350000, '2020-10-15', 10),
						('002', '자바 웹을 다루는 기술', '이병승', 40000, '2021-11-20', 20),
                        ('003', '모두의 네트워크', '미즈구치 카츠야', 18000, '2020-07-09', 5),
                        ('004', '자바스크립트 Deep Dive', '이웅모', 28000, '2021-12-24', 8);
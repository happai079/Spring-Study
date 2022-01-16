CREATE TABLE cart (
	cartNo INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    memId VARCHAR(10) NOT NULL,
    prdNo VARCHAR(10) NOT NULL,
    cartQty INT,
    CONSTRAINT FK_cart_member FOREIGN KEY (memId) REFERENCES member (memId),
    CONSTRAINT FK_cart_product FOREIGN KEY (prdNo) REFERENCES product (prdNo)
);

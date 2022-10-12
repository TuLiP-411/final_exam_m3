create schema studentmanagement;
use studentmanagement;
CREATE TABLE classroom (
    id INT AUTO_INCREMENT PRIMARY KEY,
    classroom VARCHAR(20) NOT NULL
);
CREATE TABLE student (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50),
    dob DATE,
    address VARCHAR(100),
    phone VARCHAR(20),
    email VARCHAR(50),
    class_id INT,
    FOREIGN KEY (class_id)
        REFERENCES classroom (id)
);
INSERT INTO `classroom` (`id`,`classroom`) VALUES (1,'CGMDC0622I1');
INSERT INTO `classroom` (`id`,`classroom`) VALUES (2,'CGMDC0522H1');
INSERT INTO `classroom` (`id`,`classroom`) VALUES (3,'CGTXC0322G1');
INSERT INTO `classroom` (`id`,`classroom`) VALUES (4,'CGTXC0822I1');

INSERT INTO `student` (`name`,`dob`,`address`,`phone`,`email`,`class_id`) VALUES ('Truong Huy Hoang','1999-10-22','Ha Noi','0472877371','hoang@gmail.com',1);
INSERT INTO `student` (`name`,`dob`,`address`,`phone`,`email`,`class_id`) VALUES ('Bui The Phong','1992-09-12','Nam Dinh','0472093388','phong@gmail.com',2);
INSERT INTO `student` (`name`,`dob`,`address`,`phone`,`email`,`class_id`) VALUES ('Phung Tu Linh','1997-11-04','Ha Noi','047389230','linh@gmail.com',4);
INSERT INTO `student` (`name`,`dob`,`address`,`phone`,`email`,`class_id`) VALUES ('Vu Hien Luong','1992-03-27','Bac Ninh','04724541','luong@gmail.com',3);
INSERT INTO `student` (`name`,`dob`,`address`,`phone`,`email`,`class_id`) VALUES ('Tran Thi Thanh Hoa','2022-10-05','No12. 170 alley, My Dinh, Nam Tu Liem, Ha Noi','0388205097','hoattt0497@gmail.com',2);
INSERT INTO `student` (`name`,`dob`,`address`,`phone`,`email`,`class_id`) VALUES ('Vu Hien Luong','1997-10-09','Canada','44444444446775','luong@gmail.com',3);
INSERT INTO `student` (`name`,`dob`,`address`,`phone`,`email`,`class_id`) VALUES ('Ho Ngoc Ha','1987-09-29','Italia','05883773','haho@gmail.com',3);

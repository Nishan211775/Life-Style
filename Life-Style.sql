CREATE TABLE tbl_profile (
    profile_id NUMBER(10),
    full_name VARCHAR2(100) NOT NULL,
    email VARCHAR2(100) NOT NULL UNIQUE,
    address VARCHAR2(100),
    contact VARCHAR2(100),
    dob DATE,
    username VARCHAR2(100) NOT NULL UNIQUE,
    pass VARCHAR2(100) NOT NULL,
    created_date DATE DEFAULT SYSDATE NOT NULL,
    CONSTRAINT pk_profile_id PRIMARY KEY(profile_id)
);

DESC tbl_profile;

--http://localhost:8080/LifeStyle/oauth/token?grant_type=password&client_id=restapp&client_secret=restapp&username=nishandhungana41&password=nishan123
SELECT username, pass FROM tbl_profile WHERE username = 'nishandhungana41';

INSERT INTO tbl_profile(PROFILE_ID, FULL_NAME, EMAIL, ADDRESS, CONTACT, DOB, USERNAME, PASS)
VALUES(1, 'Nishan Dhungana', 'nishandhungana41@gmail.com', 'Panchkhal-7, Hokse', '+977-9861211775', TO_DATE('1996/07/20', 'YYYY/MM/DD'), 'nishandhungana41', 'nishan123');

INSERT INTO tbl_profile(PROFILE_ID, FULL_NAME, EMAIL, ADDRESS, CONTACT, DOB, USERNAME, PASS)
VALUES(11, 'Nishan Dhungana', 'nishandhungana411@gmail.com', 'Panchkhal-7, Hokse', '+977-9861211775', TO_DATE('1996/07/20', 'YYYY/MM/DD'), 'nishandhungana411', 'nishan123');

INSERT INTO tbl_profile(PROFILE_ID, FULL_NAME, EMAIL, ADDRESS, CONTACT, DOB, USERNAME, PASS)
VALUES(111, 'Nishan Dhungana', 'nishandhungana4111@gmail.com', 'Panchkhal-7, Hokse', '+977-9861211775', TO_DATE('1996/07/20', 'YYYY/MM/DD'), 'nishandhungana4111', 'nishan123');

INSERT INTO tbl_profile(PROFILE_ID, FULL_NAME, EMAIL, ADDRESS, CONTACT, DOB, USERNAME, PASS)
VALUES(2, 'Mark Zukerberg', 'markzukerberg@gmail.com', 'LA, California', '+977-9861211775', TO_DATE('1996/07/20', 'YYYY/MM/DD'), 'thisismark2', 'mark123');

SELECT * FROM tbl_profile;

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

CREATE TABLE tbl_roles (
    roles_id NUMBER(10),
    profile_role  VARCHAR2(10) DEFAULT 'ROLE_USER' NOT NULL,
    username VARCHAR(100),
    CONSTRAINT pk_roles_id PRIMARY KEY (roles_id),
    CONSTRAINT fk_username FOREIGN KEY (username) REFERENCES tbl_profile(username)
);

DESC tbl_roles;

INSERT INTO tbl_roles(roles_id , username) 
VALUES(1, 'nishandhungana41');

INSERT INTO tbl_roles(roles_id , username) 
VALUES(2, 'nishandhungana4172');

INSERT INTO tbl_roles(roles_id , username) 
VALUES(3, 'nishandhungana411');

INSERT INTO tbl_roles(roles_id , username) 
VALUES(4, 'nishandhungana4111');

INSERT INTO tbl_roles(roles_id ,profile_role, username) 
VALUES(5, 'ROLE_ADMIN', 'thisismark2');

SELECT * FROM tbl_roles;

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------





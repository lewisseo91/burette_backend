CREATE TABLE USER (
      id INT AUTO_INCREMENT PRIMARY KEY,
      userId VARCHAR(250) NOT NULL,
      password VARCHAR(250) NOT NULL,
      nickname VARCHAR(250) DEFAULT NULL,
      email VARCHAR(250) DEFAULT NULL,
      phoneNumber VARCHAR(250) DEFAULT NULL,
      birthDay DATE,
      gender INT DEFAULT 0,
      writePermission INT DEFAULT 0,
);
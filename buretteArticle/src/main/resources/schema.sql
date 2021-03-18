DROP TABLE IF EXISTS ARTICLE;

--    private int type;
--    private String title;
--    private String subTitle;
--    private List<String> thumbnail; // List<String> 가능성 있음
--    private String contents;
--    private List<String> tags;
--    private int category;
CREATE TABLE ARTICLE (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  type INT,
  title VARCHAR(250) NOT NULL,
  subTitle VARCHAR(250) DEFAULT NULL,
  thumbnail VARCHAR(250) DEFAULT NULL,
  contents VARCHAR(10000) DEFAULT NULL,
  tags VARCHAR(250) DEFAULT NULL,
  categoryId INT
);
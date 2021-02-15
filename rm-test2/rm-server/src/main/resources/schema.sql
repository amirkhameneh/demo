CREATE TABLE IF NOT EXISTS TBL_REQUESTS (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  request_date VARCHAR(20) NOT NULL,
  user VARCHAR(1000) DEFAULT NULL,
  request_status VARCHAR(20),
  request_body clob ,
  response_body clob ,
  request_row_count INT DEFAULT NULL ,
  execution_time INT ,
  time_per_count INT 
);
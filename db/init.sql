# DROP DATABASE IF EXISTS video;

CREATE DATABASE video
  CHARACTER SET utf8
  COLLATE utf8_general_ci;



USE video;


CREATE TABLE camera (
  id VARCHAR(64) NOT NULL PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  position_lat DOUBLE NOT NULL,
  position_lon DOUBLE NOT NULL
);



CREATE TABLE video (
  id VARCHAR(64) NOT NULL PRIMARY KEY,
  camera_id VARCHAR(64) NOT NULL,
  original_location VARCHAR(1000) NOT NULL,
  playback_url VARCHAR(1000) NOT NULL,
  start_time TIMESTAMP NOT NULL,
  FOREIGN KEY (camera_id) REFERENCES camera(id)
);

CREATE INDEX camera_id ON video(camera_id);



CREATE TABLE task (
  id VARCHAR(64) NOT NULL PRIMARY KEY,
  video_id NVARCHAR(64) NOT NULL,
  create_time TIMESTAMP NOT NULL,
  status INT NULL,
  executor_id VARCHAR(64) NULL,
  executor_heartbeat TIMESTAMP NULL,
  FOREIGN KEY (video_id) REFERENCES video(id)
);

CREATE INDEX video_id ON task(video_id);

CREATE INDEX available_tasks ON task(status, executor_heartbeat);

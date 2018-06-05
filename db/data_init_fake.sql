DELETE FROM task;
DELETE FROM video;
DELETE FROM camera;

SET time_zone = 'UTC';

INSERT INTO camera VALUES
  ('c000001', N'泰安路胶南路交叉口1', 119.535685, 35.413511),
  ('c000002', N'泰安路胶南路交叉口2', 119.532934, 35.41351),
  ('c000003', N'泰安路胶南路交叉口3', 119.531119, 35.415816),
  ('c000004', N'泰安路胶南路交叉口4', 119.531093, 35.418461),
  ('c000005', N'泰安路胶南路交叉口5', 119.531271, 35.421082),
  ('c000006', N'泰安路胶南路交叉口6', 119.531975, 35.425995);

INSERT INTO video VALUES
  ('v000001', 'c000001', 'ftp://unknown/path/video.mp4', 'https://rich-video.oss-cn-beijing.aliyuncs.com/street_cam/__1.mp4', '2018-06-05 02:30:00'),
  ('v000002', 'c000002', 'ftp://unknown/path/video.mp4', 'https://rich-video.oss-cn-beijing.aliyuncs.com/street_cam/__1.mp4', '2018-06-05 02:30:00'),
  ('v000003', 'c000003', 'ftp://unknown/path/video.mp4', 'https://rich-video.oss-cn-beijing.aliyuncs.com/street_cam/__1.mp4', '2018-06-05 02:30:00'),
  ('v000004', 'c000004', 'ftp://unknown/path/video.mp4', 'https://rich-video.oss-cn-beijing.aliyuncs.com/street_cam/__1.mp4', '2018-06-05 02:30:00'),
  ('v000005', 'c000005', 'ftp://unknown/path/video.mp4', 'https://rich-video.oss-cn-beijing.aliyuncs.com/street_cam/__1.mp4', '2018-06-05 02:30:00'),
  ('v000006', 'c000006', 'ftp://unknown/path/video.mp4', 'https://rich-video.oss-cn-beijing.aliyuncs.com/street_cam/__1.mp4', '2018-06-05 02:30:00');

INSERT INTO task VALUES
  ('t000001', 'v000001', '2018-06-05 03:00:00', 0, NULL, NULL),
  ('t000002', 'v000002', '2018-06-05 03:00:00', 0, NULL, NULL),
  ('t000003', 'v000003', '2018-06-05 03:00:00', 0, NULL, NULL),
  ('t000004', 'v000004', '2018-06-05 03:00:00', 0, NULL, NULL),
  ('t000005', 'v000005', '2018-06-05 03:00:00', 0, NULL, NULL),
  ('t000006', 'v000006', '2018-06-05 03:00:00', 0, NULL, NULL);

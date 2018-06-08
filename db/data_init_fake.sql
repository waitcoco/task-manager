DELETE FROM task;
DELETE FROM video;
DELETE FROM camera;

SET time_zone = 'UTC';

INSERT INTO camera VALUES
  ('c000001', N'中级人民法院（南门）', 35.413511, 119.535685),
  ('c000002', N'宏伟国际酒店（南门）', 35.41351, 119.532934),
  ('c000003', N'烟台路胶州路交叉口（东北角）', 35.415816, 119.531119),
  ('c000004', N'公共法律服务中心', 35.418461, 119.531093),
  ('c000005', N'华润万象汇(公交站)', 35.421082, 119.531271),
  ('c000006', N'烟台路济南路交叉口（东北角）', 35.425995, 119.531975);

INSERT INTO video VALUES
  ('1.mp4', 'c000001', 'ftp://unknown/path/video.mp4', 'https://rich-video.oss-cn-beijing.aliyuncs.com/street_cam/__1.mp4', '2018-06-05 02:30:00'),
  ('2.mp4', 'c000002', 'ftp://unknown/path/video.mp4', 'https://rich-video.oss-cn-beijing.aliyuncs.com/street_cam/__2.mp4', '2018-06-05 02:30:00'),
  ('3.mp4', 'c000003', 'ftp://unknown/path/video.mp4', 'https://rich-video.oss-cn-beijing.aliyuncs.com/street_cam/__3.mp4', '2018-06-05 02:30:00'),
  ('4.mp4', 'c000004', 'ftp://unknown/path/video.mp4', 'https://rich-video.oss-cn-beijing.aliyuncs.com/street_cam/__4.mp4', '2018-06-05 02:30:00'),
  ('5.mp4', 'c000005', 'ftp://unknown/path/video.mp4', 'https://rich-video.oss-cn-beijing.aliyuncs.com/street_cam/__5.mp4', '2018-06-05 02:30:00'),
  ('6.mp4', 'c000006', 'ftp://unknown/path/video.mp4', 'https://rich-video.oss-cn-beijing.aliyuncs.com/street_cam/__6.mp4', '2018-06-05 02:30:00');

INSERT INTO task VALUES
  ('t000001', '1.mp4', '2018-06-05 03:00:00', 0, NULL, NULL),
  ('t000002', '2.mp4', '2018-06-05 03:00:00', 0, NULL, NULL),
  ('t000003', '3.mp4', '2018-06-05 03:00:00', 0, NULL, NULL),
  ('t000004', '4.mp4', '2018-06-05 03:00:00', 0, NULL, NULL),
  ('t000005', '5.mp4', '2018-06-05 03:00:00', 0, NULL, NULL),
  ('t000006', '6.mp4', '2018-06-05 03:00:00', 0, NULL, NULL);

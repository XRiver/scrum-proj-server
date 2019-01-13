/*
SQLyog Ultimate v12.5.0 (64 bit)
MySQL - 5.6.42 : Database - nanjing_travel
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`nanjing_travel` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `nanjing_travel`;

/*Table structure for table `apply` */

DROP TABLE IF EXISTS `apply`;

CREATE TABLE `apply` (
  `applyid` int(11) NOT NULL AUTO_INCREMENT,
  `openid` varchar(50) DEFAULT NULL COMMENT '申请加入者的openid',
  `pid` int(11) DEFAULT NULL COMMENT '申请加入的景点pid',
  `mess` varchar(200) DEFAULT NULL COMMENT '申请者的留言',
  `pass` int(1) DEFAULT NULL COMMENT '是否允许加入',
  `deal` int(1) DEFAULT '0' COMMENT '是否审批过',
  PRIMARY KEY (`applyid`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8 COMMENT='申请信息';

/*Data for the table `apply` */

insert  into `apply`(`applyid`,`openid`,`pid`,`mess`,`pass`,`deal`) values 
(1,'007',3,'take me away~',1,1),
(2,'007',6,'take me away~',0,1),
(3,'111',6,'take me away~',1,1),
(4,'111',3,'4444',NULL,0),
(5,'111',3,'5555',NULL,0),
(22,'mf1832113',1,'jack want to join you!',NULL,0),
(23,'19960305',1,'jack want to join you!',NULL,0),
(24,'o9VBV4x48dxVHVXeozv_jKb9MQHE',25,'jack want to join you!',1,1),
(25,'111',25,'jack want to join you!',1,1),
(26,'o9VBV44gvvycu-kp8dnCoBI8npe8',1,NULL,NULL,0),
(27,'mf1832113',2,'jack want to join you!',1,1),
(28,'',1,NULL,NULL,0),
(29,'o9VBV44gvvycu-kp8dnCoBI8npe8',32,'你就',NULL,0);

/*Table structure for table `attraction` */

DROP TABLE IF EXISTS `attraction`;

CREATE TABLE `attraction` (
  `aId` int(11) NOT NULL AUTO_INCREMENT,
  `aName` varchar(50) DEFAULT NULL COMMENT '景点名字',
  `location` varchar(100) DEFAULT NULL COMMENT '景点位置',
  `pictureUrl` varchar(500) DEFAULT NULL COMMENT '景点图片url',
  `description` varchar(500) DEFAULT NULL COMMENT '对景点的描述',
  PRIMARY KEY (`aId`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COMMENT='景点信息';

/*Data for the table `attraction` */

insert  into `attraction`(`aId`,`aName`,`location`,`pictureUrl`,`description`) values 
(1,'夫子庙','南京市秦淮区贡院西街53号','http://h.bytravel.cn/www/40/head/40223.gif','夫子庙秦淮风光带位于南京城南，指的是以夫子庙建筑为中心，秦淮河为纽带，东起东水关淮青桥秦淮水亭，越过文德桥，直到中华门城堡延伸至西水关的内秦淮河地带，包括秦淮河两岸的街巷、民居、附近的古迹和风景点，是南京最繁华的地方。'),
(2,'中山陵','南京市玄武区石象路7号','http://h2.bytravel.cn/www/3/head/2588.gif','中山陵是我国伟大的革命先行者孙中山先生的陵墓，坐落在紫金山第二峰小茅山的南麓，北依青山，南临平川，依山就势，气势雄伟，使人有仰止崇高之感。孙中山先生1925年逝世于北京，临终时他希望将遗体葬于南京钟山，故死后其灵柩暂厝于北京香山碧云寺内，为了尊重他的遗愿，于翌年3月12日在他逝世一周年之日，在钟山开始建墓，至1929年春落成，同年6月1日就将其灵柩从北京移葬于此。'),
(3,'总统府','南京市玄武区长江路292号','http://h2.bytravel.cn/www/3/head/2572.gif','南京总统府建筑群占地面积约为5万余平方米，既有中国古代传统的江南园林，也有近代西风东渐时期的建筑遗存，至今已有600多年的历史。其历史可追溯到明初的归德侯府和汉王府，清代被辟为江宁织造署、两江总督署等，清康熙乾隆南巡均以此为行宫。太平天国定都天京（今南京）后，在此基础上扩建为天王府。1912年1月1日，孙中山在此宣誓就职中华民国临时大总统，辟为大总统府，后来又为南京国民政府总统府。'),
(4,'明孝陵','南京市玄武区长江路292号','http://h2.bytravel.cn/www/5/head/5254.gif','明孝陵作为中国明皇陵之首，代表了明初建筑和石刻艺术的最高成就，直接影响明清两代五百余年20多座帝王陵寝的形制，依历史进程分布于北京、湖北、辽宁、河北等地的明清皇家陵寝，均按南京明孝陵的规制和模式营建，在中国帝陵发展史上有着特殊的地位，故而有“明清皇家第一陵”的美誉。'),
(5,'玄武湖公园','南京市玄武区玄武巷1号','https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1604155085,230319881&fm=27&gp=0.jpg','玄武湖，位于南京市玄武区，东枕紫金山，西靠明城墙，北邻南京站，是江南地区最大的城内公园，也是中国最大的皇家园林湖泊、仅存的江南皇家园林，被誉为“金陵明珠”，现为国家重点公园、国家AAAA级旅游景区。'),
(6,'南京博物院','南京市玄武区中山东路321号','http://img1.imgtn.bdimg.com/it/u=2944737778,1872551779&fm=26&gp=0.jpg','南京博物院简称南院或南博，是中国三大博物馆之一，其前身是1933年蔡元培等倡建的国立中央博物院，是中国创建最早的博物馆、中国第一座由国家投资兴建的大型综合类博物馆。南京博物院是大型综合性的国家级博物馆、国家综合性历史艺术博物馆，现为国家一级博物馆、首批中央地方共建国家级博物馆、国家AAAA级旅游景区和全国重点文物保护单位。'),
(7,'雨花台','南京市雨花台区雨花路215号','https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1745272485,739059556&fm=26&gp=0.jpg','雨花台风景区又名雨花台风景名胜区，简称雨花台。位于南京市雨花台区中华门外1公里处，面积为153.7公顷，绿地覆盖率达90%以上。是以自然山林为依托，以红色旅游为主体，融和自然风光和人文景观为一体的全国独具特色的纪念性风景名胜区。'),
(8,'钟山风景区','南京市玄武区石象路7号','https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=1838017313,1801833207&fm=26&gp=0.jpg','钟山风景区以中山陵园为中心，明孝陵和灵谷寺为依托，分布各类名胜古迹多达200多处，84个可供游览景点。其中世界文化遗产1处，全国重点文物保护单位15处，江苏省文物保护单位和市级文物保护单位共31处。风景区分为明孝陵景区、中山陵景区、灵谷景区、头陀岭景区和其他景点五大部分。'),
(9,'乌衣巷','南京市秦淮区大石坝街146-1','https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2297472448,1255874577&fm=26&gp=0.jpg','乌衣巷位于南京市秦淮区秦淮河上文德桥旁的南岸，地处夫子庙秦淮风光带核心地带，是中国历史最悠久最著名的古巷，当时中国世家大族居住之地，三国时是吴国戍守石头城部队营房所在地。乌衣巷是晋代王谢两家豪门大族的宅第，两族子弟都喜欢穿乌衣以显身份尊贵，因此得名。乌衣巷门庭若市，冠盖云集，走出了王羲之、王献之，及山水诗派鼻祖谢灵运等文化巨匠。乌衣巷见证了王谢的艺术成就，与两大家族的历史，乃至整个中国文化的历史紧密相连。'),
(10,'瞻园','南京市秦淮区瞻园路128号','https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1969235961,888061924&fm=26&gp=0.jpg','瞻园位于南京市秦淮区夫子庙秦淮风光带核心区，是南京现存历史最久的明代古典园林，是江南四大名园，其历史可追溯至明太祖朱元璋称帝前的吴王府，后赐予中山王徐达的府邸花园，素以假山著称，以欧阳修诗“瞻望玉堂，如在天上”而命名，明代被称为“南都第一园”。现为全国重点文物保护单位、国家AAAAA级旅游景区。'),
(11,'南京海底世界','南京市玄武区中山陵四方城8号','https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=589109492,1950625029&fm=26&gp=0.jpg','南京海底世界有200余种，10000多尾海洋鱼类，6只来自南极的帝企鹅，20余只温带企鹅，并有北极熊、北极狐、海豚海狮等海洋哺乳动物30余只。南京海底世界拥有180度亚克力透明玻璃构成的隧道，长74米，宽3米，高2.4米，储水量4000多吨，其中生活着百余种海洋鱼类，使您漫步在海底，领略迷人的海底景观。五光十色的珊瑚鱼、凶猛的大鲨鱼围绕在您的身边，使您赏心悦目，心旷神怡，让您漫游海底的梦想成真。南京海底世界每天都为各位参观者准备了丰富多彩的海洋动物表演，“人鲨共舞”中，参观者可以亲眼目睹由潜水员和鲨鱼所呈现的惊心动魄的精彩表演。'),
(12,'南京大屠杀遇难同胞纪念馆','南京市水西门大街418号','https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=1065610575,3743437348&fm=26&gp=0.jpg','纪念馆占地25000平方米，主体建筑面积2100平方米。由南京工学院建筑系教授齐康设计，是一座纪念性的墓地。均以花岗石、大理石、青条石铺砌墙面。正面馆名由邓小平题写。人口处有中、英、日三种文字镌刻的石碑，上书“死难者300000”。颓垣断壁的围墙，空旷的墓场，大片鹅卵石铺地，寸草不生，几棵枯树仕立，气氛凄凉。院墙外的常青树木和院内卵石边生机盎然的小草象征生命力和斗争精神。院内小道边沿途竖小型碑刻I3块，揭示出日军的种种罪行。尚有死难同胞尸骨陈列室，门前有大型立雕母亲像，作呐喊状。室内陈列从“万人坑”中挖出的层层白骨。另有史料陈列厅、电影放映室等。'),
(13,'栖霞山','南京市栖霞区栖霞街88号','https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1027455241,2865100731&fm=26&gp=0.jpg','古称摄山，位于南京市太平门外22公里处。山有三峰、东峰如龙称龙山；西峰似虎称虎山；主峰三茅宫又称凤翔峰、海拔286 米。山西侧称枫岭，有成片的枫树，每到深秋，满山红遍，景色十分迷人，是栖霞山吸引游人的主要景致。另外栖霞山古迹名胜很多，奇岩怪石不少，因之成为远近闻名的旅游胜地。 栖霞山风景区的第一景是明镜湖，它位于栖霞寺大门西面，面积约3000平方米。是清乾隆年间兴建的，湖中有湖心亭，并有九曲桥与岸相连。造型精巧，景点名“彩虹明镜”。'),
(14,'江南贡院','南京市秦淮区夫子庙金陵路1号','https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=1867944851,3727256737&fm=26&gp=0.jpg','是夫子庙地区三大古建筑群之一。始建于南宋（1169年），是县、府学考试场所。朱元璋定都南京后，乡试、会试都集中在南京举行，回此，县学、府学必须另建考棚。当时东边营的下江考棚，原为江宁县学考场，鸡鸣山下南京市政府大院是上元县县学考场。明成祖1421年迁都北京，但南京仍为陪都，而江南又是人文荟萃之地，考试仍在此按期举行。这时成祖又继续派人建造江南贡院。明清两代对贡院均有扩建，到清光绪年间，贡院占地达数万平方米。其规模之庞大，为当时全国23个行省的贡院之最。至同治年间，已建供考试用的“号舍”20644间，还不包括司考官员办公住宿用房在内。'),
(15,'莫愁湖','南京城西水西门外','https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=1352949073,3250390019&fm=26&gp=0.jpg','位于南京城西水西门外 。公园里林木郁葱，湖畔亭、堂、厅、楼错列，古代享有南京第一名湖之称。相传莫愁是南朝时齐国（479一502）洛阳一美少女，家贫卖身葬父，远嫁金陵，不容于舅姑，投湖自尽。因此得名莫愁湖。 　　事实上，六朝时这里还是大江的一部分。唐时叫横塘，北宋乐史著《太平衰字记》中才有莫愁湖的名字。1929年辟为公园。1953年开始大加修葺，并在郁金堂西重雕莫愁女像。 胜棋楼 在莫愁湖公园内。始建于明洪武初年，重修于清同治十年（1871）。 　　相传这里是明太祖朱元璋与大将徐达弈棋的地方。有一次徐达站立起身，对皇帝说：”陛下，这局棋已经和了。”朱元璋求胜心切，不愿和局，徐达躬身行礼说，“请陛下到这边来，细看臣的棋势。”朱元璋走过去一看， 不觉又惊又喜。原来徐达用的黑子在棋盘上摆成了“万岁”二字。朱元漳这才明白，自己不是徐达的对手，于是便把莫愁湖送给了徐达，此楼被称为“胜棋楼”。湖畔有“粤军殉难烈士墓”和孙中山先生手书“建国成仁”碑 。');

/*Table structure for table `plan` */

DROP TABLE IF EXISTS `plan`;

CREATE TABLE `plan` (
  `pId` int(11) NOT NULL AUTO_INCREMENT,
  `openId` varchar(50) DEFAULT NULL COMMENT '计划创建者微信标识号',
  `aId` varchar(50) DEFAULT NULL COMMENT '景点编号',
  `travelTime` varchar(50) DEFAULT NULL COMMENT '出行时间',
  `detail` varchar(200) DEFAULT NULL COMMENT '备注',
  `applyList` varchar(200) DEFAULT NULL COMMENT '申请加入者的ID列表',
  `state` varchar(50) DEFAULT '0' COMMENT '出行计划的状态',
  PRIMARY KEY (`pId`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8 COMMENT='出行计划信息';

/*Data for the table `plan` */

insert  into `plan`(`pId`,`openId`,`aId`,`travelTime`,`detail`,`applyList`,`state`) values 
(1,'111','1','2019-01-01','come on guys!!!','007,111,112,mf1832113,19960305,o9VBV44gvvycu-kp8dnCoBI8npe8,,','0'),
(2,'2','2','2019-01-31','please join us!!!','111,007,mf1832113,','0'),
(25,'o9VBV4x48dxVHVXeozv_jKb9MQHE','5','2019-03-03','we will travel on Marth 3rd','o9VBV4x48dxVHVXeozv_jKb9MQHE,111,','0'),
(26,'111','2','2019-01-01','come on',NULL,'1'),
(29,'2','1','2019-01-26','aaaa',NULL,'1'),
(30,'88888888','5','1546777799999','timestamp3',NULL,'0'),
(32,'111','1','1580760060000','黄金季节','o9VBV44gvvycu-kp8dnCoBI8npe8,','0'),
(33,'o9VBV44gvvycu-kp8dnCoBI8npe8','1','1582992000000','你也是',NULL,'0'),
(34,NULL,NULL,NULL,NULL,NULL,'0');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `uId` int(11) NOT NULL AUTO_INCREMENT,
  `openId` varchar(50) DEFAULT NULL COMMENT '微信身份标识',
  `uName` varchar(50) DEFAULT NULL COMMENT '用户姓名',
  `school` varchar(100) DEFAULT NULL COMMENT '用户所在高校',
  `pictureUrl` text COMMENT '用户头像url',
  `sex` enum('男','女') DEFAULT NULL COMMENT '性别',
  `nickName` varchar(100) DEFAULT NULL COMMENT '用户昵称',
  `city` varchar(50) DEFAULT NULL COMMENT '用户所在城市',
  PRIMARY KEY (`uId`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COMMENT='用户信息';

/*Data for the table `user` */

insert  into `user`(`uId`,`openId`,`uName`,`school`,`pictureUrl`,`sex`,`nickName`,`city`) values 
(1,'111','张三','南京大学','/root/picture/111','男','小三','南京'),
(2,'2','劫','河海大学','/root/picture/112','男','影流之主','纽约'),
(3,'007','JamesBund','HaFo','www.halliwood','男','特工','Samfromsisco'),
(4,'11',NULL,NULL,NULL,'女',NULL,NULL),
(15,'19960305','刘正元',NULL,NULL,NULL,NULL,NULL),
(16,'mf1832113','ltx','nju','/home/ltx','男','jack','nanjing'),
(17,'o9VBV44gvvycu-kp8dnCoBI8npe8','何炜杰','南大','https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTK9vP0sq9CPps6aQpQ07ZXJFqiaia9icl8khJkGlGoSTR1m2kaFdtGvMj9gNXagxdsaxcxOiaEoaoxSmA/132','男',NULL,'Wuxi'),
(19,'o9VBV4x48dxVHVXeozv_jKb9MQHE','徐江河','南京大学','https://wx.qlogo.cn/mmopen/vi_32/fcnvXSfjbaib862WeK7ibia442aSU1TqdEfOKs45I22TuIQmgNrzAGAibhG7g0pibHGwTE3ZEniaUGZf8Xia0YJlkYaEw/132','男',NULL,'Zibo');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

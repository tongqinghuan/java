/*
SQLyog Ultimate v9.20 
MySQL - 5.0.96-community-nt : Database - upcjob
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`upcjob` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `upcjob`;

/*Table structure for table `campus_talk` */

DROP TABLE IF EXISTS `campus_talk`;

CREATE TABLE `campus_talk` (
  `campus_talkID` int(11) NOT NULL,
  `campus_talkname` varchar(50) default NULL,
  `publish_time` datetime default NULL,
  `campus_talktime` datetime default NULL,
  `campus_talkplace` varchar(50) default NULL,
  `main_content` varchar(500) default NULL,
  PRIMARY KEY  (`campus_talkID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `campus_talk` */

/*Table structure for table `collect` */

DROP TABLE IF EXISTS `collect`;

CREATE TABLE `collect` (
  `collectID` int(11) NOT NULL,
  `nameID` int(11) default NULL,
  `campus_talkID` int(11) default NULL,
  `jobID` int(11) default NULL,
  `informationID` int(11) default NULL,
  PRIMARY KEY  (`collectID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `collect` */

/*Table structure for table `feedback` */

DROP TABLE IF EXISTS `feedback`;

CREATE TABLE `feedback` (
  `feedbackID` int(11) NOT NULL,
  `nameID` int(11) default NULL,
  `title` varchar(500) default NULL,
  `content` varchar(500) default NULL,
  PRIMARY KEY  (`feedbackID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `feedback` */

/*Table structure for table `job` */

DROP TABLE IF EXISTS `job`;

CREATE TABLE `job` (
  `jobiD` int(11) NOT NULL auto_increment,
  `jobname` varchar(50) default NULL,
  `related_job` varchar(50) default NULL,
  `salary` varchar(50) default NULL,
  `requirement` varchar(500) default NULL,
  `job_description` varchar(500) default NULL,
  `pubilsh_time` datetime default NULL,
  PRIMARY KEY  (`jobiD`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `job` */

/*Table structure for table `job_information` */

DROP TABLE IF EXISTS `job_information`;

CREATE TABLE `job_information` (
  `informationID` int(11) NOT NULL,
  `informatio_name` varchar(50) default NULL,
  `information_content` varchar(500) default NULL,
  `publish_time` datetime default NULL,
  `title` varchar(500) default NULL,
  PRIMARY KEY  (`informationID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `job_information` */

/*Table structure for table `job_tb` */

DROP TABLE IF EXISTS `job_tb`;

CREATE TABLE `job_tb` (
  `jobiD` int(11) NOT NULL auto_increment,
  `jobname` varchar(50) default NULL,
  `related_job` varchar(50) default NULL,
  `salary` varchar(50) default NULL,
  `requirement` varchar(500) default NULL,
  `job_description` varchar(500) default NULL,
  `publish_time` datetime default NULL,
  PRIMARY KEY  (`jobiD`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `job_tb` */

insert  into `job_tb`(`jobiD`,`jobname`,`related_job`,`salary`,`requirement`,`job_description`,`publish_time`) values (1,'农业处项目经理1名','','面议','硕士及以上学历','具有较强的文字表达能力，制图能力。','2015-04-19 00:00:00'),(2,'监理员（1人）',NULL,'面议','全日制应届硕士研究生(2015年)','应聘毕业生能够熟练掌握计算机基本操作技能，熟练使用WORD、EXCEL等办公软件','2015-04-19 00:00:00'),(3,'项目监理（10人）',NULL,'面议','本科及以上','无','2015-04-19 00:00:00'),(4,'项目监理（10人）',NULL,'面议','本科及以上','无','2015-04-20 00:00:00'),(5,'造价费控',NULL,'面议','本科及以上','无','2015-04-20 00:00:00'),(6,'安全管理',NULL,'面议','本科及以上','安全相关专业','2015-04-20 00:00:00'),(7,'UI界面设计实习生',NULL,'面议','本科及以上','.移动Web应用程序的用户界面设计经验（iPhone和Android）','2015-04-21 00:00:00'),(8,'产品规划',NULL,'面议','本科及以上','无','2015-04-21 00:00:00');

/*Table structure for table `manager` */

DROP TABLE IF EXISTS `manager`;

CREATE TABLE `manager` (
  `managerID` int(11) NOT NULL,
  `password` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY  (`managerID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `manager` */

insert  into `manager`(`managerID`,`password`,`name`) values (11,'www','zhang');

/*Table structure for table `news` */

DROP TABLE IF EXISTS `news`;

CREATE TABLE `news` (
  `newsID` int(20) NOT NULL auto_increment,
  `news_title` varchar(50) NOT NULL,
  `content` varchar(5000) NOT NULL,
  `website` varchar(500) default NULL,
  `publishtime` varchar(20) NOT NULL,
  PRIMARY KEY  (`newsID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `news` */

insert  into `news`(`newsID`,`news_title`,`content`,`website`,`publishtime`) values (1,'中国中铁东方国际建设分公司2015校园招聘','中国中铁东方国际建设分公司（以下简称“东方国际”）是世界企业500强、世界品牌500强企业——中国中铁股份有限公司（CREC）的分公司。作为中国中铁国际化战略经营单元，东方国际在国际工程项目的运作、实施、管理及融资等方面优势明显，积累形成了丰富的国际商务、信息渠道、合作伙伴、海外经营资源等独特优势，拥有广泛的国内外合作关系和一大批熟练掌握多语种语言、精通国际商务、熟悉现代化大型项目管理、国际工程实践经验丰富的复合型人才，迅速成为中国中铁海外业务板块最具竞争力的分公司之一。','http://career.upc.edu.cn/article_show.asp?id=12700','2015-05-06'),(2,'青岛市首届人力资源扶持计划暨大学生模拟职场大赛','青岛市中小企业公共服务中心，作为主办单位举办青岛市首届人力资源扶持计划暨大学生模拟职场大赛。活动已试运行一周。本次活动主要面向在校大三及应届生......','http://career.upc.edu.cn/article_show.asp?id=12629','2015-05-05'),(3,'莱商银行2015校园招聘','莱商银行是经中国银行业监督管理委员会批准设立的股份制商业银行，多年来，坚持走规范发展、改革创新、文化兴行、品牌竞争之路，逐步成长为一家发展理念先进、公司治理完善、内部控制严密、管理机制高效、经营效益优良的区域性品牌银行......','http://career.upc.edu.cn/article_show.asp?id=12701','2015-05-05'),(4,'中海油天津人力资源公司招聘往届生信息(第二批)','北京办事处销售代表 1名  常驻工作地点北京(根据工作需要有时需要去天津出差.要求：工科背景……','http://career.upc.edu.cn/article_show.asp?id=12705','2015-05-05'),(5,'大唐山东发电有限公司所属单位2015春季校园招','大唐山东发电有限公司是中国大唐集团公司设立的国有独资公司，于2009年1月9日登记注册，注册资本金30亿元人民币。依照中国大唐集团公司授权……','http://career.upc.edu.cn/article_show.asp?id=12714','2015-05-05'),(6,'鲁西集团招聘','鲁西集团地处山东聊城市，是国有大型综合性企业集团，目前总资产 220 亿元，职工 12000 余人。近几年来，随着集团公司的快速发展，形成了化肥、化工、装备制造安装和化工设计研发、金融等产业板块……','http://career.upc.edu.cn/article_show.asp?id=12741','2015-05-05'),(7,'中央机关及其直属机构2015年度补充录用公务员公告','中央机关及其直属机构2015年度公务员招考已经进入公示和备案阶段。经过前一阶段的面试、体检和考察，有部分职位出现空缺，需要面向社会公开调剂补充人选……','http://career.upc.edu.cn/article_show.asp?id=12739','2105-05-04'),(8,'利群集团2015招聘','利群集团是一家跨地区、多业态、综合性的股份制商业企业集团，经营范围及业态包括商业零售、物流配送、酒店餐 饮、房地产、医药批发及连锁、汽车租赁、旅游、金融等领域。到目前为止，已经拥有100多家子分公司，已开业运营的万米以上的商厦40余座.....','http://career.upc.edu.cn/article_show.asp?id=12737','2015-05-04');

/*Table structure for table `profession_information` */

DROP TABLE IF EXISTS `profession_information`;

CREATE TABLE `profession_information` (
  `jobID` int(20) NOT NULL,
  `job_name` varchar(50) NOT NULL,
  `salary` varchar(50) NOT NULL,
  `company` varchar(50) NOT NULL,
  `address` varchar(50) NOT NULL,
  `nature` varchar(20) NOT NULL,
  `publish_time` varchar(20) NOT NULL,
  `wanted_number` varchar(10) NOT NULL,
  `scale` varchar(20) NOT NULL,
  `degree_demand` varchar(20) NOT NULL,
  `job_description` varchar(2000) NOT NULL,
  `company_xinxi` varchar(10000) NOT NULL,
  `industry` varchar(50) NOT NULL,
  PRIMARY KEY  (`jobID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `profession_information` */

insert  into `profession_information`(`jobID`,`job_name`,`salary`,`company`,`address`,`nature`,`publish_time`,`wanted_number`,`scale`,`degree_demand`,`job_description`,`company_xinxi`,`industry`) values (0,'','','','','','','','','','','',''),(1,'光刻胶制程工程师','4000起薪','阜阳欣奕华材料科技有限公司','安徽省阜阳市','全职','2015-05-05','10 人','500-999人','本科','岗位职责：负责光刻胶生产。\r\n\r\n要求：本科以上学历，高分子材料相关专业，对光刻胶有了解，涂料、颜料方向也可。\r\n\r\n工作方式：倒班。\r\n\r\n\r\n待遇：4000起薪\r\n福利：五险一金，提供宿舍、工作餐，培训和晋升体系，年终奖。','公司简介\r\n\r\n欣奕华科技有限公司，是由中国光电与创新科技产业基金与战略投资者共同创建的高科技公司。公司专注于智能机器和先进材料研发生产，旨在推进工业机器人、服务机器人、关键零部件产业发展，实现先进材料研发和产业化突破。公司愿景是成为一家智能机器和先进材料领域世界领先企业，为中国现代化和人类文明进步做贡献。\r\n公司运营与研发总部位于北京，并在安徽设有智能机器、先进材料两大事业集群及生产基地。智能机器事业群位于安徽合肥新站智能制造产业园，目前产品主要为泛半导体产业机器人、工厂自动化和数字化制造解决方案的生产、销售与服务。先进材料事业群位于安徽阜阳合肥现代产业园，主要从事液晶单体、中间体、彩色光刻胶等平板显示用新型电子材料以及生物医药材料的研发、生产、销售与服务，。','生物/制药/化工/环保类'),(2,'公共关系专员','面议','阜阳欣奕华材料科技有限公司','安徽省阜阳市','全职','2015-04-27','2 人','500-999人','硕士','岗位职责：\r\n1.政策分析及项目申报。\r\n2.公共关系维护与品牌宣传。\r\n\r\n任职要求：\r\n1.硕士学历，管理类、化学材料类及相关专业。\r\n2.英语6级。\r\n3.有项目申报、主持经验者优先。\r\n4.形象好，气质佳。','公司简介\r\n\r\n欣奕华科技有限公司，是由中国光电与创新科技产业基金与战略投资者共同创建的高科技公司。公司专注于智能机器和先进材料研发生产，旨在推进工业机器人、服务机器人、关键零部件产业发展，实现先进材料研发和产业化突破。公司愿景是成为一家智能机器和先进材料领域世界领先企业，为中国现代化和人类文明进步做贡献。\r\n公司运营与研发总部位于北京，并在安徽设有智能机器、先进材料两大事业集群及生产基地。智能机器事业群位于安徽合肥新站智能制造产业园，目前产品主要为泛半导体产业机器人、工厂自动化和数字化制造解决方案的生产、销售与服务。先进材料事业群位于安徽阜阳合肥现代产业园，主要从事液晶单体、中间体、彩色光刻胶等平板显示用新型电子材料以及生物医药材料的研发、生产、销售与服务，。','经营管理类'),(3,'财务人员','面议','阜阳欣奕华材料科技有限公司','北京市大兴区','全职','2015-04-27 ','2 人','500-999人','本科','工作职责：财务相关工作。\r\n要求：财务相关专业，本科以上学历。','公司简介\r\n\r\n欣奕华科技有限公司，是由中国光电与创新科技产业基金与战略投资者共同创建的高科技公司。公司专注于智能机器和先进材料研发生产，旨在推进工业机器人、服务机器人、关键零部件产业发展，实现先进材料研发和产业化突破。公司愿景是成为一家智能机器和先进材料领域世界领先企业，为中国现代化和人类文明进步做贡献。\r\n公司运营与研发总部位于北京，并在安徽设有智能机器、先进材料两大事业集群及生产基地。智能机器事业群位于安徽合肥新站智能制造产业园，目前产品主要为泛半导体产业机器人、工厂自动化和数字化制造解决方案的生产、销售与服务。先进材料事业群位于安徽阜阳合肥现代产业园，主要从事液晶单体、中间体、彩色光刻胶等平板显示用新型电子材料以及生物医药材料的研发、生产、销售与服务，。','生物/制药/化工/环保类'),(4,'ERP/EHR/OA工程师','面议','阜阳欣奕华材料科技有限公司','安徽省阜阳市','全职','2015-04-27','2 人','500-999人','本科','职责：\r\n1.负责ERP项目系统实施及日常维护。\r\n2.负责ERP系统改善及需求沟通解决。\r\n3. e-HR系统，提供系统支持，保证系统稳定运行；\r\n\r\n4．OA系统的维护；\r\n \r\n任职要求：\r\n1.本科以上学历，计算机、信息管理等相关专业。\r\n2.熟悉ERP系统原理及开发实施方法，有分销零售业务、财务方面的背景尤佳。\r\n3.具备企业ERP开发、实施、维护经验优先\r\n4.熟悉SQL Server或者Oracle数据库。\r\n5.具备较强的组织、沟通和协调能力。\r\n6.工作积极，负责，品行端正，能承受压力。\r\n','公司简介\r\n\r\n欣奕华科技有限公司，是由中国光电与创新科技产业基金与战略投资者共同创建的高科技公司。公司专注于智能机器和先进材料研发生产，旨在推进工业机器人、服务机器人、关键零部件产业发展，实现先进材料研发和产业化突破。公司愿景是成为一家智能机器和先进材料领域世界领先企业，为中国现代化和人类文明进步做贡献。\r\n公司运营与研发总部位于北京，并在安徽设有智能机器、先进材料两大事业集群及生产基地。智能机器事业群位于安徽合肥新站智能制造产业园，目前产品主要为泛半导体产业机器人、工厂自动化和数字化制造解决方案的生产、销售与服务。先进材料事业群位于安徽阜阳合肥现代产业园，主要从事液晶单体、中间体、彩色光刻胶等平板显示用新型电子材料以及生物医药材料的研发、生产、销售与服务，。','计算机/网络/技术类'),(5,'人力资源专员','面议','阜阳欣奕华材料科技有限公司','安徽省合肥市','全职','2015-04-27','2 人','500-999人','本科','岗位描述：\r\n1.负责公司岗位需求的日常招聘。\r\n2.薪资福利\r\n3.员工关系的日常维护。\r\n要求：\r\n1.本科以上学历\r\n2.人力资源相关专业','公司简介\r\n\r\n欣奕华科技有限公司，是由中国光电与创新科技产业基金与战略投资者共同创建的高科技公司。公司专注于智能机器和先进材料研发生产，旨在推进工业机器人、服务机器人、关键零部件产业发展，实现先进材料研发和产业化突破。公司愿景是成为一家智能机器和先进材料领域世界领先企业，为中国现代化和人类文明进步做贡献。\r\n公司运营与研发总部位于北京，并在安徽设有智能机器、先进材料两大事业集群及生产基地。智能机器事业群位于安徽合肥新站智能制造产业园，目前产品主要为泛半导体产业机器人、工厂自动化和数字化制造解决方案的生产、销售与服务。先进材料事业群位于安徽阜阳合肥现代产业园，主要从事液晶单体、中间体、彩色光刻胶等平板显示用新型电子材料以及生物医药材料的研发、生产、销售与服务，。','人力资源类'),(6,'高端销售管培生(应届生优先-8)','底薪4200元','麦田房产','北京市朝阳区','全职','2015-05-05 ','20 人','1000人以上','大专','就要毕业了，应届毕业生是欣喜、兴奋；还是苦恼、迷茫呢？\r\n你会因为未来的不确定而举步维艰吗？\r\n你会因为家人的不理解而放弃梦想吗？\r\n你会因为自己的困惑而举棋不定吗？\r\n还是会坚定着走自己的路……\r\n在这个时候，麦田房产校园招聘启动啦！\r\n \r\n在这里：不用因为没有经验而不敢尝试房产销售行业！\r\n麦田房产邀约您以培训生的角色进入销售行业，由麦田学院将你培养成为优秀的房产经纪专家！\r\n \r\n如何被培养？\r\n1、岗前培训：麦田讲师团队为您讲解房产经纪理论知识。\r\n2、超级培训：麦田新人三个月内接受不间断的公开课和区域培训。\r\n3、实战演练：麦田销售精英带你接触业务实战。\r\n4、经验分享：麦田老麦与你共同分享经验，让你借鉴别人的成功秘诀。\r\n5、工作氛围：麦田房产将是您校园生活的延续，因为这里拥有一群爱学习、爱团结、爱激情、爱梦想的伙伴！\r\n \r\n如何被重用？\r\n1、无空降兵：麦田为你提供一个公开、公平、透明，没有天花板的竞争平台。\r\n2、快速晋升：麦田为你提供明确的晋升标准与晋升体系。\r\n3、领导支持：麦田上级的全力以赴的付出与帮助为你排除一切工作障碍。\r\n4、价值体现：麦田业绩不是唯一标准，价值全面体现才是麦田精英。\r\n \r\n麦苗，我们将帮助你成长！相信有了你的加入，麦田会更精彩！\r\n \r\n职位描述：\r\n1、优越的薪酬\r\n无责任高底薪4200元+高额提成（通提）+带薪培训+全套保险（社保+商保） = 全公司近8000名置业专家平均月薪7000元以上。\r\n2、快速的成长\r\n应届毕业生--销售培训生--（半年）--精英销售顾问--（1年）--门店销售经理--（2-3年）--区域销售经理--（5年）--分公司销售总监--（8年）分公司销售总经理……\r\n3、具有吸引力的工作环境\r\n麦田从事平均价格为400万以上的高端房产服务（公寓、别墅、写字楼），服务的客户群体为各行各业的成功人士。与成功人士相伴，赢在成功起跑线。\r\n4、雄厚的平台支持\r\n全国500多家直营连锁门店，近8000多名置业专家；\r\n未来五年北京即将发展为1000家门店，近10000名置业专家。\r\n5、强大的教育体系\r\n业界内被享誉的“黄埔军校”和“麦田学院”；麦田没有空降兵，所有中、高层领导干部均由基层培养。\r\n6、自由选择工作地点\r\n店面遍布北京（东起四惠，北到上地，西至西山，南达亦庄，60个区域），任您选择。麦田零距离与你接触。\r\n\r\n岗位职责：\r\n1、负责客户的接待、咨询；\r\n2、识别客户需求，提供合适产品，进行价格谈判；\r\n3、负责公寓、别墅、写字楼的买卖与租赁的全过程，包括带看、收意向、签约及过户等，促成业务成交；\r\n4、负责业务跟进、客户信息登记及客户关系维护等后续工作；\r\n5、负责公司产品的开发积累，与客户建立良好的业务协作关系。\r\n \r\n任职资格：\r\n1、大专以上学历（军人退伍条件可以适当放宽），年龄21岁-28岁之间，男女不限,专业不限，应届毕业生优先；\r\n2、沟通能力强，普通话标准；有亲和力，工作积极主动，乐观开朗；\r\n3、具备良好的沟通表达能力和学习能力；\r\n4、敏锐的洞察力，较强的抗压和抗挫能力；勇于接受房产行业的压力和挑战；\r\n5、做事认真踏实，为人正直诚恳；高度的工作意识，具有良好的团队精神；\r\n6、注明：没有房产从业背景者优先。\r\n7、麦田房产遍布CBD、金融街、中关村、燕莎、马甸、公主坟、朝外、亚运村、上地、望京、东直门、石景山、西直门、亦庄、建国门、三元桥、王府井、酒仙桥、西单、知春路、国展中心、德胜门、和平里、世贸天阶、五棵松、紫竹桥、静安庄、北太平庄、朝阳门、芍药居、三里屯、学院路、崇文门、团结湖、阜成门、四惠、安定门、西坝河、复兴门等地铁沿线。\r\n\r\n \r\n特殊说明：因公司拓展，望有志之士加入。此信息只针对应聘者，谢绝其它来电、来访；应聘者参加面试时请自带纸质简历一份，注明应聘职位；我们会根据应聘者住址优先就近分配，第一时间告知面试结果；本招聘信息解释权归麦田房产集团总部。\r\n \r\n公司名称：北京麦田房产经纪有限公司\r\n公司地址：北京市朝阳区朝阳北路237号楼复星国际中心23层，乘地铁10号或6号线呼家楼站下，6号线E口出；乘公交车至关东店北街东口，西行50米即到。\r\n联系人： 周经理\r\n联系电话：010- 56800577\r\n公司主页：www.maitian.cn\r\n邮箱：mthr2_bj@maitian.cn  \r\n\r\n','公司简介\r\n\r\n   麦田房产集团成立于2000年10月19日，05年进驻北京，目前已发展为横跨南北，辐射北京、福州、厦门三地，致力于房产经纪代理、居间、担保、售后服务等领域的全国集团型企业。目前拥有近500多家直营门店，员工人数超过8000多名，集团总部中心位于北京市CBD商务核心位置5A级写字楼复星国际中心大厦。  \r\n\r\n   麦田房产集团成立14周年，北京麦田成立9周年，目前已经成长为中国本土最具影响力和发展潜力的经纪房产服务商之一；全国直营连锁，定位中高端市场，平均成交价格500万，发展速度和人均收入始终蝉联同行业第一名，业绩遥遥领先。凭借13年间对房地产经纪业中合同、法律、信贷、金融、以及市场运作的深入研究与探索，结合国外科学管理模式和国内现状，坚守“不炒楼，不赚差价，透明交易”的原则，同时独创出麦田自身的商业模式和企业文化，为整个房地产经纪业的健康发展做出积极贡献。未来，我们将以每年超过50％的发展速度稳健前进，陆续进驻中国各大中城市，逐步形成覆盖中国的战略布局。麦田房产集团每年目标成交总额在500亿左右，长期为国民经济做出重要贡献。\r\n\r\n   真诚、善良、感恩的麦田人，凭借专业能力和优质服务、独一无二的业内企业文化，以同享丰收为企业目标，始终保持稳健前进的步伐，进而不断获得业界和客户的认可，频频亮相媒体独家专访，专题报道多次见诸网络和报端。麦田人希望通过自身的自律和不懈地努力，用我们的行为引导行业，规范行业，完善行业，进而影响行业乃至全中国！ \r\n\r\n1、薪酬待遇：较高的无责底薪，独特的提成方式，完善的福利补贴，保证麦田的新人和老人学到的同时更能赚到。\r\n2、晋升空间：明确的晋升时间，科学的晋升制度，完善的晋升体系，致力于打造一个公开，公平，透明的晋升平台。\r\n3、培训体系：坚信一流的公司，一流的培训。“全方位、立体式、多层次、多角度、专业化”培训、不外聘管理层的我们被业内称为“黄埔军校”和“麦田学院”，始终做到培训是员工最大的福利。\r\n4、保险补贴：健全的社保体系，提供养老保险、医疗保险、工伤保险和失业保险，为员工的全力付出保驾护航。“麦基金”的出现，更是为员工解决后顾之忧。\r\n5、奖励体系：月度、季度、年度评选优秀员工，现金大奖与认可的同时，还可以与总裁亲密接触。\r\n6、工作氛围：和谐、互助、团结、共赢的工作理念，融洽的工作氛围，为大家创造一个良好的工作环境。\r\n7、企业文化：麦田“五行”：感恩、正向、专注、精进、利他。善的文化，家的方向，麦田人的行为标准正是对企业文化的最好诠释。\r\n8、生活娱乐：多姿多彩的文娱生活，节日中特殊神秘的礼金礼品，优秀员工的全球旅游，让大家感到家一样的温暖。\r\n\r\n\r\n   这是一个前途无量的行业，值得我们全力以赴；这是一个有理想的企业，值得有梦想的人去追求；这更是一个光荣的职业，每位从业人员都应引以为荣！——中国麦田董事长缪寿建\r\n','销售类'),(7,'北京必胜客餐厅储备经理','4000元/月起','北京肯德基有限公司','北京市东城区','全职','2015-05-04 ','若干 人','1000人以上','大专','工作地点：北京市必胜客各门店餐厅\r\n \r\n您将从事：\r\n- 餐厅现场人员管理，订货排班，成本控制，设备维护等营运系统管理工作\r\n \r\n您将得到：\r\n(1) 进入与您职业发展匹配的“领军人物养成计划”，开启自己作为管理者的职业生涯。“领军人物养成计划”提供的学习课程媲美商学院且为职场新人量身定制，选拔超豪华的千人讲师团队悉心授教。\r\n(2) 最初在储备经理这个岗位上的8-12个月，将学会全方位餐厅经营与领导力的基础课程，完成从一个职场新人向餐厅副经理发展的重要过程。\r\n(3) 沿着我们清晰的职业发展路径，继而晋升为副经理、资深副经理。\r\n(4) 3– 4年就能成为餐厅经理，独当一面，带领餐厅，成为百胜最重要的领导者。\r\n\r\n具备以下条件，即可申请：\r\n- 拥有大专以上学历\r\n- 热情开朗，善于与人沟通\r\n- 适应倒班和高效的工作环境\r\n- 乐于从事连锁餐饮零售业\r\n薪资福利：\r\n- 薪资约为：4000元/月起\r\n- 依照国家规定购买五险一金及提供带薪年假（10天），每周2天休息，享有商业医疗保险。\r\n\r\n可任选以下一种应聘方式：\r\n1、在线投递简历\r\n2.参加每周现场面试会：每周二、周五下午13:30-16:00\r\n面试地点：北京市东城区东四十条富华大厦A座7层（地铁2号线东四十条站C出口向南200米，二环路东）\r\n\r\n3.将个人简历投递到yang.ning@yum.com（邮件标题处请注明应聘职位：储备经理）\r\n\r\n4.如需了解更多详情，欢迎登录百胜官网查询：http://www.yumcareers.cn/\r\n  面试携带资料：个人简历，身份证原件和复印件，毕业证（学生证）原件和复印件，黑色签字笔。\r\n ','公司简介\r\n\r\n百胜餐饮集团中国事业部隶属于美国纽约证券交易所挂牌上市的百胜餐饮集团(Yum! Brands，Inc.)。百胜餐饮集团是全球餐厅网络最大的餐饮集团之一，在全球超过125个国家和地区拥有超过39000家连锁餐厅, 员工人数150多万。2012年，百胜餐饮集团的收入超过130亿美元。百胜餐饮集团旗下肯德基、必胜客和塔可钟三个餐饮品牌分别在烹鸡、比萨、墨西哥风味食品连锁餐饮领域居全球领导地位。\r\n\r\n百胜餐饮集团中国总部于1993年在上海成立。它为中国大陆直营、合资和特许经营的肯德基、必胜客、必胜宅急送、东方既白、小肥羊餐厅提供营运、开发、企划、财务、人力资源、法律及公共事务等方面的服务。\r\n\r\n截至2012年12月底，百胜集团在中国大陆800多个城市和乡镇成功开出超过4200家肯德基餐厅，在中国200个城市开出800多家必胜客餐厅，此外，百胜还拥有150余家必胜宅急送、近30家东方既白和近450家小肥羊餐厅，员工人数超过46万。2012年中国百胜创纪录地开出889家新店，营业额达到522亿元人民币，是百胜在全球业务发展最快、增长最迅速的市场。\r\n\r\n自从1987年进入中国市场以来，百胜集团在自身发展同时，不忘其企业社会责任，一直秉承“回报社会”的宗旨，积极支持慈善事业，让关爱社会成为企业的核心价值观之一。20多年来，百胜直接和间接用于公益方面的捐款已超过 1.7亿元人民币。','经营管理类'),(8,'初中数学老师','面议','杭州乐普教育信息咨询有限公司','浙江省杭州市','全职','2015-05-05','5 人','100-499人','本科','主要工作：负责学员答疑辅导、授课及教研工作\r\n任职要求： \r\n1、 本科及本科以上学历，数学相关专业毕业；非数学专业者需理工类相关专业且数学成绩优异； \r\n2、对数学有独到见解和知识传授能力，而且授课条理清晰，目标明确；  \r\n3、普通话标准，表达能力超强，有较强的亲和力，性格开朗，有良好的团队协作能力和沟通能力。\r\n\r\n应聘办法\r\n1．  请将简历发送至 lepuyang@sina.cn 2.咨询电话：0571-87359956\r\n各校区地址：\r\n朝晖校区 下城区朝晖路163号0571-81021983  古墩校区西湖区古墩路558号 0571-87359957\r\n文一校区西湖区文一路212号 0571-87359958  拱宸校区：拱墅区金华路88号0571-88919706\r\n濮家校区：江干区天运路49号   0571-86904571  江南校区：滨江区春晓路422号  0571-85021165\r\n彩虹城校区：滨江区东信大道1038号 0571-87712140江城校区：上城区江城路286号  0571-87066349','公司简介\r\n\r\n杭州乐普教育信息咨询有限公司，是杭城一家专注初中理科辅导的教育培训机构。成立于2008年，总部位于杭州市西湖区文一西路98号数娱大厦711号，环境幽雅、交通便利。一直以来，乐普教育凭借创新教育理念、全方位育人目标、独创“理科辅导学习流程图”、成熟教师培训体系、独特“两黑板”课堂教学模式五大优势，在探索中寻求发展，在发展中不断创新，在培训市场竞争激烈的今天，我们的规模迅速壮大，在短短5年时间内，现已发展成为八个教学点，在杭州地区赢得了良好的口碑。 \r\n“乐普教育”本着“思与做，缓说破”，“无为而为，借力打力”的方法论作为指导，将育人目标和教育理论融入到教学过程的每个细节之中，以其严格的管理和人才培训机制，新颖的课堂教学模式和独创的“乐普教学法”，帮助许多家庭解决了孩子学习方法和学习习惯中存在的问题。“乐普教育”这块沃土不仅培养了孩子，同时也为更多胸怀大志的年轻人提供了实现抱负的舞台。 \r\n在人才培养方面，“乐普教育”一直本着“以人为本”的理念，把员工培训和成长作为公司发展的核心竞争力，现已有部分教师从原本教师的岗位中脱颖而出，成为优秀的中层管理人员，“乐普教育”期待更多有理想的年轻人的加入。','教育/培训类'),(9,'结构分析工程师','面议','北京思易特科技有限责任公司','北京市海淀区','全职','2015-05-05  ','若干 人','1-49人','硕士','任职要求：\r\n1、力学、机械工程、车辆工程、飞行器设计、理工科相关专业，硕士及以上学历；\r\n2、熟悉有限元技术，力学基础扎实，思路清晰，口头、书面表达能力强；\r\n3、较强的沟通、协调和人际交往能力，一定的演讲能力； \r\n4、具有应用CAE软件完成工程项目的经验；\r\n5、熟练掌握HyperMesh,ABAQUS,Ansys、Nastran等软件的一种；\r\n6、大学英语六级或相当水平，良好的英语口语、阅读能力，熟练使用办公软件；','公司简介\r\n\r\n北京思易特科技有限责任公司致力于推进中国信息化、数字化技术的发展，赋予企业更高的价值，提升中国工业设计技术水平；同时致力于提供有特色的、成熟的行业仿真优化设计解决方案。作为把先进的设计优化和协同技术引入中国的先驱，思易特人自2002年开始在中国推动Isight产品的先进理念和成熟的工程应用。\r\n\r\n\r\n       经过思易特人近10年的努力播种耕耘，Isight以其集设计自动化、过程集成化和设计最佳化于一体的产品优势，已经在各个工业制造领域获得广泛卓有成效的应用。通过Isight的应用使我们的客户能够身体力行现代工业设计的三大方法：系统设计、参数设计和稳健设计。结合我们的产品优势，思易特的工程技术团队更在帮助客户提升技术和产品的应用水平，为客户实现可观的投资回报。\r\n\r\n\r\n       Isight解决方案为客户提供了“系统整合，流程统一，参数优化，协同设计” 的一揽子方案。该方案在航空、航天、兵器、船舶、汽车、动力等各个行业得以成功实施和应用。伴随着中国的多学科优化和协同集成优化市场的起步和跃进，Isight产品已经在国内占有市场的绝对主导地位。','其他类'),(10,'通用电气信息技术领导力培训生暑期实习项目','面议','通用电气（中国）有限公司','上海市浦东新区','实习','2015-05-06','60人','1000人以上','本科',' An eight to ten-week long challenging assignment in IT domain','通用电气（GE) 公司是一家全球领先的科技、服务和金融公司，是全球最大的多元化企业，致力于解决世界上最棘手的问题。GE的产品和服务范围广阔，从能源、石油天然气、水处理、航空、医疗、运输系统、家电、照明，到金融，客户遍及全球100多个国家，拥有30多万员工。杰夫 伊梅尔特先生是现任董事长及首席执行官。','计算机/网络/技术类'),(11,'通用电气爱迪生工程技术培训项目(EEDP)','面议','通用电气（中国）有限公司','北京市市辖区','实习','2015-04-27 ','133 人','1000人以上','本科','学校','通用电气（GE) 公司是一家全球领先的科技、服务和金融公司，是全球最大的多元化企业，致力于解决世界上最棘手的问题。GE的产品和服务范围广阔，从能源、石油天然气、水处理、航空、医疗、运输系统、家电、照明，到金融，客户遍及全球100多个国家，拥有30多万员工。杰夫 伊梅尔特先生是现任董事长及首席执行官。','科研类'),(12,'供应链管理培训生（EID实习生）','面议','通用电气（中国）有限公司','北京市市辖区','实习','2015-04-27','70人','1000人以上','本科','The OMLP EID Program is designed to identify high-potential engineering students early in their academic career as possible candidates for OMLP entry programs. The EID Program offers students the opportunity to experience a real-life work environment at GE, while developing the professionalism critical to a successful career.','通用电气（GE) 公司是一家全球领先的科技、服务和金融公司，是全球最大的多元化企业，致力于解决世界上最棘手的问题。GE的产品和服务范围广阔，从能源、石油天然气、水处理、航空、医疗、运输系统、家电、照明，到金融，客户遍及全球100多个国家，拥有30多万员工。杰夫 伊梅尔特先生是现任董事长及首席执行官。','贸易/物流/采购/运输类'),(13,'营销岗','','上海中建东孚投资发展有限公司','上海市市辖区','全职','2015-05-06','10人','500-999人','本科','一、专业要求：经济学、广告学、新闻学、市场营销等专业','上海中建东孚投资发展有限公司（以下简称“公司”）成立于2008年，是中建八局旗下专业负责房地产投资开发和物业服务的全资子公司。目前拥有房地产开发壹级资质、物业服务企业壹级资质，集成“居住地产、商业地产、保障性住房和城市综合开发”等四大业务线。','销售类'),(14,'美国公立学校中文教师','20万人民币年薪起步','成都金色印象科技有限公司','全国','全职','2015-05-06','50 人','1-49人','本科','项目概述','','教育/培训类'),(16,'泰国公立学校中文教师岗位','20万人民币年薪起步','成都金色印象科技有限公司','全国','全职','2015-05-05 ','50 人','1-49人','本科','1、每月工资为15000—18000泰铢；并逐年提高薪水。（另外所需求的学校工作将非常轻松，每天工作时间大概是8：00-16：00左右。周末双休以及节假日可在外兼职，在外兼职每月收入可达8000-10，000泰铢左右，）','','教育/培训类'),(17,'中文、汉语教师海外岗位招聘','20万人民币年薪起步','成都金色印象科技有限公司','全国','全职','2015-04-30','100 人','1-49人','本科','（二）韩国中文培训学校、国际幼儿园招聘国际汉语教师','','教育/培训类'),(18,'五险一金诚招置业顾问','','济南汇众房地产经纪有限公司','全国','全职','2015-05-06','4人','1000人以上','本科','任职要求：','','销售类'),(19,'学术助理','','中加新世纪（北京）科技开发有限公司','北京市北京市丰台区丰台区','全职','2015-05-06','2 人','1-49人','本科','岗位职责:','中加新世纪（北京）科技开发有限公司，作为世界新经济研究院旗下的科技公司，将致力于企业信息化管理软件产品的研发和销售。该公司依托世界新经济研究院关于知识资本量化研究的最新成果，同现代化的企业管理相结合，开发一系列面向市场的管理软件，满足在科技日益发达的条件下，企业在信息化管理进程中，提高企业综合管理水平，实现企业发展方式的转型与升级，提供咨询和帮助。 ','其他类'),(20,'技术服务工程师','','北京源仪迅驰科技有限公司','北京市海淀区','全职','2015-05-06 ','6人','1-49人','本科','岗位职责：','公司简介','电子/电器/通信技术类'),(21,'环保工程师','','青岛新太平洋节能环保集团有限公司','山东省青岛市','全职','2015-05-06','5人','1000人以上','本科','职位描述：','','生物/制药/化工/环保类'),(22,'销售（业务）经理','','青岛新太平洋节能环保集团有限公司','山东省青岛市','全职','2015-05-06','5人','1000人以上','不限','职位描述：\r\n1、负责污水处理项目的市场开拓；\r\n2、维护客户关系，树立公司在行业区域内良好的企业形象；\r\n任职要求：\r\n1、具有较强职业素养，工作踏实能吃苦\r\n2、男女不限，接受应届毕业生；\r\n3、有污水处理及相关经验者优先。','','生物/制药/化工/环保类'),(23,'软件工程师','','上海锐承通讯技术有限公司','上海浦东新区张江集电港','全职','2015-05-06','10 人','100-499人','本科','岗位职责：','锐承通讯技术有限公司( Reacheng Communication Technology Co.,Ltd )，位于上海浦东张江高科技园区，是一家专注于第三代移动通讯终端方案设计、开发的高科技企业。\r\n公司产品专注于WCDMA/GSM、CDMA、LTE、WiFi、GPS等无线制式的手机/平板电脑的主板及整机研发，拥有无线通讯行业第一流的技术人才和管理团队，技术骨干拥有平均超过10年的通信行业经验，具备工业设计（ID）、结构设计（MD）、硬件设计（HW）、软件设计（SW）、生产制造（Manufacturing）等无线产品研发及生产能力，并建立了完善的质量管理体系（QA），确保产品研发及生产质量；同时配备有高素质的客户支持队伍，能够高效地对客户端工厂进行技术支持，为客户提供最优秀的、具有竞争力的无线通讯方案、产品和专业的服务。','电子/电器/通信技术类'),(24,'机械-专利代理人','','西安三高永信知识产权代理有限责任公司','陕西省西安市','全职','2015-05-06','2 人','1-49人','本科','职位名称：专利代理人或专利代理人助理\r\n \r\n专业类别：机械\r\n任职条件：\r\n   1.教育背景：本科及以上学历，上述专业类别及其它专利技术相关专业，或法律专业。 \r\n   2.工作经验：不限，有无经验均可。具备专利代理人资格优先。 \r\n   3.知识/技能：（1）熟悉专利代理的业务知识和相关领域的基础技术知识和法律知识； \r\n                （2）熟悉专业代理工作流程； \r\n                （3）熟练掌握Word、Excel、PowerPoint等办公软件。 \r\n   4.素质要求：为人诚实，踏实好学，有责任心，有良好的沟通能力和团队精神，性格乐观开\r\n     朗，思维逻辑性、条理性强，具有比较好的悟性、很强的学习能力以及较好的语言表达能\r\n     力。有志于从事知识产权行业。\r\n             　\r\n薪资待遇：基本工资+提成，可面议',' 西安三高永信知识产权代理有限责任公司，于1991年成立，是国内最早从事专利代理的代理机构之一，也是经国家知识产权局批准设立的涉外知识产权代理机构。其专业涵盖了通讯、电子、机械、计算机、生物、化工、药品等各领域。','电子/电器/通信技术类'),(25,'结构分析工程师','','北京思易特科技有限责任公司','北京市海淀区','全职','2015-05-06','若干 人','1-49人','硕士','任职要求：','北京思易特科技有限责任公司致力于推进中国信息化、数字化技术的发展，赋予企业更高的价值，提升中国工业设计技术水平；同时致力于提供有特色的、成熟的行业仿真优化设计解决方案。作为把先进的设计优化和协同技术引入中国的先驱，思易特人自2002年开始在中国推动Isight产品的先进理念和成熟的工程应用。','其他类'),(26,'流体分析应用工程师','','北京思易特科技有限责任公司','北京市海淀区','全职','2015-05-06','1人','1-49人','本科','工作职责：\r\n1.          实际工程问题仿真模型的建立，仿真结果的可靠性分析，撰写用户计算报告；\r\n\r\n2.          软件产品的客户培训与技术支持，以及客户的工程项目分析；\r\n3.          建立公司仿真产品的案例库等。\r\n4.          仿真项目的售前与售后支持。\r\n任职要求：\r\n1．.具有工程硕士以上学历（或本科学历具有2年以上相关工作经验），掌握流体力学方面知识，具有良好的力学和数值分析基础，熟练使用CAD（如UG，Pro-E，Catia等）、通用CFD软件（如CFX，Fluent，STAR-CD）的经验。\r\n2．.最好具有直接工程应用经验，如汽车、航空航天、新能源、核电等领域。\r\n\r\n3．.具有较强的组织、沟通能力和团队协作能力,善于学习，适应短期出差。','北京思易特科技有限责任公司致力于推进中国信息化、数字化技术的发展，赋予企业更高的价值，提升中国工业设计技术水平；同时致力于提供有特色的、成熟的行业仿真优化设计解决方案。作为把先进的设计优化和协同技术引入中国的先驱，思易特人自2002年开始在中国推动Isight产品的先进理念和成熟的工程应用。','计算机/网络/技术类'),(27,'ABAQUS技术支持工程师','','北京思易特科技有限责任公司','北京市海淀区','全职','2015-05-06','3人','1-49人','硕士','职位描述：','北京思易特科技有限责任公司致力于推进中国信息化、数字化技术的发展，赋予企业更高的价值，提升中国工业设计技术水平；同时致力于提供有特色的、成熟的行业仿真优化设计解决方案。作为把先进的设计优化和协同技术引入中国的先驱，思易特人自2002年开始在中国推动Isight产品的先进理念和成熟的工程应用。','电气/能源/动力类'),(28,'网络与信息安全技术研发工程师','','北京利云技术开发公司','北京市朝阳区','全职','2015-05-06','3人','50-99人','本科','岗位职责：\r\n\r\n1、网络与信息安全技术产品测试；\r\n2、现有产品优化；\r\n3、新产品的设计和研发。\r\n\r\n任职要求：\r\n\r\n1、计算机相关专业本科及以上学历；\r\n2、熟练掌握 C/C++编程、Linux编程，具备算法基础；\r\n3、熟悉嵌入式开发、Android、 IOS开发或具备网络与信息安全产品研发经验者优先；\r\n4、对网络与信息安全技术有浓厚兴趣，具有开拓创新精神；\r\n5、提供住宿和优越的办公条件，为能力突出者提供优厚待遇。\r\n','公司简介\r\n\r\n   北京利云技术开发公司为国家高新技术企业，所属业务涉及光学、电子、通信、印刷、机械和信息材料等多种门类学科。\r\n   公司拥有一支优秀的研发团队,博士、硕士或拥有高级技术职称的科研人员占员工总数的60%以上。公司长期承担着国家、部级重大专项和科研课题，具有很强的研发能力。公司研制的产品主要有无线视频传输系统、夜视设备、专用无线应急通信系统等，进行光学、无线电、机械结构、光盘及电子产品的测试。同时，公司面向公众提供数字多媒体个性化服务。\r\n \r\n   利云公司为员工提供宽松的成长环境,良好的薪酬福利体系,欢迎您加入利云公司。','计算机/网络/技术类'),(29,'网络与信息安全技术实习生','','北京利云技术开发公司','北京市朝阳区','全职','2015-05-06','3人','50-99人','硕士','岗位职责：\r\n\r\n1、进行网络与信息安全技术研究、产品测试、产品研发。\r\n\r\n\r\n\r\n任职要求：\r\n\r\n1、信息安全、计算机相关专业在读研究生；\r\n2、熟悉信息安全技术、计算机网络基础等；\r\n3、具备良好的沟通能力和文档撰写能力，责任心强；\r\n4、至少实习半年以上；\r\n5、有一定的文字功底；\r\n6、待遇面议，提供住宿。','公司简介\r\n\r\n   北京利云技术开发公司为国家高新技术企业，所属业务涉及光学、电子、通信、印刷、机械和信息材料等多种门类学科。\r\n   公司拥有一支优秀的研发团队,博士、硕士或拥有高级技术职称的科研人员占员工总数的60%以上。公司长期承担着国家、部级重大专项和科研课题，具有很强的研发能力。公司研制的产品主要有无线视频传输系统、夜视设备、专用无线应急通信系统等，进行光学、无线电、机械结构、光盘及电子产品的测试。同时，公司面向公众提供数字多媒体个性化服务。\r\n \r\n   利云公司为员工提供宽松的成长环境,良好的薪酬福利体系,欢迎您加入利云公司。','计算机/网络/技术类'),(30,'装配焊接工程师','','北京利云技术开发公司','北京市朝阳区','全职','2015-05-06','2人','','中专','岗位职责：负责产品的焊接和组装工作。\r\n\r\n任职要求：\r\n\r\n1、电子或机械相关专业，中专以上学历；\r\n2、具备熟练的电子线路板焊接技术和电子产品组装经验；\r\n3、熟悉常用电子元器件，掌握焊接工艺，能进行表贴以及BGA芯片焊接，能检查电子线路常   见故障，动手能力强；\r\n4、乐观开朗、责任心强，善于沟通协作；\r\n5、对工作有稳定长期的预期；\r\n6、可提供集体宿舍。','公司简介\r\n\r\n   北京利云技术开发公司为国家高新技术企业，所属业务涉及光学、电子、通信、印刷、机械和信息材料等多种门类学科。\r\n   公司拥有一支优秀的研发团队,博士、硕士或拥有高级技术职称的科研人员占员工总数的60%以上。公司长期承担着国家、部级重大专项和科研课题，具有很强的研发能力。公司研制的产品主要有无线视频传输系统、夜视设备、专用无线应急通信系统等，进行光学、无线电、机械结构、光盘及电子产品的测试。同时，公司面向公众提供数字多媒体个性化服务。\r\n \r\n   利云公司为员工提供宽松的成长环境,良好的薪酬福利体系,欢迎您加入利云公司。','机械/仪器仪表类');

/*Table structure for table `profession_news` */

DROP TABLE IF EXISTS `profession_news`;

CREATE TABLE `profession_news` (
  `newsID` int(20) NOT NULL,
  `title` varchar(100) NOT NULL,
  `type` varchar(20) NOT NULL,
  `content` varchar(10000) NOT NULL,
  `publish_time` varchar(20) default NULL,
  PRIMARY KEY  (`newsID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `profession_news` */

insert  into `profession_news`(`newsID`,`title`,`type`,`content`,`publish_time`) values (0,'单位想找什么样的人','【求职方向】','建行来招聘时，讲到想招什么样的人，我觉得总结得很好：想做事，能做事，会做事，不出事','2015-03-05'),(1,'单位的烦恼','【求职方向】','今天有两家单位来找我们，说招聘结果不理想,和我们讨论怎样可以吸引到更多的学生来投简历','2015-03-05'),(2,'明确的求职方向','【求职方向】','搜索应聘岗位条件先紧后松,留意过时信息,注意岗位描述的附加条件','2015-03-05'),(3,'面试程序','【面试技巧】','第一阶段：准备阶段。准备阶段主要是以一般性的社交话题进行交谈','2015-03-05'),(4,'面试基本礼仪','【面试技巧】','一旦和用人单位约好面试时间后，一定要提前5-10分钟到达面试地点，以表示求职者的诚意，给对方以信任感','2015-03-05'),(5,'面试小妙招','【面试技巧】','把紧自己的嘴巴，三思而后答，留足进退的余地，随机而应变','2015-03-05'),(6,'教你一些面试技巧','【面试技巧】','要以一颗平常心正确对待面试，要做好承受挫折的心理准备。即使面试一时失利，也不要以一次失败论英雄','2015-03-05'),(7,'面试后应注意的问题','【面试技巧】','当主考官宣布面试结束后，求职者应礼貌道谢，及时退出考场，不要再补充几句，也不要再提什么问题','2015-03-05'),(8,'面试禁忌','【面试技巧】','以自己为中心，抢话争辩，反应木讷，好为人师，提低级的问题，目中无人','2105-03-05'),(9,'相关就业政策','【职业辅导】','高校毕业生就业创业工作是教育领域重要的民生工程，党中央、国务院高度重视，明确要求强化就业创业服务体系建设','2015-03-05'),(10,'就业案例','【职业辅导】','了解自己，选择就业。了解行业，选择行业，缩小范围，了解公司','2015-03-05'),(11,'大学生应该如何进行择业','【职业辅导】','大学生作为社会的重要人力资源，应该正确面对社会的选择，不仅需要有一个正确的择业心态，同时也应该进一步提高自身素质，了解社会需求，进行正确择业。','2015-03-05');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `usernameID` int(20) NOT NULL auto_increment,
  `username` varchar(20) NOT NULL,
  `studentnumber` int(20) NOT NULL,
  `grade` varchar(20) NOT NULL,
  `major` varchar(20) NOT NULL,
  `pwd` varchar(50) NOT NULL,
  PRIMARY KEY  (`usernameID`)
) ENGINE=InnoDB AUTO_INCREMENT=245 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`usernameID`,`username`,`studentnumber`,`grade`,`major`,`pwd`) values (238,'ssssss',12082124,'333333','大一','hhhh'),(239,'wwwwww',12882121,'会计','大一','666666'),(240,'wwwwww',12882121,'会计','大一','666666'),(241,'tt',12082525,'大二','信管','444444'),(242,'12082122',12082122,'大三','信管','123456'),(243,'12082122',12082122,'大三','信管','123456'),(244,'12082122',12082122,'大三','信管','123456');

/*Table structure for table `user_tb` */

DROP TABLE IF EXISTS `user_tb`;

CREATE TABLE `user_tb` (
  `name` varchar(50) default NULL,
  `nameID` int(11) NOT NULL,
  `sex` char(10) default NULL,
  `password` varchar(50) default NULL,
  `professtion` varchar(50) default NULL,
  `studentnumber` int(11) default NULL,
  `job_intend` varchar(50) default NULL,
  `birthday` datetime default NULL,
  PRIMARY KEY  (`nameID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user_tb` */

insert  into `user_tb`(`name`,`nameID`,`sex`,`password`,`professtion`,`studentnumber`,`job_intend`,`birthday`) values ('zhangdan',111,'boy','www','jisuanji',NULL,'jisuanji',NULL),('undjsun',112,'girl','mtl330820','信管',12082124,NULL,NULL);

/*Table structure for table `xuanjiang` */

DROP TABLE IF EXISTS `xuanjiang`;

CREATE TABLE `xuanjiang` (
  `TitleID` int(20) NOT NULL auto_increment,
  `title` varchar(50) NOT NULL,
  `time` varchar(20) NOT NULL,
  `place` varchar(50) NOT NULL,
  `pub_time` varchar(20) NOT NULL,
  `content` varchar(5000) default NULL,
  PRIMARY KEY  (`TitleID`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `xuanjiang` */

insert  into `xuanjiang`(`TitleID`,`title`,`time`,`place`,`pub_time`,`content`) values (1,'五月花国际英语','2015/5/9  10:00:00','就业报告厅','',NULL),(2,'东方地球物理公司面试','2015/5/10  8:00:00','就业中心123、125会议室','',NULL),(3,'北京碧海舟腐蚀防护工业股份有限公司','2015/5/14  10:00:00','南教106','',NULL),(4,'东方里程(青岛)塑胶技术有限公司','2015/5/14  10:00:00','南教118','',NULL),(5,'青岛华仁物业股份有限公司','2015/5/22  14:00:00','就业报告厅','',NULL),(6,'','','','',NULL),(7,'','','','',NULL),(8,'','','','',NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

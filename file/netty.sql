/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 50710
 Source Host           : 127.0.0.1
 Source Database       : netty

 Target Server Type    : MySQL
 Target Server Version : 50710
 File Encoding         : utf-8

 Date: 05/31/2016 21:01:24 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `bill`
-- ----------------------------
DROP TABLE IF EXISTS `bill`;
CREATE TABLE `bill` (
  `carNum` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `car`
-- ----------------------------
DROP TABLE IF EXISTS `car`;
CREATE TABLE `car` (
  `carNum` varchar(200) DEFAULT NULL,
  `location` varchar(500) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `time` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `car`
-- ----------------------------
BEGIN;
INSERT INTO `car` VALUES ('苏BA5N98', 'A区一排一列', '1', '1463723942520');
COMMIT;

-- ----------------------------
--  Table structure for `clientMsg`
-- ----------------------------
DROP TABLE IF EXISTS `clientMsg`;
CREATE TABLE `clientMsg` (
  `message` varchar(255) DEFAULT NULL,
  `addTime` bigint(20) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `clientMsg`
-- ----------------------------
BEGIN;
INSERT INTO `clientMsg` VALUES ('1', null, '1'), ('12', null, '1'), ('1', null, '10'), ('1', null, '10'), ('1', null, '10'), ('1-1', '1462989568249', '1'), ('jyy-123456', '1463013047409', 'login'), ('yzt-123456', '1463013047511', null), ('1-1', '1463015876943', 'login'), ('2-2', '1463017379884', 'login'), ('10-10', '1463017443082', 'login'), ('10-11', '1463017506735', 'login'), ('1-1', '1463017614918', 'login'), ('1-1', '1463017660490', 'login'), ('1-15', '1463017751050', 'login'), ('1-1', '1463017819381', 'login'), ('1-1', '1463017858199', 'login'), ('1-1', '1463017860508', 'login'), ('1-11', '1463017912070', 'login'), ('1-10-', '1463017974157', 'login'), ('1-1', '1463018032276', 'login'), ('1-20', '1463018047199', 'login'), ('test-20', '1463018125566', 'login'), ('test-20', '1463018247731', 'login'), ('1-1', '1463018522285', 'login'), ('1-20', '1463018533090', 'login'), ('1-1', '1463018592800', 'login'), ('1-123456', '1463018607742', 'login'), ('1-20', '1463018615810', 'login'), ('12-23', '1463018764624', 'login'), ('1-10', '1463018869583', 'login'), ('1-20', '1463018876003', 'login'), ('1-1', '1463019050706', 'login'), ('1-20', '1463361804575', 'login'), ('1-20', '1463361825665', 'login'), ('1-20', '1463362864660', 'login'), ('1-20', '1463363229980', 'login'), ('1-20', '1463363520778', 'login'), ('1-20', '1463364099015', 'login'), ('1-20', '1463364173438', 'login'), ('1-20', '1463364473103', 'login'), ('1-20', '1463364567293', 'login'), ('1-1', '1463364577793', 'cancelOrder'), ('1-20', '1463364891542', 'login'), ('1-1', '1463364900772', 'cancelOrder'), ('1-20', '1463365039934', 'login'), ('1-1', '1463365049421', 'cancelOrder'), ('1-20', '1463365096522', 'login'), ('1-1', '1463365106514', 'cancelOrder'), ('1-1', '1463365190079', 'cancelOrder'), ('1-1', '1463365202716', 'cancelOrder'), ('1-20', '1463365486350', 'login'), ('1-20', '1463366375143', 'login'), ('1', '1463366386324', 'jf'), ('1111', '1463366429212', 'jf'), ('1111', '1463366462375', 'jf'), ('1111', '1463366476777', 'jf'), ('1-20', '1463367141240', 'login'), ('1-20', '1463367151386', 'login'), ('1-20', '1463367193935', 'login'), ('1', '1463367203294', 'jf'), ('1', '1463367218871', 'jf'), ('1', '1463367231494', 'jf'), ('1', '1463367262922', 'jf'), ('1-20', '1463367303653', 'login'), ('1-20', '1463367305980', 'login'), ('1', '1463367314393', 'jf'), ('1-20', '1463367437281', 'login'), ('1-20', '1463367453337', 'login'), ('1-20', '1463367534514', 'login'), ('1-20', '1463368304168', 'login'), ('1-1-1-1463368311140', '1463368311140', 'zf'), ('1-1-1-1463368328022', '1463368328022', 'zf'), ('1-20', '1463369340014', 'login'), ('1', '1463369345911', 'yhcl'), ('1', '1463369358904', 'yhcl'), ('1', '1463369446297', 'yhcl'), ('1-20', '1463369467047', 'login'), ('1-20', '1463369505386', 'login'), ('1', '1463369512079', 'yhcl'), ('1', '1463369604817', 'yhcl'), ('1-20', '1463369688335', 'login'), ('1-20', '1463369699067', 'login'), ('1-20', '1463369727246', 'login'), ('1', '1463369733776', 'yhcl'), ('1', '1463369747673', 'yhcl'), ('-', '1463369819904', 'cancelOrder'), ('1-2', '1463369835866', 'cancelOrder'), ('1-20', '1463713462549', 'login'), ('1-1-1-1463713483595', '1463713483595', 'zf'), ('1', '1463713499857', 'jf'), ('1-20', '1463721387343', 'login'), ('1-20', '1463721401323', 'login'), ('1-20', '1463721433423', 'login'), ('?BA5N98', '1463721451517', 'selectLocation'), ('1-20', '1463721565927', 'login'), ('?BA5N98', '1463721578242', 'selectLocation'), ('1-20', '1463721745818', 'login'), ('?BA5N98', '1463721762231', 'selectLocation'), ('1-20', '1463721905689', 'login'), ('BA5N98', '1463721916761', 'selectLocation'), ('1-20', '1463722123818', 'login'), ('?BA5N98', '1463722151528', 'selectLocation'), ('1-20', '1463722276200', 'login'), ('苏BA5N98', '1463722283731', 'selectLocation'), ('1-20', '1463722475631', 'login'), ('?BA5N98', '1463722498560', 'selectLocation'), ('1-20', '1463722911245', 'login'), ('?BA5N98', '1463722926780', 'selectLocation'), ('1-20', '1463723098083', 'login'), ('?BA5N98', '1463723106879', 'selectLocation'), ('1-20', '1463723463497', 'login'), ('?BA5N98', '1463723494448', 'selectLocation'), ('1-20', '1463723602003', 'login'), ('苏BA5N98', '1463723607722', 'selectLocation'), ('1-20', '1463723924632', 'login'), ('苏BA5N98', '1463723942520', 'selectLocation'), ('1-20', '1463724104801', 'login'), ('苏5N98BA', '1463724133599', 'selectLocation'), ('苏5N98BA', '1463724178556', 'selectLocation'), ('1-20', '1463724229749', 'login'), ('苏5N98BA', '1463724241773', 'selectLocation'), ('苏BA5N98', '1463724260326', 'selectLocation'), ('1-20', '1463724334669', 'login'), ('苏BA5N98', '1463724340542', 'selectLocation'), ('1-20', '1463724438482', 'login'), ('苏BA5N98', '1463724457490', 'selectLocation'), ('1-20', '1463724561979', 'login'), ('苏BA5N98', '1463724578681', 'selectLocation'), ('1-20', '1463725703808', 'login'), ('1-20', '1463725778841', 'login'), ('1-20', '1463725869505', 'login'), ('1-20', '1463725954049', 'login'), ('1-20', '1463726021942', 'login'), ('1-20', '1463726870482', 'login'), ('苏BA5N98-1-1', '1463726877416', 'cancelOrder'), ('苏BA5N98', '1463726907733', 'selectLocation'), ('1-20', '1463727102790', 'login'), ('苏BA5N98-1-1', '1463727110669', 'cancelOrder'), ('1-20', '1463727320853', 'login'), ('苏BA5N98-1-20', '1463727351389', 'cancelOrder'), ('苏BA5N98-1-20', '1463727369048', 'cancelOrder'), ('苏BA5N98', '1463727410928', 'selectLocation'), ('1-20', '1463730315039', 'login'), ('1-20', '1463878219552', 'login'), ('1-20', '1463878959608', 'login'), ('苏BA5N98-1-1', '1463878967506', 'order'), ('1-20', '1463879039221', 'login'), ('苏BA5N98-1-1', '1463879045882', 'order'), ('1-20', '1463879234847', 'login'), ('苏BA5N98-1-1', '1463879241565', 'order'), ('1-20', '1463879997792', 'login'), ('苏BA5N98-1-1', '1463880004767', 'order'), ('1-20', '1463880176438', 'login'), ('苏BA5N98-1-1', '1463880183243', 'order'), ('1-20', '1463880931683', 'login'), ('1-20', '1463881039710', 'login'), ('1-20', '1463881185251', 'login'), ('1-20', '1463881331726', 'login'), ('1-20', '1463881678614', 'login'), ('1-20', '1463881843040', 'login'), ('1-20', '1463881873623', 'login'), ('1-20', '1463883016745', 'login'), ('2016052209229', '1463883038347', 'jf'), ('1-20', '1463883141961', 'login'), ('2016052209229', '1463883147259', 'jf'), ('苏BA5N98-1-2', '1463883164058', 'order'), ('2016052209229', '1463883187233', 'jf'), ('1-1', '1463883526125', 'login'), ('1-20', '1463883534689', 'login'), ('2016052209229-2016052209229-1463883541011', '1463883541011', 'zf'), ('1-20', '1464675751804', 'login'), ('1-20', '1464676036512', 'login'), ('1-20', '1464676269418', 'login'), ('test1-1', '1464676751979', 'login'), ('test-20', '1464676765188', 'login'), ('1-20', '1464677247258', 'login'), ('2016052210122-2016052210122-1464677299636', '1464677299637', 'zf'), ('1-20', '1464677387676', 'login'), ('1-20', '1464677563123', 'login'), ('1-20', '1464677665827', 'login'), ('1-20', '1464677702401', 'login'), ('1-20', '1464677814881', 'login'), ('test-20', '1464677842270', 'login'), ('1-20', '1464678525507', 'login'), ('1-20', '1464699049609', 'login'), ('1-20', '1464699354087', 'login'), ('1-20', '1464699439476', 'login'), ('1-20', '1464699522138', 'login'), ('苏BA5N98-1-1', '1464699579708', 'order');
COMMIT;

-- ----------------------------
--  Table structure for `location`
-- ----------------------------
DROP TABLE IF EXISTS `location`;
CREATE TABLE `location` (
  `location` varchar(500) DEFAULT NULL,
  `status` int(2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `location`
-- ----------------------------
BEGIN;
INSERT INTO `location` VALUES ('A区1排1列', '1'), ('A区1排2列', '1'), ('A区1排3列', '1'), ('A区2排1列', '1'), ('A区2排2列', '1'), ('A区2排3列', '1'), ('B区1排1列', '1'), ('B区1排2列', '1'), ('B区1排3列', '1');
COMMIT;

-- ----------------------------
--  Table structure for `order`
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `orderNum` bigint(20) DEFAULT NULL,
  `carNum` varchar(255) DEFAULT NULL,
  `orderTime` bigint(20) DEFAULT NULL,
  `orderLong` bigint(20) DEFAULT NULL,
  `status` int(2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `order`
-- ----------------------------
BEGIN;
INSERT INTO `order` VALUES ('1', null, null, null, null), ('1', '1', '1', '1', '1'), ('2', '1', '1', '1', '1'), ('2', '1', '11', '11', '1'), ('2016052209229', '苏BA5N98', '1', '1', '0'), ('2016052209233', '苏BA5N98', '1', '1', '0'), ('2016052209357', '苏BA5N98', '1', '1', '0'), ('2016052210122', '苏BA5N98', '1', '2', '0'), ('2016053120593', '苏BA5N98', '1', '1', '1');
COMMIT;

-- ----------------------------
--  Table structure for `pay`
-- ----------------------------
DROP TABLE IF EXISTS `pay`;
CREATE TABLE `pay` (
  `orderNum` bigint(20) DEFAULT NULL,
  `carNum` varchar(255) DEFAULT NULL,
  `payTime` datetime DEFAULT NULL,
  `money` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `promot`
-- ----------------------------
DROP TABLE IF EXISTS `promot`;
CREATE TABLE `promot` (
  `userIdentity` varchar(255) DEFAULT NULL,
  `PromotType` varchar(255) DEFAULT NULL,
  `Promotcontent` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `promot`
-- ----------------------------
BEGIN;
INSERT INTO `promot` VALUES ('1', 'discount', '20 percent off');
COMMIT;

-- ----------------------------
--  Table structure for `serverMsg`
-- ----------------------------
DROP TABLE IF EXISTS `serverMsg`;
CREATE TABLE `serverMsg` (
  `message` varchar(255) DEFAULT NULL,
  `addTime` bigint(20) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `serverMsg`
-- ----------------------------
BEGIN;
INSERT INTO `serverMsg` VALUES ('error', '1463017357289', 'login'), ('error', '1463017381044', 'login'), ('error', '1463017424253', 'login'), ('error', '1463017444008', 'login'), ('error', '1463017491169', 'login'), ('error', '1463017507900', 'login'), ('error', '1463017616208', 'login'), ('error', '1463017806434', 'login'), ('error', '1463017820153', 'login'), ('error', '1463017859258', 'login'), ('error', '1463017861265', 'login'), ('error', '1463017912405', 'login'), ('error', '1463018005501', 'login'), ('error', '1463018033279', 'login'), ('success', '1463018231704', 'login'), ('success', '1463018248438', 'login'), ('success', '1463018506924', 'login'), ('error', '1463018522651', 'login'), ('success', '1463018533678', 'login'), ('success', '1463018578913', 'login'), ('error', '1463018593638', 'login'), ('error', '1463018608690', 'login'), ('success', '1463018616715', 'login'), ('success', '1463018744845', 'login'), ('error', '1463018765615', 'login'), ('error', '1463018846146', 'login'), ('error', '1463018869909', 'login'), ('success', '1463018876929', 'login'), ('success', '1463019037356', 'login'), ('error', '1463019051110', 'login'), ('success', '1463361822093', 'login'), ('success', '1463361825790', 'login'), ('success', '1463362846088', 'login'), ('success', '1463362865816', 'login'), ('success', '1463363219003', 'login'), ('success', '1463363230713', 'login'), ('success', '1463363510953', 'login'), ('success', '1463363521655', 'login'), ('success', '1463364088802', 'login'), ('success', '1463364099505', 'login'), ('success', '1463364169226', 'login'), ('success', '1463364173936', 'login'), ('success', '1463364451786', 'login'), ('success', '1463364473520', 'login'), ('success', '1463364554120', 'login'), ('success', '1463364567831', 'login'), ('success', '1463364892641', 'login'), ('null', '1463365030944', 'login'), ('success', '1463365040994', 'login'), ('error', '1463365055676', 'login'), ('success', '1463365096820', 'login'), ('error', '1463365112193', 'login'), ('null', '1463365187317', 'cancelOrder'), ('error', '1463365195277', 'cancelOrder'), ('success', '1463365208473', 'cancelOrder'), ('null', '1463365478717', 'cancelOrder'), ('success', '1463365486761', 'login'), ('success', '1463366344446', 'login'), ('success', '1463366376217', 'login'), ('null', '1463366459778', 'jf'), ('success', '1463366473782', 'jf'), ('error', '1463366482834', 'jf'), ('success', '1463367187723', 'login'), ('success', '1463367194440', 'login'), ('ERROR', '1463367208838', 'jf'), ('error', '1463367225461', 'jf'), ('success-1-1-1-1', '1463367245065', 'jf'), ('success-1-1-1-1', '1463367268953', 'jf'), ('success', '1463367304067', 'login'), ('success', '1463367306075', 'login'), ('success-1-1-1-1', '1463367320783', 'jf'), ('success', '1463367451572', 'login'), ('success', '1463367454275', 'login'), ('success', '1463367517633', 'login'), ('success', '1463367535368', 'login'), ('success', '1463368290110', 'login'), ('success', '1463368304824', 'login'), ('null', '1463368323159', 'zf'), ('error', '1463368337218', 'zf'), ('null', '1463369333385', 'zf'), ('success', '1463369340428', 'login'), ('error', '1463369353306', 'zf'), ('success-????', '1463369365027', 'zf'), ('success', '1463369489913', 'login'), ('success', '1463369506644', 'login'), ('success-??-??', '1463369517956', 'zf'), ('success-discount-20 percent off', '1463369609699', 'zf'), ('success', '1463369713777', 'login'), ('success', '1463369728503', 'login'), ('success-discount-20 percent off', '1463369739202', 'zf'), ('error', '1463369752336', 'zf'), ('null', '1463370022723', 'cancelOrder'), ('null', '1463713422651', 'cancelOrder'), ('success', '1463713463789', 'login'), ('success', '1463713487932', 'zf'), ('success-null-null-null-null', '1463713515067', 'jf'), ('success', '1463721416924', 'login'), ('success', '1463721434665', 'login'), ('success', '1463721566522', 'login'), ('success', '1463721746706', 'login'), ('success', '1463721906544', 'login'), ('A?????', '1463721917575', 'selectLocation'), ('A?????', '1463722111567', 'selectLocation'), ('success', '1463722124273', 'login'), ('success', '1463722277412', 'login'), ('A?????', '1463722452716', 'selectLocation'), ('A?????', '1463722463301', 'selectLocation'), ('success', '1463722476007', 'login'), ('success', '1463722912430', 'login'), ('success', '1463723098576', 'login'), ('success', '1463723464783', 'login'), ('success', '1463723602791', 'login'), ('A区一排一列', '1463723607808', 'selectLocation'), ('A区一排一列-1970-01-01 08-00-02', '1463723912601', 'selectLocation'), ('success', '1463723925317', 'login'), ('A区一排一列-1970-01-01 08-00-02', '1463723943373', 'selectLocation'), ('A区一排一列-2016-05-20 13-59-02', '1463724092932', 'selectLocation'), ('success', '1463724105632', 'login'), ('success', '1463724230139', 'login'), ('A区一排一列-2016-05-20 13时59分02秒', '1463724261219', 'selectLocation'), ('A区一排一列-2016-05-20 13时59分02秒', '1463724321049', 'selectLocation'), ('success', '1463724335752', 'login'), ('A区一排一列-2016-05-20 13时59分02秒', '1463724340767', 'selectLocation'), ('A区一排一列-2016-05-20 13时59分02秒', '1463724423796', 'selectLocation'), ('success', '1463724439511', 'login'), ('A区一排一列-2016-05-20 13时59分02秒', '1463724457573', 'selectLocation'), ('A区一排一列-2016年05月20 13时59分02秒', '1463724544442', 'selectLocation'), ('success', '1463724563148', 'login'), ('A区一排一列-2016年05月20 13时59分02秒', '1463724579190', 'selectLocation'), ('A区一排一列-2016年05月20 13时59分02秒', '1463725692651', 'selectLocation'), ('success', '1463725704345', 'login'), ('success', '1463725766552', 'login'), ('success', '1463725779275', 'login'), ('success', '1463725863564', 'login'), ('success', '1463725870275', 'login'), ('success', '1463725940571', 'login'), ('success', '1463725955294', 'login'), ('success', '1463726009839', 'login'), ('success', '1463726022567', 'login'), ('success', '1463726855770', 'login'), ('success', '1463726871521', 'login'), ('2016052014475', '1463726877542', 'cancelOrder'), ('A区一排一列-2016年05月20 13时59分02秒', '1463726908639', 'selectLocation'), ('A区一排一列-2016年05月20 13时59分02秒', '1463727085759', 'selectLocation'), ('success', '1463727103488', 'login'), ('2016052014516', '1463727111507', 'cancelOrder'), ('2016052014555', '1463727302816', 'cancelOrder'), ('success', '1463727321562', 'login'), ('2016052014555', '1463727351637', 'cancelOrder'), ('2016052014561', '1463727369711', 'cancelOrder'), ('A区一排一列-2016年05月20 13时59分02秒', '1463727411833', 'selectLocation'), ('A区一排一列-2016年05月20 13时59分02秒', '1463730303043', 'selectLocation'), ('success', '1463730315734', 'login'), ('success', '1463878202518', 'login'), ('success', '1463878220132', 'login'), ('success', '1463878944066', 'login'), ('success', '1463878960788', 'login'), ('2016052209026', '1463878967811', 'cancelOrder'), ('2016052209032', '1463879024242', 'order'), ('success', '1463879039986', 'login'), ('2016052209041', '1463879046005', 'order'), ('2016052209064', '1463879217452', 'order'), ('success', '1463879235188', 'login'), ('2016052209072', '1463879242205', 'order'), ('2016052209197', '1463879980844', 'order'), ('success', '1463879998584', 'login'), ('2016052209200', '1463880005606', 'order'), ('2016052209229', '1463880161917', 'order'), ('success', '1463880177641', 'login'), ('2016052209233', '1463880183661', 'order'), ('2016052209357', '1463880916047', 'order'), ('success', '1463880932783', 'login'), ('success', '1463881034417', 'login'), ('success', '1463881040127', 'login'), ('success', '1463881166332', 'login'), ('success', '1463881186076', 'login'), ('success', '1463881310479', 'login'), ('success', '1463881332231', 'login'), ('success', '1463881665144', 'login'), ('success', '1463881679866', 'login'), ('success', '1463881805183', 'login'), ('success', '1463881844021', 'login'), ('success', '1463881874098', 'login'), ('success', '1463883005521', 'login'), ('success', '1463883017253', 'login'), ('10', '1463883039317', 'jf'), ('10', '1463883130106', 'jf'), ('success', '1463883142825', 'login'), ('10', '1463883147837', 'jf'), ('2016052210122', '1463883164875', 'order'), ('10', '1463883187957', 'jf'), ('10', '1463883513009', 'jf'), ('error', '1463883526747', 'login'), ('success', '1463883534772', 'login'), ('支付成功', '1463883541795', 'zf'), ('支付成功', '1464675743235', 'zf'), ('success', '1464675752928', 'login'), ('success', '1464676016259', 'login'), ('success', '1464676037002', 'login'), ('success', '1464676262951', 'login'), ('success', '1464676270668', 'login'), ('success', '1464676727223', 'login'), ('error', '1464676752979', 'login'), ('success', '1464676766009', 'login'), ('success', '1464677233607', 'login'), ('success', '1464677248342', 'login'), ('支付成功', '1464677300472', 'zf'), ('支付成功', '1464677361907', 'zf'), ('success', '1464677388654', 'login'), ('success', '1464677550185', 'login'), ('success', '1464677563911', 'login'), ('success', '1464677655609', 'login'), ('success', '1464677666323', 'login'), ('success', '1464677703403', 'login'), ('success', '1464677804522', 'login'), ('success', '1464677815233', 'login'), ('success', '1464677843308', 'login'), ('success', '1464678416988', 'login'), ('success', '1464678526004', 'login'), ('success', '1464699023150', 'login'), ('success', '1464699050884', 'login'), ('success', '1464699340638', 'login'), ('success', '1464699355344', 'login'), ('success', '1464699416807', 'login'), ('success', '1464699440546', 'login'), ('success', '1464699512155', 'login'), ('success', '1464699522866', 'login'), ('2016053120593', '1464699580004', 'order');
COMMIT;

-- ----------------------------
--  Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `name` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `carNum` varchar(500) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `user`
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES ('1', '20', '1', '苏BA5N98'), ('test', '20', '1', null);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;

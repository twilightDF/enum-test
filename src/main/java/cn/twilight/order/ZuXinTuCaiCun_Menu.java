package cn.twilight.order;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ZuXinTuCaiCun_Menu {

    ZHJCDC("渣海椒炒大肠",58.0,1),
    YZCXTD("油炸炒小土豆",22.0,2),
    CDF("菜豆腐",18.0,2),
    SZRP("水煮肉片",32.0,2),
    LWPYJR("老外婆盐煎肉",22.0,3),
    JJXD("尖椒小肚",38.0,1),
    GBSJD("干煸四季豆",18.0,3),
    RMQZ("肉末茄子",18.0,3),
    DHYM("蛋黄玉米",28.0,1),
    QCSG("清炒丝瓜",18.0,2),
    SRHFS("酥肉烩粉丝",38.0,1),
    QCHGR("炝炒回锅肉",38.0,3),
    STRP("酸汤肉片",48.0,1),

    NFOW("农夫藕丸",35.0,2),
    SFCSG("顺风茶树菇",38.0,2),
    GGCSG("干锅茶树菇",58.0,1),
    QJRS("青椒肉丝",28.0,3),
    JJGZ("尖椒拱嘴",35.0,2),
    ZJXCR("祝记小炒肉",35.0,2),
    BBSY("保爆山药",28.0,2),
    LYCCTJD("老盐菜炒土鸡蛋",28.0,3),
    GBTDS("干煸土豆丝",18.0,2),
    YZLB("油渣莲白",14.0,3),
    JQCDJ("茄子炒豆角",18.0,3),
    QJTDS("青椒土豆丝",13.0,3);

    private String name;
    private Double cost;
    private Integer weight;
}

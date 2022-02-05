package com.ai.common.utils;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author: Administrator
 * @date: 2022/2/5 14:13
 * @description:
 */
public class OurRuleUtils {
    //我方规则定义
    public static LinkedList<String> linkedList = new LinkedList();

    //我方声明
    public static LinkedList<String>  myDeclare = new LinkedList();

    //商户方指定IP
    public static LinkedList<String>  ipAddree = new LinkedList();

    //提示步骤
    public static Map<String,String>  hintProcess  = new HashMap<>();

    //已经完成的步骤
    public static Map<String,String> alFinishProcess = new HashMap<>();


    //已经完成规则
    public static Map<String,String>  alFinishRule = new HashMap<>();


    //管理员授权
    public static  Map<String,String>  adminAuthProcess = new HashMap<>();



    public OurRuleUtils() {
        //初始化商户方对接流程步骤
        hintProcess.put("1","1");
        hintProcess.put("2","2,注意事项");
        hintProcess.put("3","3");
        hintProcess.put("4","4");
        hintProcess.put("5","5");
        hintProcess.put("6","6");

        //我方设置跳过步骤权限码
        adminAuthProcess.put("admin1","abc1");
        adminAuthProcess.put("admin2","abc2");
        adminAuthProcess.put("admin3","abc3");
        adminAuthProcess.put("admin4","abc4");
        adminAuthProcess.put("admin5","abc5");
        adminAuthProcess.put("admin6","abc6");
        adminAuthProcess.put("admin7","abc7"); //一键全开权限

        ipAddree.add("192.168.1.5");
        ipAddree.add("192.168.1.6");

    }


}

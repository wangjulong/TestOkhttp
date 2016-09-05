package com.example.administrator.testokhttp;

/**
 * Created by Administrator on 2016/9/5.
 */

class DataInit {

    /**
     * 根据网页内容更新数据库中的开奖号码数据
     * @param htmlData 传递过来的网页 html 源代码
     *                 http://trend.caipiao.163.com/ln11xuan5/?periodNumber=100
     */
    static void dataSave(String htmlData) {

        // 新建数组，利用源代码中的特别字符分割字符串，生成字符串数组
        String[] arr0 = htmlData.split("data-period=\"");

        // 临时变量
        String s0;
        int n1,n2,n3,n4,n5;

        // 清空数据库内容
        Kjh.deleteAll(Kjh.class);

        // 循环字符串数组
        for (String abc : arr0) {

            // 正则表达式匹配开始的8个字符是否是数字，更新数据库
            if (abc.substring(0,8).matches("\\d{8}")) {
                s0 = abc.substring(0, 8);
                n1 = Integer.parseInt(abc.substring(22, 24));
                n2 = Integer.parseInt(abc.substring(25, 27));
                n3 = Integer.parseInt(abc.substring(28, 30));
                n4 = Integer.parseInt(abc.substring(31, 33));
                n5 = Integer.parseInt(abc.substring(34, 36));
                Kjh kjh = new Kjh(s0,n1,n2,n3,n4,n5);
                kjh.save();
            }
        }

    }
}

package org.xxf.gundam.util;

import java.util.Random;

/**
 * @author: xxf
 * @date: 2019/1/14 0014 上午 11:32
 */
public class Utils {

    /**
     * 获取随机字符串
     *
     * @param length
     * @return
     */
    public static String getRandomStr(Integer length){
        //定义一个字符串（A-Z，a-z，0-9）即62位；
        String str="zxcvbnmlkjhgfdsaqwertyuiopQWERTYUIOPASDFGHJKLZXCVBNM1234567890";
        //由Random生成随机数
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        //长度为几就循环几次
        for(int i=0; i<6; ++i){
            //产生0-61的数字
            int number=random.nextInt(62);
            //将产生的数字通过length次承载到sb中
            sb.append(str.charAt(number));
        }
        //将承载的字符转换成字符串
        return sb.toString();
    }

}

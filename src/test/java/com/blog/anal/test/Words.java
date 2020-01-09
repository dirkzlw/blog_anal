package com.blog.anal.test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ranger
 * @create 2020-01-06 14:03
 */
public class Words {
    public static Map<String, Map<String, Integer>> sexCountMap = new HashMap<>();
    //性别频率词

    public static Map<String,Map<String,Integer>> ageCountMap = new HashMap<>();

    static {
        Map<String,Integer> maleMap = new HashMap<>();
        Map<String,Integer> femaleMap = new HashMap<>();
        maleMap.put("linux", 0);
        maleMap.put("microsoft", 0);
        maleMap.put("gaming", 0);
        maleMap.put("server", 0);
        maleMap.put("software", 0);
        maleMap.put("gb", 0);
        maleMap.put("programming", 0);
        maleMap.put("google", 0);
        maleMap.put("data", 0);
        maleMap.put("graphics", 0);
        maleMap.put("india", 0);
        maleMap.put("nations", 0);
        maleMap.put("democracy", 0);
        maleMap.put("users", 0);
        maleMap.put("economic", 0);
        maleMap.put("shopping", 0);
        maleMap.put("mom", 0);
        maleMap.put("cried", 0);
        maleMap.put("freaked", 0);
        maleMap.put("pink", 0);
        maleMap.put("cute", 0);
        maleMap.put("gosh", 0);
        maleMap.put("kisses", 0);
        maleMap.put("yummy", 0);
        maleMap.put("mommy", 0);
        maleMap.put("boyfriend", 0);
        maleMap.put("skirt", 0);
        maleMap.put("adorable", 0);
        maleMap.put("husband", 0);
        maleMap.put("hubby", 0);
        maleMap.put("linux", 0);
        maleMap.put("microsoft", 0);
        maleMap.put("gaming", 0);

        femaleMap.put("server", 0);
        femaleMap.put("software", 0);
        femaleMap.put("gb", 0);
        femaleMap.put("programming", 0);
        femaleMap.put("google", 0);
        femaleMap.put("data", 0);
        femaleMap.put("graphics", 0);
        femaleMap.put("india", 0);
        femaleMap.put("nations", 0);
        femaleMap.put("democracy", 0);
        femaleMap.put("users", 0);
        femaleMap.put("economic", 0);
        femaleMap.put("shopping", 0);
        femaleMap.put("mom", 0);
        femaleMap.put("cried", 0);
        femaleMap.put("freaked", 0);
        femaleMap.put("pink", 0);
        femaleMap.put("cute", 0);
        femaleMap.put("gosh", 0);
        femaleMap.put("kisses", 0);
        femaleMap.put("yummy", 0);
        femaleMap.put("mommy", 0);
        femaleMap.put("boyfriend", 0);
        femaleMap.put("skirt", 0);
        femaleMap.put("adorable", 0);
        femaleMap.put("husband", 0);
        femaleMap.put("hubby", 0);
        femaleMap.put("linux", 0);
        femaleMap.put("microsoft", 0);
        femaleMap.put("gaming", 0);

        sexCountMap.put("male", maleMap);
        sexCountMap.put("female", femaleMap);
    }
}

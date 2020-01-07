package com.blog.anal;

import shapeless.HMap;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Ranger
 * @create 2020-01-06 14:03
 */
public class Words {
    public static Map<String, Map<String, Integer>> sexCountMap = new HashMap<>();

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

        sexCountMap.put("male", maleMap);
        sexCountMap.put("female", femaleMap);
    }
    static {
        /**
         * 各年龄段 amgMap[0]:13-17 ageMap[1]:18-22 ageMap[2]:23-27
         * amgMap[3]:28-32 ageMap[4]:33-37 ageMap[5]:38-42 ageMap[6]:43-48
         *
         * 三个年龄段：10s:13-17 20s:23-27 30s:33-42
         */
        Map<String,Integer>[] ageMap = new HashMap[3];
        for(int i = 0;i < ageMap.length;i++){
            ageMap[i] = new HashMap<>();
            ageMap[i].put("maths", 0);
            ageMap[i].put("homework", 0);
            ageMap[i].put("bored", 0);
            ageMap[i].put("sis", 0);
            ageMap[i].put("boring", 0);
            ageMap[i].put("awesome", 0);
            ageMap[i].put("mum", 0);
            ageMap[i].put("crappy", 0);

            ageMap[i].put("mad", 0);
            ageMap[i].put("dumb", 0);
            ageMap[i].put("semester", 0);
            ageMap[i].put("apartment", 0);
            ageMap[i].put("drunk", 0);
            ageMap[i].put("beer", 0);
            ageMap[i].put("student", 0);

            ageMap[i].put("album", 0);
            ageMap[i].put("college", 0);
            ageMap[i].put("someday", 0);
            ageMap[i].put("dating", 0);
            ageMap[i].put("bar", 0);
            ageMap[i].put("marriage", 0);
            ageMap[i].put("developm", 0);
            ageMap[i].put("campaign", 0);
            ageMap[i].put("tax", 0);
            ageMap[i].put("local", 0);
            ageMap[i].put("democrati", 0);
            ageMap[i].put("son", 0);
            ageMap[i].put("systems", 0);
            ageMap[i].put("provide", 0);
            ageMap[i].put("workers", 0);

            ageCountMap.put("ageMap["+i+"]",ageMap[i]);
        }


    }
}

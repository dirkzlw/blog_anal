package com.blog.anal.age;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.Test;

/**
 * @author Ranger
 * @create 2020-01-07 15:32
 */
public class CreateAgeLinearData {

    /**
     * 统计每篇文章频率词
     */
    @Test
    public void countWords() throws IOException {
        Map<String, Integer> ageMap = new LinkedHashMap<>();
        ageMap.put("maths", 0);
        ageMap.put("homework", 0);
        ageMap.put("bored", 0);
        ageMap.put("sis", 0);
        ageMap.put("boring", 0);
        ageMap.put("awesome", 0);
        ageMap.put("mum", 0);
        ageMap.put("crappy", 0);
        ageMap.put("mad", 0);
        ageMap.put("dumb", 0);
        ageMap.put("semester", 0);
        ageMap.put("apartment", 0);
        ageMap.put("drunk", 0);
        ageMap.put("beer", 0);
        ageMap.put("student", 0);
        ageMap.put("album", 0);
        ageMap.put("college", 0);
        ageMap.put("someday", 0);
        ageMap.put("dating", 0);
        ageMap.put("bar", 0);
        ageMap.put("marriage", 0);
        ageMap.put("development", 0);
        ageMap.put("campaign", 0);
        ageMap.put("tax", 0);
        ageMap.put("local", 0);
        ageMap.put("democratic", 0);
        ageMap.put("son", 0);
        ageMap.put("systems", 0);
        ageMap.put("provide", 0);
        ageMap.put("workers", 0);

        File outFile = new File("./data/agedata");
        if (!outFile.exists())
            outFile.createNewFile();
        BufferedWriter writer = new BufferedWriter(new FileWriter(outFile));

        String dir = "C:\\Users\\zhouliwei\\Desktop\\zhks\\blogs";
        File dirFile = new File(dir);
        String[] list = dirFile.list();
        BufferedReader reader;
        String age;
        int i=0;
        for (String s : list) {
            System.out.println("i = " + ++i);
            age = s.split("\\.")[2];
            reader = new BufferedReader(new FileReader(new File(dir + "\\" + s)));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] s1 = line.split(" ");
                for (String s2 : s1) {
                    for (String word : ageMap.keySet()) {
                        if (s2.contains(word))
                            ageMap.put(word, ageMap.get(word) + 1);
                    }
                }
            }
            String outLine = age + ",";
            for (String word : ageMap.keySet()) {
                outLine += ageMap.get(word) + " ";
            }

            writer.write(outLine.substring(0, outLine.length() - 1) + "\n");
            writer.flush();
            //记录清零
            for (String word : ageMap.keySet()) {
                ageMap.put(word, 0);
            }
        }

    }
}

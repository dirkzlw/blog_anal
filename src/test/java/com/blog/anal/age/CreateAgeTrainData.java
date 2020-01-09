package com.blog.anal.age;

import com.blog.anal.utils.MapUtils;
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
public class CreateAgeTrainData {

    /**
     * 创建年龄训练数据集
     */
    @Test
    public void countWords() throws IOException {
        Map<String, Integer> ageMap = MapUtils.ageMap;

//        File outFile = new File("./data/age1.data");
        File outFile = new File("./data/age2.data");
        if (!outFile.exists())
            outFile.createNewFile();
        BufferedWriter writer = new BufferedWriter(new FileWriter(outFile));

        String dir = "C:\\Users\\zhouliwei\\Desktop\\zhks\\blogs";
        File dirFile = new File(dir);
        String[] list = dirFile.list();
        BufferedReader reader;
        int age;
        int i = 0;
        for (String s : list) {
            System.out.println("i = " + ++i);
            age = Integer.parseInt(s.split("\\.")[2]);
            //10s 和20 30s两类
//            if (age <= 20)
//                age = 0;
//            else
//                age = 1;

            //20s和 30s两类
            if (age<=20)
                continue;
            else if(age <= 30 && age>20)
                age = 0;
            else
                age=1;
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
            String outLine = age + " ";
            int n=1;
            for (String word : ageMap.keySet()) {
                outLine += n++ + ":" + ageMap.get(word) + " ";
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

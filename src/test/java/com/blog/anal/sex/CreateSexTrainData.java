package com.blog.anal.sex;

import com.blog.anal.utils.MapUtils;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import org.junit.Test;

/**
 * @author Ranger
 * @create 2020-01-07 15:32
 */
public class CreateSexTrainData {

    /**
     * 统计每篇文章频率词
     */
    @Test
    public void countWords() throws IOException {

        Map<String, Integer> sexMap = MapUtils.sexMap;

        File outFile = new File("./data/sex.data");
        if (!outFile.exists())
            outFile.createNewFile();
        BufferedWriter writer = new BufferedWriter(new FileWriter(outFile));

        String dir = "C:\\Users\\zhouliwei\\Desktop\\zhks\\blogs";
        File dirFile = new File(dir);
        String[] list = dirFile.list();
        BufferedReader reader;
        String sex;
        int i = 0;
        for (String s : list) {
            System.out.println("i = " + ++i);
            sex = s.split("\\.")[1];
            switch (sex) {
                case "female":
                    sex = 0 + "";
                    break;
                case "male":
                    sex = 1 + "";
                    break;
            }
            reader = new BufferedReader(new FileReader(new File(dir + "\\" + s)));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] s1 = line.split(" ");
                for (String s2 : s1) {
                    for (String word : sexMap.keySet()) {
                        if (s2.contains(word))
                            sexMap.put(word, sexMap.get(word) + 1);
                    }
                }
            }
            String outLine = sex + " ";
            int n = 1;
            for (String word : sexMap.keySet()) {
                outLine += n++ + ":" + sexMap.get(word) + " ";
            }

            writer.write(outLine.substring(0, outLine.length() - 1) + "\n");
            writer.flush();
            //记录清零
            for (String word : sexMap.keySet()) {
                sexMap.put(word, 0);
            }
        }

    }
}

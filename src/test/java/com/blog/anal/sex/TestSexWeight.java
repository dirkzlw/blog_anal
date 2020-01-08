package com.blog.anal.sex;

import com.blog.anal.utils.MapUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import org.junit.Test;

/**
 * @author Ranger
 * @create 2020-01-07 21:47
 */
public class TestSexWeight {

    @Test
    public void test() throws IOException {
        Map<String, Integer> sexMap = MapUtils.sexMap;

        String dir = "C:\\Users\\zhouliwei\\Desktop\\zhks\\blogs";

        File dirFile = new File(dir);

        File weightFile = new File("./data/sex.weight");
        BufferedReader weightReader = new BufferedReader(new FileReader(weightFile));
        String[] weightStrArr = weightReader.readLine().split("\\,");
        double[] weights = new double[weightStrArr.length];
        for (int i = 0; i <=weights.length - 1; i++) {
            weights[i] = Double.parseDouble(weightStrArr[i]);
        }
        String line;
        int r;
        int y;
        int count = 0;
        int i = 0;
        String[] list = dirFile.list();
        for (String s : list) {
            System.out.print("进度：" + ++i + "\t");
            BufferedReader reader = new BufferedReader(new FileReader(dir + "/" + s));
            while ((line = reader.readLine()) != null) {
                String[] s1 = line.split(" ");
                for (String s2 : s1) {
                    for (String word : sexMap.keySet()) {
                        if (s2.contains(word))
                            sexMap.put(word, sexMap.get(word) + 1);
                    }
                }
            }
            int ii = 0;
            double c = 0.0;
            for (String word : sexMap.keySet()) {
                c += sexMap.get(word) * weights[ii++];
            }
            c = 1 / (1 + Math.pow(Math.E, -c));
            System.out.print("c = " + c + "\t");
            r = c >= 0.5 ? 1 : 0;
            switch (s.split("\\.")[1]) {
                case "female":
                    y = 0;
                    break;
                case "male":
                    y = 1;
                    break;
                default:
                    y = 1;
                    break;
            }
            if (y == r)
                count++;
            System.out.println("预测值：" + r + "\t" + "实际值：" + y);
            //记录清零
            for (String word : sexMap.keySet()) {
                sexMap.put(word, 0);
            }
        }
        System.out.println("count = " + count);
    }
}

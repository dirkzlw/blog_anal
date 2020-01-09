package com.blog.anal.age;

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
public class TestAgeWeight {

    @Test
    public void test() throws IOException {
        Map<String, Integer> ageMap = MapUtils.ageMap;
        String dir = "C:\\Users\\zhouliwei\\Desktop\\zhks\\blogs";
        File dirFile = new File(dir);
        //age1权重
        File weightFile = new File("./data/age1.weight");
        BufferedReader weightReader = new BufferedReader(new FileReader(weightFile));
        String[] weightStrArr = weightReader.readLine().split("\\,");
        double[] weights = new double[weightStrArr.length];
        for (int i = 0; i <= weights.length - 1; i++) {
            weights[i] = Double.parseDouble(weightStrArr[i]);
        }
        //age2权重
        File weightFile2 = new File("./data/age2.weight");
        BufferedReader weightReader2 = new BufferedReader(new FileReader(weightFile2));
        String[] weightStrArr2 = weightReader2.readLine().split("\\,");
        double[] weights2 = new double[weightStrArr2.length];
        for (int i = 0; i <= weights2.length - 1; i++) {
            weights2[i] = Double.parseDouble(weightStrArr2[i]);
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
                    for (String word : ageMap.keySet()) {
                        if (s2.contains(word))
                            ageMap.put(word, ageMap.get(word) + 1);
                    }
                }
            }
            int ii = 0;
            double c = 0.0;
            for (String word : ageMap.keySet()) {
                c += ageMap.get(word) * weights[ii++];
            }
            c = 1 / (1 + Math.pow(Math.E, -c));
            System.out.print("c1 = " + c + "\t");
            r = c > 0.5 ? 1 : 0;
            if (r == 1) {
                //再次分类
                ii = 0;
                c = 0.0;
                for (String word : ageMap.keySet()) {
                    c += ageMap.get(word) * weights2[ii++];
                }
                c = 1 / (1 + Math.pow(Math.E, -c));
                r = c > 0.5 ? 2 : 1;
                System.out.print("c2 = " + c + "\t");
            }
            int a = Integer.parseInt(s.split("\\.")[2]);
            System.out.print(s + "\t");
            if (a <= 20)
                y = 0;
            else if (a > 20 && a <= 30) {
                y = 1;
            } else
                y = 2;
            if (y == r)
                count++;
            System.out.println("预测值：" + r + "\t" + "实际值：" + y);
            //记录清零
            for (String word : ageMap.keySet()) {
                ageMap.put(word, 0);
            }
        }
        System.out.println("count = " + count);
    }
}

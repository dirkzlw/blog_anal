package com.blog.anal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

/**
 * @author Ranger
 * @create 2020-01-06 13:43
 */
public class SexWordsCount {
    public static void main(String[] args) throws IOException {
        String dir = "C:\\Users\\zhouliwei\\Desktop\\zhks\\blogs4";
        File dirFile = new File(dir);
        String[] list = null;
        if (null != dirFile && dirFile.isDirectory()) {
            list = dirFile.list();
        }
        BufferedReader reader = null;
        int i = 0;
        for (String s : list) {
            System.out.println("进度：" + ++i);
            if(s.contains("female")){
                reader = new BufferedReader(new FileReader(new File(dir + "\\" + s)));
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] s1 = line.split(" ");
                    for (String s2 : s1) {
                        Map<String, Integer> femaleMap = Words.sexCountMap.get("female");
                        for (String word : femaleMap.keySet()) {
                            if (s2.contains(word))
                                femaleMap.put(word, femaleMap.get(word) + 1);
                        }
                    }
                }
            }else {
                reader = new BufferedReader(new FileReader(new File(dir + "\\" + s)));
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] s1 = line.split(" ");
                    for (String s2 : s1) {
                        Map<String, Integer> maleMap = Words.sexCountMap.get("male");
                        for (String word : maleMap.keySet()) {
                            if (s2.contains(word))
                                maleMap.put(word, maleMap.get(word) + 1);
                        }
                    }
                }
            }
        }

        Map<String, Integer> maleMap = Words.sexCountMap.get("male");
        Map<String, Integer> femaleMap = Words.sexCountMap.get("female");
        for (String word : maleMap.keySet()) {
            System.out.println(word + "--" + maleMap.get(word));
        }
        for (String word : femaleMap.keySet()) {
            System.out.println(word + "--" + femaleMap.get(word));
        }
    }

    /**
     * 统计性别总词汇
     */
    @Test
    public void countSexWords() throws Exception {
        Map<String, Long> sexMap = new HashMap<>();
        sexMap.put("male", 0l);
        sexMap.put("female", 0l);
        String dir = "C:\\Users\\zhouliwei\\Desktop\\zhks\\blogs4";
        File dirFile = new File(dir);
        String[] list = null;
        if (null != dirFile && dirFile.isDirectory()) {
            list = dirFile.list();
        }
        int i=0;
        BufferedReader reader = null;
        for (String s : list) {
            System.out.println("进度：" + ++i);
            reader = new BufferedReader(new FileReader(dir + "\\" + s));
            String line ;
            while ((line=reader.readLine())!=null){
                if(line.equalsIgnoreCase("<Blog>") || line.equalsIgnoreCase("</Blog>")
                        || line.contains("<date>") || line.contains("</date>")
                        || line.contains("<post>") || line.contains("</post>")){

                } else {
                    long n = line.split(" ").length;
                    if(s.contains("female")){
                        sexMap.put("female", sexMap.get("female")+n);
                    }else {
                        sexMap.put("male", sexMap.get("male")+n);
                    }
                }
            }
            for (String sex : sexMap.keySet()) {
                System.out.println(sex + "--" + sexMap.get(sex));
            }
        }
    }
}

package com.blog.anal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.spark.sql.sources.In;
import org.junit.Test;

/**
 * @author Ranger
 * @create 2020-01-06 13:43
 */
public class SexWordsCount {
    public static void main(String[] args) throws IOException {
        String dir = "D:\\2019秋专业综合课程设计数据集\\3-博客作者身份分析\\testblog";
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
                            if(StringUtils.containsIgnoreCase(s2,word))
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
                            if(StringUtils.containsIgnoreCase(s2,word))
                                maleMap.put(word, maleMap.get(word) + 1);
                        }
                    }
                }
            }
        }

        Map<String, Integer> maleMap = Words.sexCountMap.get("male");
        Map<String, Integer> femaleMap = Words.sexCountMap.get("female");
        for (String word : maleMap.keySet()) {
            System.out.println("male  " + word + "--" + maleMap.get(word));
        }
        for (String word : femaleMap.keySet()) {
            System.out.println("female  " + word + "--" + femaleMap.get(word));
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
        String dir = "D:\\2019秋专业综合课程设计数据集\\3-博客作者身份分析\\blogs2";
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




    /**
     * 统计每个年龄段词的总数
     */
    @Test
    public void ageCoutAllWords() throws IOException {
        String dir = "D:\\2019秋专业综合课程设计数据集\\3-博客作者身份分析\\testblog";
        File dirFile = new File(dir);
        String[] list = null;
        if (null != dirFile && dirFile.isDirectory()) {
            list = dirFile.list();
        }
        System.out.println("文件数量："+list.length);
        BufferedReader reader = null;
        int i = 0;
        Map<String,Long> map = new HashMap<>();
        map.put("10s", 0l);
        map.put("20s", 0l);
        map.put("30s", 0l);
        for (String s : list) {
            String[] split = s.split("\\.");
            int age = Integer.parseInt(split[2]);
            System.out.println("进度：" + ++i);
            reader = new BufferedReader(new FileReader(dir + "\\" + s));
            String line ;
            while ((line=reader.readLine())!=null){
                if(line.equalsIgnoreCase("<Blog>") || line.equalsIgnoreCase("</Blog>")
                        || line.contains("<date>") || line.contains("</date>")
                        || line.contains("<post>") || line.contains("</post>")){

                } else {
                    long n = line.split(" ").length;
                    if(age>=13&&age<=17){
                        map.put("10s", map.get("10s")+n);
                    }else if(age>=23&&age<=27){
                        map.put("20s", map.get("20s")+n);
                    }else if(age>=33&&age<=42){
                        map.put("30s", map.get("30s")+n);
                    }
                }
            }
            for (String word : map.keySet()) {
                System.out.println(word + "--" + map.get(word));
            }
        }
    }

    /**
     * 统计每个年龄段博客中关键词出现的次数
     */
    public Map<String,Integer> everyAgeCount(BufferedReader reader,String ageScope) throws IOException {
        String line;
        Map<String, Integer> ageMap = null;
        while ((line = reader.readLine()) != null) {
            String[] s1 = line.split(" ");
            for (String s2 : s1) {
                ageMap = Words.ageCountMap.get(ageScope);
                for (String word : ageMap.keySet()) {
                    //不区分大小写包含
                    if(StringUtils.containsIgnoreCase(s2,word))
                        ageMap.put(word, ageMap.get(word) + 1);
                }
            }
        }
        return ageMap;
    }


    /**
     * 统计各个年龄段关键词出现的次数
     * @throws IOException
     */
    @Test
    public void countAgeWords() throws IOException {
        String dir = "D:\\2019秋专业综合课程设计数据集\\3-博客作者身份分析\\blogs2";
        File dirFile = new File(dir);
        String[] list = null;
        if (null != dirFile && dirFile.isDirectory()) {
            list = dirFile.list();
        }
        System.out.println("文件数量："+list.length);
        BufferedReader reader = null;
        int i = 0;
        Map<String,Integer>[] ageMap = new HashMap[3];

        for(String s:list){
            System.out.println("进度：" + ++i);
            //解析文件名，判断该文件作者年龄
            String[] split = s.split("\\.");
            int age = Integer.parseInt(split[2]);
            if(age>=13&&age<=17){
                reader = new BufferedReader(new FileReader(new File(dir + "\\" + s)));
                ageMap[0] = everyAgeCount(reader,"ageMap[0]");
            }else if(age>=23&&age<=27){
                reader = new BufferedReader(new FileReader(new File(dir + "\\" + s)));
                ageMap[1] = everyAgeCount(reader,"ageMap[1]");
            }else if(age>=33&&age<=42){
                reader = new BufferedReader(new FileReader(new File(dir + "\\" + s)));
                ageMap[2] = everyAgeCount(reader,"ageMap[2]");
            }
        }

        Map<String, Integer> mage;
        /**
         * ageMap[0] 10s:13-17
         * ageMap[1] 20s:23-27
         * ageMap[2] 30s:33-42
         */

        for(int j = 0;j < 3;j++){
            System.out.println("》》》》》》》》年龄段分割线ageMap【"+j+"】《《《《《《《《《《");
            mage = Words.ageCountMap.get("ageMap["+j+"]");
            for (String word : mage.keySet()) {
                System.out.println(word + "--" + mage.get(word));
            }
        }
    }

    /**
     * 统计公共词
     * @throws IOException
     */
    @Test
    public void commonCountWords()throws IOException {
        Map<String, Long> map = new HashMap<>();

        map.put("money", 0l);
        map.put("job", 0l);
        map.put("sports", 0l);
        map.put("tv", 0l);
        map.put("sleep", 0l);
        map.put("eating", 0l);
        map.put("sex", 0l);
        map.put("family", 0l);
        map.put("friends", 0l);
        String dir = "D:\\2019秋专业综合课程设计数据集\\3-博客作者身份分析\\blogs2";
        File dirFile = new File(dir);
        String[] list = null;
        if (null != dirFile && dirFile.isDirectory()) {
            list = dirFile.list();
        }
        int i = 0;
        BufferedReader reader = null;
        for (String s : list) {
            System.out.println("进度：" + ++i);
            reader = new BufferedReader(new FileReader(dir + "\\" + s));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.equalsIgnoreCase("<Blog>") || line.equalsIgnoreCase("</Blog>")
                        || line.contains("<date>") || line.contains("</date>")
                        || line.contains("<post>") || line.contains("</post>")) {

                } else {
                    String[] spilit = line.split(" ");
                    for (String s1 : spilit) {
                        if (s1.equalsIgnoreCase("money")) {
                            map.put("money", map.get("money") + 1);
                        } else if (s1.equalsIgnoreCase("job")) {
                            map.put("job", map.get("job") + 1);
                        } else if (s1.equalsIgnoreCase("sports")) {
                            map.put("sports", map.get("sports") + 1);
                        } else if (s1.equalsIgnoreCase("tv")) {
                            map.put("tv", map.get("tv") + 1);
                        } else if (s1.equalsIgnoreCase("sleep")) {
                            map.put("sleep", map.get("sleep") + 1);
                        } else if (s1.equalsIgnoreCase("eating")) {
                            map.put("eating", map.get("eating") + 1);
                        } else if (s1.equalsIgnoreCase("sex")) {
                            map.put("sex", map.get("sex") + 1);
                        } else if (s1.equalsIgnoreCase("family")) {
                            map.put("family", map.get("family") + 1);
                        } else if (s1.equalsIgnoreCase("friends")) {
                            map.put("friends", map.get("friends") + 1);
                        }
                    }
                }
            }
        }
        for (String words : map.keySet()) {
            System.out.println(words + "--" + map.get(words));
        }
    }

}

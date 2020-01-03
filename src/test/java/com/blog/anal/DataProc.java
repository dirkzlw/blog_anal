package com.blog.anal;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Ranger
 * @create 2020-01-02 14:57
 */
public class DataProc {

    @Test
    public void XmlProc() throws IOException {

        String dir = "C:\\Users\\zhouliwei\\Desktop\\综合课设\\blogs";
        String dir2 = "C:\\Users\\zhouliwei\\Desktop\\综合课设\\blogs2";
        File dirFile = new File(dir);

        if (dirFile.isDirectory()){
            String[] list = dirFile.list();
            BufferedReader reader = null;
            BufferedWriter writer = null;
            for (String s : list) {
                File file = new File(dir + "\\" + s);
                File file2 = new File(dir2 + "\\" + s);
                if(!file2.exists())
                    file2.createNewFile();
                reader = new BufferedReader(new FileReader(file));
                writer = new BufferedWriter(new FileWriter(file2));
                String line;
                while ((line=reader.readLine())!=null){
                    if(line.contains("&")){
                        line = line.replace("&", " and ");
                    }
                    writer.write(line+"\n");
                    writer.flush();
                }
            }
            if(null!=writer)
                writer.close();
            if(null!=reader)
                reader.close();
        }
    }
}

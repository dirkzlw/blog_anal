package com.blog.anal;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Ranger
 * @create 2020-01-02 14:57
 */
public class DataProc {

    @Test
    public void XmlProc() throws IOException {

        String dir = "C:\\Users\\zhouliwei\\Desktop\\zhks\\blogs";
        String dir2 = "C:\\Users\\zhouliwei\\Desktop\\zhks\\blogs";
        File dirFile = new File(dir);

        if (dirFile.isDirectory()){
            String[] list = dirFile.list();
            BufferedReader reader = null;
            BufferedWriter writer = null;
            int i=0;
            for (String s : list) {
                System.out.println("进度："+ ++i);
                File file = new File(dir + "\\" + s);
                File file2 = new File(dir2 + "\\" + s);
                if(!file2.exists())
                    file2.createNewFile();
                reader = new BufferedReader(new FileReader(file));
                writer = new BufferedWriter(new FileWriter(file2));
                String line;
                while ((line=reader.readLine())!=null){
                    line = line.trim();
                    if(line.equals(""))
                        continue;
                    if(line.equals("<post>")){
                        writer.write(line+"\n\t");
                        continue;
                    }
                    if(line.contains("&")){
                        line = line.replace("&", " and ");
                    }
                    if (line.contains("<") || line.contains(">")) {
                        if(line.equalsIgnoreCase("<Blog>") || line.equalsIgnoreCase("</Blog>")
                        || line.contains("<date>") || line.contains("</date>")
                        || line.contains("<post>") || line.contains("</post>")){

                        } else {
                            line = line.replace(">", " ");
                            line = line.replace("<", " ");
                        }
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

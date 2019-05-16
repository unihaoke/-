package com.hzu.paper.Test;

import org.junit.Test;


import java.io.*;

public class PaperTest {


    @Test
    public void paperTest2()  {
        String a = "school";
        try {
            String[] args = new String[] { "python", "D:\\Python_workplace\\wsgipython\\paper.py", String.valueOf(a)};
            Process proc = Runtime.getRuntime().exec(args);// 执行py文件

            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            String line = null;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
            in.close();
            proc.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

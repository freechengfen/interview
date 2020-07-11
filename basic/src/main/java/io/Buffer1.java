package io;/*
@author : Administrator
@create : 2020-07-2020/7/11-23:24

*/

import java.io.*;

public class Buffer1 {

    public static void main(String[] args) {
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        try {
            File srcFile = new File("aa.txt");
            File desFile = new File("aa2.txt");

            FileReader fileReader = new FileReader(srcFile);
            FileWriter fileWriter = new FileWriter(desFile);

            bufferedReader = new BufferedReader(fileReader);
            bufferedWriter = new BufferedWriter(fileWriter);
            String read;
            while((read=bufferedReader.readLine())!=null){
                bufferedWriter.write(read);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(bufferedWriter!=null){
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if(bufferedReader!=null){

                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }



    }
}

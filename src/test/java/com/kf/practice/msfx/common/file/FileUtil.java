package com.kf.practice.msfx.common.file;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 * @author tangjinhui
 * @Description：
 * @date 2018/3/26
 */
public class FileUtil {


    public  static void download(File file,String urlStr) throws IOException{

        URL url = new URL(urlStr);
        HttpURLConnection connection = null;
        InputStream inputStream = null;
        OutputStream outputStream = null;

        try{
            connection  = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(30*1000);
            connection.setReadTimeout(60*1000);
            connection.setRequestProperty("User-Agent","...");

            inputStream = connection.getInputStream();
            byte[] buffer = new byte[4096];
            int len;
            outputStream = new FileOutputStream(file);
            while ((len = inputStream.read(buffer))!=-1){
                outputStream.write(buffer,0,len);
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(inputStream != null){
                inputStream.close();
            }
            if(outputStream!=null){
                outputStream.close();
            }
            if(connection!=null){
                connection.disconnect();
            }
        }



    }


}

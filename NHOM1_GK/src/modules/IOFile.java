package modules;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nhom1
 */
public class IOFile {
    
    public static ArrayList<String> convertFromString(String s){
        ArrayList<String> list = new ArrayList<>();
        String[] arr = s.split(" ");
        for(String num:arr){
            list.add(num);
        }
        return list;
    }
    
    public static String convertFromList(ArrayList<String> list){
        String result = "";
        for(String i:list){
            result+=(i+", ");
        }
        
        return result;
    }
    
    public static boolean isFileExist(String fileName){
        return new File(fileName).exists();
    }
    
    public static void saveFileCharacterStream(String filePath, String content){
        
        FileOutputStream fileOutputStream = null;
        BufferedWriter bufferedWriter = null;
        
        try {
            fileOutputStream = new FileOutputStream(filePath);
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream));
            bufferedWriter.write(content);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(IOFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(IOFile.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                bufferedWriter.close();
                fileOutputStream.close();
            } catch (IOException ex) {
                Logger.getLogger(IOFile.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    public static String readFileCharacterStream(String filePath){

        FileInputStream fileInputStream = null;
        BufferedReader bufferedReader = null;

        try {
            fileInputStream = new FileInputStream(filePath);
            bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            return bufferedReader.readLine();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(IOFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(IOFile.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                bufferedReader.close();
                fileInputStream.close();
            } catch (IOException ex) {
                Logger.getLogger(IOFile.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return "";
        
    }
    
    public static void saveFileByteStream(String filePath, String content){
        
        BufferedOutputStream bufferOut = null;
        
        try {
            OutputStream outputStream = new FileOutputStream(filePath);
            bufferOut = new BufferedOutputStream(outputStream);
            
            byte[] b = content.getBytes();
            bufferOut.write(b);
            bufferOut.flush();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(IOFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(IOFile.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (bufferOut != null) {
                try {
                    bufferOut.close();
                } catch (IOException ex) {
                    Logger.getLogger(IOFile.class.getName()).log(Level.SEVERE, null, ex);
                }
            }   
        }
        
    }
    
    public static String readFileByteStream(String filePath){

        BufferedInputStream bufferIn = null;
        String line="";
        try {
            InputStream inputStream = new FileInputStream(filePath);
 
            bufferIn = new BufferedInputStream(inputStream);
    
            int c;                    
            while ((c = bufferIn.read()) != -1) {
                line+=(char)c;
            }
            System.out.println("Line: "+line);
            return line;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(IOFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(IOFile.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (bufferIn != null) {
                try {
                    bufferIn.close();
                } catch (IOException ex) {
                    Logger.getLogger(IOFile.class.getName()).log(Level.SEVERE, null, ex);
                }
            }         
        }
        
        return "";
        
    }
    
}

package gti310.tp3.writer;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.LinkedList;
import sun.text.normalizer.UTF16;
public class ConcreteWriter implements Writer<ArrayList<String>>{
    @Override
    public void write(String filename, ArrayList<String>[] test) {
        try {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
                      new FileOutputStream(filename), "utf-8"));
            for (int i = 0 ; i < test.length ; i++){
                if(i != 0) {
            	writer.newLine();
                }
                for(String path : test[i]) {
                    writer.write(path + " ");
                }
            }
            writer.close();
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
}


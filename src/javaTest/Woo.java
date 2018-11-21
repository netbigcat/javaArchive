package feng;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Random;

public class Woo {
	public static void main(String[] args) throws IOException {
		File wo=new File("wo.txt");
		if(wo.exists()){
			wo.delete();
			//System.exit(0);
		}
		System.out.println("Not break");
         
       
        //int [] a = new int[]{1,2,3,4};
           try {
        	   wo.createNewFile();
               FileOutputStream fos = new FileOutputStream(wo);
               OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
              for(int ii=1;ii<=5;ii++){
            	  
               for(int i=1;i<1000000;i++) {
            	int x=ii;
            	   //int x=(int)(Math.random()*1000000);
            	  //int x = new Random().nextInt(9999);
            	  //int tt = new Random().nextInt(9999);
                   osw.write(x+"");
                   //osw.write(",");
                   //osw.write(tt+"");
                   //osw.write("\n");
              }
               osw.flush();}
           } catch (Exception e) {
               e.printStackTrace();
           }
       }
}

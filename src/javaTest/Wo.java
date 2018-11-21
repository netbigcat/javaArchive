package feng;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Wo {
	public static void main(String[] angs){
		String encoding = "UTF-8";//设置文件的编码！！
		
		File wo=new File("wo.txt");
		if(wo.exists()){
			wo.delete();
			//System.exit(0);
		}
		System.out.println("Not break");
		try {
			//wo.createNewFile();
			//FileOutputStream ww=new FileOutputStream(wo);
			//FileWriter wr=new FileWriter(wo);
			for(int i=1;i<10;i++){
				//int max=20;
		        //int min=10;
		        //Random random = new Random();		 
		        //int s = random.nextInt(max)%(max-min+1) + min;
		 
		        //byte buy[]=s;
		        //String str=new String();
		        //s.toString("ISO-8859-1");
		        //System.out.println(str);
		        
				//wr.write(i);
				//System.out.println();
				//wr.write("\r\n");
				String FileContent = "文件内容";
                
                    FileOutputStream fos = new FileOutputStream(wo);
                    OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
                    osw.write(FileContent);
                    osw.flush();
			}
			//wr.close();
			}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
}

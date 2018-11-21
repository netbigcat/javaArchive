package mysqltomysql;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Mthtm {
	public static void main(String[] args){		
		//String command = "sqoop import --connect jdbc:mysql://172.18.51.115:3306/koala --username root --password root --table ks_param --fields-terminated-by '#'";
		String command = "ls";
		Runtime run = Runtime.getRuntime();
		try {  
            Process p = run.exec(command);// 启动另一个进程来执行命令  
            BufferedInputStream in = new BufferedInputStream(p.getInputStream());  
            BufferedReader inBr = new BufferedReader(new InputStreamReader(in));  
            String lineStr;  
            while ((lineStr = inBr.readLine()) != null)  
                //获得命令执行后在控制台的输出信息  
                System.out.println(lineStr);// 打印输出信息  
            //检查命令是否执行失败。  
            if (p.waitFor() != 0) {  
                if (p.exitValue() == 1)//p.exitValue()==0表示正常结束，1：非正常结束  
                    System.err.println("命令执行失败!");  
            }  
            inBr.close();  
            in.close();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
	}
}

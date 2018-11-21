package mysqltomysql;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test8 {
	public static void main(String[] args){
		//String command = "ls /";
		String command = "sqoop import --connect jdbc:mysql://172.18.51.115:3306/koala --username root --password root --table ks_param --fields-terminated-by '#' --target-dir /mysql";
		try{
			String s = null;
			Process p = Runtime.getRuntime().exec(command);
			BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
			BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));
			while((s = stdInput.readLine()) != null){
				System.out.println(s);
			} 
			while((s = stdError.readLine()) != null){
				System.out.println(s);
			}
		}catch(IOException e){
				e.printStackTrace();
				System.exit(1);
		
			
		
		}
	}
}
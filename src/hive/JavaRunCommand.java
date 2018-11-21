package mysqltomysql;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JavaRunCommand {
	public static void main(String[] args){
		String command = "ls /";
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
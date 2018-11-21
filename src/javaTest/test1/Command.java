package test1;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Command {
	
	public static void main(String[] args) throws IOException{

String sql="select * from test;";
String export="sqoop export -connect \"jdbc:mysql://172.18.51.115:3306/koala?useUnicode=true&characterEncoding=utf-8\" -table test -fields-terminated-by '\\001' -export-dir /home/cloud/hive/warehouse/test -username root -password root";
List<String> command = new ArrayList<String>();  
  
command.add("javaTest");
command.add("-e");  
command.add(sql);  
  
List<String> results = new ArrayList<String>();  
ProcessBuilder hiveProcessBuilder = new ProcessBuilder("sqoop export --connect \"jdbc:mysql://172.18.51.115:3306/koala?useUnicode=true&characterEncoding=utf-8\" -table test -fields-terminated-by '\\001' -export-dir /home/cloud/hive/warehouse/test -username root -password root");  
Process hiveProcess = hiveProcessBuilder.start();  
//Process exportcommand = new ProcessBuilder("sqoop export").start();
//ProcessBuilder hive = new ProcessBuilder("ls");  
//Process hiveP = hive.start();


BufferedReader br = new BufferedReader(new InputStreamReader(  
        hiveProcess.getInputStream()));  
String data = null;  
while ((data = br.readLine()) != null) {
	System.out.println(data);
    results.add(data);  
		}

}

}
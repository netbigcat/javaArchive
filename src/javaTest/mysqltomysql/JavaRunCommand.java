package mysqltomysql;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JavaRunCommand {

    public static void main(String[] args) {
        String s = null;
        try {
            //Process p = Runtime.getRuntime().exec("sqoop import --connect jdbc:mysql://172.18.51.115:3306/koala --username root --password root --table ks_param --fields-terminated-by '#' -target-dir /mysql");
        		Process p = Runtime.getRuntime().exec("ls /");
        		BufferedReader stdInput = new BufferedReader(new InputStreamReader(p.getInputStream()));
            BufferedReader stdError = new BufferedReader(new InputStreamReader(p.getErrorStream()));
            //从命令行打印出输出结果
            System.out.println("标准输出命令\n");
            while ((s = stdInput.readLine()) != null) {
                System.out.println(s);
            }

            System.out.println("标准错误的输出命令(如果存在):\n");
            while ((s = stdError.readLine()) != null) {
                System.out.println(s);
            }
            System.exit(0);
        } catch (IOException e) {
            System.out.println("异常发生: ");
            e.printStackTrace();
            System.exit(1);
        }
        
    }
}
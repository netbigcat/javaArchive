import java.math.*;
import java.math.BigInteger;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
public class NeiBu {


	static String num="1";
	static String jieguo;
	public static void main(String[] args) throws IOException {
		
		for(int i=1;i<=100000;i++){
			num=num+"7";
		}	
		jieguo=BigIntegerGet.getMultiply(num,num);
	
		
		File wo=new File("wo.txt");
		if(wo.exists()){
			wo.delete();
		}
		
           try {
        	   wo.createNewFile();
               FileOutputStream fos = new FileOutputStream(wo);
               OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
             
                   osw.write(jieguo);
               osw.flush();
           } catch (Exception e) {
               e.printStackTrace();
           }

	}

}

class BigIntegerGet
{
    public static String getAdd(String Str1,String Str2){
        String Str3=new String();
        BigInteger BigInt1=new BigInteger(Str1);
        BigInteger BigInt2=new BigInteger(Str2);
        BigInt1=BigInt1.add(BigInt2);//加
        Str3=BigInt1.toString();
        return Str3;
    }



public static String getMultiply(String Str1,String Str2){
    String Str3=new String();
    BigInteger BigInt1=new BigInteger(Str1);
    BigInteger BigInt2=new BigInteger(Str2);
    BigInt1=BigInt1.multiply(BigInt2);//乘
    Str3=BigInt1.toString();       
    return Str3;
}
}








package feng;

import java.sql.Date;
import java.text.SimpleDateFormat;

import org.apache.hadoop.hive.ql.exec.UDF;

public class Tdd extends UDF {
	public String evaluate(String num){
		Date d=new Date(Long.decode(num));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:MM:SS");
		return sdf.format(d);
	}
}
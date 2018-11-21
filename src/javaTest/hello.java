package feng;

import org.apache.hadoop.hive.ql.exec.UDF;
public class hello extends UDF {
    public String evaluate(String str) {

        try {

            return "HelloWorld " + str;

        } catch (Exception e) {

            return null;

        }
    }
}
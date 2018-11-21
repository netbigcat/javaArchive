package feng;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;


public class Dedup {
	public static class Map extends Mapper<Object,Text,Text,Text>{
		private static Text line=new Text();
		public void map(Object key,Text value,Context context)
		throws IOException,InterruptedException{
		line=value;
		context.write(line,new Text(""));
}

}


public static class Reduce extends Reducer <Text,Text,Text,Text>{
	public  void reduce (Text key ,Iterable<Text> values,Context context){
	try {
		context.write(key,new Text(""));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}
}

public static void main(String[] args) throws Exception{
	Configuration conf = new Configuration();
	Job job=new Job(conf,"Dedup");
	job.setJarByClass(Dedup.class);
	job.setMapperClass(Map.class);
	job.setCombinerClass(Reduce.class);
	job.setReducerClass(Reduce.class);
	job.setOutputValueClass(Text.class);
	job.setOutputKeyClass(Text.class);
	FileInputFormat.addInputPath(job,new Path(args[0]));
	FileOutputFormat.setOutputPath(job,new Path(args[1]));
	System.exit(job.waitForCompletion(true)?0:1);





}










}


package feng;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class Score{
	public  class Map extends Mapper<LongWritable,Text,Text,IntWritable>{
		public void map(LongWritable key,Text value) throws IOException,
		InterruptedException{
			String line = value.toString();
			
			
		}
	}
}
package feng;

import java.io.IOException;
import java.util.Iterator;
import java.util.StringTokenizer;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;


public class STjoin{
	public static int time=0;
	public static class Map extends Mapper <Object,Text,Text,Text>{
		public void map(Object key,Text value,Context context) throws 
		IOException,InterruptedException{
			String childname=new String();
			String parentname=new String();
			String relationtype=new String();
			StringTokenizer itr= new StringTokenizer(value.toString());
			String[] values=new String[2];
			int i=0;
			while(itr.hasMoreTokens()){
				values[i]=itr.nextToken();
				i++;
			}
			
			if (values[0].compareTo("child")!=0){
				childname=values[0];
				parentname=values[1];
				
				relationtype="1";
				context.write(new Text(values[1]),new Text(relationtype+
						"+"+childname+"+"+parentname));
				relationtype="2";
				context.write(new Text(values[0]),new Text(relationtype+
						"+"+childname+"+"+parentname));
			
			}	
		}
	
	}
	public static class Reduce extends Reducer <Text,Text,Text,Text>{
		public void reduce(Text key,Iterable<Text>values,Context context)
		throws IOException,InterruptedException{
			if (time == 0){
				context.write(new Text("grandchild"),new Text("grandparent"));
				time++;
				
			}
			int grandchildnum=0;
			String[] grandchild = new String[10];
			int grandparentnum=0;
			String[] grandparent = new String[10];
			
			Iterator ite = values.iterator();
			while (ite.hasNext()){
				String record = ite.next().toString();
				int len = record.length();
				int i=2;
				if (len == 0){
					continue;
				}
				char relationtype = record.charAt(0);
				
				String childname = new String();
				String parentname = new String();
				
				while ( record.charAt(i) != '+'){
					childname+=record.charAt(i);
					i++;
				}
				i++;
				while (i < len){
					parentname += record.charAt(i);
					i++;
					
				}
				if ( relationtype == '1'){
					grandchild[grandchildnum]=childname;
					grandchildnum++;
				}
				if ( relationtype == '2'){
					grandparent[grandparentnum] = parentname;
					grandparentnum++;
				}
				if ( grandchildnum != 0 && grandparentnum!= 0 ){
					for(int m=0; m < grandchildnum ; m++){
						for ( int n=0;n < grandparentnum; n++){
							context.write(new Text(grandchild[m]),new Text(
									grandparent[n]));
						}
						
					}
				}
				
				
				
				
			}
			
			
			
			
		}
	}
	
	public static void main(String[] args)throws Exception{
		Configuration conf = new Configuration();
		conf.set("mapred.jar","STjoin.jar");
		Job job = new Job(conf,"STjoin");
		job.setJarByClass(STjoin.class);
		job.setMapperClass(Map.class);
		job.setReducerClass(Reduce.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(Text.class);
		FileInputFormat.addInputPath(job,new Path(args[0]));
		FileOutputFormat.setOutputPath(job,new Path(args[1]));
		System.exit(job.waitForCompletion(true)?0:1);
	}
	
	
	
}

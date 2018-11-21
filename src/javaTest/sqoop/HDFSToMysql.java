package sqoop;

import org.apache.sqoop.client.SqoopClient;
import org.apache.sqoop.model.MDriverConfig;
import org.apache.sqoop.model.MFromConfig;
import org.apache.sqoop.model.MJob;
import org.apache.sqoop.model.MLink;
import org.apache.sqoop.model.MLinkConfig;
import org.apache.sqoop.model.MSubmission;
import org.apache.sqoop.model.MToConfig;
import org.apache.sqoop.submission.counter.Counter;
import org.apache.sqoop.submission.counter.CounterGroup;
import org.apache.sqoop.submission.counter.Counters;
import org.apache.sqoop.validation.Status;

public class HDFSToMysql {
	public static void main(String[] args) {
		sqoopTransfer();
	}
	public static void sqoopTransfer() {
		

		
		//初始化
		String url = "http://172.18.51.126:12000/sqoop/";
		SqoopClient client = new SqoopClient(url);
		client.setServerUrl(url);

    	//创建一个源链接 HDFS
  		//long fromConnectorId = 1;
		MLink fromLink = client.createLink("hdfs-connector");
		fromLink.setName("HDFS");
		fromLink.setCreationUser("cloud");
		MLinkConfig fromLinkConfig = fromLink.getConnectorLinkConfig();
		fromLinkConfig.getStringInput("linkConfig.uri").setValue("hdfs://172.18.51.126:9000/");
		Status fromStatus = client.saveLink(fromLink);
		if(fromStatus.canProceed()) {
		 System.out.println("创建HDFS Link成功，ID为: " + fromLink.getPersistenceId());
		} else {
		 System.out.println("创建HDFS Link失败");
		}
		

		 
		//创建一个目的地链接 JDBC
		//long toConnectorId = 2;
		MLink toLink = client.createLink("generic-jdbc-connector");
		toLink.setName("JDBC");
		toLink.setCreationUser("cloud");
		MLinkConfig toLinkConfig = toLink.getConnectorLinkConfig();
		toLinkConfig.getStringInput("linkConfig.connectionString").setValue("jdbc:mysql://172.18.51.126:3306/test");
		toLinkConfig.getStringInput("linkConfig.jdbcDriver").setValue("com.mysql.jdbc.Driver");
		toLinkConfig.getStringInput("linkConfig.username").setValue("javaTest");
		toLinkConfig.getStringInput("linkConfig.password").setValue("javaTest");
		Status toStatus = client.saveLink(toLink);
		if(toStatus.canProceed()) {
		 System.out.println("创建JDBC Link成功，ID为: " + toLink.getPersistenceId());
		} else {
		 System.out.println("创建JDBC Link失败");
		}
	
/*
		
		//创建一个任务
		//long fromLinkId = fromLink.getPersistenceId();
		//long toLinkId = toLink.getPersistenceId();
		MJob job = client.createJob("HDFS","JDBC");
		job.setName("HDFS to MySQL job");
		job.setCreationUser("cloud");
		//设置源链接任务配置信息
		MFromConfig fromJobConfig = job.getFromJobConfig();
		fromJobConfig.getStringInput("fromJobConfig.inputDirectory").setValue("/home/cloud/hive/warehouse/test");
		
		//创建目的地链接任务配置信息
		MToConfig toJobConfig = job.getToJobConfig();
		toJobConfig.getStringInput("toJobConfig.schemaName").setValue("test");
		toJobConfig.getStringInput("toJobConfig.tableName").setValue("test");
		//toJobConfig.getStringInput("fromJobConfig.partitionColumn").setValue("id");
		//set the driver config values
		//MDriverConfig driverConfig = job.getDriverConfig();
		//driverConfig.getStringInput("throttlingConfig.numExtractors").setValue("3");//这句还没弄明白
		Status status = client.saveJob(job);
		if(status.canProceed()) {
		 System.out.println("JOB创建成功，ID为: "+ job.getPersistenceId());
		} else {
		 System.out.println("JOB创建失败。");
		 client.deleteJob("HDFS to MySQL job");
		}
		

		

		//启动任务
		//long jobId = job.getPersistenceId();
		//client.deleteAllJobs();
		MSubmission submission = client.startJob("HDFS to MySQL job");
		System.out.println("JOB提交状态为 : " + submission.getStatus());
		while(submission.getStatus().isRunning() && submission.getProgress() != -1) {
		  System.out.println("进度 : " + String.format("%.2f %%", submission.getProgress() * 100));
		  //三秒报告一次进度
		  try {
			Thread.sleep(3000);
		  } catch (InterruptedException e) {
			e.printStackTrace();
		  }
		}
		System.out.println("JOB执行结束... ...");
		System.out.println("Hadoop任务ID为 :" + submission.getExternalJobId());
		Counters counters = submission.getCounters();
		if(counters != null) {
		  System.out.println("计数器:");
		  for(CounterGroup group : counters) {
		    System.out.print("\t");
		    System.out.println(group.getName());
		    for(Counter counter : group) {
		      System.out.print("\t\t");
		      System.out.print(counter.getName());
		      System.out.print(": ");
		      System.out.println(counter.getValue());
		    }
		  }
		}
		
		//if(submission.getExceptionInfo() != null) {
		//	  System.out.println("Exception info : " +submission.getExceptionInfo());
		//	}
		//if(submission.getExceptionInfo() != null) {
		//  System.out.println("JOB执行异常，异常信息为 : " +submission.getExceptionInfo());
		//}
		System.out.println("HDFS通过sqoop传输数据到MySQL统计执行完毕");   */
	}  
}
	
	
	

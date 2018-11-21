package sqoop;

import org.apache.sqoop.client.SqoopClient;
import org.apache.sqoop.model.MSubmission;
import org.apache.sqoop.submission.counter.Counter;
import org.apache.sqoop.submission.counter.CounterGroup;
import org.apache.sqoop.submission.counter.Counters;

public class NewJob {
	public static void main(String[] args){
		
		String url = "http://172.18.51.126:12000/sqoop/";
		SqoopClient client = new SqoopClient(url);
		client.setServerUrl(url);
		
		//Job start
		MSubmission submission = client.startJob("jobName");
		System.out.println("Job Submission Status : " + submission.getStatus());
		if(submission.getStatus().isRunning() && submission.getProgress() != -1) {
		  System.out.println("Progress : " + String.format("%.2f %%", submission.getProgress() * 100));
		}
		System.out.println("Hadoop job id :" + submission.getExternalJobId());
		System.out.println("Job link : " + submission.getExternalLink());
		Counters counters = submission.getCounters();
		if(counters != null) {
		  System.out.println("Counters:");
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
		  //System.out.println("Exception info : " +submission.getExceptionInfo());
		//}


		//Check job status for a running job
		//MSubmission submission = client.getJobStatus("jobName");
		if(submission.getStatus().isRunning() && submission.getProgress() != -1) {
		  System.out.println("Progress : " + String.format("%.2f %%", submission.getProgress() * 100));
		}

	
		
	}

}

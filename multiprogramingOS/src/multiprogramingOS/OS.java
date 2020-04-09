package multiprogramingOS;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Scanner;;

public class OS {
	
	public static void main(String [] arg) {
	//int hardDisk=2 * 1024 * 1024;
	//int RAM= 192 * 1024;
	int jobID=0;
	String fileLocation="C:\\Users\\HP\\Desktop\\Level7\\os\\Jobs.txt";
	File file = new File(fileLocation);
	jobQueue<PCB> JQ=new jobQueue<PCB>(); 
	readyQueue<PCB> RQ=new readyQueue<PCB>();
	CPU cpu=new CPU();
	hardDisk HD=new hardDisk();
	RAM ram=new RAM();
	
	   try {
	   FileWriter FW=new FileWriter(file);
	   for(int i=0 ; i<=5 ; i++) {
		   Job job=new Job(jobID);
		   FW.write("The Job ID Is:"+job.getJID()+", The ECU Is:"+job.getECU()+", The EMR Is:"+job.getEMR()+"\n");
		  // System.out.println("The Job ID Is: "+job.getJID()+" The Expected ECU Is: "+job.getECU()+" The Expected Memory Requirment Is: "+job.getEMR());
		   jobID++;
	   }
	       FW.close();
	   }catch(Exception ex){
		   
	   }
	   System.out.println("after File");
	   JQ=HD.fullHD(fileLocation);
	   RQ=ram.fullRAM(JQ);
	   
	   
	     
	}

}

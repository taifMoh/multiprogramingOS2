package multiprogramingOS;

import java.io.BufferedReader;
import java.io.FileReader;

public class hardDisk {
	int hardDisk=2 * 1024 * 1024;
	jobQueue<PCB> JQ=new jobQueue<PCB>();
	
	
	public jobQueue<PCB> fullHD(String file){ 
	 try {
		   FileReader FR=new FileReader(file);
		   BufferedReader br=new BufferedReader(FR);
		   String Line;
		   while((Line=br.readLine())!=null) {
			   //System.out.println(Line);
			   int StartIndex1=Line.indexOf(":");
			   int EndIndex1=Line.indexOf(",");
			   String id=Line.substring(StartIndex1+1, EndIndex1);
			   
			   int StartIndex2=Line.indexOf(":",StartIndex1+1);
			   int EndIndex2=Line.indexOf(",",EndIndex1+1);
			   String ECU=Line.substring(StartIndex2+1, EndIndex2);
			   
			   int StartIndex3=Line.indexOf(":",StartIndex2+1);
			   String EMR=Line.substring(StartIndex3+1); 
			   
			   //System.out.println("Read From File: ");
			   //System.out.println(id+" "+ECU+" "+EMR);
			   
			   int EMRInt=Integer.parseInt(EMR);
			   
			        if(EMRInt<=hardDisk) {
			          PCB pcb=new PCB(Integer.parseInt(id),"New",Integer.parseInt(ECU),EMRInt,0,0,0);
			          NodeHD<PCB> pcb2=JQ.insert(pcb,EMRInt);
				      hardDisk=hardDisk-EMRInt;
				      System.out.println(" Size: "+JQ.size);
				      System.out.println("Job insert in Job Queue: ");
				      System.out.println("ID: "+pcb2.data.ID+" ECU: "+pcb2.data.ECU+" EMR: "+pcb2.data.EMR+" CUT: "+pcb2.data.CUT+" IRT: "+pcb2.data.IRT+" WT:"+pcb2.data.WT+ " State: "+pcb2.data.State);
				      //System.out.println("ID: "+pcb2.data.+" ECU: "+pcb2.data.ECU+" EMR: "+pcb2.data.EMR);
			         }
			   }
		   
		   br.close();
		   FR.close();
		   }catch(Exception ex){
			   
		   }
		   
		   //System.out.println(" PCB In Ready Queue: ");
		   //cpu.fullCPU(JQ);
		   
		   return JQ;
        }
}

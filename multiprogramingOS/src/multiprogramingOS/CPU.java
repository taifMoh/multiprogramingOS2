package multiprogramingOS;

public class CPU {
	
	int IOInter;
	int norIter;
	int abnormInter;
	int Interrupt=0;
	int RAM= 192 * 1024;
	jobQueue<Job> JQFromHD=new jobQueue<Job>(); 
	readyQueue<PCB> RQ=new readyQueue<PCB>();
	OS os=new OS();
	
	public void fullCPU(jobQueue<Job> JQ) {
		//JQFromHD=JQ;
		while(!JQ.empty()) {
			   NodeHD<Job> pcb2=JQ.remove ();
			   if(RAM>=pcb2.data.EMR) {
			   PCB pcb=new PCB(pcb2.data.JID,"New",pcb2.data.ECU,pcb2.data.EMR,0,0,0);
			   RQ.insert(pcb);
			   System.out.println("ID: "+pcb2.data.getJID()+" ECU: "+pcb2.data.getECU()+" EMR: "+pcb2.data.EMR+" The Size is: "+JQ.size);
			   RAM=RAM-pcb2.data.EMR;
			   }
		   }
		
		System.out.println("After insert:");
		
		while(!RQ.empty()) {
			System.out.println(" Size: "+RQ.size);
			   Node<PCB> pcb=RQ.remove ();
			   //RQ.insert(pcb2.data, pcb2.priority);
			   System.out.println("ID: "+pcb.data.ID+" ECU: "+pcb.data.ECU+" EMR: "+pcb.data.EMR+" CUT: "+pcb.data.CUT+" IRT: "+pcb.data.IRT+" WT:"+pcb.data.WT+ " State: "+pcb.data.State);
			   
		   }
	}
	
	public boolean IORequest(){
		IOInter = (int) Math.random()*20;
		if(IOInter>0 && IOInter <0.9999999999) {
			Interrupt++;
			return true;
		}
		return false;
	}
	
	public boolean  terminatesNorm(){
		norIter = (int )Math.random()*10;
		if(norIter>0 && norIter <0.9999999999) {
			Interrupt++;

			return true;
		}
		return false;
	}
	
	public boolean terminatesAN(){
		abnormInter =(int) Math.random()*5;
		if(abnormInter>0 && abnormInter <0.9999999999) {
			Interrupt++;

			return true;
		}
		return false;
	}

}

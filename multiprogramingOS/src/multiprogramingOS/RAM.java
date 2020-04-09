package multiprogramingOS;

public class RAM {
	
	int RAM= 192 * 1024;
	readyQueue<PCB> RQ=new readyQueue<PCB>();
	public readyQueue<PCB> fullRAM(jobQueue<PCB> JQ) {
		//JQFromHD=JQ;
		while(!JQ.empty()) {
			   NodeHD<PCB> pcb2=JQ.remove ();
			   if(RAM>=pcb2.data.EMR) {
			   PCB pcb=new PCB(pcb2.data.ID,"Ready",pcb2.data.ECU,pcb2.data.EMR,0,0,0);
			   RQ.insert(pcb);
			   System.out.println("ID: "+pcb2.data.ID+" ECU: "+pcb2.data.ECU+" EMR: "+pcb2.data.EMR+" CUT: "+pcb2.data.CUT+" IRT: "+pcb2.data.IRT+" WT:"+pcb2.data.WT+ " State: "+pcb2.data.State+" Size: "+RQ.size);
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
		return RQ;
	}

}

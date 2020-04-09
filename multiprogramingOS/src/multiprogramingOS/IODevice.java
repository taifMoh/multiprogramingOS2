package multiprogramingOS;

public class IODevice {
 
	IOQueue<PCB> ioQueue=new IOQueue<PCB>();
	
	public IOQueue<PCB> insertToQueue(PCB pcb){
		ioQueue.insert(pcb);
		return ioQueue;
	} 
}

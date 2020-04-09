package multiprogramingOS;

public class PCB {
	
	int ID;
	String State;
	int EMR;
	int ECU;
	int CUT=0;
	int IRT=0;
	int WT=0;
	
	public PCB(int iD, String state, int eCU,int eMR, int cUT, int iRT, int wT) {
		super();
		ID = iD;
		State = state;
		EMR = eMR;
		ECU=eCU;
		CUT = cUT;
		IRT = iRT;
		WT = wT;
	}
	
	
}

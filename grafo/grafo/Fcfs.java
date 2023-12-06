package it.edu.iisgubbio.grafo;
public class Fcfs {
	String processi[];
	int tempoAttesa[];
	int tempoEsecuzione[];
	int TempoServizio[];
	public String Fcfs(String x) {
		return x;
	}
/**
 * 
 * prima riga: cosa fa la funzione
 * secpnda riga: i parametri e cosa rappresentano
 * terza riga: cosa ritorna 
 */
	
	
	
	
	
	
	
	/**
	 * set a name to the process
	 * @param void 
	 * @return void
	 */
	public void setProcessi () {
		for(int x=0;x<this.processi.length;x++) {
			this.processi[x]+=x;
		}
	}

	
	
	
	public int[] getTAttesa() {
		for(int x=0;x<tempoAttesa.length;x++) {
			tempoAttesa[x]=x;
		}
		return tempoAttesa;
	}
	//tempo esecuzione
	public void setTEsecuzione(int[] tEsecuzione) {
		this.tempoEsecuzione = tEsecuzione;
	}
	//tempoServizio
	public int[] getTs() {
		for (int x=0;x<TempoServizio.length;x++) {
			TempoServizio[x]=tempoEsecuzione[x]+tempoAttesa[x-1];
		}
		return TempoServizio;
	}
}
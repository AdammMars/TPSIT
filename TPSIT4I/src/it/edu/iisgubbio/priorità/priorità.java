package it.edu.iisgubbio.priorità;

public class priorità {
	int tServizioProcessi[];
	int nProcessiInseriti=0,nTempiInseriti=0;
	int tAttesaProcessi[];
	String nomeProcessi[];
	int tArrivoProcessi[];
	int tEsecuzioneProcessi[];
	int priorità[];

	
	public priorità(int nPosti) {
		nomeProcessi = new String[nPosti];
		tServizioProcessi=new int[nPosti];
		priorità=new int[nPosti];

		tEsecuzioneProcessi = new int[nPosti];
		tAttesaProcessi=new int[nPosti];
		tArrivoProcessi=new int[nPosti];
		for(int i=0;i<nPosti;i++) {
			tArrivoProcessi[i]=i;
		}
	}
	public void aggiungiProcesso(String nome, int tempo,int priorità) {
		nomeProcessi[nProcessiInseriti]=nome;
		this.priorità[nProcessiInseriti]=priorità;
		tEsecuzioneProcessi[nTempiInseriti]=tempo;
		nProcessiInseriti++;
		nTempiInseriti++;
	}
	public double esegui() {
		int ultimo=priorità.length-1;
		int appoggio,appoggioArrivo,appoggioPriorità;
		for(int i=0;i<=ultimo-1;i++){
			  for(int k=ultimo-1;k>=i;k--){
			    if(priorità[k]>priorità[k+1]){
			    appoggioPriorità=priorità[k];
			    priorità[k]=priorità[k+1];
			    priorità[k+1]=appoggioPriorità;
				      
			      appoggio=tEsecuzioneProcessi[k];
			      tEsecuzioneProcessi[k]=tEsecuzioneProcessi[k+1];
			      tEsecuzioneProcessi[k+1]=appoggio;
			      
			      appoggioArrivo=tArrivoProcessi[k];
			      tArrivoProcessi[k]=tArrivoProcessi[k+1];
			      tArrivoProcessi[k+1]=appoggioArrivo;
			    }
			  }
			}
		tServizioProcessi[0]=0;
		for(int i=1;i<nomeProcessi.length ;i++) {
			tServizioProcessi[i]=tServizioProcessi[i-1]+tEsecuzioneProcessi[i-1];
		}
		double sommaTempiAttesa=0;
		for(int i=0;i<nomeProcessi.length;i++) {
			sommaTempiAttesa=sommaTempiAttesa+tServizioProcessi[i]-tArrivoProcessi[i];
		}
		double media=sommaTempiAttesa/nomeProcessi.length;
		return media;
	}
	public static void main(String[] args) {
		priorità priorità= new priorità(4);
		priorità.aggiungiProcesso("0",8,1);
		priorità.aggiungiProcesso("1",3,2);
		priorità.aggiungiProcesso("2",8,1);
		priorità.aggiungiProcesso("3",6,3);
		System.out.println("Il valore medio del tempo di attesa è: "+priorità.esegui());
   }
	
}

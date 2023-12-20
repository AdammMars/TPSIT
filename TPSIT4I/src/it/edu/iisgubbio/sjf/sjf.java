package it.edu.iisgubbio.sjf;

public class sjf {
	int tServizioProcessi[];
	int nProcessiInseriti=0,nTempiInseriti=0;
	int tAttesaProcessi[];
	String nomeProcessi[];
	int tArrivoProcessi[];
	int tEsecuzioneProcessi[];

	
	public sjf(int nPosti) {
		nomeProcessi = new String[nPosti];
		tServizioProcessi=new int[nPosti];
		tEsecuzioneProcessi = new int[nPosti];
		tAttesaProcessi=new int[nPosti];
		tArrivoProcessi=new int[nPosti];
		for(int i=0;i<nPosti;i++) {
			tArrivoProcessi[i]=i;
		}
	}
	public void aggiungiProcesso(String nome, int tempo) {
		nomeProcessi[nProcessiInseriti]=nome;
		tEsecuzioneProcessi[nTempiInseriti]=tempo;
		nProcessiInseriti++;
		nTempiInseriti++;
	}
	public double esegui() {
		int ultimo=tEsecuzioneProcessi.length-1;
		int appoggio,appoggioArrivo;
		for(int i=0;i<=ultimo-1;i++){
			  for(int k=ultimo-1;k>=i;k--){
			    if(tEsecuzioneProcessi[k]>tEsecuzioneProcessi[k+1]){
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
		sjf sjf= new sjf(4);
	    sjf.aggiungiProcesso("0",5);
		sjf.aggiungiProcesso("1",3);
		sjf.aggiungiProcesso("2",8);
		sjf.aggiungiProcesso("3",6);
		System.out.println("Il valore medio del tempo di attesa è: "+sjf.esegui());
   }
	
}

package bowling;

/**
 * Cette classe a pour but d'enregistrer le nombre de quilles abattues lors des
 * lancés successifs d'<b>un seul et même</b> joueur, et de calculer le score
 * final de ce joueur
 */
public class SinglePlayerGame {
    public int total;
    public int cptStrike;
    public int cptSpare;
    public int cpt;
    public int tour;

	/**
	 * Constructeur
	 */
	public SinglePlayerGame() {
            this.total=0;
            this.cpt=0;
            this.cptSpare=0;
            this.cptStrike=0;
            this.tour=0;
	}

	/**
	 * Cette méthode doit être appelée à chaque lancé de boule
	 *
	 * @param nombreDeQuillesAbattues le nombre de quilles abattues lors de
	 * ce lancé
	 */
	public void lancer(int nombreDeQuillesAbattues) {
            this.tour+=1;
            
            if(this.tour>20){
                if(this.cptStrike>2){
                    this.total+=nombreDeQuillesAbattues;
                    this.cptStrike-=1;
                }
                this.total+=nombreDeQuillesAbattues;
                
            }else{
                if(this.cptStrike>0){
                    if(this.cptStrike>2){
                        this.total+=nombreDeQuillesAbattues*2;
                        this.cptStrike-=2;
                    }else{
                        this.total+=nombreDeQuillesAbattues;
                        this.cptStrike-=1;
                    }
                }
                if (this.cptSpare>0){
                    this.total+=nombreDeQuillesAbattues;
                    this.cptSpare-=1;
                }
                if(this.tour%2!=0){
                    if(nombreDeQuillesAbattues==10){
                        ///STRIKE///
                        this.total+=10;
                        this.cptStrike+=2;
                        this.tour+=1;
                    }else{
                        this.cpt+=nombreDeQuillesAbattues;
                        
                    }
                    
                }else{
                    if(this.cpt+nombreDeQuillesAbattues==10){
                        ///SPARE///
                        this.total+=this.cpt+nombreDeQuillesAbattues;
                        this.cpt=0;
                        this.cptSpare+=1;
                    }else{
                        this.cpt+=nombreDeQuillesAbattues;
                        this.total+=this.cpt;
                        this.cpt=0;
                    }
                }
                
                
                
                
            }

	}

	/**
	 * Cette méthode donne le score du joueur
	 *
	 * @return Le score du joueur
	 */
	public int score() {
            return this.total;
		//throw new UnsupportedOperationException("Pas encore implémenté");
	}
}

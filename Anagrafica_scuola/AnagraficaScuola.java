import java.util.ArrayList;

public class AnagraficaScuola {
    private ArrayList <Persona> anagrafica;

    public AnagraficaScuola() {
        this.anagrafica = new ArrayList<>();
    }

    public ArrayList<Persona> getAnagrafica() {
        return anagrafica;
    }

    public void setAnagrafica(ArrayList<Persona> anagrafica) {
        this.anagrafica = anagrafica;
    }

    @Override
    public String toString() {
        return "Anagrafica scuola: " + anagrafica;
    }

    public void addPersona(Persona persona){
        anagrafica.add(persona);
    }

    public double getSommaStipendi(){
        double somma = 0;
        for(Persona p : anagrafica){
            /*try{
                somma += ((Docente)p).getStipendio();
            }
            catch(Exception e){

            }*/
            if(p instanceof Docente){
                somma += ((Docente)p).getStipendio();
            }
            
        }
        return somma;
    }

    public ArrayList<Docente> getCdc(int nome, char sezione, String indirizzo){
        //ritorna l'arraylist dei docenti di una certa classe 
        ArrayList <Docente> Cdc = new ArrayList<>();
        
        for(Persona p : anagrafica){
            if(p instanceof Docente){ //se p è un'istanza di Docente
                Docente docente = (Docente)p;

                for(Classe classe : docente.getClassi()){
                    if(classe.getNome() == nome && classe.getSezione() == sezione && classe.getIndirizzo().equals(indirizzo)) {
                        Cdc.add(docente);
                    }
                }
            }
        }
        return Cdc;
    }

    

}

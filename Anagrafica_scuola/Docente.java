import java.util.ArrayList;

public class Docente extends Persona{
    private double stipendio;
    private ArrayList<Classe> classi;

    public Docente(String nome, String cognome, String codiceFiscale, double stipendio) {
        super(nome, cognome, codiceFiscale);
        this.stipendio = stipendio;
        this.classi = new ArrayList<>();
    }

    public double getStipendio() {
        return stipendio;
    }

    public void setStipendio(double stipendio) {
        this.stipendio = stipendio;
    }

    public ArrayList<Classe> getClassi() {
        return classi;
    }

    public void setClassi(ArrayList<Classe> classi) {
        this.classi = classi;
    }

    @Override
    public String toString() {
        return super.toString() + " Stipendio: " + stipendio;
    }

    public void addClasse(Classe classe){
        classi.add(classe);
    }
}

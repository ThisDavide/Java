public class Studente extends Persona{
    private Classe classe;

    public Studente(String nome, String cognome, String codiceFiscale, Classe classe) {
        super(nome, cognome, codiceFiscale);
        this.classe = classe;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    @Override
    public String toString() {
        return super.toString() + "Classe: " + classe;
    }
}

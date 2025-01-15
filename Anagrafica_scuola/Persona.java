public class Persona {
    private int codice; //calcolare in automatico
    private String nome;
    private String cognome;
    private String codiceFiscale;
    private static int incremento = 0;


    public Persona(String nome, String cognome, String codiceFiscale) {
        this.nome = nome;
        this.cognome = cognome;
        this.codiceFiscale = codiceFiscale;
        this.incremento++;
        this.codice = incremento;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCognome() {
        return cognome;
    }
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
    public String getCodiceFiscale() {
        return codiceFiscale;
    }
    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", cognome: " + cognome + ", codiceFiscale: " + codiceFiscale;
    }
}
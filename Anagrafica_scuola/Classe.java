public class Classe {
    private int nome;
    private char sezione;
    private String indirizzo;
    
    public Classe(int nome, char sezione, String indirizzo) {
        this.nome = nome;
        this.sezione = sezione;
        this.indirizzo = indirizzo;
    }

    public int getNome() {
        return nome;
    }

    public void setNome(int nome) {
        this.nome = nome;
    }

    public char getSezione() {
        return sezione;
    }

    public void setSezione(char sezione) {
        this.sezione = sezione;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", sezione: " + sezione + ", indirizzo: " + indirizzo;
    }   
}

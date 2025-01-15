import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Classe classe1 = new Classe(4, 'C', "Informatica");
        Classe classe2 = new Classe(3, 'A', "Meccanica");

        Docente docente1 = new Docente("Mario", "Rossi", "RSSMRA80A01H501Z", 2500);
        Docente docente2 = new Docente("Anna", "Bianchi", "BNCTNN80B01F205X", 2300);
        Docente docente3 = new Docente("Giuseppe", "Verdi", "VRDGSU80C01F205Y", 2700);
        Docente docente4 = new Docente("Lucia", "Gialli", "GLCLUC80D01H501X", 2200);
        Docente docente5 = new Docente("Federico", "Azzurri", "FDRFDC80A01H501W", 2600);

        Studente studente1 = new Studente("Luca", "Verdi", "VRDLUC80A01H501Y", classe1); 
        Studente studente2 = new Studente("Giulia", "Neri", "NRIGIA80B01F205W", classe2);
        Studente studente3 = new Studente("Marco", "Rossi", "MRCRSS80C01H501Z", classe2);
        Studente studente4 = new Studente("Alessandra", "Gialli", "ALSGIA80D01F205X", classe1);
        Studente studente5 = new Studente("Francesca", "Blu", "FRABLU80E01H501Y", classe2);

        AnagraficaScuola anagraficaScuola = new AnagraficaScuola();

        anagraficaScuola.addPersona(docente1);
        anagraficaScuola.addPersona(docente2);
        anagraficaScuola.addPersona(docente3);
        anagraficaScuola.addPersona(docente4);
        anagraficaScuola.addPersona(docente5);
        anagraficaScuola.addPersona(studente1);
        anagraficaScuola.addPersona(studente2);
        anagraficaScuola.addPersona(studente3);
        anagraficaScuola.addPersona(studente4);
        anagraficaScuola.addPersona(studente5);

        docente1.addClasse(classe2);
        docente2.addClasse(classe2);
        docente3.addClasse(classe1);
        docente4.addClasse(classe1);
        docente5.addClasse(classe2);

        
        System.out.println("Somma stipendi docenti: " + anagraficaScuola.getSommaStipendi());

        ArrayList <Docente> docentiClasse1 = anagraficaScuola.getCdc(4, 'C',"Informatica");

        System.out.println("Docenti della classe 4C Informatica:");
        for(Docente docente : docentiClasse1){
            System.out.println(docente);
        }

        ArrayList <Docente> docentiClasse2 = anagraficaScuola.getCdc(3, 'A',"Meccanica");

        System.out.println("Docenti della classe 3A Meccanica:");
        for(Docente docente : docentiClasse2){
            System.out.println(docente);
        }
    }
}

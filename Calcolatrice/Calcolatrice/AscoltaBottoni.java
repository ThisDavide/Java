import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;

public class AscoltaBottoni implements ActionListener{
    public String numCompleto = "0";
    public String primoNum = "";
    private String op = "";
    private String operator = "";
    private String outString = "";
    private JLabel outLabel;
    private double ris = 0;
    private int divisionePerZero = 0;
    private double valueOfRis = 0;
    private int flagEqual = 0;
    private int flagPoint = 0;

    public AscoltaBottoni(JLabel l){
        this.outLabel = l;
    }

    public void actionPerformed(ActionEvent e){
        JButton clickedButton = (JButton)e.getSource();
        String btnTxt = clickedButton.getText();

        //se viene premuto il tasto C vengono resettate tutte le variabili
        if(btnTxt.equals("C")){
            outLabel.setText("0");
            numCompleto = "";
            primoNum = "";
            op = "";
            outString = "";
            divisionePerZero = 0;
            ris = 0;
            valueOfRis = 0;
            flagEqual = 0;
            operator = "";
            flagPoint = 0;
        }
        //se premo un operatore
        else if(btnTxt.equals("+") || btnTxt.equals("-") || btnTxt.equals("x") || btnTxt.equals(":") || btnTxt.equals("x²") || btnTxt.equals("%") || btnTxt.equals("√") || btnTxt.equals("x!") || btnTxt.equals("x10ˣ")){
            //permetto di premere un operatore solo se all'interno di op non ce ne è già uno
            if(flagEqual == 0){
                op = "";
            }
            if(!op.equals("+") && !op.equals("-") && !op.equals("x") && !op.equals(":") && !op.equals("x²") && !op.equals("%") && !op.equals("√") && !op.equals("x!") && !op.equals("x10ˣ")){
                if(outString.equals("0") && numCompleto.equals("")){
                    outString = "";
                    outLabel.setText("0");
                }
                op = btnTxt;
                flagEqual = 1;
                outString += op;
                outLabel.setText(outString);
                primoNum = numCompleto;
                numCompleto = "";
                flagPoint = 0;

                //aggiorno la variabile ris (risultato) in base all'operatore
                switch(op){ 
                    case "+":
                        ris += Double.valueOf(primoNum);
                        break;
                    case "-":
                        if(ris == 0){
                            ris = Double.valueOf(primoNum) - ris;
                        }
                        else{
                            ris = ris - Double.valueOf(primoNum);
                        }
                        break;
                    case "x":
                        if(ris == 0){
                            ris = 1;
                        }
                        ris *= Double.valueOf(primoNum);
                        break;
                    case ":":
                        break;
                    case "x²":
                        ris = Double.valueOf(primoNum) * Double.valueOf(primoNum);
                        break;
                    case "√":
                        ris = Math.sqrt(Double.valueOf(primoNum));
                        break;
                    case "%":
                        ris = (Double.valueOf(primoNum)) / 100;
                        break;
                    case "x!":
                        double i = 0;
                        double fattoriale = 1;
                        for(i = (Double.valueOf(primoNum)); i >= 1; i--){
                            fattoriale *= i;
                        }
                        ris = fattoriale;
                        break;
                    case "x10ˣ":
                        break;
                    default:
                        outLabel.setText("Errore");
                        break;
                }
            }
        }
        //se ho premuto +/- cambio il segno corrente del numero
        else if(btnTxt.equals("+/-")){
            double temp = Double.valueOf(numCompleto) * (-1);
            numCompleto = String.valueOf(temp);
            outString = String.valueOf(temp);
            outLabel.setText(outString);
        }
        //se premo il pi greco stampo il suo valore
        else if(btnTxt.equals("π")){
            double temp = 0;
            temp = (Math.PI);
            numCompleto = String.valueOf(temp);
            outString += String.valueOf(temp);;
            outLabel.setText(outString);
        }
        else if(btnTxt.equals(",")){
            if(!outString.equals(".") && flagPoint != 1){
                if(outString.equals("")){
                    outString += 0;
                }
                numCompleto += ".";
                outString += ".";
                outLabel.setText(outString);
            }
            flagPoint = 1;
        }
        //se premo l'uguale eseguo il calcolo finale
        else if(btnTxt.equals("=")){
            switch(operator){ 
                case "+":
                    ris += Double.valueOf(numCompleto);
                    break;
                case "-":
                    ris -= Double.valueOf(numCompleto);
                    break;
                case "x":
                    ris *= Double.valueOf(numCompleto);
                    break;
                case ":":
                if(Double.valueOf(numCompleto) == 0){
                    divisionePerZero = 1;
                }
                else{
                    ris = Double.valueOf(primoNum) / Double.valueOf(numCompleto); 
                }
                    break;
                case "x10ˣ":
                    ris = Double.valueOf(primoNum) * Math.pow(10, Double.valueOf(numCompleto));
                    break;
            }
            if(divisionePerZero == 1){
                outLabel.setText("Errore");
            }
            else{
                outLabel.setText(String.valueOf(ris));
                //riutilizzo il risultato per il calcolo successivo 
                primoNum = String.valueOf(ris);
                outString = String.valueOf(ris);
            }
            numCompleto = primoNum;
            divisionePerZero = 0;
            valueOfRis = ris;
            ris = 0;
            flagEqual = 0;
            flagPoint = 0;
        }
        else{
            if(outString.equals(String.valueOf(valueOfRis))){
                numCompleto = "";
                primoNum = "";
                op = "";
                outString = "";
                divisionePerZero = 0;
                ris = 0;
                valueOfRis = 0;
                flagEqual = 0;
                flagPoint = 0;
            }
            numCompleto += btnTxt;
            outString += btnTxt;
            outLabel.setText(outString);
            operator = op;
        } 
    }
}
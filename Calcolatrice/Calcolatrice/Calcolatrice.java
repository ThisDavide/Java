import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.border.LineBorder;
import javax.swing.*;

public class Calcolatrice extends JFrame{
    public Calcolatrice(){
        super();
        creaCalcolatrice();
    }

    public void creaCalcolatrice(){
        String[] arrSimboli = {"x²", "x!", "√", "C", "π", "%", "x10ˣ", "+", "7", "8", "9", "-", "4", "5", "6", "x", "1", "2", "3", ":", "+/-", "0", ",", "="};
        
        JPanel panelButtons = new JPanel();
        this.add(panelButtons, BorderLayout.CENTER);
        panelButtons.setBackground(Color.black);
        panelButtons.setLayout(new GridLayout(6, 4));

        JPanel panelResult = new JPanel();
        this.add(panelResult, BorderLayout.NORTH);
        panelResult.setPreferredSize(new Dimension(350, 100));
        panelResult.setBackground(Color.black);
        
        JLabel labelResult = new JLabel();
        labelResult.setText("0");
        
        panelResult.add(labelResult);
        panelResult.setLayout((LayoutManager) new FlowLayout(FlowLayout.RIGHT)); //imposta il testo del pannello allineato a destra
        labelResult.setForeground(Color.white);
        labelResult.setFont(new Font("Arial", Font.BOLD, 30));
        
        AscoltaBottoni ascoltaBottoni = new AscoltaBottoni(labelResult);

        JButton[] arrButtons = new JButton[24];

        for (int i = 0; i < 24; i++){                        
			arrButtons[i] = new JButton(arrSimboli[i]); //assegno il simbolo al bottone
            arrButtons[i].setFont(new Font("Arial", Font.BOLD, 30));
            arrButtons[i].setBackground(Color.darkGray);
            arrButtons[i].setForeground(Color.white);
            arrButtons[i].setBorder(new LineBorder(Color.BLACK, 2));
            arrButtons[i].addActionListener(ascoltaBottoni);
            arrButtons[i].setFocusPainted(false);
			panelButtons.add(arrButtons[i]);
		}
        arrButtons[23].setBackground(new Color(130, 190, 250)); //colore tasto =
        arrButtons[6].setFont(new Font("Arial", Font.BOLD, 25));

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Calcolatrice");
		setSize(350, 500);
		setVisible(true); 
    }
}
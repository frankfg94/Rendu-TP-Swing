/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examtpconverter;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Gator
 */
public class converterFrame extends JFrame {
    
                // Conversion des celsius en fahrenheit 
            private double GetFahrenheit(double celsius) {
                return celsius * (9.0/5.0) + 32.0;
            }
            
            // On regles les parametres de notre frame
            private void ConfigureFrame(JPanel panel)
            {
                   getContentPane().add(panel);
                     setBounds(0,0,300,70);
                     setLocationRelativeTo(null);
                        setResizable(false);
                         setTitle("Convert Celsius to Fahrenheit");
            }
            
            
            
    public void start()
    {
        
        // Le panel qui va contenir tous nos objets
        JPanel p = new JPanel();
        
        // On crée un grid layout de 4 cases (2 lignes et 2 colonnes) afin de positionner nos éléments
        p.setLayout(new GridLayout(2,2));
        ConfigureFrame(p);
        
        // On met à 10 le nombre de colonnes afin d'avoir 
        JTextField celsiusField = new JTextField("",10);
        
        // On crée nos contrôles swings qui vont être placés dans le JPanel
        JButton but = new JButton();
        but.setText("Convert");
        JLabel lblCelsius = new JLabel("Celsius");
        JTextArea textField = new JTextArea("? Fahrenheit");
        but.addActionListener(new ActionListener() {
           
            @Override
            
            // Quand on clique sur le bouton "Convert" on va convertir en farenheit le texte de celsiusField
            public void actionPerformed(ActionEvent e) {
                // On utilise un try catch afin de de ne pas faire planter le programme si l'utilisateur entre autre chose
                // qu'un nombre (un texte)
                try 
                {
                    // Conversion en double du texte du champ de celsius
                    double celsius =  Double.parseDouble(celsiusField.getText());
                    
                    // On affiche la conversion calculée dans la zone de texte pour les Fahrenheit
                textField.setText( String.valueOf(GetFahrenheit(celsius)) + " Fahrenheit");
                }
                catch(NumberFormatException ex)
                {
                    ex.printStackTrace();
                }
                
            }

        });
        
        // Informations additionnelles
        celsiusField.setToolTipText("Entrez votre valeur en Celsius à convertir");
        
        // On ajoute à notre panneau tous nos contrôles
        p.add(celsiusField);
        p.add(lblCelsius);
        p.add(but);
        p.add(textField);
        
        // On ferme le programme si on ferme la JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }
}

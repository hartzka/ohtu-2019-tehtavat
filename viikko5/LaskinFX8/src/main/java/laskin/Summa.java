package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Summa extends Komento {
    private int data;
    public Summa(TextField tulosKentta, TextField syoteKentta, Button nollaa, Button undo, Sovelluslogiikka sovelluslogiikka) {
        super(tulosKentta, syoteKentta, nollaa, undo, sovelluslogiikka);
    }

    @Override
    public void suorita() {
        try {
            data = Integer.parseInt(syoteKentta.getText());
            sovelluslogiikka.plus(data);
        } catch (Exception e) {

        }
        int laskunTulos = sovelluslogiikka.tulos();
        syoteKentta.setText("");
        tulosKentta.setText("" + laskunTulos);
        
        if ( laskunTulos==0) {
            nollaa.disableProperty().set(true);
        } else {
            nollaa.disableProperty().set(false);
        }
        undo.disableProperty().set(false);
    }  

    @Override
    public void peru() {
        try {
            sovelluslogiikka.miinus(data);
        } catch (Exception e) {

        }
        int laskunTulos = sovelluslogiikka.tulos();
        
        syoteKentta.setText("");
        tulosKentta.setText("" + laskunTulos);
        undo.disableProperty().set(true);
    }
}
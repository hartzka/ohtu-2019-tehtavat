package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Nollaa extends Komento {
    private int data;
    public Nollaa (TextField tulosKentta, TextField syoteKentta, Button nollaa, Button undo, Sovelluslogiikka sovelluslogiikka) {
        super(tulosKentta, syoteKentta, nollaa, undo, sovelluslogiikka);
    }

    @Override
    public void suorita() {
        try {
            data = Integer.parseInt(tulosKentta.getText());
        } catch (Exception e) {

        }
        sovelluslogiikka.nollaa();
        syoteKentta.setText("");
        tulosKentta.setText("0");
        undo.disableProperty().set(false);
    }

    @Override
    public void peru() {
        try {
            sovelluslogiikka.plus(data);
        } catch (Exception e) {

        }
        int laskunTulos = sovelluslogiikka.tulos();
        
        syoteKentta.setText("");
        tulosKentta.setText("" + laskunTulos);
        undo.disableProperty().set(true);
    }  
}
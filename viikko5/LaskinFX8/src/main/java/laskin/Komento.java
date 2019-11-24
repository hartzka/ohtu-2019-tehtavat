package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public abstract class Komento {
    protected TextField tulosKentta;
    protected TextField syoteKentta;
    protected Button nollaa;
    protected Button undo;
    protected Sovelluslogiikka sovelluslogiikka;

    public Komento(TextField tulosKentta, TextField syoteKentta, Button nollaa, Button undo, Sovelluslogiikka sovelluslogiikka) {
        this.tulosKentta = tulosKentta;
        this.syoteKentta = syoteKentta;
        this.nollaa = nollaa;
        this.undo = undo;
        this.sovelluslogiikka = sovelluslogiikka;
    }

    public abstract void suorita();
    public abstract void peru();
}

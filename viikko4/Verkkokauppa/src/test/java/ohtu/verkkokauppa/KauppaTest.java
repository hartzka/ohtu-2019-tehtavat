package ohtu.verkkokauppa;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class KauppaTest {

    Pankki pankki;
    Viitegeneraattori viite;
    Varasto varasto;
    Kauppa k;

    @Before
    public void setUp() {
        pankki = mock(Pankki.class);
        viite = mock(Viitegeneraattori.class);
        varasto = mock(Varasto.class);
        k = new Kauppa(varasto, pankki, viite);
        when(viite.uusi()).thenReturn(42);
        when(varasto.saldo(1)).thenReturn(10); 
        when(varasto.haeTuote(1)).thenReturn(new Tuote(1, "maito", 5));       
        when(varasto.saldo(2)).thenReturn(10); 
        when(varasto.haeTuote(2)).thenReturn(new Tuote(2, "kurkku", 3));
        when(varasto.saldo(3)).thenReturn(0); //finkbrau on loppu!
        when(varasto.haeTuote(3)).thenReturn(new Tuote(3, "finkbrau", 1));


        k.aloitaAsiointi();
    }

    @Test
    public void ostoksenPaatyttyaPankinMetodiaTilisiirtoKutsutaan() {
       k.lisaaKoriin(1);     // ostetaan tuotetta numero 1 eli maitoa
       k.tilimaksu("pekka", "12345");
       verify(pankki).tilisiirto(anyString(), anyInt(), anyString(), anyString(),anyInt());   
    }

    @Test
    public void ostoksenPaatyttyaPankinMetodiaTilisiirtoKutsutaanOikeillaParametreilla() {
        k.lisaaKoriin(1);     // ostetaan tuotetta numero 1 eli maitoa
        k.tilimaksu("pekka", "12345");
        verify(pankki).tilisiirto(eq("pekka"), eq(42), eq("12345"), eq("33333-44455"), eq(5));   
    }

    @Test
    public void kahdenEriTuotteenOstonPaatyttyaPankinMetodiaTilisiirtoKutsutaanOikeillaParametreilla() {
        k.lisaaKoriin(1);     // ostetaan tuotetta numero 1 eli maitoa
        k.lisaaKoriin(2);     // ostetaan kurkkua!
        k.tilimaksu("pekka", "12345");
        verify(pankki).tilisiirto(eq("pekka"), eq(42), eq("12345"), eq("33333-44455"), eq(8));   
    }

    @Test
    public void kahdenSamanTuotteenOstonPaatyttyaPankinMetodiaTilisiirtoKutsutaanOikeillaParametreilla() {
        k.lisaaKoriin(1);     // ostetaan tuotetta numero 1 eli maitoa
        k.lisaaKoriin(1);
        k.tilimaksu("pekka", "12345");
        verify(pankki).tilisiirto(eq("pekka"), eq(42), eq("12345"), eq("33333-44455"), eq(10));   
    }

    @Test
    public void kahdenEriTuotteenJoistaToinenOnLoppuOstonPaatyttyaPankinMetodiaTilisiirtoKutsutaanOikeillaParametreilla() {
        k.lisaaKoriin(1);     // ostetaan tuotetta numero 1 eli maitoa
        k.lisaaKoriin(3);     // yritetaan ostaa finkbrauta joka on loppu
        k.tilimaksu("pekka", "12345");
        verify(pankki).tilisiirto(eq("pekka"), eq(42), eq("12345"), eq("33333-44455"), eq(5));   
    }
}


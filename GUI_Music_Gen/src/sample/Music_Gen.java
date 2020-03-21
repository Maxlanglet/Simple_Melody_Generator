package sample;

import jm.JMC;
import jm.music.data.Note;
import jm.music.data.Phrase;
import jm.util.Play;
import jm.util.Write;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Music_Gen {


    private int[] pitches;
    //Minor scales
    private int[] csm;
    private int[] cm;
    private int[] dm;
    private int[] dsm;
    private int[] em;
    private int[] fm;
    private int[] fsm;
    private int[] gm;
    private int[] gsm;
    private int[] am;
    private int[] asm;
    private int[] bm;
    //Major scales
    private int[] cs;
    private int[] c;
    private int[] d;
    private int[] ds;
    private int[] e;
    private int[] f;
    private int[] fs;
    private int[] g;
    private int[] gs;
    private int[] a;
    private int[] as;
    private int[] b;
    //Harmonic minor scales
    private int[] cshm;
    private int[] chm;
    private int[] dhm;
    private int[] dshm;
    private int[] ehm;
    private int[] fhm;
    private int[] fshm;
    private int[] ghm;
    private int[] gshm;
    private int[] ahm;
    private int[] ashm;
    private int[] bhm;


    private Note note = new Note();
    private Phrase phr = new Phrase();
    private int length = 8;
    private int tempo = 120;
    private int Mmh = 1; //0, 1 ou 2
    private boolean duplicates = false;//mieux comme ca en vrai, une chance sur 100 d'avoir repetition
    private double note_length = JMC.QUARTER_NOTE;


    public Music_Gen(){

        pitches = new int[]{JMC.C3, JMC.D3, JMC.DS3, JMC.F3, JMC.G3, JMC.GS3, JMC.AS3, JMC.C4, JMC.D4, JMC.AS4 };
        //Minor scales
        csm = new int[]{JMC.CS3, JMC.DS3, JMC.E3, JMC.FS3, JMC.GS3, JMC.A3, JMC.B3, JMC.CS4, JMC.DS4, JMC.B4 };
        cm = new int[]{JMC.C3, JMC.D3, JMC.DS3, JMC.F3, JMC.G3, JMC.GS3, JMC.AS3, JMC.C4, JMC.D4, JMC.AS4 };
        dm = new int[]{JMC.D3, JMC.E3, JMC.F3, JMC.G3, JMC.A3, JMC.AS3, JMC.C3, JMC.D4, JMC.E4, JMC.C4 };
        dsm = new int[]{JMC.DS3, JMC.F3, JMC.FS3, JMC.GS3, JMC.AS3, JMC.B3, JMC.CS3, JMC.DS4, JMC.F4, JMC.CS4 };
        em = new int[]{JMC.E3, JMC.FS3, JMC.G3, JMC.A3, JMC.B3, JMC.C3, JMC.D3, JMC.E4, JMC.FS4, JMC.D4 };
        fm = new int[]{JMC.F3, JMC.G3, JMC.GS3, JMC.AS3, JMC.C3, JMC.CS3, JMC.DS3, JMC.F4, JMC.G4, JMC.DS4 };
        fsm = new int[]{JMC.FS3, JMC.GS3, JMC.A3, JMC.B3, JMC.CS3, JMC.D3, JMC.E3, JMC.FS4, JMC.GS4, JMC.E4 };
        gm = new int[]{JMC.FS3+1, JMC.GS3+1, JMC.A3+1, JMC.B3+1, JMC.CS3+1, JMC.D3+1, JMC.E3+1, JMC.FS4+1, JMC.GS4+1, JMC.E4+1 };
        gsm = new int[]{JMC.FS3+2, JMC.GS3+2, JMC.A3+2, JMC.B3+2, JMC.CS3+2, JMC.D3+2, JMC.E3+2, JMC.FS4+2, JMC.GS4+2, JMC.E4+2 };
        am = new int[]{JMC.FS3+3, JMC.GS3+3, JMC.A3+3, JMC.B3+3, JMC.CS3+3, JMC.D3+3, JMC.E3+3, JMC.FS4+3, JMC.GS4+3, JMC.E4+3 };
        asm = new int[]{JMC.FS3+4, JMC.GS3+4, JMC.A3+4, JMC.B3+4, JMC.CS3+4, JMC.D3+4, JMC.E3+4, JMC.FS4+4, JMC.GS4+4, JMC.E4+4 };
        bm = new int[]{JMC.FS3+5, JMC.GS3+5, JMC.A3+5, JMC.B3+5, JMC.CS3+5, JMC.D3+5, JMC.E3+5, JMC.FS4+5, JMC.GS4+5, JMC.E4+5 };
        //Major scales
        c = new int[]{JMC.C3, JMC.D3, JMC.E3, JMC.F3, JMC.G3, JMC.A3, JMC.B3, JMC.C4, JMC.D4, JMC.B4 };
        cs = new int[]{JMC.C3+1, JMC.D3+1, JMC.E3+1, JMC.F3+1, JMC.G3+1, JMC.A3+1, JMC.B3+1, JMC.C4+1, JMC.D4+1, JMC.B4+1 };
        d = new int[]{JMC.C3+2, JMC.D3+2, JMC.E3+2, JMC.F3+2, JMC.G3+2, JMC.A3+2, JMC.B3+2, JMC.C4+2, JMC.D4+2, JMC.B4+2 };
        ds = new int[]{JMC.C3+3, JMC.D3+3, JMC.E3+3, JMC.F3+3, JMC.G3+3, JMC.A3+3, JMC.B3+3, JMC.C4+3, JMC.D4+3, JMC.B4+3 };
        e = new int[]{JMC.C3+4, JMC.D3+4, JMC.E3+4, JMC.F3+4, JMC.G3+4, JMC.A3+4, JMC.B3+4, JMC.C4+4, JMC.D4+4, JMC.B4+4 };
        f = new int[]{JMC.C3+5, JMC.D3+5, JMC.E3+5, JMC.F3+5, JMC.G3+5, JMC.A3+5, JMC.B3+5, JMC.C4+5, JMC.D4+5, JMC.B4+5 };
        fs = new int[]{JMC.C3+6, JMC.D3+6, JMC.E3+6, JMC.F3+6, JMC.G3+6, JMC.A3+6, JMC.B3+6, JMC.C4+6, JMC.D4+6, JMC.B4+6 };
        g = new int[]{JMC.C3+7, JMC.D3+7, JMC.E3+7, JMC.F3+7, JMC.G3+7, JMC.A3+7, JMC.B3+7, JMC.C4+7, JMC.D4+7, JMC.B4+7 };
        gs = new int[]{JMC.C3+8, JMC.D3+8, JMC.E3+8, JMC.F3+8, JMC.G3+8, JMC.A3+8, JMC.B3+8, JMC.C4+8, JMC.D4+8, JMC.B4+8 };
        a = new int[]{JMC.C3+9, JMC.D3+9, JMC.E3+9, JMC.F3+9, JMC.G3+9, JMC.A3+9, JMC.B3+9, JMC.C4+9, JMC.D4+9, JMC.B4+9 };
        as = new int[]{JMC.C3+10, JMC.D3+10, JMC.E3+10, JMC.F3+10, JMC.G3+10, JMC.A3+10, JMC.B3+10, JMC.C4+10, JMC.D4+10, JMC.B4+10 };
        b = new int[]{JMC.C3+11, JMC.D3+11, JMC.E3+11, JMC.F3+11, JMC.G3+11, JMC.A3+11, JMC.B3+11, JMC.C4+11, JMC.D4+11, JMC.B4+11 };
        //Harmonic minor
        chm = new int[]{JMC.C3, JMC.D3, JMC.DS3, JMC.F3, JMC.G3, JMC.GS3, JMC.B3, JMC.C4, JMC.D4, JMC.B4 };
        cshm = new int[]{JMC.C3+1, JMC.D3+1, JMC.DS3+1, JMC.F3+1, JMC.G3+1, JMC.GS3+1, JMC.B3+1, JMC.C4+1, JMC.D4+1, JMC.B4+1 };
        dhm = new int[]{JMC.C3+2, JMC.D3+2, JMC.DS3+2, JMC.F3+2, JMC.G3+2, JMC.GS3+2, JMC.B3+2, JMC.C4+2, JMC.D4+2, JMC.B4+2 };
        dshm = new int[]{JMC.C3+3, JMC.D3+3, JMC.DS3+3, JMC.F3+3, JMC.G3+3, JMC.GS3+3, JMC.B3+3, JMC.C4+3, JMC.D4+3, JMC.B4+3 };
        ehm = new int[]{JMC.C3+4, JMC.D3+4, JMC.DS3+4, JMC.F3+4, JMC.G3+4, JMC.GS3+4, JMC.B3+4, JMC.C4+4, JMC.D4+4, JMC.B4+4 };
        fhm = new int[]{JMC.C3+5, JMC.D3+5, JMC.DS3+5, JMC.F3+5, JMC.G3+5, JMC.GS3+5, JMC.B3+5, JMC.C4+5, JMC.D4+5, JMC.B4+5 };
        fshm = new int[]{JMC.C3+6, JMC.D3+6, JMC.DS3+6, JMC.F3+6, JMC.G3+6, JMC.GS3+6, JMC.B3+6, JMC.C4+6, JMC.D4+6, JMC.B4+6 };
        ghm = new int[]{JMC.C3+7, JMC.D3+7, JMC.DS3+7, JMC.F3+7, JMC.G3+7, JMC.GS3+7, JMC.B3+7, JMC.C4+7, JMC.D4+7, JMC.B4+7 };
        gshm = new int[]{JMC.C3+8, JMC.D3+8, JMC.DS3+8, JMC.F3+8, JMC.G3+8, JMC.GS3+8, JMC.B3+8, JMC.C4+8, JMC.D4+8, JMC.B4+8 };
        ahm = new int[]{JMC.C3+9, JMC.D3+9, JMC.DS3+9, JMC.F3+9, JMC.G3+9, JMC.GS3+9, JMC.B3+9, JMC.C4+9, JMC.D4+9, JMC.B4+9 };
        ashm = new int[]{JMC.C3+10, JMC.D3+10, JMC.DS3+10, JMC.F3+10, JMC.G3+10, JMC.GS3+10, JMC.B3+10, JMC.C4+10, JMC.D4+10, JMC.B4+10 };
        bhm = new int[]{JMC.C3+11, JMC.D3+11, JMC.DS3+11, JMC.F3+11, JMC.G3+11, JMC.GS3+11, JMC.B3+11, JMC.C4+11, JMC.D4+11, JMC.B4+11 };
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setMmh(int mmh){ this.Mmh = mmh; }
/*
    public void setNote_length(double len){ this.note_length = len; }

     public double getNote_Length(){
        return this.note_length;
     }

 */


    public void setScale(String scale){
        if (scale=="csharp_m" && Mmh == 1){
            pitches=csm;
        }
        else if (scale=="c_m" && Mmh == 1) {
            pitches=cm;
        }
        else if (scale=="d_m" && Mmh == 1) {
            pitches=dm;
        }
        else if (scale=="ds_m" && Mmh == 1) {
            pitches=dsm;
        }
        else if (scale=="e_m" && Mmh == 1) {
            pitches=em;
        }
        else if (scale=="f_m" && Mmh == 1) {
            pitches=fm;
        }
        else if (scale=="fs_m" && Mmh == 1) {
            pitches=fsm;
        }
        else if (scale=="g_m" && Mmh == 1) {
            pitches=gm;
        }
        else if (scale=="gs_m" && Mmh == 1) {
            pitches=gsm;
        }
        else if (scale=="a_m" && Mmh == 1) {
            pitches=am;
        }
        else if (scale=="as_m" && Mmh == 1) {
            pitches=asm;
        }
        else if (scale=="b_m" && Mmh == 1) {
            pitches=bm;
        }
        else if (scale=="csharp_m" && Mmh == 0){
            pitches=cs;
        }
        else if (scale=="c_m" && Mmh == 0) {
            pitches=c;
        }
        else if (scale=="d_m" && Mmh == 0) {
            pitches=d;
        }
        else if (scale=="ds_m" && Mmh == 0) {
            pitches=ds;
        }
        else if (scale=="e_m" && Mmh == 0) {
            pitches=e;
        }
        else if (scale=="f_m" && Mmh == 0) {
            pitches=f;
        }
        else if (scale=="fs_m" && Mmh == 0) {
            pitches=fs;
        }
        else if (scale=="g_m" && Mmh == 0) {
            pitches=g;
        }
        else if (scale=="gs_m" && Mmh == 0) {
            pitches=gs;
        }
        else if (scale=="a_m" && Mmh == 0) {
            pitches=a;
        }
        else if (scale=="as_m" && Mmh == 0) {
            pitches=as;
        }
        else if (scale=="b_m" && Mmh == 0) {
            pitches=b;
        }
        else if (scale=="csharp_m" && Mmh == 2){
            pitches=cshm;
        }
        else if (scale=="c_m" && Mmh == 2) {
            pitches=chm;
        }
        else if (scale=="d_m" && Mmh == 2) {
            pitches=dhm;
        }
        else if (scale=="ds_m" && Mmh == 2) {
            pitches=dshm;
        }
        else if (scale=="e_m" && Mmh == 2) {
            pitches=ehm;
        }
        else if (scale=="f_m" && Mmh == 2) {
            pitches=fhm;
        }
        else if (scale=="fs_m" && Mmh == 2) {
            pitches=fshm;
        }
        else if (scale=="g_m" && Mmh == 2) {
            pitches=ghm;
        }
        else if (scale=="gs_m" && Mmh == 2) {
            pitches=gshm;
        }
        else if (scale=="a_m" && Mmh == 2) {
            pitches=ahm;
        }
        else if (scale=="as_m" && Mmh == 2) {
            pitches=ashm;
        }
        else if (scale=="b_m" && Mmh == 2) {
            pitches=bhm;
        }

    }
/*
    public void PlayNote(int random_number) throws InterruptedException {

        note.setPitch(pitches[random_number]);
        note.setLength(3);
        note.setDynamic(JMC.PP);
        System.out.println(note);
        Play.midi(note);
    }

 */
    public void Melody_Gen() throws IOException {
        phr.setInstrument(JMC.ACOUSTIC_GRAND);
        phr.setLength(3);
        phr.setDynamic(JMC.PP);
        phr.setTempo(this.tempo);
        if (duplicates){
            for (int i =0 ; i<length; i++){
                int j = (int) (Math.random()*100000);
                int k = PiReader.getPi(j) - '0';
                //System.out.println("k = "+k);
                phr.add(new Note(pitches[k], note_length));//Peu changer quarter note si on veut
            }
        }
        else{
            int dup = 0;
            int u=0;
            for (int i =0 ; i<length; i++){
                int j = (int) (Math.random()*100000);
                int k = PiReader.getPi(j) - '0';
                if (dup==k && u!=0){
                    phr.add(new Note(pitches[(int) (Math.random()*10)], JMC.QUARTER_NOTE));//Peu changer quarter note si on veut
                }
                else {
                    phr.add(new Note(pitches[k], JMC.QUARTER_NOTE));//Peu changer quarter note si on veut
                    u=1;
                }
                dup = k;
            }
        }
        Write.midi(phr, "MIDI_Generated.mid");
        //Play.midi(phr);

    }

    public void Playmelody(){
        Play.midi(phr);
    }
    public void ClearMelody(){
        phr.empty();
    }


    public void setTempo(int tempo){
        this.tempo = tempo;
    }

    public int getTempo(){
        return this.tempo;
    }
}

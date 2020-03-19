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


    private Note note = new Note();
    private Phrase phr = new Phrase();
    private int length = 8;
    private boolean duplicates = false;//mieux comme ca en vrai, une chance sur 100 d'avoir repetition


    //TODO: set scale major
    public Music_Gen(){

        pitches = new int[]{JMC.C3, JMC.D3, JMC.DS3, JMC.F3, JMC.G3, JMC.GS3, JMC.AS3, JMC.C4, JMC.D4, JMC.AS4 };
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
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setScale(String scale){
        if (scale=="csharp_m"){
            pitches=csm;
        }
        else if (scale=="c_m") {
            pitches=cm;
        }
        else if (scale=="d_m") {
            pitches=dm;
        }
        else if (scale=="ds_m") {
            pitches=dsm;
        }
        else if (scale=="e_m") {
            pitches=em;
        }
        else if (scale=="f_m") {
            pitches=fm;
        }
        else if (scale=="fs_m") {
            pitches=fsm;
        }
        else if (scale=="g_m") {
            pitches=gm;
        }
        else if (scale=="gs_m") {
            pitches=gsm;
        }
        else if (scale=="a_m") {
            pitches=am;
        }
        else if (scale=="as_m") {
            pitches=asm;
        }
        else if (scale=="b_m") {
            pitches=bm;
        }
    }

    public void PlayNote(int random_number) throws InterruptedException {

        note.setPitch(pitches[random_number]);
        note.setLength(3);
        note.setDynamic(JMC.PP);
        System.out.println(note);
        Play.midi(note);
    }
    public void Melody_Gen() throws IOException {
        phr.setInstrument(JMC.HONKYTONK_PIANO);
        phr.setLength(3);
        phr.setDynamic(JMC.PP);
        if (duplicates){
            for (int i =0 ; i<length; i++){
                int j = (int) (Math.random()*100000);
                int k = PiReader.getPi(j) - '0';
                System.out.println("k = "+k);
                phr.add(new Note(pitches[k], JMC.QUARTER_NOTE));//Peu changer quarter note si on veut
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
        Write.midi(phr, "Test.mid");
        Play.midi(phr);

    }
}

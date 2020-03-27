package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import jm.JMC;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;


//TODO: pretty up code

public class MyApp extends Application {

    Music_Gen midi = new Music_Gen();

    @Override
    public void init() throws Exception {
    }

    @Override
    public void start(Stage stage) throws Exception {
        String beware = "Beware, the midi file created will be in the same directory as the application,\n" +
                "so place the app in your file directory accordingly \n" + "Created by Maxime Langlet, link to Github :";

        stage.setTitle("MIDI Generator");
        stage.initStyle(StageStyle.DECORATED);
        stage.setMinHeight(500);
        stage.setMinWidth(600);

        //Buttons and borderpanes
        BorderPane br = new BorderPane();

        //------------ BUTTON LENGTH
        Button music_gen = new Button("MIDI Gen");

        MenuItem menulen4 = new MenuItem("4");
        MenuItem menulen8 = new MenuItem("8");
        MenuItem menulen16 = new MenuItem("16");
        MenuItem menulen32 = new MenuItem("32");
        MenuButton length = new MenuButton("Length", null, menulen4, menulen8, menulen16, menulen32);

        menulen4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                midi.setLength(4);
                length.setText("4");
            }
        });

        menulen8.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                midi.setLength(8);
                length.setText("8");
            }
        });

        menulen16.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                midi.setLength(16);
                length.setText("16");
            }
        });

        menulen32.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                midi.setLength(32);
                length.setText("32");
            }
        });


        //-------------- BUTTON SCALE
        MenuItem menuItemcsm = new MenuItem("C#");
        MenuItem menuItemcm = new MenuItem("C");
        MenuItem menuItemdm = new MenuItem("D");
        MenuItem menuItemdsm = new MenuItem("D#");
        MenuItem menuItemem = new MenuItem("E");
        MenuItem menuItemfm = new MenuItem("F");
        MenuItem menuItemfsm = new MenuItem("F#");
        MenuItem menuItemgm = new MenuItem("G");
        MenuItem menuItemgsm = new MenuItem("G#");
        MenuItem menuItemam = new MenuItem("A");
        MenuItem menuItemasm = new MenuItem("A#");
        MenuItem menuItembm = new MenuItem("B");
        MenuButton scale = new MenuButton("Scale",null, menuItemcm, menuItemcsm, menuItemdm, menuItemdsm, menuItemem,
                menuItemfm, menuItemfsm, menuItemgm, menuItemgsm, menuItemam, menuItemasm, menuItembm);

        menuItemcm.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                midi.setScale("c_m");
                scale.setText("C");
            }
        });

        menuItemcsm.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                midi.setScale("csharp_m");
                scale.setText("C#");
            }
        });

        menuItemdm.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                midi.setScale("d_m");
                scale.setText("D");
            }
        });
        menuItemdsm.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                midi.setScale("ds_m");
                scale.setText("D#");
            }
        });

        menuItemem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                midi.setScale("e_m");
                scale.setText("E");
            }
        });

        menuItemfm.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                midi.setScale("f_m");
                scale.setText("F");
            }
        });

        menuItemfsm.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                midi.setScale("fs_m");
                scale.setText("F#");
            }
        });

        menuItemgm.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                midi.setScale("g_m");
                scale.setText("G");
            }
        });

        menuItemgsm.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                midi.setScale("gs_m");
                scale.setText("G#");
            }
        });

        menuItemam.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                midi.setScale("a_m");
                scale.setText("A");
            }
        });

        menuItemasm.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                midi.setScale("as_m");
                scale.setText("A#");
            }
        });

        menuItembm.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                midi.setScale("b_m");
                scale.setText("B");
            }
        });



        //---------------- Toggle buttons
        ToggleGroup buttongroup = new ToggleGroup();
        RadioButton major = new RadioButton("Major");
        RadioButton minor = new RadioButton("Minor");
        RadioButton harmonic = new RadioButton("Harmonic Minor");

        major.setToggleGroup(buttongroup);
        minor.setToggleGroup(buttongroup);
        harmonic.setToggleGroup(buttongroup);

        major.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                midi.setMmh(0);
            }
        });

        minor.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                midi.setMmh(1);
            }
        });

        harmonic.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                midi.setMmh(2);
            }
        });



        //-------------- Slider

        Slider slider = new Slider();
        slider.setMin(10);
        slider.setMax(200);
        slider.setValue(120);
        slider.setShowTickLabels(false);
        slider.setShowTickMarks(false);
        slider.setBlockIncrement(1);

        Label tempo = new Label("Tempo :");
        Label tempoval = new Label(String.valueOf(midi.getTempo()));

        slider.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                midi.setTempo((int) slider.getValue());
                tempoval.setText(String.valueOf(midi.getTempo()));
            }
        });

/*
        //-------------- Note length
        Slider notelength = new Slider();
        notelength.setMin(1/16);
        notelength.setMax(1/2);
        notelength.setValue(1/4);
        notelength.setShowTickLabels(false);
        notelength.setShowTickMarks(true);
        notelength.setBlockIncrement(1/16);
        notelength.isSnapToTicks();
        notelength.setT

        Label notelen = new Label("Note Length :");
        Label notelenval = new Label(String.valueOf(midi.getNote_Length()));

        slider.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                midi.setNote_length(notelength.getValue());
                notelenval.setText(String.valueOf(midi.getNote_Length()));
            }
        });
*/
        //Colors secondaire
        //TODO: hyperlink to github


        //------------- Displaying on stage


        HBox top = new HBox();
        VBox left = new VBox();
        VBox right = new VBox();
        VBox bottum = new VBox();

        top.getChildren().addAll( scale, length);
        left.getChildren().addAll(major, minor, harmonic);
        right.getChildren().addAll(tempo, slider, tempoval);//notelen, notelength, notelenval


        Hyperlink link = new Hyperlink("Github/MaxLanglet");
        link.setOnAction(e -> {
            if(Desktop.isDesktopSupported())
            {
                try {
                    Desktop.getDesktop().browse(new URI("https://github.com/Maxlanglet"));
                } catch (IOException e1) {
                    e1.printStackTrace();
                } catch (URISyntaxException e1) {
                    e1.printStackTrace();
                }
            }
        });
        Label attention = new Label(beware);
        attention.setPrefHeight(70);
        String jMusic = "I do not own the library used in this project, if you want to download it,\n"+
                "here's the link to the jMusic library :";
        Label jMusiclabel = new Label(jMusic);
        Hyperlink library = new Hyperlink("jMusic library");
        link.setOnAction(e -> {
            if(Desktop.isDesktopSupported())
            {
                try {
                    Desktop.getDesktop().browse(new URI("https://explodingart.com/jmusic/GetjMusic.html"));
                } catch (IOException e1) {
                    e1.printStackTrace();
                } catch (URISyntaxException e1) {
                    e1.printStackTrace();
                }
            }
        });
        bottum.getChildren().addAll(attention, link, jMusiclabel, library);
        bottum.setMargin(attention, new Insets(0,0,0,5));
        bottum.setMargin(link, new Insets(0,0,0,5));
        bottum.setMargin(jMusiclabel, new Insets(0,0,0,5));
        bottum.setMargin(library, new Insets(0,0,0,5));

        length.setMinSize(80,30);
        scale.setMinSize(80,30);
        length.setMaxSize(80,30);
        scale.setMaxSize(80,30);
        //menuItemam.setStyle("-fx-font: 12 arial; -fx-base: #a4edd2;");
        scale.setStyle("-fx-font: 12 arial; -fx-base: #a4edd2;");
        length.setStyle("-fx-font: 12 arial; -fx-base: #a4edd2;");
        music_gen.setStyle("-fx-font: 12 arial; -fx-base: #a4edd2;");


        br.setTop(top);

        br.setBottom(bottum);

        br.setLeft(left);

        br.setRight(right);

        br.setAlignment(music_gen, Pos.CENTER);
        br.setCenter(music_gen);

        //br.setBackground(new Background(new BackgroundFill(Color.AQUAMARINE, CornerRadii.EMPTY, Insets.EMPTY)));

/*
        VBox parent = new VBox();

        Label label1 = new Label("That's my gulfiend"); //child node

        parent.getChildren().add(label1);

        Scene scene1 = new Scene(parent);
        scene1.setCursor(Cursor.CLOSED_HAND);
 */
        Scene scene1 = new Scene(br);
        stage.setScene(scene1);

        stage.show();

/*
        final String[] destination = {""};
        directory.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                DirectoryChooser dc = new DirectoryChooser();
                File selectedDirectory = dc.showDialog(stage);
                if (selectedDirectory!=null){
                    destination[0] =selectedDirectory.getAbsolutePath();
                    //System.out.println(destination[0]);
                }
            }
        });
*/
        music_gen.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                try {
                    midi.ClearMelody();
                    midi.Melody_Gen();//ajouter destination
                    midi.Playmelody();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void stop() throws Exception {
    }
}

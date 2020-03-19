package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.io.IOException;

public class MyApp extends Application {

    Music_Gen midi = new Music_Gen();

    @Override
    public void init() throws Exception {
    }

    @Override
    public void start(Stage stage) throws Exception {
        String beware = "Beware, the midi file created will be in the same directory as the application,\n" +
                " so place the app in your file directory accordingly";

        stage.setTitle("MIDI Generator");
        stage.initStyle(StageStyle.DECORATED);
        stage.setMinHeight(400);
        stage.setMinWidth(500);

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
        MenuItem menuItemcsm = new MenuItem("C# minor");
        MenuItem menuItemcm = new MenuItem("C minor");
        MenuItem menuItemdm = new MenuItem("D minor");
        MenuItem menuItemdsm = new MenuItem("D# minor");
        MenuItem menuItemem = new MenuItem("E minor");
        MenuItem menuItemfm = new MenuItem("F minor");
        MenuItem menuItemfsm = new MenuItem("F# minor");
        MenuItem menuItemgm = new MenuItem("G minor");
        MenuItem menuItemgsm = new MenuItem("G# minor");
        MenuItem menuItemam = new MenuItem("A minor");
        MenuItem menuItemasm = new MenuItem("A# minor");
        MenuItem menuItembm = new MenuItem("B minor");
        MenuButton scale = new MenuButton("Scale",null, menuItemcm, menuItemcsm, menuItemdm, menuItemdsm, menuItemem,
                menuItemfm, menuItemfsm, menuItemgm, menuItemgsm, menuItemam, menuItemasm, menuItembm);

        menuItemcm.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                midi.setScale("c_m");
                scale.setText("C minor");
            }
        });

        menuItemcsm.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                midi.setScale("csharp_m");
                scale.setText("C# minor");
            }
        });

        menuItemdm.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                midi.setScale("d_m");
                scale.setText("D minor");
            }
        });
        menuItemdsm.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                midi.setScale("ds_m");
                scale.setText("D# minor");
            }
        });

        menuItemem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                midi.setScale("e_m");
                scale.setText("E minor");
            }
        });

        menuItemfm.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                midi.setScale("f_m");
                scale.setText("F minor");
            }
        });

        menuItemfsm.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                midi.setScale("fs_m");
                scale.setText("F# minor");
            }
        });

        menuItemgm.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                midi.setScale("g_m");
                scale.setText("G minor");
            }
        });

        menuItemgsm.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                midi.setScale("gs_m");
                scale.setText("G# minor");
            }
        });

        menuItemam.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                midi.setScale("a_m");
                scale.setText("A minor");
            }
        });

        menuItemasm.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                midi.setScale("as_m");
                scale.setText("A# minor");
            }
        });

        menuItembm.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                midi.setScale("b_m");
                scale.setText("B minor");
            }
        });

        //TODO: ajouter new event on mouse click pour tous avec set scale pour major

        Button invisible = new Button();
        invisible.setVisible(false);
        TextArea attention = new TextArea(beware);
        attention.setPrefHeight(50);

        length.setMinSize(80,30);
        scale.setMinSize(80,30);
        length.setMaxSize(80,30);
        scale.setMaxSize(80,30);
        invisible.setMinSize(80,30);
        invisible.setMaxSize(80,30);

        //br.setAlignment(length, Pos.TOP_RIGHT);
        br.setLeft(length);

        br.setRight(invisible);


        br.setAlignment(scale, Pos.BOTTOM_LEFT);
        br.setTop(scale);

        br.setBottom(attention);

        br.setAlignment(music_gen, Pos.CENTER);
        br.setCenter(music_gen);

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
                    midi.Melody_Gen();//ajouter destination
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

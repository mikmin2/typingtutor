package org.mikmin.typingtutor;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage)  {
        Button aKey = new Button("a");
        Button bKey = new Button("b");
        Button cKey = new Button("c");
        Button dKey = new Button("d");
        Button eKey = new Button("e");
        Button fKey = new Button("f");
        Button gKey = new Button("g");
        Button hKey = new Button("h");
        Button iKey = new Button("i");
        Button jKey = new Button("j");
        Button kKey = new Button("k");
        Button lKey = new Button("l");
        Button mKey = new Button("m");
        Button nKey = new Button("n");
        Button oKey = new Button("o");
        Button pKey = new Button("p");
        Button qKey = new Button("q");
        Button rKey = new Button("r");
        Button sKey = new Button("s");
        Button tKey = new Button("t");
        Button uKey = new Button("u");
        Button vKey = new Button("v");
        Button wKey = new Button("w");
        Button xKey = new Button("x");
        Button yKey = new Button("y");
        Button zKey = new Button("z");
        Button spaceKey = new Button("space");
        Button shiftKey = new Button("shift");
        Button next = new Button("next");
        Button reset = new Button("reset");
        Button backSpace = new Button("backspace");
        Label errorLabel = new Label(" ");
        Label displayText = new Label("Try typing this text Do it as quickly and accurately as you can");
        Label titleText = new Label("Typing Tutor");
        Label textCounter = new Label("1 of 6");
        Label correctCounterLabel = new Label("you've pressed 0 correct keys");
        Label incorrectCounterLabel = new Label("you've pressed 0 incorrect keys");

        TextField typingText = new TextField();
        final int[] currentIdx = {0};
        int currentText = 1;
        final int[] correctCounter = {0};
        final int[] incorrectCounter = {0};
        final boolean[] isShiftPressed = {false};

        GridPane mainPane = new GridPane();
        GridPane keyPane = new GridPane();
        GridPane altPane = new GridPane();
        GridPane textPane = new GridPane();
        GridPane otherPane = new GridPane();


        Scene scene = new Scene(mainPane, 800, 500);

        displayText.setPrefSize(600,50);
        typingText.setPrefSize(600,50);
        aKey.setPrefSize(50,50);
        bKey.setPrefSize(50,50);
        cKey.setPrefSize(50,50);
        dKey.setPrefSize(50,50);
        eKey.setPrefSize(50,50);
        fKey.setPrefSize(50,50);
        gKey.setPrefSize(50,50);
        hKey.setPrefSize(50,50);
        iKey.setPrefSize(50,50);
        jKey.setPrefSize(50,50);
        kKey.setPrefSize(50,50);
        lKey.setPrefSize(50,50);
        mKey.setPrefSize(50,50);
        nKey.setPrefSize(50,50);
        oKey.setPrefSize(50,50);
        pKey.setPrefSize(50,50);
        qKey.setPrefSize(50,50);
        rKey.setPrefSize(50,50);
        sKey.setPrefSize(50,50);
        tKey.setPrefSize(50,50);
        uKey.setPrefSize(50,50);
        vKey.setPrefSize(50,50);
        wKey.setPrefSize(50,50);
        xKey.setPrefSize(50,50);
        yKey.setPrefSize(50,50);
        zKey.setPrefSize(50,50);
        spaceKey.setPrefSize(280,50);
        shiftKey.setPrefSize(90,50);
        backSpace.setPrefSize(90,50);

        final Map<KeyCode, Button> keyMap = new HashMap<>();

        if (getClass().getResource("/styling.css") != null) {
            scene.getStylesheets().add(getClass().getResource("/styling.css").toExternalForm());
        }

        aKey.getStyleClass().add("button-unpressed");
        bKey.getStyleClass().add("button-unpressed");
        cKey.getStyleClass().add("button-unpressed");
        dKey.getStyleClass().add("button-unpressed");
        eKey.getStyleClass().add("button-unpressed");
        fKey.getStyleClass().add("button-unpressed");
        gKey.getStyleClass().add("button-unpressed");
        hKey.getStyleClass().add("button-unpressed");
        iKey.getStyleClass().add("button-unpressed");
        jKey.getStyleClass().add("button-unpressed");
        kKey.getStyleClass().add("button-unpressed");
        lKey.getStyleClass().add("button-unpressed");
        mKey.getStyleClass().add("button-unpressed");
        nKey.getStyleClass().add("button-unpressed");
        oKey.getStyleClass().add("button-unpressed");
        pKey.getStyleClass().add("button-unpressed");
        qKey.getStyleClass().add("button-unpressed");
        rKey.getStyleClass().add("button-unpressed");
        sKey.getStyleClass().add("button-unpressed");
        tKey.getStyleClass().add("button-unpressed");
        uKey.getStyleClass().add("button-unpressed");
        vKey.getStyleClass().add("button-unpressed");
        wKey.getStyleClass().add("button-unpressed");
        xKey.getStyleClass().add("button-unpressed");
        yKey.getStyleClass().add("button-unpressed");
        zKey.getStyleClass().add("button-unpressed");
        backSpace.getStyleClass().add("button-unpressed");
        shiftKey.getStyleClass().add("button-unpressed");
        spaceKey.getStyleClass().add("button-unpressed");
        titleText.getStyleClass().add("label-title");

        keyMap.put(KeyCode.A, aKey);
        keyMap.put(KeyCode.B, bKey);
        keyMap.put(KeyCode.C, cKey);
        keyMap.put(KeyCode.D, dKey);
        keyMap.put(KeyCode.E, eKey);
        keyMap.put(KeyCode.F, fKey);
        keyMap.put(KeyCode.G, gKey);
        keyMap.put(KeyCode.H, hKey);
        keyMap.put(KeyCode.I, iKey);
        keyMap.put(KeyCode.J, jKey);
        keyMap.put(KeyCode.K, kKey);
        keyMap.put(KeyCode.L, lKey);
        keyMap.put(KeyCode.M, mKey);
        keyMap.put(KeyCode.N, nKey);
        keyMap.put(KeyCode.O, oKey);
        keyMap.put(KeyCode.P, pKey);
        keyMap.put(KeyCode.Q, qKey);
        keyMap.put(KeyCode.R, rKey);
        keyMap.put(KeyCode.S, sKey);
        keyMap.put(KeyCode.T, tKey);
        keyMap.put(KeyCode.U, uKey);
        keyMap.put(KeyCode.V, vKey);
        keyMap.put(KeyCode.W, wKey);
        keyMap.put(KeyCode.X, xKey);
        keyMap.put(KeyCode.Y, yKey);
        keyMap.put(KeyCode.Z, zKey);
        keyMap.put(KeyCode.SPACE, spaceKey);
        keyMap.put(KeyCode.SHIFT, shiftKey);
        keyMap.put(KeyCode.BACK_SPACE, backSpace);

        for (Button btn : keyMap.values()) {
            btn.setFocusTraversable(false);
        }

        mainPane.add(textPane, 0, 0);
        mainPane.add(keyPane,0,1);
        mainPane.add(altPane,0,2);
        mainPane.add(otherPane,0,3);

        textPane.add(titleText,0,0);
        textPane.add(displayText, 0,2);
        textPane.add(typingText,0,3);
        textPane.add(errorLabel, 0,4);
        textPane.add(correctCounterLabel,1,4);
        textPane.add(incorrectCounterLabel,1,5);
        keyPane.add(qKey,0,0);
        keyPane.add(wKey,1,0);
        keyPane.add(eKey,2,0);
        keyPane.add(rKey,3,0);
        keyPane.add(tKey,4,0);
        keyPane.add(yKey,5,0);
        keyPane.add(uKey,6,0);
        keyPane.add(iKey,7,0);
        keyPane.add(oKey,8,0);
        keyPane.add(pKey,9,0);
        keyPane.add(backSpace,10,0);
        keyPane.add(aKey,0,1);
        keyPane.add(sKey,1,1);
        keyPane.add(dKey,2,1);
        keyPane.add(fKey,3,1);
        keyPane.add(gKey,4,1);
        keyPane.add(hKey,5,1);
        keyPane.add(jKey,6,1);
        keyPane.add(kKey,7,1);
        keyPane.add(lKey,8,1);
        keyPane.add(zKey,1,2);
        keyPane.add(xKey,2,2);
        keyPane.add(cKey,3,2);
        keyPane.add(vKey,4,2);
        keyPane.add(bKey,5,2);
        keyPane.add(nKey,6,2);
        keyPane.add(mKey,7,2);
        altPane.add(shiftKey,0,0);
        altPane.add(spaceKey,1,0);
        otherPane.add(next, 0, 0);
        otherPane.add(reset,0,0);

        typingText.setOnKeyPressed(event -> {
            Button pressedButton = keyMap.get(event.getCode());
            if (pressedButton != null && !pressedButton.getStyleClass().contains("button-pressed")) {
                pressedButton.getStyleClass().add("button-pressed");
                if (Objects.equals(pressedButton.getText(), "shiftKey")) {
                    isShiftPressed[0] = true;
                } else {
                    if (Objects.equals(pressedButton.getText(), "backspace") ) {
                        currentIdx[0]--;

                    } else {
                        char key = Objects.equals(pressedButton.getText(), "space") ? ' ' : pressedButton.getText().toCharArray()[0];
                        currentIdx[0]++;
                        if (isShiftPressed[0]) {
                            if (isCharCorrect(displayText, currentIdx[0], toUpperCase(key))) {
                                correctCounter[0]++;
                                correctCounterLabel.setText(String.format("you've pressed %d correct keys", correctCounter[0]));
                            } else {
                                incorrectCounter[0]++;
                                incorrectCounterLabel.setText(String.format("you've pressed %d incorrect keys", incorrectCounter[0]));
                            }
                        } else {
                            if (isCharCorrect(displayText, currentIdx[0], toLowerCase(key))) {
                                correctCounter[0]++;
                                correctCounterLabel.setText(String.format("you've pressed %d correct keys", correctCounter[0]));
                            } else {
                                incorrectCounter[0]++;
                                incorrectCounterLabel.setText(String.format("you've pressed %d incorrect keys", incorrectCounter[0]));
                            }
                        }

                    }
                }

            } else {
                errorLabel.setText("This Key is not Handled");
            }
        });

        typingText.setOnKeyReleased(event -> {
            Button releasedButton = keyMap.get(event.getCode());
            if (releasedButton != null) {
                releasedButton.getStyleClass().remove("button-pressed");
                if (Objects.equals(releasedButton.getText(), "shiftKey")) {
                    isShiftPressed[0] = false;
                } else {
                    errorLabel.setText(" ");
                }
            }

        });

        stage.setTitle("Typing Tutor");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }


    public static boolean isCharCorrect(Label label, int index, char nextChar) {
        char correctChar = label.getText().toCharArray()[index];

        return correctChar == nextChar;
    }

    public static char toUpperCase(char chr) {
        String temp = String.valueOf(chr);
        temp.toUpperCase();

        return temp.toCharArray()[0];


    }

    public static char toLowerCase(char chr) {
        String temp = String.valueOf(chr);
        temp.toLowerCase();

        return temp.toCharArray()[0];


    }
}

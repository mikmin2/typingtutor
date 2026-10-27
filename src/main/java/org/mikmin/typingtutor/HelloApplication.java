package org.mikmin.typingtutor;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.*;
import java.util.function.UnaryOperator;

public class HelloApplication extends Application {
    // github repository https://github.com/mikmin2/typingtutor

    int currentIdx = 0;
    int correctCount = 0;
    int mistakeCount = 0;
    boolean wasCorrectChar;
    int displayTextCounter = 0;

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
        Button[] keyButtons = {aKey,bKey,cKey,dKey,eKey,fKey,gKey,hKey,iKey,jKey,kKey,lKey,mKey,nKey,oKey,pKey,qKey,rKey,sKey,tKey,uKey,vKey,wKey,xKey,yKey,zKey};
        Button spaceKey = new Button("space");
        Button shiftKey = new Button("shift");
        Button next = new Button("next");
        Button reset = new Button("reset");
        Button backSpace = new Button("backspace");
        Label errorLabel = new Label(" ");
        Label displayText = new Label("Try typing this text and do it as quickly and accurately as you can");
        Label titleText = new Label("Typing Tutor");
        Label textCounter = new Label("1 of 6");
        Label correctCounterLabel = new Label("0 correct keys");
        Label incorrectCounterLabel = new Label("0 incorrect keys");
        Label currentKeyLabel = new Label(" ");

        TextField typingText = new TextField();


        GridPane mainPane = new GridPane();
        mainPane.setAlignment(Pos.CENTER);
        GridPane keyPane = new GridPane();
        GridPane altPane = new GridPane();
        GridPane textPane = new GridPane();
        GridPane otherPane = new GridPane();


        Scene scene = new Scene(mainPane, 800, 600);

        if (getClass().getResource("/styling.css") != null) {
            scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/styling.css")).toExternalForm());
        }

        displayText.setPrefSize(600,50);
        typingText.setPrefSize(600,50);

        next.setDisable(true);

        for (Button button : keyButtons) {
            button.setPrefSize(50,50);
            button.getStyleClass().add("button-unpressed");
            button.setFocusTraversable(false);
        }

        spaceKey.setPrefSize(280,50);
        shiftKey.setPrefSize(90,50);
        backSpace.setPrefSize(120,50);
        next.setPrefSize(70,50);
        reset.setPrefSize(70,50);

        spaceKey.getStyleClass().add("button-unpressed");
        shiftKey.getStyleClass().add("button-unpressed");
        backSpace.getStyleClass().add("button-unpressed");
        next.getStyleClass().add("button-unpressed");
        reset.getStyleClass().add("button-unpressed");
        titleText.getStyleClass().add("label-title");
        displayText.getStyleClass().add("label-display");
        errorLabel.getStyleClass().add("label-error");
        textCounter.getStyleClass().add("label-subLabel");
        correctCounterLabel.getStyleClass().add("label-subLabel");
        incorrectCounterLabel.getStyleClass().add("label-subLabel");
        currentKeyLabel.getStyleClass().add("label-display");

        spaceKey.setFocusTraversable(false);
        shiftKey.setFocusTraversable(false);
        backSpace.setFocusTraversable(false);
        next.setFocusTraversable(false);
        reset.setFocusTraversable(false);

        final Map<KeyCode, Button> keyMap = new HashMap<>();

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

        mainPane.add(textPane, 0, 0);
        mainPane.add(keyPane,0,1);
        mainPane.add(altPane,0,2);
        mainPane.add(otherPane,0,3);

        textPane.add(titleText,0,0);
        textPane.add(displayText, 0,2);
        textPane.add(textCounter,0,3);
        textPane.add(typingText,0,4);
        textPane.add(errorLabel, 0,5);
        textPane.add(correctCounterLabel,0,6);
        textPane.add(incorrectCounterLabel,0,7);
        textPane.add(currentKeyLabel,0,8);

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

        otherPane.add(next, 1, 0);
        otherPane.add(reset,0,0);
        otherPane.setAlignment(Pos.CENTER_RIGHT);

        UnaryOperator<TextFormatter.Change> filter = change -> {
            String newText = change.getText();
            if (newText.matches("[a-zA-Z ]*")) {
                return change;
            }
            return null;
        };

        typingText.setTextFormatter(new TextFormatter<>(filter));

        typingText.setOnKeyPressed(event -> {
            Button pressedButton = keyMap.get(event.getCode());
            if (pressedButton != null && !pressedButton.getStyleClass().contains("button-pressed")) {
                pressedButton.getStyleClass().add("button-pressed");
                }
        });

        typingText.setOnKeyReleased(e -> {
            Button releasedButton = keyMap.get(e.getCode());
            if (releasedButton != null) {
                releasedButton.getStyleClass().remove("button-pressed");
            } if(e.getCode().equals(KeyCode.BACK_SPACE) && currentIdx != 0) {
                String previousDisplayChar;
                String previousTypedChar;
                errorLabel.setText(" ");

                if (wasCorrectChar) {
                    correctCount--;
                    correctCounterLabel.setText(String.format("%d correct keys", correctCount));
                    currentIdx--;
                } else {
                    mistakeCount--;
                    incorrectCounterLabel.setText(String.format("%d incorrect keys", mistakeCount));
                    currentIdx--;
                }

                    previousDisplayChar = displayText.getText().substring(currentIdx - 1, currentIdx);
                    previousTypedChar = typingText.getText().substring(typingText.getText().length() - 1);
                    wasCorrectChar = previousDisplayChar.equals(previousTypedChar);

            }
        });

        typingText.setOnKeyTyped(e -> {
            if (Character.isLetter(e.getCharacter().charAt(0) ) || e.getCharacter().charAt(0) == ' '){
                String currentChar = displayText.getText().substring(currentIdx,currentIdx + 1);
                currentIdx++;

                if (e.getCharacter().equals(currentChar)) {
                    correctCount++;
                    correctCounterLabel.setText(String.format("%d correct keys",correctCount));
                    wasCorrectChar = true;
                    errorLabel.setText(" ");
                } else {
                    mistakeCount++;
                    incorrectCounterLabel.setText(String.format("%d incorrect keys", mistakeCount));
                    wasCorrectChar = false;
                    errorLabel.setText(" ");
                }
            } else {
                if (!e.getCharacter().equals("\b")) {
                    errorLabel.setText(String.format("%s is not handled", e.getText()));
                }
            }
            if (!e.getCharacter().equals("\b")) {
            currentKeyLabel.setText(String.format("%s",e.getCharacter()));
            }

            if (correctCount == displayText.getText().length() && displayTextCounter != 5) {
                next.setDisable(false);
            }
        });

        String[] sampleTexts = {"Try typing this text and do it as quickly and accurately as you can",
                "Next type another line of input data",
                "The quick brown fox jumps over the lazy dog",
                "Five big quacking zephyrs jolt my wax bed",
                "Sympathizing would fix Quaker objectives",
                "A large fawn jumped quickly over white zinc boxes"};

        next.setOnAction(e -> {
            displayTextCounter++;
            displayText.setText(sampleTexts[displayTextCounter]);
            typingText.setText("");
            correctCount = 0;
            mistakeCount = 0;
            currentIdx = 0;
            errorLabel.setText(" ");
            correctCounterLabel.setText(String.format("%d correct keys",correctCount));
            incorrectCounterLabel.setText(String.format("%d incorrect keys", mistakeCount));
            textCounter.setText(String.format("%d of 6",displayTextCounter + 1));
            next.setDisable(true);
        });

        reset.setOnAction(e -> {
            displayTextCounter = 0;
            displayText.setText(sampleTexts[displayTextCounter]);
            typingText.setText("");
            correctCount = 0;
            mistakeCount = 0;
            currentIdx = 0;
            errorLabel.setText(" ");
            correctCounterLabel.setText(String.format("%d correct keys",correctCount));
            incorrectCounterLabel.setText(String.format("%d incorrect keys", mistakeCount));
            textCounter.setText(String.format("%d of 6",displayTextCounter + 1));
            next.setDisable(true);
        });


        stage.setTitle("Typing Tutor");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

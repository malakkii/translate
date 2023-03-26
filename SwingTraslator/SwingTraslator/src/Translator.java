import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

public class Translator extends JFrame implements ActionListener {
    private JLabel firstlabel, secondlabel;
    private JTextField firsttextField, secondtextField;
    private JButton translatorButton;

    private Map<String, String> translatorMap;

    public Translator() {
        super("Translator");
        setLayout(new FlowLayout());

        translatorMap = new HashMap<>();
        translatorMap.put("king", "roi");
        translatorMap.put("fire", "feu");
        translatorMap.put("animal", "animal");
        translatorMap.put("boat", "bateau");
        translatorMap.put("car", "voiture");
        translatorMap.put("city", "ville");
        translatorMap.put("farm", "ferme");
        translatorMap.put("tree", "arbre");
        translatorMap.put("sea", "mer");
        translatorMap.put("water", "eau");
        translatorMap.put("river", "rivière");

        // add more words to your translation map as needed

        firstlabel = new JLabel("Enter the input in English:");
        add(firstlabel);

        firsttextField = new JTextField(20);
        add(firsttextField);

        translatorButton = new JButton("Translate to French");
        add(translatorButton);
        translatorButton.addActionListener(this);

        secondlabel = new JLabel("Translated text:");
        add(secondlabel);

        secondtextField = new JTextField(20);
        secondtextField.setEditable(false);
        add(secondtextField);

        setSize(460, 450);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == translatorButton) {
            String textToTranslate = firsttextField.getText();
            String translatedText = translate(textToTranslate);
            secondtextField.setText(translatedText);
        }
    }

    private String translate(String textToTranslate) {
        String[] words = textToTranslate.split(" ");
        StringBuilder translatedText = new StringBuilder();
        for (String word : words) {
            String translatedWord = translatorMap.get(word.toLowerCase());
            if (translatedWord != null) {
                translatedText.append(translatedWord).append(" ");
            } else {
                translatedText.append(word).append(" ");
            }
        }
        return translatedText.toString().trim();
    }

    public static void main(String[] args) {
        new Translator();
    }
}
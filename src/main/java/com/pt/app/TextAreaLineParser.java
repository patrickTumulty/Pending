package com.pt.app;

public class TextAreaLineParser {
    private String title;
    private String description;
    private final String originalText;

    public TextAreaLineParser(String text) {
        originalText = text;
        analyze();
    }

    private void analyze() {
        String[] lines = originalText.split("\\n");
        int counter = 0;
        for (String thisLine : lines) {
            counter++;
            if (!thisLine.equals("")) {
                title = thisLine;
                break;
            }
        }
        StringBuilder stringBuilder = new StringBuilder("");
        for (int i = counter; i < lines.length; i++) {
            String thisLine = lines[i];
            if (!thisLine.equals("")) {
                stringBuilder.append(thisLine).append("\n");
            }
        }
        description = stringBuilder.toString();
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }







}

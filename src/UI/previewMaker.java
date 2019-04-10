package UI;

import javafx.scene.control.TextArea;

import java.io.File;

public class previewMaker {
    private static String orderToStyle(int order) {
        switch (order) {
            case 0:
                return ".wav";
            case 1:
                return ".flac";
            case 2:
                return ".ape";
            case 3:
                return ".dff";
            case 4:
                return ".dsf";
            case 5:
                return ".dts";
        }
        return null;
    }
    public static void maker(File file, String text, int filestyle, TextArea output) {
        try {
            String temp;
            File[] files=file.listFiles();
            for (File one:files) {
                if (one.getName().endsWith(orderToStyle(filestyle))) {
                    temp="FILE \""+one.getName()+"\" WAVE\n";

                    //System.out.println(temp);

                    text=text+temp;
                }
            }
            //System.out.println(text);
            output.setText(text);
        } catch (Exception e) {
            System.out.println("File Folder is null.");
        }
    }
}
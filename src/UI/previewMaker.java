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
            int index=1;
            String temp;
            if (Album.getInstance().getTitle()!=null)
                text="TITLE \""+Album.getInstance().getTitle()+"\""+"\n";
            if (Album.getInstance().getDate()!=null) {
                text=text+"REM DATE "+Album.getInstance().getDate()+"\n";
            }
            if (Album.getInstance().getPerformer()!=null)
                text=text+"PERFORMER \""+Album.getInstance().getPerformer()+"\"\n";
            if (Album.getInstance().getGenre()!=null)
                text=text+"REM GENRE "+Album.getInstance().getGenre()+"\n";
            File[] files=file.listFiles();
            for (File one:files) {
                if (one.getName().endsWith(orderToStyle(filestyle))) {
                    temp="FILE \""+one.getName()+"\" WAVE\n";
                    temp= temp + "  TRACK "+index+" AUDIO\n";
                    temp=temp+"    TITLE \""+one.getName().substring(0,one.getName().lastIndexOf("."))+"\"\n";
                    //System.out.println(temp);
                    index++;
                    if (Album.getInstance().getSinger()!=null)
                        temp=temp+"    PERFORMER \""+Album.getInstance().getSinger()+"\"\n";
                    temp=temp+"    INDEX 01 00:00:00\n";
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

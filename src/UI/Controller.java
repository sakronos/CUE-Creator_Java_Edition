package UI;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.*;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Controller {
    private File file;
    private String CUEFile;
    @FXML protected TextField show_location;
    @FXML protected TextArea preview;
    @FXML protected TextField date;
    @FXML protected TextField genre;
    @FXML protected TextField title;
    @FXML protected TextField singer;
    @FXML protected TextField performer;
    @FXML protected ChoiceBox filestyle;
    @FXML protected void clickMethod_LocalChoose(ActionEvent event) {
        DirectoryChooser directoryChooser=new DirectoryChooser();
        file = directoryChooser.showDialog(new Stage());
        try {
            show_location.setText(file.getPath());
            /* TODO 显示文件夹内的文件后缀名*/
        } catch (Exception exception) {
            System.out.println("No Directory is chosen.");
        }
    }
    @FXML protected void handleMethod_output(ActionEvent event) {
        //System.out.println(preview.getText());
        FileWriter fileWriter=null;
        try {
            fileWriter=new FileWriter(file.getPath()+"\\"+Album.getInstance().getTitle()+".cue",false);
            fileWriter.write(preview.getText());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (fileWriter!=null)
                    fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            //Runtime.getRuntime().exec("explorer /select, " +file.getPath());
            Runtime.getRuntime().exec("explorer /root, " +file.getPath());
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML protected void handleTypeChoice(MouseEvent event) {
        filestyle.getSelectionModel().selectedIndexProperty().addListener(new ChoiceEvent(filestyle));
        previewMaker.maker(file,CUEFile,filestyle.getSelectionModel().getSelectedIndex(),preview);
    }

    @FXML protected void setGenre(MouseEvent event) {
        genre.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                Album.getInstance().setGenre(genre.getText());
                previewMaker.maker(file,CUEFile,filestyle.getSelectionModel().getSelectedIndex(),preview);
            }
        });
    }

    @FXML protected void setDate(MouseEvent event) {
        //TODO 似乎日期最后设置的话预览界面总不能成功更新DATE，原因有待找出
        date.textProperty().addListener((observable, oldValue, newValue) -> {
            Album.getInstance().setDate(date.getText());
            previewMaker.maker(file,CUEFile,filestyle.getSelectionModel().getSelectedIndex(),preview);
        });
    }

    @FXML protected void setTitle(MouseEvent event) {
        title.textProperty().addListener((observable, oldValue, newValue) -> {
            Album.getInstance().setTitle(title.getText());
            //System.out.println(Album.getInstance().getTitle());
            //preview.setText(Album.getInstance().getTitle()+"\n"+Album.getInstance().getGenre());
            previewMaker.maker(file,CUEFile,filestyle.getSelectionModel().getSelectedIndex(),preview);
        });
    }

    @FXML protected void setSinger(MouseEvent event) {
        singer.textProperty().addListener((observable, oldValue, newValue) -> {
            Album.getInstance().setSinger(singer.getText());
            previewMaker.maker(file,CUEFile,filestyle.getSelectionModel().getSelectedIndex(),preview);
        });
    }

    @FXML protected void  setPerformer(MouseEvent event) {
        performer.textProperty().addListener((observable, oldValue, newValue) -> {
            Album.getInstance().setPerformer(performer.getText());
            previewMaker.maker(file,CUEFile,filestyle.getSelectionModel().getSelectedIndex(),preview);
        });
    }
}

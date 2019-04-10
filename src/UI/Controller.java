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

    }

    @FXML protected void handleTypeChoice(MouseEvent event) {
        filestyle.getSelectionModel().selectedIndexProperty().addListener(new ChoiceEvent(filestyle));
        previewMaker.maker(file,CUEFile,filestyle.getSelectionModel().getSelectedIndex(),preview);
        //preview.setText(CUEFile);
    }

    @FXML protected void setGenre(MouseEvent event) {
        genre.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                Album.getInstance().setGenre(genre.getText());
            }
        });
    }

    @FXML protected void setDate(MouseEvent event) {
        date.textProperty().addListener((observable, oldValue, newValue) -> {
            Album.getInstance().setDate(date.getText());
        });
    }

    @FXML protected void setTitle(MouseEvent event) {
        title.textProperty().addListener((observable, oldValue, newValue) -> {
            Album.getInstance().setTitle(title.getText());
            //System.out.println(Album.getInstance().getTitle());
            //preview.setText(Album.getInstance().getTitle()+"\n"+Album.getInstance().getGenre());
        });
    }

    @FXML protected void setSinger(MouseEvent event) {
        singer.textProperty().addListener((observable, oldValue, newValue) -> {
            Album.getInstance().setSinger(singer.getText());
        });
    }

    @FXML protected void  setPerformer(MouseEvent event) {
        performer.textProperty().addListener((observable, oldValue, newValue) -> {
            Album.getInstance().setPerformer(performer.getText());
        });
    }
}

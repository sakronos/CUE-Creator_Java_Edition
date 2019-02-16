package UI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import java.io.File;

public class Controller {
    private File file;
    @FXML protected TextField show_location;
    @FXML protected void clickMethod_LocalChoose(ActionEvent event1) {
        DirectoryChooser directoryChooser=new DirectoryChooser();
        file = directoryChooser.showDialog(new Stage());
        try {
            show_location.setText(file.getPath());
            /* TODO 显示文件夹内的文件后缀名*/
        } catch (Exception exception) {
            System.out.println("No Directory is chosen.");
        }
    }
}

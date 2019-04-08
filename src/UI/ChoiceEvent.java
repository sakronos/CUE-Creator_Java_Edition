package UI;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.ChoiceBox;

public class ChoiceEvent implements ChangeListener<Number> {
    ChoiceBox choiceBox;

    public ChoiceEvent(ChoiceBox choiceBox) {
        this.choiceBox = choiceBox;
    }

    @Override
    public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
        switch (choiceBox.getSelectionModel().getSelectedIndex()) {
            case 0:
                System.out.println("wav");
                break;
            case 1:
                System.out.println("flac");
                break;
            case 2:
                System.out.println("ape");
                break;
            case 3:
                System.out.println("dff");
                break;
            case 4:
                System.out.println("dsf");
                break;
            case 5:
                System.out.println("dts");
        }
    }
}

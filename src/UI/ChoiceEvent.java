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

    }
}

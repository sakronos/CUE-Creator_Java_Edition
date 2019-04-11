package UI;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.ChoiceBox;

public class ChoiceEvent implements ChangeListener<Number> {
    ChoiceBox choiceBox;

    public ChoiceEvent(ChoiceBox choiceBox) {
        this.choiceBox = choiceBox;
    }

    /*
    TODO 现在发现这个类建了没什么用，亏我在这个上面花了那么长时间，
         不过正是因为研究这个，我了解了JavaFX的监听的写法
         发现可以自己写Java没有提供的监听功能

    TODO 如果有机会重写这个类，我会将按文件类型限定文件的功能移到这边来，
         通过传递Files[]数组，这样只需遍历一次文件夹
     */

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
                break;
            case 6:
                System.out.println("tta");
                break;
        }
    }
}

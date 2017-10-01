package utils;

import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;

public class GroupButtonUtils {

    public String getSelectedButtonText(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return button.getText();
            }
        }

        return null;
    }
    public int getSelectedOption(ButtonGroup buttonGroup){
        String selected=getSelectedButtonText(buttonGroup);
        String[] sa=selected.split(" ");
        if(sa.length>1 && sa[1].length()==1) return Integer.parseInt(sa[1]);
        return 0;
    }
}

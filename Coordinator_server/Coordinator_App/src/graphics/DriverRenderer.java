package graphics;

import java.awt.Color;
import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

import entities.Driver;

public class DriverRenderer extends DefaultListCellRenderer {
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        if (value instanceof Driver) {
            setText(((Driver)value).getName());
            if(((Driver)value).getCurrentClient() != null )
            setBackground(Color.green);
        }
        return this;
    }
}

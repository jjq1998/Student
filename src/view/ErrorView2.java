package view;

import constants.AppConstants;

import javax.swing.*;

public class ErrorView2 extends JDialog
{
    public ErrorView2(JFrame jFrame)
    {
        super(jFrame,AppConstants.ERROR_TITLE,true);
        JLabel label = new JLabel(AppConstants.ERROR_TEXT2);
        label.setHorizontalAlignment(SwingConstants.CENTER);

        add(label);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(300,200);
        setLocation(800,400);
        setVisible(true);
    }
}

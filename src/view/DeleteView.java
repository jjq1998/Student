package view;

import bean.Student;
import constants.AppConstants;
import dao.StudentDAO;

import javax.swing.*;
import java.awt.*;

public class DeleteView extends JFrame
{
    private ImageIcon background;
    private Container container;
    private JLabel jLabel;
    private JTextField sno;
    private JButton button;
    public DeleteView()
    {
        //添加背景
        background = new ImageIcon(AppConstants.LOGIN_BACKGROUND_URL);
        JLabel backLabel = new JLabel(background);
        backLabel.setBounds(0,0,background.getIconWidth(),background.getIconHeight());
        getLayeredPane().add(backLabel,new Integer(Integer.MIN_VALUE));
        //获取容器
        container = getContentPane();
        container.setLayout(null);
        ((JPanel)container).setOpaque(false);

        jLabel = new JLabel(AppConstants.DELETE_SNO);
        jLabel.setBounds(50,30,100,30);
        sno = new JTextField();
        sno.setBounds(150,30,100,30);
        button = new JButton(AppConstants.DELETE_BUTTON);
        button.setBounds(100,100,100,30);
        button.addActionListener(e ->
        {
            try
            {
                int i = StudentDAO.deleteByID(Integer.valueOf(sno.getText()));
                if (i == 0)
                {
                    new ErrorView2(this);
                }
                else
                    dispose();
            }
            catch (Exception e1)
            {
                new ErrorView2(this);
            }
        });

        container.add(jLabel);
        container.add(button);
        container.add(sno);

        setLayout(null);
        setTitle(AppConstants.DELETE_TITLE);
        setSize(300,200);
        setResizable(false);
        setVisible(true);
        setLocation(800,400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}

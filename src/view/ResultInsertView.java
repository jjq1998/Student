package view;

import constants.AppConstants;
import dao.ResultDAO;

import javax.swing.*;
import java.awt.*;

public class ResultInsertView extends JFrame
{
    private ImageIcon background;
    private Container container;
    private JLabel snoLabel,c_idLaber,markLabel;
    private JTextField sno,c_id,mark;
    private JButton jButtonOK,jButtonReset;
    public ResultInsertView()
    {
        setLayout(null);
        //添加背景
        background = new ImageIcon(AppConstants.LOGIN_BACKGROUND_URL);
        JLabel backLabel = new JLabel(background);
        backLabel.setBounds(0,0,background.getIconWidth(),background.getIconHeight());
        getLayeredPane().add(backLabel,new Integer(Integer.MIN_VALUE));
        //获取容器
        container = getContentPane();
        container.setLayout(null);
        ((JPanel)container).setOpaque(false);

        snoLabel = new JLabel("学号");
        snoLabel.setBounds(50,30,100,50);
        c_idLaber = new JLabel("课号");
        c_idLaber.setBounds(50,80,100,50);
        markLabel = new JLabel("分数");
        markLabel.setBounds(50,130,100,50);
        sno = new JTextField();
        sno.setBounds(150,40,120,30);
        c_id = new JTextField();
        c_id.setBounds(150,90,120,30);
        mark = new JTextField();
        mark.setBounds(150,140,120,30);
        jButtonOK = new JButton("确定");
        jButtonOK.setBounds(30,200,100,30);
        jButtonOK.addActionListener(e ->
        {
            try
            {
                ResultDAO.insert(Integer.valueOf(sno.getText()),Integer.valueOf(c_id.getText()),Integer.valueOf(mark.getText()));
                dispose();
            }
            catch (Exception e1)
            {
                new ErrorView2(this);
            }
        });
        jButtonReset = new JButton("重置");
        jButtonReset.setBounds(150,200,100,30);
        jButtonReset.addActionListener(e ->
        {
            sno.setText("");
            c_id.setText("");
            mark.setText("");
        });

        container.add(snoLabel);
        container.add(sno);
        container.add(c_idLaber);
        container.add(c_id);
        container.add(markLabel);
        container.add(mark);
        container.add(jButtonOK);
        container.add(jButtonReset);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("添加成绩");
        setVisible(true);
        setResizable(false);
        setSize(300,300);
        setLocation(800,400);
    }
}

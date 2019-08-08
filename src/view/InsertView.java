package view;

import constants.AppConstants;
import dao.StudentDAO;

import javax.swing.*;
import java.awt.*;

public class InsertView extends JFrame
{

    private static ImageIcon background;
    private Container container;
    private JTextField sno,c_id,name,sex,birth,address,dormitory,tel,duty;
    private JLabel snoLabel,c_idLabel,nameLabel,sexLabel,birthLabel,addressLabel,dormitoryLabel,telLabel,dutyLabel;
    private JButton jButtonOK,jButtonReset;
    public InsertView()
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

        snoLabel = new JLabel(AppConstants.INSERT_SNO);
        snoLabel.setBounds(40,0,150,50);
        c_idLabel = new JLabel(AppConstants.INSERT_C_ID);
        c_idLabel.setBounds(40,48,150,50);
        nameLabel = new JLabel(AppConstants.INSERT_NAME);
        nameLabel.setBounds(40,96,150,50);
        sexLabel = new JLabel(AppConstants.INSERT_SEX);
        sexLabel.setBounds(40,144,150,50);
        birthLabel = new JLabel(AppConstants.INSERT_BIRTH);
        birthLabel.setBounds(40,192,150,50);
        addressLabel = new JLabel(AppConstants.INSERT_ADDRESS);
        addressLabel.setBounds(40,240,150,50);
        dormitoryLabel = new JLabel(AppConstants.INSERT_DORMITORY);
        dormitoryLabel.setBounds(40,288,150,50);
        telLabel = new JLabel(AppConstants.INSERT_TEL);
        telLabel.setBounds(40,336,150,50);
        dutyLabel = new JLabel(AppConstants.INSERT_DUTY);
        dutyLabel.setBounds(40,384,150,50);

        sno = new JTextField();
        sno.setBounds(120,10,150,30);
        c_id = new JTextField();
        c_id.setBounds(120,58,150,30);
        name = new JTextField();
        name.setBounds(120,106,150,30);
        sex = new JTextField();
        sex.setBounds(120,154,150,30);
        birth = new JTextField();
        birth.setBounds(120,202,150,30);
        address = new JTextField();
        address.setBounds(120,250,150,30);
        dormitory = new JTextField();
        dormitory.setBounds(120,298,150,30);
        tel = new JTextField();
        tel.setBounds(120,346,150,30);
        duty = new JTextField();
        duty.setBounds(120,394,150,30);

        jButtonOK = new JButton(AppConstants.INSERT_OKBUTTON);
        jButtonOK.setBounds(45,430,100,30);
        jButtonOK.addActionListener(e ->
        {
            try
            {
                StudentDAO.insert(Integer.valueOf(sno.getText()),Integer.valueOf(c_id.getText()),name.getText(),sex.getText(),birth.getText(),address.getText(),dormitory.getText(),tel.getText(),duty.getText());
                dispose();
            }
            catch (Exception e1)
            {
                new ErrorView2(this);
            }
        });
        jButtonReset = new JButton(AppConstants.INSERT_RESET);
        jButtonReset.addActionListener(e ->
        {
            sno.setText("");
            c_id.setText("");
            name.setText("");
            sex.setText("");
            birth.setText("");
            address.setText("");
            dormitory.setText("");
            tel.setText("");
            duty.setText("");
        });
        jButtonReset.setBounds(155,430,100,30);

        container.add(jButtonOK);
        container.add(jButtonReset);
        container.add(snoLabel);
        container.add(sno);
        container.add(c_idLabel);
        container.add(c_id);
        container.add(nameLabel);
        container.add(name);
        container.add(sexLabel);
        container.add(sex);
        container.add(birthLabel);
        container.add(birth);
        container.add(addressLabel);
        container.add(address);
        container.add(dormitoryLabel);
        container.add(dormitory);
        container.add(telLabel);
        container.add(tel);
        container.add(dutyLabel);
        container.add(duty);

        setLayout(null);
        setTitle(AppConstants.INSERT_TITLE);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(300,500);
        setLocation(800,200);
    }
}

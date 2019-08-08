package view;

import bean.User;
import constants.AppConstants;
import dao.UserDAO;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class LoginView extends JFrame
{
    private JTextField username;
    private Container container;
    private JPasswordField password;
    private JButton loginButton,resetButton;
    private ImageIcon background;

    public LoginView()
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

        //添加Logo
        JLabel logoLabel = new JLabel(AppConstants.LOGIN_LOGO);
        logoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        logoLabel.setBounds(0,0,500,100);
        container.add(logoLabel);

        //添加用户名行
        JLabel userLabel = new JLabel(AppConstants.LOGIN_USERNAME);
        userLabel.setHorizontalAlignment(SwingConstants.CENTER);
        userLabel.setBounds(10,100,250,30);
        container.add(userLabel);
        username = new JTextField();
        username.setBounds(250,100,200,30);
        container.add(username);

        //添加密码行
        JLabel passwordLabel = new JLabel(AppConstants.LOGIN_PASSWORD);
        passwordLabel.setHorizontalAlignment(SwingConstants.CENTER);
        passwordLabel.setBounds(10,140,250,30);
        container.add(passwordLabel);
        password = new JPasswordField();
        password.setBounds(250,140,200,30);
        container.add(password);

        //添加登录按钮
        loginButton = new JButton(AppConstants.LOGIN);
        loginButton.setBounds(125,200,100,30);
        loginButton.addActionListener(e ->
        {
            this.check();
        });
        container.add(loginButton);

        //添加重置按钮
        resetButton = new JButton(AppConstants.RESET);
        resetButton.setBounds(275,200,100,30);
        resetButton.addActionListener(e ->
        {
            username.setText("");
            password.setText("");
        });
        container.add(resetButton);

        setTitle(AppConstants.LOGIN_TITLE);
        setSize(500,300);
        setVisible(true);
        setResizable(false);
        setLocation(700,300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private void check()
    {
        try
        {
            User select = UserDAO.select(username.getText(), String.valueOf(password.getPassword()));
            if (null != select)
            {
                dispose();
                new MainView(select);
            }
            else
            {
                username.setText("");
                password.setText("");
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}

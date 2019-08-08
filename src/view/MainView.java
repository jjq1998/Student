package view;

import bean.User;
import constants.AppConstants;
import dao.StudentDAO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;

public class MainView extends JFrame
{
    private static User user;
    private static Container container;
    private static ImageIcon background;
    private static JPanel jPanelTop, jPanelBottom;
    private static JButton findButton, insertButton, deleteButton, updateButton, resultSelectButton, resultInsertButton,freshButton;
    private static JTextField condition;
    private static JScrollPane jScrollPane;
    private static JTable table;
    private static String[][] strings;
    private DefaultTableModel myTableModel;

    public MainView(User user)
    {
        this.user = user;
        //添加背景
        background = new ImageIcon(AppConstants.LOGIN_BACKGROUND_URL);
        JLabel backLabel = new JLabel(background);
        backLabel.setBounds(0, 0, background.getIconWidth(), background.getIconHeight());
        getLayeredPane().add(backLabel, new Integer(Integer.MIN_VALUE));
        //获取容器
        container = getContentPane();
        container.setLayout(null);
        ((JPanel) container).setOpaque(false);
        //写顶部
        jPanelTop = new JPanel();
        jPanelTop.setSize(990, 40);
        jPanelTop.setLayout(new GridLayout(1, 5));
        condition = new JTextField();
        findButton = new JButton(AppConstants.MAIN_FIND);
        findButton.addActionListener(e ->
        {
            try
            {
                if ("".equals(condition.getText()) || condition.getText() == null)
                {
                    ((DefaultTableModel) table.getModel()).setDataVector(null, AppConstants.MAIN_COLUMNNAME);
                }
                else
                {
                    String[][] strings = StudentDAO.selectById(Integer.valueOf(condition.getText()));
                    ((DefaultTableModel) table.getModel()).setDataVector(strings, AppConstants.MAIN_COLUMNNAME);
                }
            }
            catch (SQLException e1)
            {
                e1.printStackTrace();
            }
            catch (ClassNotFoundException e1)
            {
                e1.printStackTrace();
            }
            catch (Exception e1)
            {
                e1.printStackTrace();
            }
        });
        insertButton = new JButton(AppConstants.MAIN_INSERT);
        insertButton.addActionListener(e ->
        {
            if (user.getUserName().startsWith("admin"))
            {
                new InsertView();
            }
            else
                new ErrorView(this);
        });
        deleteButton = new JButton(AppConstants.MAIN_DELETE);
        deleteButton.addActionListener(e ->
        {
            if (user.getUserName().startsWith("admin"))
            {
                new DeleteView();
            }
            else
                new ErrorView(this);
        });
        updateButton = new JButton(AppConstants.MAIN_UPDATE);
        updateButton.addActionListener(e ->
        {
            if (user.getUserName().startsWith("admin"))
            {
                new UpateView();
            }
            else
                new ErrorView(this);
        });
        jPanelTop.add(condition);
        jPanelTop.add(findButton);
        jPanelTop.add(insertButton);
        jPanelTop.add(deleteButton);
        jPanelTop.add(updateButton);

        //写底部
        jPanelBottom = new JPanel();
        jPanelBottom.setSize(990,40);
        jPanelBottom.setLocation(0,520);
        jPanelBottom.setLayout(new GridLayout(1,3));
        resultSelectButton = new JButton(AppConstants.MAIN_RESULT_SELECT);
        resultSelectButton.addActionListener(e ->
        {
            new ResultSelectView();
        });
        resultInsertButton = new JButton(AppConstants.MAIN_RESULT_INSERT);
        resultInsertButton.addActionListener(e ->
        {
            if (user.getUserName().startsWith("t") || user.getUserName().startsWith("admin"))
            {
                new ResultInsertView();
            }
            else
                new ErrorView(this);
        });
        freshButton = new JButton(AppConstants.MAIN_FRESH);
        freshButton.addActionListener(e ->
        {
            try
            {
                strings = StudentDAO.selectAll();
            }
            catch (Exception e1)
            {
                e1.printStackTrace();
            }
            ((DefaultTableModel) table.getModel()).setDataVector(strings, AppConstants.MAIN_COLUMNNAME);
        });

        jPanelBottom.add(resultSelectButton);
        jPanelBottom.add(freshButton);
        jPanelBottom.add(resultInsertButton);

        //写中间
        try
        {
            strings = StudentDAO.selectAll();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        myTableModel = new DefaultTableModel(strings, AppConstants.MAIN_COLUMNNAME);
        table = new JTable(myTableModel);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane = new JScrollPane(table);
        jScrollPane.setSize(990,480);
        jScrollPane.setLocation(0,40);


        //框架设置
        setLayout(null);
        add(jPanelTop);
        add(jScrollPane);
        add(jPanelBottom);
        setTitle(AppConstants.MAIN_TITLE);
        setResizable(false);
        setVisible(true);
        setSize(995, 590);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocation(700, 300);
    }


}

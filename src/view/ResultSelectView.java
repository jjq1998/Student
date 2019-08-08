package view;

import constants.AppConstants;
import dao.ResultDAO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;

public class ResultSelectView extends JFrame
{
    private JPanel jPanel;
    private JTextField sno;
    private JButton jButtonOK, jButtonAverage,jButtonCount;
    private DefaultTableModel myTableModel;
    private JScrollPane jScrollPane;
    private static JTable table;
    private static String[][] strings;


    public ResultSelectView()
    {
        setLayout(null);
        jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(1, 3));
        sno = new JTextField();
        jButtonOK = new JButton("确定");
        jButtonOK.addActionListener(e ->
        {
            try
            {
                strings = ResultDAO.selectById(Integer.valueOf(sno.getText()));
            }
            catch (SQLException ex)
            {
                ex.printStackTrace();
            }
            catch (ClassNotFoundException ex)
            {
                ex.printStackTrace();
            }
            catch (Exception e1)
            {
                e1.printStackTrace();
            }
            myTableModel = new DefaultTableModel(strings, AppConstants.RESULT_SELECT_COLUMN);
            table = new JTable(myTableModel);
            table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            jScrollPane = new JScrollPane(table);
            jScrollPane.setSize(500, 460);
            jScrollPane.setLocation(0, 40);
            add(jScrollPane);
        });
        jButtonAverage = new JButton("平均分");
        jButtonAverage.addActionListener(e ->
        {
            try
            {
                strings = ResultDAO.selectAVG(Integer.valueOf(sno.getText()));
            }
            catch (SQLException ex)
            {
                ex.printStackTrace();
            }
            catch (ClassNotFoundException ex)
            {
                ex.printStackTrace();
            }
            catch (Exception e1)
            {
                e1.printStackTrace();
            }
            myTableModel = new DefaultTableModel(strings, AppConstants.RESULT_SELECTAVG_COLUMN);
            table = new JTable(myTableModel);
            table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            jScrollPane = new JScrollPane(table);
            jScrollPane.setSize(500, 460);
            jScrollPane.setLocation(0, 40);
            add(jScrollPane);
        });
        jButtonCount = new JButton("统计");
        jButtonCount.addActionListener(e ->
        {
            try
            {
                String text = sno.getText();
                String[] s = text.split("-");
                strings = ResultDAO.selectCount(Integer.valueOf(s[0]), Integer.valueOf(s[1]));
            }
            catch (Exception e1)
            {
                new ErrorView2(this);
            }
            myTableModel = new DefaultTableModel(strings, AppConstants.RESULT_SELECTCOUNT_COLUMN);
            table = new JTable(myTableModel);
            table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
            jScrollPane = new JScrollPane(table);
            jScrollPane.setSize(500, 460);
            jScrollPane.setLocation(0, 40);
            add(jScrollPane);
        });

        jPanel.setSize(500, 30);
        jPanel.add(sno);
        jPanel.add(jButtonOK);
        jPanel.add(jButtonAverage);
        jPanel.add(jButtonCount);

        add(jPanel);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        setTitle(AppConstants.RESULT_SELECT_TITLE);
        setSize(500, 500);
        setLocation(800, 300);
        setResizable(false);
    }
}

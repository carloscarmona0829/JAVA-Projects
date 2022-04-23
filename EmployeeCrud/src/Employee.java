/*
ctrl  Alt  l --> formatea el código (Identar)
ctrl  shift + --> encoge todo el código
ctrl  shift - --> expande todo el código
ctrl Shift / --> comenta el bloque de código seleccionado
*/

import net.proteanit.sql.DbUtils;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Employee {
    private JPanel Main;
    private JTextField txtName;
    private JTextField txtSalary;
    private JTextField txtMobile;
    private JButton btnSave;
    private JTable table1;
    private JButton btnUpdate;
    private JButton btnDelete;
    private JButton btnSearch;
    private JTextField txtSearch;
    private JScrollPane tbl_1;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Employee");
        frame.setContentPane(new Employee().Main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    //region * Variables Globales *

    Connection con;
    PreparedStatement pst;

    //endregion

    //region * Métodos Privados *

    public void connect() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rbcompany", "root", "123456");
            System.out.println("Success");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
    }

    private void table_load() {
        try {
            pst = con.prepareStatement("select * from employee");
            ResultSet rs = pst.executeQuery();
            table1.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }

    }

    //endregion

    //region * Eventos *

    public Employee() {
        connect();
        table_load();

        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String name, salary, mobile;

                name = txtName.getText();
                salary = txtSalary.getText();
                mobile = txtMobile.getText();

                try {
                    pst = con.prepareStatement("insert into employee(name, salary, mobile)value(?,?,?)");
                    pst.setString(1, name);
                    pst.setString(2, salary);
                    pst.setString(3, mobile);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Record Added!!!");
                    table_load();
                    txtName.setText("");
                    txtSalary.setText("");
                    txtMobile.setText("");
                    txtName.requestFocus();
                } catch (Exception e1) {
                    e1.printStackTrace();
                    System.out.println(e);
                }

            }
        });
        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    String id = txtSearch.getText();

                    pst = con.prepareStatement("select name, salary, mobile from employee where id = ?");
                    pst.setString(1, id);
                    ResultSet rs = pst.executeQuery();

                    if (rs.next() == true) {

                        String name = rs.getString(1);
                        String salary = rs.getString(2);
                        String mobile = rs.getString(3);

                        txtName.setText(name);
                        txtSalary.setText(salary);
                        txtMobile.setText(mobile);
                    } else {
                        txtName.setText("");
                        txtSalary.setText("");
                        txtMobile.setText("");
                        JOptionPane.showMessageDialog(null, "Invalid Employee Number");
                    }
                } catch (Exception e1) {
                    e1.printStackTrace();
                    System.out.println(e);
                }
            }
        });
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                String id, name, salary, mobile;

                id = txtSearch.getText();
                name = txtName.getText();
                salary = txtSalary.getText();
                mobile = txtMobile.getText();

                try {
                    pst = con.prepareStatement("update employee set name = ?,salary = ?,mobile = ? where id = ?");
                    pst.setString(1, name);
                    pst.setString(2, salary);
                    pst.setString(3, mobile);
                    pst.setString(4, id);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Record Updated!!!");
                    table_load();
                    txtName.setText("");
                    txtSalary.setText("");
                    txtMobile.setText("");
                    txtName.requestFocus();
                } catch (Exception e1) {
                    e1.printStackTrace();
                    System.out.println(e);
                }

            }
        });
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String id;
                id = txtSearch.getText();

                try {
                    pst = con.prepareStatement("delete from employee where id = ?");
                    pst.setString(1, id);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Record Deleted!!!");
                    table_load();
                    txtName.setText("");
                    txtSalary.setText("");
                    txtMobile.setText("");
                    txtName.requestFocus();
                } catch (Exception e1) {
                    e1.printStackTrace();
                    System.out.println(e);
                }

            }
        });
    }

    //endregion
}

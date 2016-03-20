package GUI;

import Main.LoginInfo;
import WebUtil.Login.LoginReq;
import WebUtil.Login.LoginRes;
import WebUtil.Webutil;

import javax.swing.*;
import javax.swing.event.AncestorListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by bjc90_000 on 3/20/2016.
 */
public class LoginScreen extends JFrame{
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton button1;
    private JPanel RootPanel;


    public LoginScreen() {

        super("ScholarStation Admin");
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setContentPane(RootPanel);
        setSize(300,200);
        setLocationRelativeTo(null);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginReq lr = new LoginReq();
                lr.password =new String( passwordField1.getPassword());
                lr.username = textField1.getText();
                LoginRes loginRes = (LoginRes) new Webutil().webRequest(lr);
                LoginInfo.KEY = loginRes.KEY;
                LoginInfo.username = lr.username;
                if(LoginInfo.KEY !=null){
                    new Dashboard();
                    dispose();
                } else
                    JOptionPane.showMessageDialog(getContentPane(),
                            "Invalid Login Credentials.",
                            "ERROR",
                            JOptionPane.ERROR_MESSAGE);

            }
        });
    }
}

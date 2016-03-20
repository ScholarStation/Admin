package GUI;

import Main.LoginInfo;
import WebUtil.Profile.ProfileReq;
import WebUtil.Webutil;

import javax.swing.*;



/**
 * Created by bjc90_000 on 3/20/2016.
 */
public class Dashboard extends JFrame{
    private JPanel panel1;
    private JTextArea textArea1;

    public Dashboard(){
        super("ScholarStation Admin Dashboard         USER: "+ LoginInfo.username);
        setContentPane(panel1);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(MAXIMIZED_BOTH);
        createUIComponents();
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        ProfileReq pr = new ProfileReq();
        pr.username= LoginInfo.username;
        pr.KEY = LoginInfo.KEY;
        textArea1.setText(new Webutil().webRequest(pr).toString());
    }
}

package pv3;

import javax.swing.*;
import java.awt.event.*;

public class LoginForma extends JDialog {
    private JPanel contentPane;
    private JButton buttonCheck;
    private JButton buttonCancel;
    private JTextField usernameTextField;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JTextField passwordTextField;

    public LoginForma() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonCheck);

        buttonCheck.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        // add your code here
        if (usernameTextField.getText().isEmpty() || passwordTextField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Unesite sve vrednosti!", "Upozorenje", JOptionPane.WARNING_MESSAGE);
        }
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        LoginForma dialog = new LoginForma();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}

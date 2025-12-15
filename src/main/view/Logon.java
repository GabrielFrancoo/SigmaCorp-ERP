package main.view;
import javax.swing.*;
import main.model.LoginAcess;

public class Logon extends JFrame{
    public static void main(String[] args) {
        JFrame frame = new JFrame("SigmaCorp");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);

        JLabel login = new JLabel("Login:");
        login.setBounds(70, 40, 250, 25);
        frame.add(login);

        JTextField loginUser= new JTextField();
        loginUser.setBounds(70, 60, 250, 25);
        frame.setLayout(null);
        frame.add(loginUser);

        JLabel password = new JLabel("Senha:");
        password.setBounds(70, 100, 250, 25);
        frame.add(password);

        JPasswordField Password= new JPasswordField();
        Password.setBounds(70, 120, 250, 25);
        frame.add(Password);

        JButton button = new JButton("Enter");
        button.setBounds(150, 170, 100, 25);
        frame.add(button);

        button.addActionListener(e -> {
            LoginAcess acesso = new LoginAcess(loginUser, Password);
            acesso.validarLogin();
            
        });

        frame.setVisible(true);
    }
}

package main.model;
import javax.swing.JTextField;

import main.view.Inicial;

import javax.swing.JOptionPane;

public class LoginAcess {
    private JTextField loginUser;
    private JTextField passwordUser;
    
    public LoginAcess(JTextField loginUser, JTextField Password){
        this.loginUser = loginUser;
        this.passwordUser = Password;
    }
        public void validarLogin(){
            String login = loginUser.getText();
            String password = passwordUser.getText();


            if(login.equals("admin") && password.equals("123")){
                Inicial inicial = new Inicial();
                inicial.setVisible(true);
                inicial.setResizable(false);
            }else{
            JOptionPane.showMessageDialog(null, "Acesso negado!");
         }
    }
   }

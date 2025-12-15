package main.view;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Inicial  extends JFrame{

    public Inicial(){
    super("Inicial - SigmaCorp");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(800, 500);
    setResizable(false);

ImageIcon img = new ImageIcon("src/main/assets/SigmaCorp.png");

// diminui o tamanho (ex: 150 x 200)
Image smaller = img.getImage().getScaledInstance(150, 200, Image.SCALE_SMOOTH);

JLabel backgroundLabel = new JLabel(new ImageIcon(smaller));
backgroundLabel.setBounds(0, 0, 150, 200);
add(backgroundLabel);

    JLabel ApontamentoProd = new JLabel("Apont_Producao");
    ApontamentoProd.setFont(new Font("Times New Roman", Font.BOLD, 18));
    ApontamentoProd.setForeground(new Color(30, 144, 255));
    ApontamentoProd.setCursor(new Cursor(Cursor.HAND_CURSOR));

    ApontamentoProd.setSize(ApontamentoProd.getPreferredSize());
    ApontamentoProd.setBounds(0,215,160, ApontamentoProd.getPreferredSize().height);

    ApontamentoProd.setBorder(BorderFactory.createLineBorder(Color.RED));

    ApontamentoProd.addMouseListener(new MouseAdapter(){
        @Override
        public void mouseClicked(MouseEvent e) {
            new ApontProducao().setVisible(true);
            dispose();
        }
    });
    add(ApontamentoProd);

    JLabel ApontametoHr = new JLabel("Apont_Horas");
    ApontametoHr.setFont(new Font("Times New Roman", Font.BOLD, 18));
    ApontametoHr.setForeground(new Color(30, 144, 255));
    ApontametoHr.setCursor(new Cursor(Cursor.HAND_CURSOR));

    ApontametoHr.setSize(ApontametoHr.getPreferredSize());
    ApontametoHr.setBounds(0,242,160, ApontametoHr.getPreferredSize().height);

    ApontametoHr.setBorder(BorderFactory.createLineBorder(Color.RED));

    ApontametoHr.addMouseListener(new MouseAdapter(){
    @Override
        public void mouseClicked(MouseEvent e) {
            // Ação ao clicar em Apontamento de Horas
            new ApontamentoHoras().setVisible(true);
            dispose();
        }
    });

    add(ApontametoHr);

    JLabel CadastroProduto = new JLabel("Cadastro_Produto");
    CadastroProduto.setBounds(0,225,180,100);
    CadastroProduto.setFont(new Font("Times New Roman", Font.BOLD, 18));
    CadastroProduto.setForeground(new Color(30, 144, 255));
    add(CadastroProduto);

    JLabel EstruturaProd = new JLabel("Estrutura_Produto");
    EstruturaProd.setBounds(0,250,180,100);
    EstruturaProd.setFont(new Font("Times New Roman", Font.BOLD, 18));
    EstruturaProd.setForeground(new Color(30, 144, 255));
    add(EstruturaProd);

    JLabel Kardex = new JLabel("Kardex");
    Kardex.setBounds(0,275,150,100);
    Kardex.setFont(new Font("Times New Roman", Font.BOLD, 18));
    Kardex.setForeground(new Color(30, 144, 255));
    add(Kardex);

    JLabel Relatorios = new JLabel("Relatorios");
    Relatorios.setBounds(0,300,100,100);
    Relatorios.setFont(new Font("Times New Roman", Font.BOLD, 18));
    Relatorios.setForeground(new Color(30, 144, 255));
    add(Relatorios);

    JLabel Faturamento = new JLabel("Faturamento");
    Faturamento.setBounds(0,325,150,100);
    Faturamento.setFont(new Font("Times New Roman", Font.BOLD, 18));
    Faturamento.setForeground(new Color(30, 144, 255));
    add(Faturamento);

    JLabel Configuracoes = new JLabel("Configuracoes");
    Configuracoes.setBounds(0,350,150,100);
    Configuracoes.setFont(new Font("Times New Roman", Font.BOLD, 18));
    Configuracoes.setForeground(new Color(30, 144, 255));
    add(Configuracoes); 


    JLabel Informacoes = new JLabel("Informacoes");
    Informacoes.setBounds(0,375,150,100);
    Informacoes.setFont(new Font("Times New Roman", Font.BOLD, 18));
    Informacoes.setForeground(new Color(30, 144, 255));
    add(Informacoes);

    JLabel BoasVindas = new JLabel("<html><center>Bem Vindo<br>ao SigmaCorp!</center><html/>");
    BoasVindas.setBounds(300,50,600,280);
    BoasVindas.setFont(new Font("Times New Roman", Font.BOLD, 50));
    BoasVindas.setForeground(Color.BLACK);
    add(BoasVindas);



    setLayout(null);
    setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        Inicial inicial = new Inicial();
        inicial.setVisible(true);
    }
}

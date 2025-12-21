package main.view;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;


public class CadastraProduto extends JFrame{
        public CadastraProduto(){
        setTitle("Cadastro de Produtos - SigmaCorp");
        setSize(700, 250);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


 setLayout(new GridBagLayout());

// ================= PRODUTO =================
GridBagConstraints produto = new GridBagConstraints();
produto.insets = new Insets(10, 10, 10, 10);
produto.anchor = GridBagConstraints.WEST;

// Label
produto.gridx = 0;
produto.gridy = 0;
produto.weightx = 0;
produto.weighty = 0;
add(new JLabel("Produto:"), produto);

// Campo
produto.gridx = 1;
produto.gridy = 0;
produto.fill = GridBagConstraints.NONE;
produto.weightx = 1.0;
produto.weighty = 0;
add(new JTextField(20), produto);

// ================= DESCRIÇÃO =================
GridBagConstraints descricao = new GridBagConstraints();
descricao.insets = new Insets(10, 10, 10, 10);
descricao.anchor = GridBagConstraints.WEST;

// Label
descricao.gridx = 0;
descricao.gridy = 1;
descricao.weightx = 0;
descricao.weighty = 0;
add(new JLabel("Descricao:"), descricao);

// Campo
descricao.gridx = 1;
descricao.gridy = 1;
descricao.fill = GridBagConstraints.NONE;
descricao.weightx = 1.0;
descricao.weighty = 0;
add(new JTextField(20), descricao);

// ================= NOME CIENTÍFICO =================
GridBagConstraints nomeCientifico = new GridBagConstraints();
nomeCientifico.insets = new Insets(5, 10, 5, 10);
nomeCientifico.anchor = GridBagConstraints.WEST;

// Label
nomeCientifico.gridx = 0;
nomeCientifico.gridy = 2;
nomeCientifico.weightx = 0;
nomeCientifico.weighty = 0;
add(new JLabel("Nome Cientifico:"), nomeCientifico);

// Campo
nomeCientifico.gridx = 1;
nomeCientifico.gridy = 2;
nomeCientifico.fill = GridBagConstraints.NONE;
nomeCientifico.weightx = 0;
nomeCientifico.weighty = 0;
add(new JTextField(20), nomeCientifico);

//ARMAZÉM
GridBagConstraints armazem = new GridBagConstraints();
armazem.insets = new Insets(5, 10, 5, 10);
armazem.anchor = GridBagConstraints.WEST;

// Label
armazem.gridx = 2;
armazem.gridy = 0;
add(new JLabel("Armazém:"), armazem);

//CAMPO
armazem.gridx = 3;
armazem.gridy = 0;
armazem.fill = GridBagConstraints.NONE;
add(new JTextField(15), armazem);


//custo unitario
GridBagConstraints custoUnitario = new GridBagConstraints();
custoUnitario.insets = new Insets(5, 10, 5, 10);
custoUnitario.anchor = GridBagConstraints.WEST;

// Label
custoUnitario.gridx = 2;
custoUnitario.gridy = 1;
add(new JLabel("Custo Unitário:"), custoUnitario);

// Campo
custoUnitario.gridx = 3;
custoUnitario.gridy = 1;
custoUnitario.fill = GridBagConstraints.NONE;
add(new JTextField(15), custoUnitario);

//tipo
GridBagConstraints tipo = new GridBagConstraints();
tipo.insets = new Insets(5, 10, 5, 10);
tipo.anchor = GridBagConstraints.WEST;

// Label
tipo.gridx = 2;
tipo.gridy = 2;
add(new JLabel("Tipo:"), tipo);

// Campo
tipo.gridx = 3;
tipo.gridy = 2;
tipo.fill = GridBagConstraints.NONE;
add(new JTextField(15), tipo);

//BOTÃO CADASTRAR
GridBagConstraints botaoCadastrar = new GridBagConstraints();
botaoCadastrar.insets = new Insets(5, 10, 5, 10);
botaoCadastrar.gridx = 1;
botaoCadastrar.gridy = 6;
botaoCadastrar.anchor = GridBagConstraints.CENTER;
botaoCadastrar.fill = GridBagConstraints.NONE;

//BOTAO LIMPAR 
GridBagConstraints botaoLimpar = new GridBagConstraints();
botaoLimpar.insets = new Insets(5, 10, 5, 10);
botaoLimpar.gridx = 2;
botaoLimpar.gridy = 6;
botaoLimpar.anchor = GridBagConstraints.CENTER;
botaoLimpar.fill = GridBagConstraints.NONE;

//BOTAO VOLTAR
GridBagConstraints botaoVoltar = new GridBagConstraints();
botaoVoltar.insets = new Insets(5, 10, 5, 10);
botaoVoltar.gridx = 3;
botaoVoltar.gridy = 6;
botaoVoltar.anchor = GridBagConstraints.CENTER;
botaoVoltar.fill = GridBagConstraints.NONE;

JPanel painelBotoes =  new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));

GridBagConstraints painelBotoesConstraints = new GridBagConstraints();
painelBotoesConstraints.gridx = 0;
painelBotoesConstraints.gridy = 6;
painelBotoesConstraints.gridwidth = 4;
painelBotoesConstraints.anchor = GridBagConstraints.CENTER;
painelBotoesConstraints.insets = new Insets(30, 30, 10, 10);
add(painelBotoes, painelBotoesConstraints);

JButton cadastrar = new JButton("Cadastrar");
painelBotoes.add(cadastrar);
cadastrar.addActionListener(e->{
    // Lógica para cadastrar o produto
    // Aqui você pode adicionar a lógica para salvar os dados do produto
});
cadastrar.setBackground(new Color(177, 254, 126));
cadastrar.setContentAreaFilled(false);
cadastrar.setOpaque(true);
cadastrar.setCursor(new Cursor(Cursor.HAND_CURSOR));


//LIMAR 
JButton Limpar = new JButton("Limpar");
painelBotoes.add(Limpar);
Limpar.addActionListener(e->{
    // Lógica para limpar os campos de entrada
    for (java.awt.Component comp : getContentPane().getComponents()) {
        if (comp instanceof JTextField) {
            ((JTextField) comp).setText("");
        }
    }
});
    Limpar.setBackground(new Color(255, 148, 166));
    Limpar.setContentAreaFilled(false);
    Limpar.setOpaque(true);
    Limpar.setCursor(new Cursor(Cursor.HAND_CURSOR));
//VOLTAR--
JButton Voltar = new JButton("Voltar");
painelBotoes.add(Voltar);

Voltar.addActionListener(e -> {
    Inicial telaInicial = new Inicial();
    dispose();
});
Voltar.setBackground(new Color(112,176,225));
Voltar.setContentAreaFilled(false);
Voltar.setOpaque(true);
Voltar.setCursor(new Cursor(Cursor.HAND_CURSOR));

// ================= EMPURRADOR FINAL =================
GridBagConstraints empurrador = new GridBagConstraints();
empurrador.gridx = 0;
empurrador.gridy = 99;
empurrador.weightx = 0;
empurrador.weighty = 1.0;
add(new JLabel(), empurrador);

setVisible(true);

    }
}   
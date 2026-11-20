package main.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import main.controller.CadastraProdutoDAO;

public class CadastraProduto extends JFrame {

    private final JTextField tfProduto = new JTextField(20);
    private final JTextField tfDescricao = new JTextField(20);
    private final JTextField tfNomeCientifico = new JTextField(20);
    private final JTextField tfArmazem = new JTextField(20);
    private final JTextField tfCustoUnitario = new JTextField(20);
    private final JTextField tfTipo = new JTextField(20);

    private final Integer idEdicao;
    private final Runnable aposAtualizar;

    public CadastraProduto() {
        this(null, null);
    }

    public CadastraProduto(Integer idEdicao, Runnable aposAtualizar) {
        this.idEdicao = idEdicao;
        this.aposAtualizar = aposAtualizar;

        setTitle(idEdicao == null
            ? "Cadastro de Produtos - SigmaCorp"
            : "Edição de Produto - SigmaCorp");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);

        JPanel painelCampos = new JPanel(new GridBagLayout());
        painelCampos.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));

        adicionarCampo(painelCampos, "Produto:", tfProduto, 0, 0);
        adicionarCampo(painelCampos, "Descrição:", tfDescricao, 0, 1);
        adicionarCampo(painelCampos, "Nome científico:", tfNomeCientifico, 0, 2);
        adicionarCampo(painelCampos, "Armazém:", tfArmazem, 2, 0);
        adicionarCampo(painelCampos, "Custo unitário:", tfCustoUnitario, 2, 1);
        adicionarCampo(painelCampos, "Tipo:", tfTipo, 2, 2);

        JButton botaoSalvar = new JButton(
            idEdicao == null ? "Cadastrar" : "Salvar alterações"
        );
        botaoSalvar.addActionListener(evento -> salvarProduto());

        JButton botaoLimpar = new JButton("Limpar");
        botaoLimpar.addActionListener(evento ->
            preencherCampos("", "", "", "", "", "")
        );

        JButton botaoVoltar = new JButton("Voltar");
        botaoVoltar.addActionListener(evento -> dispose());

        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        painelBotoes.add(botaoSalvar);
        painelBotoes.add(botaoLimpar);
        painelBotoes.add(botaoVoltar);

        add(painelCampos, BorderLayout.CENTER);
        add(painelBotoes, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void adicionarCampo(JPanel painel, String rotulo, JTextField campo,
                                int coluna, int linha) {
        GridBagConstraints posicao = new GridBagConstraints();
        posicao.insets = new Insets(5, 8, 5, 8);
        posicao.anchor = GridBagConstraints.WEST;
        posicao.gridx = coluna;
        posicao.gridy = linha;

        JLabel label = new JLabel(rotulo);
        label.setLabelFor(campo);
        painel.add(label, posicao);

        posicao.gridx = coluna + 1;
        painel.add(campo, posicao);
    }

    public void preencherCampos(String produto, String descricao,
                                String nomeCientifico, String armazem,
                                String custo, String tipo) {
        tfProduto.setText(produto);
        tfDescricao.setText(descricao);
        tfNomeCientifico.setText(nomeCientifico);
        tfArmazem.setText(armazem);
        tfCustoUnitario.setText(custo);
        tfTipo.setText(tipo);
    }

    private void salvarProduto() {
        String produto = tfProduto.getText();
        String descricao = tfDescricao.getText();
        String nomeCientifico = tfNomeCientifico.getText();
        String armazem = tfArmazem.getText();
        String tipo = tfTipo.getText();

        double custo;
        try {
            custo = Double.parseDouble(tfCustoUnitario.getText().trim().replace(',', '.'));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Informe um custo válido, como 12,50.");
            tfCustoUnitario.requestFocusInWindow();
            return;
        }

        CadastraProdutoDAO dao = new CadastraProdutoDAO();

        try {
            if (idEdicao == null) {
                dao.salvar(produto, descricao, nomeCientifico, armazem, custo, tipo);
            } else {
                dao.atualizar(idEdicao, produto, descricao, nomeCientifico,
                              armazem, custo, tipo);
            }
        } catch (RuntimeException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(),
                "Erro ao salvar produto", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (idEdicao == null) {
            JOptionPane.showMessageDialog(this, "Produto cadastrado com sucesso!");
            return;
        }

        if (aposAtualizar != null) {
            try {
                aposAtualizar.run();
            } catch (RuntimeException ex) {
                JOptionPane.showMessageDialog(this,
                    "Produto salvo. Feche e reabra a listagem para ver a alteração.",
                    "Erro ao recarregar a lista", JOptionPane.WARNING_MESSAGE);
                dispose();
                return;
            }
        }

        JOptionPane.showMessageDialog(this, "Produto atualizado com sucesso!");
        dispose();
    }
}
package main.view;

import java.awt.BorderLayout;
import java.util.List;
import java.util.Objects;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import main.controller.CadastraProdutoDAO;
import main.model.Produto;

public class ProdutoView extends JFrame {

    private JTable tabela;
    private DefaultTableModel modelo;

    public ProdutoView() {
        setTitle("Produto - SigmaCorp");
        setSize(1200, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        criarTabela();
        carregarProdutos();

        setVisible(true);
    }

    private void criarTabela() {
        modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int linha, int coluna) {
                return false;
            }
        };

        modelo.addColumn("ID");
        modelo.addColumn("Produto");
        modelo.addColumn("Descrição");
        modelo.addColumn("Nome Científico");
        modelo.addColumn("Armazém");
        modelo.addColumn("Custo");
        modelo.addColumn("Tipo");

        tabela = new JTable(modelo);
        add(new JScrollPane(tabela), BorderLayout.CENTER);

        JButton botaoEditar = new JButton("Editar");
        botaoEditar.addActionListener(evento -> editarProduto());

        JButton botaoExcluir = new JButton("Excluir");
        botaoExcluir.addActionListener(evento -> excluirProduto());

        JButton botaoVoltar = new JButton("Voltar");
        botaoVoltar.addActionListener(evento -> dispose());

        JPanel painelBotoes = new JPanel();
        painelBotoes.add(botaoEditar);
        painelBotoes.add(botaoExcluir);
        painelBotoes.add(botaoVoltar);
        add(painelBotoes, BorderLayout.SOUTH);
    }

    private void editarProduto() {
        int linhaSelecionada = tabela.getSelectedRow();

        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um produto para editar.");
            return;
        }

        int linhaModelo = tabela.convertRowIndexToModel(linhaSelecionada);
        int idProduto = (Integer) modelo.getValueAt(linhaModelo, 0);

        CadastraProduto formulario =
            new CadastraProduto(idProduto, this::carregarProdutos);

        formulario.preencherCampos(
            Objects.toString(modelo.getValueAt(linhaModelo, 1), ""),
            Objects.toString(modelo.getValueAt(linhaModelo, 2), ""),
            Objects.toString(modelo.getValueAt(linhaModelo, 3), ""),
            Objects.toString(modelo.getValueAt(linhaModelo, 4), ""),
            Objects.toString(modelo.getValueAt(linhaModelo, 5), ""),
            Objects.toString(modelo.getValueAt(linhaModelo, 6), "")
        );
    }

    private void excluirProduto() {
        int linhaSelecionada = tabela.getSelectedRow();

        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(this, "Selecione um produto para excluir.");
            return;
        }

        int linhaModelo = tabela.convertRowIndexToModel(linhaSelecionada);
        int idProduto = (Integer) modelo.getValueAt(linhaModelo, 0);
        String nomeProduto = Objects.toString(modelo.getValueAt(linhaModelo, 1), "");

        int resposta = JOptionPane.showConfirmDialog(
            this,
            "Excluir definitivamente o produto " + nomeProduto + " (ID " + idProduto + ")?",
            "Confirmar exclusão",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.WARNING_MESSAGE
        );

        if (resposta != JOptionPane.YES_OPTION) {
            return;
        }

        boolean excluido;
        try {
            excluido = new CadastraProdutoDAO().excluir(idProduto);
        } catch (RuntimeException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(),
                "Erro ao excluir produto", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String mensagem = excluido
            ? "Produto excluído com sucesso!"
            : "O produto já não existe no banco de dados.";

        try {
            carregarProdutos();
        } catch (RuntimeException ex) {
            JOptionPane.showMessageDialog(this,
                mensagem + "\nReabra a listagem para atualizar a tabela.",
                "Erro ao recarregar a lista", JOptionPane.WARNING_MESSAGE);
            return;
        }

        JOptionPane.showMessageDialog(this, mensagem);
    }

    private void carregarProdutos() {
        CadastraProdutoDAO dao = new CadastraProdutoDAO();
        List<Produto> produtos = dao.listar();

        modelo.setRowCount(0);

        for (Produto p : produtos) {
            modelo.addRow(new Object[]{
                p.getId(),
                p.getProduto(),
                p.getDescricao(),
                p.getNomeCientifico(),
                p.getArmazem(),
                p.getCustoUnitario(),
                p.getTipo()
            });
        }
    }
}
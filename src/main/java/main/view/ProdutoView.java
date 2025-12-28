package main.view;

import java.util.List;
import javax.swing.*;
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
        modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Produto");
        modelo.addColumn("Descrição");
        modelo.addColumn("Nome Científico");
        modelo.addColumn("Armazém");
        modelo.addColumn("Custo");
        modelo.addColumn("Tipo");

        tabela = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(tabela);

        add(scroll);
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

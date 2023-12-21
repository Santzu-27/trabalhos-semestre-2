package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entitys.itens_lavanderia;

public class itens_lavanderiaDAO {
    public void cadastraItem(itens_lavanderia item){
        String sql = "INSERT INTO itens_lavanderia (descricao, valor_unitario, unidade) VALUES ( ?, ?, ?)";
        PreparedStatement ps = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rede_hoteis", "root", "1234");

            ps = con.prepareStatement(sql);
            ps.setString(1, item.getDescricao());
            ps.setDouble(2, item.getValor());
            ps.setInt(3, item.getUnidade());

            ps.execute();
            con.close();
            ps.close();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
    }

    public void deletaItem(itens_lavanderia item){
        String sql = "delete from itens_lavanderia where codigo = ?";
        PreparedStatement ps = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rede_hoteis", "root", "1234");

            ps = con.prepareStatement(sql);
            ps.setInt(1, item.getCodigo());
            ps.execute();
            con.close();
            ps.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    public itens_lavanderia[] selecionar() {
        List<itens_lavanderia> itens = new ArrayList();
        
        try {
            /* Abrir uma conexão com o banco de dados */
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rede_hoteis", "root", "1234");

            /* Preparar uma Sentença SQL */
            PreparedStatement pstmt = con.prepareStatement("select * from itens_lavanderia");
            
            /* Executar a Sentença */
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                itens_lavanderia it = new itens_lavanderia();
                it.setCodigo(rs.getInt("codigo"));
                itens.add(it);
            }
            /* Fechar a conexão com o banco de dados */
            con.close();
        } catch (Exception e) {
            
        }
        
        return itens.toArray(new itens_lavanderia[0]);
    }
}

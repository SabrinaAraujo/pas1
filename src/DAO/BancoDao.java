package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Banco.Conta;
import BancoDeDados.CriaConexao;
import Excecoes.ContaInvalidaException;

public class BancoDao {

	 private Connection conexao;

	    public BancoDao() throws SQLException{
	        this.conexao = CriaConexao.getConexao();
	    }

	    public void adicionaConta(Conta c1) throws SQLException{
	       //prepara a conexao
	        String sql = "insert into conta(numero,saldo)" + "values (?,?)";
	        PreparedStatement stmt = conexao.prepareStatement(sql);

	        //seta os valores
	        stmt.setString(1, c1.getConta());
	        stmt.setDouble(2, c1.getSaldo());
	       

	        //executa o codigo sql
	        stmt.execute();
	        stmt.close();
	    }

	
	    public List<Conta> getListaContas(String numConta) throws SQLException, ContaInvalidaException{
	        String sql = "select * from conta where nome like ?";
	         PreparedStatement stmt = this.conexao.prepareStatement(sql);
	         stmt.setString(1, numConta);
	         ResultSet rs = stmt.executeQuery();

	         List<Conta> listaContas = new ArrayList<Conta>();
	         while(rs.next()){
	        	 Conta c1 = new Conta();
	             c1.setConta(rs.getString("numero"));
	             c1.setSaldo(rs.getDouble("saldo"));

	             listaContas.add(c1);
	         }

	         rs.close();
	         stmt.close();
	         
	         return listaContas;
	    }
}

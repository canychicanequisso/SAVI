package Model.DAO;

//import com.jdenner.to.Produto;
import Model.VO.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Classe de acesso a dados do produto
 *
 * @author Manuel
 */
public class DAO_Usuario implements IDAO<Usuario> {

    @Override
    public void inserir(Usuario usuario) throws Exception {
        
        Conexao c = new Conexao();
        String query = "call InserirUsuario(?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps = c.getConexao().prepareStatement(query);
        ps.setString(1, usuario.getBi());
        ps.setString(2, usuario.getNome());
        ps.setString(3, usuario.getApelido());
        ps.setInt(4, usuario.getCelular());
        ps.setString(5, usuario.getBairro());
        ps.setString(6, usuario.getRua());
        ps.setInt(7, usuario.getQuarteirao());
        ps.setString(8, usuario.getNomeUsuario());
        ps.setInt(9, usuario.getSenha());
        ps.setString(10, usuario.getEmail());
        ps.executeUpdate();
        ps.close();
        c.confirmar();
    }

    @Override
    public void alterar(Usuario usuario) throws Exception {
        Conexao c = new Conexao();
        String query = "call actualizarUsuario(?,?,?,?,?,?,?,?)";
        PreparedStatement ps = c.getConexao().prepareStatement(query);
        ps.setInt(1, usuario.getNrConta());
        ps.setString(2, usuario.getNomeUsuario());
        ps.setInt(3, usuario.getSenha());
        ps.setString(4,usuario.getEmail());
        ps.setInt(5, usuario.getCelular());
        ps.setString(6, usuario.getBairro());
        ps.setString(7,usuario.getRua());
        ps.setInt(8,usuario.getQuarteirao());
        ps.executeUpdate();
        ps.close();
        c.confirmar();
        
    }

    @Override
    public void excluir(Usuario usuario) throws Exception {
        Conexao c = new Conexao();
        String query = "CALL removerUsuario(?,?)";
        PreparedStatement ps = c.getConexao().prepareStatement(query);
        ps.setString(1, usuario.getBi());
        ps.setInt(2, usuario.getNrConta());
        ps.executeUpdate();
        ps.close();
        c.confirmar();
    }

    @Override
    public ArrayList<Usuario> listarTodos() throws Exception {
        Conexao c = new Conexao();
        String sql = "SELECT * FROM TBPRODUTO ORDER BY NOME";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        ArrayList listaProdutos = new ArrayList();
        while (rs.next()) {
            Usuario usuario = new Usuario();
        //    produto.setCodigo(rs.getInt("CODIGO"));
         //   produto.setNome(rs.getString("NOME"));
         //   produto.setPrecoCompra(rs.getDouble("PRECOCOMPRA"));
         //   produto.setPrecoVenda(rs.getDouble("PRECOVENDA"));
         //   produto.setQuantidade(rs.getInt("QUANTIDADEESTOQUE"));
          listaProdutos.add(usuario);
        }

        return listaProdutos;
    }

    
    public Usuario buscar(String bi) throws Exception {
        Conexao c = new Conexao();
        String sql = "SELECT * FROM `usuario` WHERE `BI`=?";
        PreparedStatement ps = c.getConexao().prepareStatement(sql);
        ps.setString(1, bi);
        ResultSet rs = ps.executeQuery();
        Usuario user = new Usuario();
        
        if (rs.next()) {
            user.setBi(rs.getString("BI"));
            user.setNome(rs.getString("nome"));
            user.setApelido(rs.getString("Apelido"));
            user.setCelular(rs.getInt("celular"));
            user.setBairro(rs.getString("bairro"));
        }

        return user;
    }
    @Override
    public Usuario recuperar(int x){
        return null;
    }
    
}

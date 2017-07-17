/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static java.sql.Types.NULL;
import model.Pergunta;

/**
 *
 * @author User
 */
public class PerguntaDAO {
    PreparedStatement pst;
    String sql;
    
    public int salvar(Pergunta pergunta) throws SQLException {
        int idPergunta = 0;
        sql = "insert into pergunta values (?,?,?,?)";
        pst = Conexao.getInstance().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        pst.setInt(1,0);
        pst.setString(2, pergunta.getDescricao());
        pst.setString(3, pergunta.getComentario());
        pst.setInt(4, NULL);
        pst.execute();
        ResultSet rs = pst.getGeneratedKeys();
        while(rs.next()){
            idPergunta = rs.getInt(1);
        }
        pst.close();
        return idPergunta;
    }
}

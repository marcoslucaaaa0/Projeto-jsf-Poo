package dao;
import static Factory.ConnectionFactory.getConnection;
import Model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsuarioDAO {
    private Connection connection;
    public UsuarioDAO() {
        this.connection = getConnection();
    }
    public void adiciona(Usuario usuario) {
        connection = getConnection();
        String sql = "INSERT INTO (" +
                " idUsuario, " +
                " Apelido, " +
                " Genero, " +
                " senha, " +
                " e-mail) " +
                " values (?, ?, ?, ?, ?)";

        try {
            PreparedStatement stmt;
            stmt = this.connection.prepareStatement(sql);
            stmt.setInt(1, usuario.getIdUsuario());
            stmt.setString(2,usuario.getApelido());
            stmt.setString(3,usuario.getGenero());
            stmt.setString(4,usuario.getSenha());
            stmt.setString(4,usuario.getEmail());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }



}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexaobanco;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author edimar
 */
public class Conexao {

    private static Connection conn;
    private final static String driver = "org.postgresql.Driver"; //sempre assim, para o PostgreSQL
    private final static String ip = "localhost/"; //ip dp computador que contém o banco
    public static String dataBase = "aula"; //nome da base de daos no PostgreSQL
    public static String user = "postgres"; //usuário do banco de dados
    public static String password = "postgres"; //senha para o usuário do banco

  
    /* 
    *  Estabelecendo conexão com o banco
    */
    public static Connection getConexao() throws SQLException, ClassNotFoundException {

        if (conn != null) { // se já existe conexão aberta, retorna ela em vez de criar uma nova
            return conn;
        }
        // se não existe conexão cria uma nova 
        Class.forName(driver);//não mexer - definindo jdbc utilizado
        conn = java.sql.DriverManager.getConnection("jdbc:postgresql://" + ip + dataBase, user, password);//não mexer
        return conn;

    }

    public static void fechaConexao() {
        try {
            conn.close();
            conn = null;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        try {
            getConexao();
            System.out.println("Feito!");
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

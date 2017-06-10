package conexaobanco.controller;

import conexaobanco.Conexao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteController {

    public boolean inserir() {
        String sql = "INSERT INTO cliente(codigo,nome) VALUES (13,'Fabio')";
        PreparedStatement ps;
        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.execute();
            return true;
        } catch (SQLException  | ClassNotFoundException ex){
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        }
        public static void main(String[] args) {
        // objeto da classe Cliente Controller
        ClienteController objCliente = new ClienteController();
        
        // chame o metodo inserir desse objeto
        objCliente.inserir();
        
        //execute e confira no BD
    }
    }



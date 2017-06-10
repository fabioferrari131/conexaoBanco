package conexaobanco.controller;

import conexaobanco.Conexao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteController {

    public boolean inserir(int codigo, String nome) {
        String sql = "INSERT INTO cliente(codigo,nome) VALUES (?,?)";//define instrução sql
        PreparedStatement ps;//executa sql preparada
        try {
            ps = Conexao.getConexao().prepareStatement(sql);//prepara instrução sql
            ps.setInt(1, codigo);//primeiro parâmetro indica ? correspondente, subtituira a 1ª variavel
            ps.setString(2, nome);//primeiro parâmetro indica ? correspondente, subtituira a 2ª variavel
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
        objCliente.inserir(12, "Ferrari");
        
        //execute e confira no BD
    }
    }



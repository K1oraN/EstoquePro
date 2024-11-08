/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controler;

import dao.Conexao;
import dao.UsuarioDAO;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Usuario;
import view.Principal;
import view.TelaDeMenu;


/**
 *
 * @author celso
 */
public class LoginControler {
    private Principal view;
    

    public LoginControler(Principal view) {
        this.view = view;
    }

    public void autenticar() throws SQLException {
       
   String usuario = view.getLoginPrinciplaltxt().getText();
    String senha = view.getSenhaPrincipalTxt().getText();
        Usuario usuarioPrincipal =  new Usuario(usuario,senha);
//verificar se existe no banco 
 Connection conexao = new Conexao().getConnection();
UsuarioDAO usuarioDAO = new UsuarioDAO(conexao);

 boolean existe = usuarioDAO.autenticarUsuarioPorUsuarioESenha(usuarioPrincipal);
 
 //se tiver cadastrado no banco, abrir tela de menu

    
    if(existe){
        
        TelaDeMenu menu = new TelaDeMenu();
        view.dispose();
        menu.setVisible(true);
    } else {
        JOptionPane.showMessageDialog(view, "Usuario ou senha invalidos");
    }

    } 
}



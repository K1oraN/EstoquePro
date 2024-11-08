/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controler;

import dao.Conexao;
import dao.UsuarioDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Usuario;
import view.Principal;
import view.TelaDeCadastro;

/**
 *
 * @author celso
 */
public class FormCadastroControle {
    private TelaDeCadastro view;

    public FormCadastroControle(TelaDeCadastro view) {
        this.view = view;
    }
    
   
    
     public void salvaUsuario(){
         
         
        String usuario = view.getTxtLogin().getText();
        String senha = view.getTxtSenha().getText();
        String confirmasenha = view.getTxtConfirmarSenha().getText();
        
                if(senha.equals(confirmasenha)){
                    Usuario usuarios = new Usuario(usuario,senha);
                            // a partir daqui, todo esse codigo de baixo envolve encapsulamento, foda
                        try {
                            Connection conexao = new Conexao().getConnection();
                            UsuarioDAO usuarioDAO = new UsuarioDAO(conexao);
                            usuarioDAO.insirt(usuarios);
                        } catch (SQLException ex) {
                            Logger.getLogger(TelaDeCadastro.class.getName()).log(Level.SEVERE, null, ex);
                        }
                                JOptionPane.showMessageDialog(null, "Cadastro de usuário Realizado!","Cadastro", JOptionPane.INFORMATION_MESSAGE);

                Principal voltarPrincipal =  new Principal();
                      view.dispose();
                 voltarPrincipal.setVisible(true);

                }else{
                    JOptionPane.showMessageDialog(null, "As senhas devem ser iguais!","Cadastro", JOptionPane.INFORMATION_MESSAGE);

        }

     }


    
}

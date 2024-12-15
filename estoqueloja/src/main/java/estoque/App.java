/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estoque;

import java.sql.SQLException;

/**
 * Classe para rodar o codigo e receber os valores do usuario
 * @author felipe ferreira, Carlos Eduardo, Caua Alavarenga e Heitor Messias
 * @since 15/12/2024 at 16:21
 */
public class App {
    public static void main(String[] args) throws SQLException {
        
        
        Usuario u1 = new Usuario(1, "CARLOS", "MASC", "119999999", "12345678910", 30);
        u1.alterar();
        
    }
    
}

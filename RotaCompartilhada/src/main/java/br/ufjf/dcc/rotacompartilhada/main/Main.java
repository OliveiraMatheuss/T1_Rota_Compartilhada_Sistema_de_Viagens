/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.ufjf.dcc.rotacompartilhada.main;
import br.ufjf.dcc.rotacompartilhada.model.Pessoa;
import br.ufjf.dcc.rotacompartilhada.model.Endereco;

/**
 *
 * @author 55329
 */
public class Main {

    public static void main(String[] args) {
        
        Endereco endereco1 = new Endereco("Rua","das rosas",50,"Novo Horizonte","JF","estado","Br","36038510");
        Pessoa pessoa1 = new Pessoa("Matheus", "12204380652",endereco1);
        

    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package components;
import java.util.Scanner;

/**
 *@author laura
 */
public interface Component{
    
    public final static Scanner DADES = new Scanner(System.in);
    
    public void updateComponent();
    public void showComponent();
    
}

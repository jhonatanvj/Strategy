/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package strategy;

/**
 *
 * @author jhona
 */
public class GrillingStrategy implements CookingStrategy {
    @Override
    public String cook(String dish) {
        return dish + " está siendo asado.";
    }
}

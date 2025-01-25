/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package context;

import strategy.CookingStrategy;

/**
 *
 * @author jhona
 */
import strategy.CookingStrategy;

public class CookingContext {
    private CookingStrategy strategy;

    // Setter para la estrategia
    public void setStrategy(CookingStrategy strategy) {
        this.strategy = strategy;
    }

    // Método para cocinar el platillo
    public String cook(String dish) {
        if (strategy == null) {
            return "Por favor, selecciona un método de cocción.";
        } else {
            return strategy.cook(dish);
        }
    }
}

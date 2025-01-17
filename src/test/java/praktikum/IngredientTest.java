package praktikum;

import org.junit.Test;
import static org.junit.Assert.*;

public class IngredientTest {

    @Test
    public void testIngredientType() {
        Ingredient sauce = new Ingredient(IngredientType.SAUCE, "Острый лава-соус", 50);
        Ingredient filling = new Ingredient(IngredientType.FILLING, "Котлета из нибблерианца", 100);

        assertEquals(IngredientType.SAUCE, sauce.getType());
        assertEquals(IngredientType.FILLING, filling.getType());
    }

    @Test
    public void testIngredientPrice() {
        Ingredient sauce = new Ingredient(IngredientType.SAUCE, "Острый лава-соус", 50);
        assertEquals(50, sauce.getPrice(), 0);
    }

    @Test
    public void testIngredientName() {
        Ingredient filling = new Ingredient(IngredientType.FILLING, "Котлета из нибблерианца", 100);
        assertEquals("Котлета из нибблерианца", filling.getName());
    }
}
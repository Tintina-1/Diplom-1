package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class BurgerTest {

    private Burger burger;

    @Mock
    private Bun bun;

    @Mock
    private Ingredient ingredient1;

    @Mock
    private Ingredient ingredient2;

    @Before
    public void setUp() {
        burger = new Burger();
        bun = mock(Bun.class);
        ingredient1 = mock(Ingredient.class);
        ingredient2 = mock(Ingredient.class);

        when(bun.getName()).thenReturn("Булка из марсианского пепла");
        when(bun.getPrice()).thenReturn(200.5f);

        when(ingredient1.getName()).thenReturn("Кристаллическая котлета");
        when(ingredient1.getPrice()).thenReturn(600.5f);
        when(ingredient1.getType()).thenReturn(IngredientType.FILLING);

        when(ingredient2.getName()).thenReturn("Соус с Меркурия");
        when(ingredient2.getPrice()).thenReturn(199.0f);
        when(ingredient2.getType()).thenReturn(IngredientType.SAUCE);
    }

    @Test
    public void testSetBuns() {
        burger.setBuns(bun);
        assertEquals("Булка из марсианского пепла", burger.bun.getName());
        assertEquals(200.5f, burger.bun.getPrice(), 0);
    }

    @Test
    public void testAddIngredient() {
        burger.addIngredient(ingredient1);
        assertEquals(1, burger.ingredients.size());
        assertEquals("Кристаллическая котлета", burger.ingredients.get(0).getName());
    }

    @Test
    public void testRemoveIngredient() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.removeIngredient(0);
        assertEquals(1, burger.ingredients.size());
        assertEquals("Соус с Меркурия", burger.ingredients.get(0).getName());
    }

    @Test
    public void testMoveIngredient() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(0, 1);
        assertEquals("Соус с Меркурия", burger.ingredients.get(0).getName());
        assertEquals("Кристаллическая котлета", burger.ingredients.get(1).getName());
    }

    @Test
    public void testGetPrice() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        float price = burger.getPrice();
        assertEquals(1200.5f, price, 0);
    }

    @Test
    public void testGetReceipt() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        String receipt = burger.getReceipt();
        String expectedReceipt = "(==== Булка из марсианского пепла ====)\n" +
                "= filling Кристаллическая котлета =\n" +
                "= sauce Соус с Меркурия =\n" +
                "(==== Булка из марсианского пепла ====)\n\n" +
                "Price: 1200.500000\n";
        assertEquals(expectedReceipt, receipt);
    }
}

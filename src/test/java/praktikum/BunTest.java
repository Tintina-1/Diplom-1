package praktikum;
import org.junit.Assert;
import org.junit.Test;

public class BunTest {
    @Test
    public void testValidName() {
        Bun bun = new Bun("Вкусная", 800.5f);
        Assert.assertEquals("Вкусная", bun.getName());
    }

    @Test
    public void testEmptyName() {
        Bun bun = new Bun("", 800.5f);
        Assert.assertEquals("", bun.getName());
    }

    @Test
    public void testNullName() {
        Bun bun = new Bun(null, 800.5f);
        Assert.assertNull(bun.getName());
    }

    @Test
    public void testLongName() {
        String longName = "Мега-супер-пупер межгалактическая булочка".repeat(1000);
        Bun bun = new Bun(longName, 800.5f);
        Assert.assertEquals(longName, bun.getName());
    }

    @Test
    public void testSpecialCharactersName() {
        String specialName = "@#$%^&*";
        Bun bun = new Bun(specialName, 800.5f);
        Assert.assertEquals(specialName, bun.getName());
    }

    @Test
    public void testValidPrice() {
        Bun bun = new Bun("Отличная космическая", 1500.99f);
        Assert.assertEquals(1500.99f, bun.getPrice(), 0.01f);
    }

    @Test
    public void testZeroPrice() {
        Bun bun = new Bun("Отличная космическая", 0.0f);
        Assert.assertEquals(0.0f, bun.getPrice(), 0.01f);
    }

    @Test
    public void testNegativePrice() {
        Bun bun = new Bun("Отличная космическая", -500.0f);
        Assert.assertEquals(-500.0f, bun.getPrice(), 0.01f);
    }

    @Test
    public void testMinimumPositivePrice() {
        Bun bun = new Bun("Отличная космическая", 0.01f);
        Assert.assertEquals(0.01f, bun.getPrice(), 0.01f);
    }

    @Test
    public void testMaximumPossiblePrice() {
        Bun bun = new Bun("Отличная космическая", Float.MAX_VALUE);
        Assert.assertEquals(Float.MAX_VALUE, bun.getPrice(), 0.01f);
    }
}

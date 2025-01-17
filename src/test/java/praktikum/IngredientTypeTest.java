package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTypeTest {

    @Parameterized.Parameters(name = "{index}: IngredientType = {0}")
    public static Object[][] data() {
        return new Object[][]{
                {IngredientType.SAUCE, "SAUCE"},
                {IngredientType.FILLING, "FILLING"}
        };
    }

    private final IngredientType ingredientType;
    private final String expectedName;

    public IngredientTypeTest(IngredientType ingredientType, String expectedName) {
        this.ingredientType = ingredientType;
        this.expectedName = expectedName;
    }

    @Test
    public void testIngredientTypeName() {
        assertEquals(expectedName, ingredientType.name());
    }
}

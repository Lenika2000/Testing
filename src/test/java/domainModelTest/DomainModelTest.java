package domainModelTest;

import domainModel.Birthplace;
import domainModel.Environment;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class DomainModelTest extends Assert {

    static Environment environment;

    @BeforeClass
    public static void createEnvironment() {
        environment = new Environment();
    }

    @Test
    public void isEnvironmentInit() {
        assertFalse(environment.isEmpty());
    }

    @Test
    public void isAllThingsCreate() {
        assertEquals(environment.getThingsQuantity(),2);
    }

    @Test
    public void isArturEarthling() {
        assertEquals(environment.getArtur().getBirthplace(), Birthplace.EARTH);
    }

    @Test
    public void isFordBetelgeusian() {
        assertEquals(environment.getFord().getBirthplace(), Birthplace.BETELGEUSE);
    }

    @Test(expected = IllegalStateException.class)
    public void cannotTakeBottleIfAlreadyHoldingAnotherOne() throws IllegalStateException {
        environment.getFord().tryTakeBottle();
    }

    // если Форд не держит бутылку с рыбкой, то он не может предложить ее засунуть в ухо Артуру
    @Test(expected = IllegalStateException.class)
    public void testCanFordMakeAnOffer() throws IllegalStateException {
        environment.getFord().setIsHoldingBottle(false);
        environment.getFord().doOffer();
    }

    @Test
    public void arthurIsNotConfidentIfThereIsNoSimpleThing() {
        assertTrue(!(environment.getArtur().isConfident()) && (!environment.isThereSimpleThing()));
    }
}
